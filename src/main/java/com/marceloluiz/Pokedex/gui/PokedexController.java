package com.marceloluiz.Pokedex.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import com.marceloluiz.Pokedex.models.entities.PokemonPokedex;
import com.marceloluiz.Pokedex.models.enums.PokeType;
import com.marceloluiz.Pokedex.services.PokemonPokedexDeserializer;
import com.marceloluiz.Pokedex.util.Alerts;
import com.marceloluiz.Pokedex.util.Constraints;
import com.marceloluiz.Pokedex.util.Utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

@Component
public class PokedexController implements Initializable{
	
	//FXML Controls
	@FXML
	private Button rightArrowBtn;
	@FXML
	private Button leftArrowBtn;
	@FXML
	private Button startBtn;
	
	@FXML
	private Pane paneBg;
	
	@FXML
	private ImageView photoFrame;
	
	@FXML
	private Button closeBtn;
	
	@FXML
	private ImageView typeOneImg;
	@FXML
	private ImageView typeTwoImg;
	
	@FXML
	private Label weaknessesTitleLabel;
	@FXML
	private Label weaknessesOneLabel;
	@FXML
	private Label weaknessesTwoLabel;
	@FXML
	private Label weaknessesThreeLabel;
	@FXML
	private Label weaknessesFourLabel;
	@FXML
	private Label weaknessesFiveLabel;
	@FXML
	private Label weaknessesSixLabel;
	@FXML
	private Label weaknessesSevenLabel;
	
	@FXML
	private ImageView weaknessesOneImg;
	@FXML
	private ImageView weaknessesTwoImg;
	@FXML
	private ImageView weaknessesThreeImg;
	@FXML
	private ImageView weaknessesFourImg;
	@FXML
	private ImageView weaknessesFiveImg;
	@FXML
	private ImageView weaknessesSixImg;
	@FXML
	private ImageView weaknessesSevenImg;
	@FXML
	private ImageView regionImg;
	
	@FXML
	private Label regionLabel;
	@FXML
	private Label generationLabel;
	
	@FXML
	private Button shinyBtn;
	
	@FXML
	private Label nameLabel;
	@FXML
	private Label numberLabel;
	@FXML
	private Label typeOneLabel;
	@FXML
	private Label typeTwoLabel;
	
	@FXML
	private Label heightTxt;
	@FXML
	private Label weightTxt;
	@FXML
	private Label genderTxt;
	@FXML
	private Label heightLabel;
	@FXML
	private Label genderLabel;
	@FXML
	private Label weightLabel;
	
	@FXML
	private TextField searchTxt;
	
	@FXML
	private Button searchBtn;
	
	@FXML
	private Button infoBtn;
	
	@FXML
	private ImageView startImg;
	@FXML
	private ImageView closeImg;
	
	@FXML
	private Button statsBtn;
	
	//non JavaFx controls
	private PokemonPokedexDeserializer pokemonPokedexDeserializer;
	private PokemonPokedex pokemon;
	private boolean shinyOn = false;
	
	private StatsViewController statsViewController;
	
	
	@FXML
	private void onActionRightArrowBtn() {
		int index = pokemon.getId();
		
		if(pokemon.getId() == 1025) {
			System.out.println("cannot go any further");
		}
		else {
			pokemonPokedexDeserializer.setJson(index + 1);
			pokemon = pokemonPokedexDeserializer.createPokemon(pokemon);
			
			shinyOn = false;
			pokemonLabelUpdate();
			pokemonImgUpdate();
			
			searchTxt.setText("0");
		}
	}
	@FXML
	private void onActionLeftArrowBtn() {
		int index = pokemon.getId();
		
		if(pokemon.getId() == 1) {
			System.out.println("cannot go behind");
		}
		else {
			pokemonPokedexDeserializer.setJson(index - 1);
			pokemon = pokemonPokedexDeserializer.createPokemon(pokemon);
			
			shinyOn = false;
			pokemonLabelUpdate();
			pokemonImgUpdate();
			
			searchTxt.setText("0");
		}
	}
	
	@FXML
	private void onActionStartBtn(ActionEvent event) {
		initializeControls();
		
		pokemonPokedexDeserializer = new PokemonPokedexDeserializer();
		pokemonPokedexDeserializer.setJson(1);
		
		pokemon = pokemonPokedexDeserializer.createPokemon(pokemon);
		
		pokemonImgUpdate();
		pokemonLabelUpdate();
		
//		System.out.println(pokemon.toString());
	}
	
	private void pokemonImgUpdate() {
		Image pokemonImg = new Image(pokemon.getImage());
		photoFrame.setImage(pokemonImg);
	}
	
