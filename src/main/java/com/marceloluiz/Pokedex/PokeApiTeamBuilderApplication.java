package com.marceloluiz.Pokedex;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javafx.application.Application;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class PokeApiTeamBuilderApplication {

	public static void main(String[] args) {
		//SpringApplication.run(PokeApiTeamBuilderApplication.class, args);
		Application.launch(ChartApplication.class, args); // javaFX init
	}

}
