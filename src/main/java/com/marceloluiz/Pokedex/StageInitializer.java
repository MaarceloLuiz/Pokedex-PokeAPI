package com.marceloluiz.Pokedex;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.marceloluiz.Pokedex.ChartApplication.StageReadyEvent;

import javafx.stage.Stage;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent>{
	
	@Override
	public void onApplicationEvent(StageReadyEvent event) {
		Stage stage = event.getStage();
		
//		try {
//			Stage stage = event.getStage();
//			
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
//			ScrollPane scrollPane = loader.load();
//			
//			scrollPane.setFitToHeight(true);
//			scrollPane.setFitToWidth(true);
//			
//			mainScene = new Scene(scrollPane);
//			primaryStage.setScene(mainScene);
//			primaryStage.setTitle("PokeAPI JavaFX application");
//			primaryStage.show();
//		}
//		catch(IOException e) {
//			e.getStackTrace();
//		}
		
	}
}
