package com.marceloluiz.Pokedex;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.Getter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.Serial;

public class ChartApplication extends Application {

	private ConfigurableApplicationContext applicationContext;
	
	@Getter
    private static Scene mainScene;
	
	private AnchorPane anchorPane;

	@Override
	public void init() throws Exception {
		applicationContext = new SpringApplicationBuilder(PokeApiTeamBuilderApplication.class).run();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Pokedex/gui/Pokedex.fxml"));
		loader.setControllerFactory(applicationContext::getBean);

		anchorPane = loader.load();
	}

	@Override
	public void start(Stage stage) throws Exception {
		applicationContext.publishEvent(new StageReadyEvent(stage));
		 
		mainScene = new Scene(anchorPane);
		
		stage.setScene(mainScene);
		stage.setTitle("PokeAPI JavaFX application");
		stage.show();
	}

    @Override
	public void stop() throws Exception {
		applicationContext.close();
		Platform.exit();
	}

	// inner class
	public static class StageReadyEvent extends ApplicationEvent {
		@Serial
		private static final long serialVersionUID = 1L;

		public StageReadyEvent(Stage stage) {
			super(stage);
		}

		public Stage getStage() {
			return ((Stage) getSource());
		}
	}

}