	private void pokemonLabelUpdate() {
		Double height = Double.parseDouble(pokemon.getHeight()) / 10;
		Double weight = Double.parseDouble(pokemon.getWeight()) / 10;
		
		nameLabel.setText(pokemon.getName());
		numberLabel.setText("N° " + Integer.toString(pokemon.getId()));
		if(pokemon.getId()>=1000) {
			numberLabel.setStyle("-fx-font-size: 18px;");
		}
		regionLabel.setText(pokemon.getRegion());
		generationLabel.setText(Integer.toString(pokemon.getGeneration()) + " GENERATION");
		heightLabel.setText(height.toString() + " M");
		weightLabel.setText(weight.toString() + " KG");
		genderLabel.setText("UNKNOWN");
		//STATS BUTTON NOT READY YET
		
		pokemonTypeUpdate();
		pokemonWeaknessUpdate();
	}
	
	private void pokemonWeaknessUpdate() {
		Label[] label = {weaknessesOneLabel, weaknessesTwoLabel, weaknessesThreeLabel, weaknessesFourLabel, weaknessesFiveLabel, weaknessesSixLabel, weaknessesSevenLabel};
		ImageView[] imageView = {weaknessesOneImg, weaknessesTwoImg, weaknessesThreeImg, weaknessesFourImg, weaknessesFiveImg, weaknessesSixImg, weaknessesSevenImg};
		
		if (pokemon.getWeaknesses().size() == 1) {
			clearInfo();
			
            weaknessesOneLabel.setLayoutX(547);
            weaknessesOneImg.setLayoutX(547+6);

        } else if (pokemon.getWeaknesses().size() == 2) {
        	clearInfo();
        	
            weaknessesOneLabel.setLayoutX(522);
            weaknessesOneImg.setLayoutX(522+6);

            weaknessesTwoLabel.setLayoutX(572);
            weaknessesTwoImg.setLayoutX(572+6);

        } else if (pokemon.getWeaknesses().size() == 3) {
        	clearInfo();
        	
            weaknessesOneLabel.setLayoutX(507);
            weaknessesOneImg.setLayoutX(507+6);
            
            weaknessesTwoLabel.setLayoutX(547);
            weaknessesTwoImg.setLayoutX(547+6);
            
            weaknessesThreeLabel.setLayoutX(590);
            weaknessesThreeImg.setLayoutX(590+6);

        } else if (pokemon.getWeaknesses().size() == 4) {
        	clearInfo();
        	
            weaknessesOneLabel.setLayoutX(473);
            weaknessesOneImg.setLayoutX(473+6);

            weaknessesTwoLabel.setLayoutX(522);
            weaknessesTwoImg.setLayoutX(522+6);
                 
            weaknessesThreeLabel.setLayoutX(572);
            weaknessesThreeImg.setLayoutX(572+6);
            
            weaknessesFourLabel.setLayoutX(621);
            weaknessesFourImg.setLayoutX(621+6);

        } else if (pokemon.getWeaknesses().size() == 5) {
        	clearInfo();
        	
            weaknessesOneLabel.setLayoutX(462);
            weaknessesOneImg.setLayoutX(462+6);

            weaknessesTwoLabel.setLayoutX(505);
            weaknessesTwoImg.setLayoutX(505+6);
            
            weaknessesThreeLabel.setLayoutX(547);
            weaknessesThreeImg.setLayoutX(547+6);
            
            weaknessesFourLabel.setLayoutX(590);
            weaknessesFourImg.setLayoutX(590+6);
            
            weaknessesFiveLabel.setLayoutX(633);
            weaknessesFiveImg.setLayoutX(633+6);

        } else if (pokemon.getWeaknesses().size() == 6) {
        	clearInfo();
        	
            weaknessesOneLabel.setLayoutX(447);
            weaknessesOneImg.setLayoutX(447+6);
            
            weaknessesTwoLabel.setLayoutX(486);
            weaknessesTwoImg.setLayoutX(486+6);
            
            weaknessesThreeLabel.setLayoutX(526);
            weaknessesThreeImg.setLayoutX(526+6);
            
            weaknessesFourLabel.setLayoutX(567);
            weaknessesFourImg.setLayoutX(567+6);

            weaknessesFiveLabel.setLayoutX(608);
            weaknessesFiveImg.setLayoutX(608+6);
            
            weaknessesSixLabel.setLayoutX(647);
            weaknessesSixImg.setLayoutX(647+6);
        } else if (pokemon.getWeaknesses().size() == 7) {
        	clearInfo();
        	
            weaknessesOneLabel.setLayoutX(443);
            weaknessesOneImg.setLayoutX(443+6);
            
            weaknessesTwoLabel.setLayoutX(478);
            weaknessesTwoImg.setLayoutX(478+6);
            
            weaknessesThreeLabel.setLayoutX(513);
            weaknessesThreeImg.setLayoutX(513+6);
            
            weaknessesFourLabel.setLayoutX(547);
            weaknessesFourImg.setLayoutX(547+6);

            weaknessesFiveLabel.setLayoutX(583);
            weaknessesFiveImg.setLayoutX(583+6);
            
            weaknessesSixLabel.setLayoutX(616);
            weaknessesSixImg.setLayoutX(616+6);
            
            weaknessesSevenLabel.setLayoutX(651);
            weaknessesSevenImg.setLayoutX(651+6);
        }
		
		typeInfo(pokemon.getWeaknesses().stream().findFirst().orElse(null), label[0], imageView[0]);
		for(int i = 1; i< pokemon.getWeaknesses().size(); i++) {
			typeInfo(pokemon.getWeaknesses().stream().skip(i).findFirst().orElse(null), label[i], imageView[i]);
		}
		
	}
	
	private void pokemonTypeUpdate() {
		typeInfo(pokemon.getPokeType().get(0), typeOneLabel, typeOneImg);
		
		if(pokemon.getPokeType().size() == 1) {
			typeTwoImg.setImage(null);
			typeTwoLabel.setText("");
		}
		else {	
			typeInfo(pokemon.getPokeType().get(1), typeTwoLabel, typeTwoImg);
		}
	}
	
	private void typeInfo(PokeType type, Label label, ImageView image) {
		label.setStyle(type.getColor());
		label.setText(type.toString());
		image.setImage(new Image(type.getImage()));
	}
	
	@FXML
	private void onActionSearchBtn() {
		String idNumber = searchTxt.getText();
		if(!idNumber.equals("")) {
			int number = Integer.parseInt(idNumber);
			if(number > 0 && number <= 1025) {		
				pokemonPokedexDeserializer.setJson(number);
				pokemon = pokemonPokedexDeserializer.createPokemon(pokemon);
				
				shinyOn = false;
				pokemonLabelUpdate();
				pokemonImgUpdate();
				
				searchTxt.setText(idNumber);
			}
			else searchTxt.setText("0");
		}
	}
	
	@FXML
	private void onActionShinyBtn() {
		if(!shinyOn && pokemon.getShinyImg() != null) {
			Image pokemonImg = new Image(pokemon.getShinyImg());
			photoFrame.setImage(pokemonImg);
			
			shinyOn = true;
		}
		else {
			pokemonImgUpdate();	
			shinyOn = false;
		}
	}
	
	@FXML
	private void onActionInfoBtn() {
		System.out.println("infoBtn");
	}
	
	@FXML
	private void onActionStatsBtn(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("StatsView.fxml"));
			Parent root = (Parent) loader.load();
			
			statsViewController = loader.getController();
			
			Stage stage = new Stage();
			
			stage.setTitle("Stats");
			stage.setScene(new Scene(root));
			stage.setResizable(false);
			stage.initOwner(Utils.currentStage(event));
			stage.initModality(Modality.WINDOW_MODAL);
			
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
		
		if(statsViewController != null) statsViewController.updatePokemonData(pokemon);
	}
	
	@FXML
	private void onBtnCloseAction(ActionEvent event) {
		Utils.currentStage(event).close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initializeNodes();	
	}
	
	
	private void initializeNodes() {
		Constraints.setTextFieldNumericOnly(searchTxt);
		Constraints.setTextFieldMaxLength(searchTxt, 4);
	}
	
	private void initializeControls() {
		leftArrowBtn.setVisible(true);
		rightArrowBtn.setVisible(true);
		shinyBtn.setVisible(true);

		regionImg.setVisible(true);

        heightTxt.setVisible(true);
        weightTxt.setVisible(true);
        genderTxt.setVisible(true);
        
        weaknessesTitleLabel.setVisible(true);

        searchBtn.setVisible(true);
        searchTxt.setVisible(true);
        searchTxt.setText("0");

        closeBtn.setVisible(true);
        startBtn.setVisible(false);
        startImg.setVisible(false);
        closeImg.setVisible(true);
        
        statsBtn.setVisible(true);
	}
	
	private void clearInfo() {
		weaknessesOneLabel.setText("");
        weaknessesTwoLabel.setText("");
        weaknessesThreeLabel.setText("");
        weaknessesFourLabel.setText("");
        weaknessesFiveLabel.setText("");
        weaknessesSixLabel.setText("");
        weaknessesSevenLabel.setText("");
        
        weaknessesOneImg.setImage(null);
        weaknessesTwoImg.setImage(null);
        weaknessesThreeImg.setImage(null);
        weaknessesFourImg.setImage(null);
        weaknessesFiveImg.setImage(null);
        weaknessesSixImg.setImage(null);
        weaknessesSevenImg.setImage(null);
	}
	
	public PokemonPokedex getPokemon() {
		return pokemon;
	}
}