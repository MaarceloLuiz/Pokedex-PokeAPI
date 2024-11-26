package com.marceloluiz.Pokedex.gui;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import com.marceloluiz.Pokedex.models.PokeStats;
import com.marceloluiz.Pokedex.models.entities.Pokemon;
import com.marceloluiz.Pokedex.models.entities.PokemonPokedex;
import com.marceloluiz.Pokedex.services.PokemonPokedexDeserializer;
import com.marceloluiz.Pokedex.services.PokemonService;
import com.marceloluiz.Pokedex.util.Constraints;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

@Component
public class TeamBuilderController implements Initializable{
	
	@FXML
	private ImageView addImgOne;
	@FXML
	private ImageView addImgTwo;
	@FXML
	private ImageView addImgThree;
	@FXML
	private ImageView addImgFour;
	@FXML
	private ImageView addImgFive;
	@FXML
	private ImageView addImgSix;
	
	//PANE 1
	@FXML
	private Label nameLabel;
	@FXML
	private Label idLabel;
	
	@FXML
	private ImageView mainImage;
	
	@FXML
	private ImageView firstTypeImg;
	@FXML
	private ImageView secondTypeImg;
	
	@FXML
	private Label hpLabel;
	@FXML
	private ProgressBar hpProgressBar;
	@FXML
	private Label hpValueLabel;
	
	@FXML
	private Label atkLabel;
	@FXML
	private ProgressBar atkProgressBar;
	@FXML
	private Label atkValueLabel;
	
	@FXML
	private Label defLabel;
	@FXML
	private ProgressBar defProgressBar;
	@FXML
	private Label defValueLabel;
	
	@FXML
	private Label spAtkLabel;
	@FXML
	private ProgressBar spAtkProgressBar;
	@FXML
	private Label spAtkValueLabel;
	
	@FXML
	private Label spDefLabel;
	@FXML
	private ProgressBar spDefProgressBar;
	@FXML
	private Label spDefValueLabel;
	
	@FXML
	private ImageView changeImg;
	
	@FXML
	private Label searchIdLabel;
	@FXML
	private TextField searchIdText;
	@FXML
	private Button searchBtn;
	
	//PANE 2
	@FXML
	private Label nameLabelTwo;
	@FXML
	private Label idLabelTwo;
	
	@FXML
	private ImageView mainImageTwo;
	
	@FXML
	private ImageView firstTypeImg2;
	@FXML
	private ImageView secondTypeImg2;
	
	@FXML
	private Label hpLabelTwo;
	@FXML
	private ProgressBar hpProgressBarTwo;
	@FXML
	private Label hpValueLabelTwo;
	
	@FXML
	private Label atkLabelTwo;
	@FXML
	private ProgressBar atkProgressBarTwo;
	@FXML
	private Label atkValueLabelTwo;
	
	@FXML
	private Label defLabelTwo;
	@FXML
	private ProgressBar defProgressBarTwo;
	@FXML
	private Label defValueLabelTwo;
	
	@FXML
	private Label spAtkLabelTwo;
	@FXML
	private ProgressBar spAtkProgressBarTwo;
	@FXML
	private Label spAtkValueLabelTwo;
	
	@FXML
	private Label spDefLabelTwo;
	@FXML
	private ProgressBar spDefProgressBarTwo;
	@FXML
	private Label spDefValueLabelTwo;

	@FXML
	private ImageView changeImgTwo;
	
	@FXML
	private Label searchIdLabelTwo;
	@FXML
	private TextField searchIdTextTwo;
	@FXML
	private Button searchBtnTwo;
	
	//PANE 3
	@FXML
	private Label nameLabelThree;
	@FXML
	private Label idLabelThree;
	
	@FXML
	private ImageView mainImageThree;
	
	@FXML
	private ImageView firstTypeImg3;
	@FXML
	private ImageView secondTypeImg3;
	
	@FXML
	private Label hpLabelThree;
	@FXML
	private ProgressBar hpProgressBarThree;
	@FXML
	private Label hpValueLabelThree;
	
	@FXML
	private Label atkLabelThree;
	@FXML
	private ProgressBar atkProgressBarThree;
	@FXML
	private Label atkValueLabelThree;
	
	@FXML
	private Label defLabelThree;
	@FXML
	private ProgressBar defProgressBarThree;
	@FXML
	private Label defValueLabelThree;
	
	@FXML
	private Label spAtkLabelThree;
	@FXML
	private ProgressBar spAtkProgressBarThree;
	@FXML
	private Label spAtkValueLabelThree;
	
	@FXML
	private Label spDefLabelThree;
	@FXML
	private ProgressBar spDefProgressBarThree;
	@FXML
	private Label spDefValueLabelThree;

	@FXML
	private ImageView changeImgThree;
	
	@FXML
	private Label searchIdLabelThree;
	@FXML
	private TextField searchIdTextThree;
	@FXML
	private Button searchBtnThree;
	
	//PANE 4
	@FXML
	private Label nameLabelFour;
	@FXML
	private Label idLabelFour;
	
	@FXML
	private ImageView mainImageFour;
	
	@FXML
	private ImageView firstTypeImg4;
	@FXML
	private ImageView secondTypeImg4;
	
	@FXML
	private Label hpLabelFour;
	@FXML
	private ProgressBar hpProgressBarFour;
	@FXML
	private Label hpValueLabelFour;
	
	@FXML
	private Label atkLabelFour;
	@FXML
	private ProgressBar atkProgressBarFour;
	@FXML
	private Label atkValueLabelFour;
	
	@FXML
	private Label defLabelFour;
	@FXML
	private ProgressBar defProgressBarFour;
	@FXML
	private Label defValueLabelFour;
	
	@FXML
	private Label spAtkLabelFour;
	@FXML
	private ProgressBar spAtkProgressBarFour;
	@FXML
	private Label spAtkValueLabelFour;
	
	@FXML
	private Label spDefLabelFour;
	@FXML
	private ProgressBar spDefProgressBarFour;
	@FXML
	private Label spDefValueLabelFour;

	@FXML
	private ImageView changeImgFour;
	
	@FXML
	private Label searchIdLabelFour;
	@FXML
	private TextField searchIdTextFour;
	@FXML
	private Button searchBtnFour;
	
	//PANE 5
	@FXML
	private Label nameLabelFive;
	@FXML
	private Label idLabelFive;
	
	@FXML
	private ImageView mainImageFive;
	
	@FXML
	private ImageView firstTypeImg5;
	@FXML
	private ImageView secondTypeImg5;
	
	@FXML
	private Label hpLabelFive;
	@FXML
	private ProgressBar hpProgressBarFive;
	@FXML
	private Label hpValueLabelFive;
	
	@FXML
	private Label atkLabelFive;
	@FXML
	private ProgressBar atkProgressBarFive;
	@FXML
	private Label atkValueLabelFive;
	
	@FXML
	private Label defLabelFive;
	@FXML
	private ProgressBar defProgressBarFive;
	@FXML
	private Label defValueLabelFive;
	
	@FXML
	private Label spAtkLabelFive;
	@FXML
	private ProgressBar spAtkProgressBarFive;
	@FXML
	private Label spAtkValueLabelFive;
	
	@FXML
	private Label spDefLabelFive;
	@FXML
	private ProgressBar spDefProgressBarFive;
	@FXML
	private Label spDefValueLabelFive;

	@FXML
	private ImageView changeImgFive;
	
	@FXML
	private Label searchIdLabelFive;
	@FXML
	private TextField searchIdTextFive;
	@FXML
	private Button searchBtnFive;
	
	//PANE 6
	@FXML
	private Label nameLabelSix;
	@FXML
	private Label idLabelSix;
	
	@FXML
	private ImageView mainImageSix;
	
	@FXML
	private ImageView firstTypeImg6;
	@FXML
	private ImageView secondTypeImg6;
	
	@FXML
	private Label hpLabelSix;
	@FXML
	private ProgressBar hpProgressBarSix;
	@FXML
	private Label hpValueLabelSix;
	
	@FXML
	private Label atkLabelSix;
	@FXML
	private ProgressBar atkProgressBarSix;
	@FXML
	private Label atkValueLabelSix;
	
	@FXML
	private Label defLabelSix;
	@FXML
	private ProgressBar defProgressBarSix;
	@FXML
	private Label defValueLabelSix;
	
	@FXML
	private Label spAtkLabelSix;
	@FXML
	private ProgressBar spAtkProgressBarSix;
	@FXML
	private Label spAtkValueLabelSix;
	
	@FXML
	private Label spDefLabelSix;
	@FXML
	private ProgressBar spDefProgressBarSix;
	@FXML
	private Label spDefValueLabelSix;

	@FXML
	private ImageView changeImgSix;
	
	@FXML
	private Label searchIdLabelSix;
	@FXML
	private TextField searchIdTextSix;
	@FXML
	private Button searchBtnSix;
	
	//non javaFX components
	private PokemonService service;
	private ObservableList<Pokemon> obsList;
	
	private PokemonPokedexDeserializer pokemonPokedexDeserializer;
	private PokemonPokedex pokemon;
	
	public void setPokemonService(PokemonService service) {
		this.service = service;
	}
	
	//First Image Click Events
	@FXML
	public void onActionImgOneClick() {
		updateSearchInfoControls(addImgOne, searchIdLabel, searchIdText, searchBtn);
	}
	@FXML
	public void onActionImgTwoClick() {
		updateSearchInfoControls(addImgTwo, searchIdLabelTwo, searchIdTextTwo, searchBtnTwo);
	}
	@FXML
	public void onActionImgThreeClick() {	
		updateSearchInfoControls(addImgThree, searchIdLabelThree, searchIdTextThree, searchBtnThree);
	}
	@FXML
	public void onActionImgFourClick() {	
		updateSearchInfoControls(addImgFour, searchIdLabelFour, searchIdTextFour, searchBtnFour);
	}
	@FXML
	public void onActionImgFiveClick() {
		updateSearchInfoControls(addImgFive, searchIdLabelFive, searchIdTextFive, searchBtnFive);
	}
	@FXML
	public void onActionImgSixClick() {	
		updateSearchInfoControls(addImgSix, searchIdLabelSix, searchIdTextSix, searchBtnSix);
	}
	
	// OK BUTTON CLICK
	@FXML
	public void onActionSearchBtnClick() {
		String idNumber = searchIdText.getText();
		if(!idNumber.equals("")) {
			int number = Integer.parseInt(idNumber);
			if(number > 0 && number <= 1025) {		
				updatePokemonData(number, mainImage, firstTypeImg, secondTypeImg, nameLabel, idLabel);
				
				updatePokemonInfoControls(searchIdLabel, searchIdText, searchBtn,
						hpLabel, hpProgressBar, hpValueLabel, 
						atkLabel, atkProgressBar, atkValueLabel,
						defLabel, defProgressBar, defValueLabel,
						spAtkLabel, spAtkProgressBar, spAtkValueLabel,
						spDefLabel, spDefProgressBar, spDefValueLabel, changeImg);
				
				searchIdText.setText(idNumber);
			}
			else searchIdText.setText("0");
		}
	}
	@FXML
	public void onActionSearchBtnTwoClick() {
		String idNumber = searchIdTextTwo.getText();
		if(!idNumber.equals("")) {
			int number = Integer.parseInt(idNumber);
			if(number > 0 && number <= 1025) {		
				updatePokemonData(number, mainImageTwo, firstTypeImg2, secondTypeImg2, nameLabelTwo, idLabelTwo);
				
				updatePokemonInfoControls(searchIdLabelTwo, searchIdTextTwo, searchBtnTwo,
						hpLabelTwo, hpProgressBarTwo, hpValueLabelTwo, 
						atkLabelTwo, atkProgressBarTwo, atkValueLabelTwo,
						defLabelTwo, defProgressBarTwo, defValueLabelTwo,
						spAtkLabelTwo, spAtkProgressBarTwo, spAtkValueLabelTwo,
						spDefLabelTwo, spDefProgressBarTwo, spDefValueLabelTwo, changeImgTwo);
				
				searchIdTextTwo.setText(idNumber);
			}
			else searchIdTextTwo.setText("0");
		}
	}
	@FXML
	public void onActionSearchBtnThreeClick() {
		String idNumber = searchIdTextThree.getText();
		if(!idNumber.equals("")) {
			int number = Integer.parseInt(idNumber);
			if(number > 0 && number <= 1025) {		
				updatePokemonData(number, mainImageThree, firstTypeImg3, secondTypeImg3, nameLabelThree, idLabelThree);
				
				updatePokemonInfoControls(searchIdLabelThree, searchIdTextThree, searchBtnThree,
						hpLabelThree, hpProgressBarThree, hpValueLabelThree, 
						atkLabelThree, atkProgressBarThree, atkValueLabelThree,
						defLabelThree, defProgressBarThree, defValueLabelThree,
						spAtkLabelThree, spAtkProgressBarThree, spAtkValueLabelThree,
						spDefLabelThree, spDefProgressBarThree, spDefValueLabelThree, changeImgThree);
				
				searchIdTextThree.setText(idNumber);
			}
			else searchIdTextThree.setText("0");
		}
	}
	@FXML
	public void onActionSearchBtnFourClick() {
		String idNumber = searchIdTextFour.getText();
		if(!idNumber.equals("")) {
			int number = Integer.parseInt(idNumber);
			if(number > 0 && number <= 1025) {		
				updatePokemonData(number, mainImageFour, firstTypeImg4, secondTypeImg4, nameLabelFour, idLabelFour);
				
				updatePokemonInfoControls(searchIdLabelFour, searchIdTextFour, searchBtnFour,
						hpLabelFour, hpProgressBarFour, hpValueLabelFour, 
						atkLabelFour, atkProgressBarFour, atkValueLabelFour,
						defLabelFour, defProgressBarFour, defValueLabelFour,
						spAtkLabelFour, spAtkProgressBarFour, spAtkValueLabelFour,
						spDefLabelFour, spDefProgressBarFour, spDefValueLabelFour, changeImgFour);
				
				searchIdTextFour.setText(idNumber);
			}
			else searchIdTextFour.setText("0");
		}
	}
	@FXML
	public void onActionSearchBtnFiveClick() {
		String idNumber = searchIdTextFive.getText();
		if(!idNumber.equals("")) {
			int number = Integer.parseInt(idNumber);
			if(number > 0 && number <= 1025) {		
				updatePokemonData(number, mainImageFive, firstTypeImg5, secondTypeImg5, nameLabelFive, idLabelFive);
				
				updatePokemonInfoControls(searchIdLabelFive, searchIdTextFive, searchBtnFive,
						hpLabelFive, hpProgressBarFive, hpValueLabelFive, 
						atkLabelFive, atkProgressBarFive, atkValueLabelFive,
						defLabelFive, defProgressBarFive, defValueLabelFive,
						spAtkLabelFive, spAtkProgressBarFive, spAtkValueLabelFive,
						spDefLabelFive, spDefProgressBarFive, spDefValueLabelFive, changeImgFive);
				
				searchIdTextFive.setText(idNumber);
			}
			else searchIdTextFive.setText("0");
		}
	}
	@FXML
	public void onActionSearchBtnSixClick() {
		String idNumber = searchIdTextSix.getText();
		if(!idNumber.equals("")) {
			int number = Integer.parseInt(idNumber);
			if(number > 0 && number <= 1025) {		
				updatePokemonData(number, mainImageSix, firstTypeImg6, secondTypeImg6, nameLabelSix, idLabelSix);
				
				updatePokemonInfoControls(searchIdLabelSix, searchIdTextSix, searchBtnSix,
						hpLabelSix, hpProgressBarSix, hpValueLabelSix, 
						atkLabelSix, atkProgressBarSix, atkValueLabelSix,
						defLabelSix, defProgressBarSix, defValueLabelSix,
						spAtkLabelSix, spAtkProgressBarSix, spAtkValueLabelSix,
						spDefLabelSix, spDefProgressBarSix, spDefValueLabelSix, changeImgSix);
				
				searchIdTextSix.setText(idNumber);
			}
			else searchIdTextSix.setText("0");
		}
	}
	
	//Change Pokemon Image Click Events
	@FXML
	public void onActionChangeImgClick() {
		updatePokemonInfoControlsAfterChange(searchIdLabel, searchIdText, searchBtn,
				hpLabel, hpProgressBar, hpValueLabel, 
				atkLabel, atkProgressBar, atkValueLabel,
				defLabel, defProgressBar, defValueLabel,
				spAtkLabel, spAtkProgressBar, spAtkValueLabel,
				spDefLabel, spDefProgressBar, spDefValueLabel,changeImg,
				nameLabel, idLabel,
				firstTypeImg, secondTypeImg, mainImage);
	}
	@FXML
	public void onActionChangeImgTwoClick() {
		updatePokemonInfoControlsAfterChange(searchIdLabelTwo, searchIdTextTwo, searchBtnTwo,
				hpLabelTwo, hpProgressBarTwo, hpValueLabelTwo, 
				atkLabelTwo, atkProgressBarTwo, atkValueLabelTwo,
				defLabelTwo, defProgressBarTwo, defValueLabelTwo,
				spAtkLabelTwo, spAtkProgressBarTwo, spAtkValueLabelTwo,
				spDefLabelTwo, spDefProgressBarTwo, spDefValueLabelTwo, changeImgTwo,
				nameLabelTwo, idLabelTwo,
				firstTypeImg2, secondTypeImg2, mainImageTwo);
	}
	@FXML
	public void onActionChangeImgThreeClick() {
		updatePokemonInfoControlsAfterChange(searchIdLabelThree, searchIdTextThree, searchBtnThree,
				hpLabelThree, hpProgressBarThree, hpValueLabelThree, 
				atkLabelThree, atkProgressBarThree, atkValueLabelThree,
				defLabelThree, defProgressBarThree, defValueLabelThree,
				spAtkLabelThree, spAtkProgressBarThree, spAtkValueLabelThree,
				spDefLabelThree, spDefProgressBarThree, spDefValueLabelThree, changeImgThree,
				nameLabelThree, idLabelThree,
				firstTypeImg3, secondTypeImg3, mainImageThree);
	}
	@FXML
	public void onActionChangeImgFourClick() {
		updatePokemonInfoControlsAfterChange(searchIdLabelFour, searchIdTextFour, searchBtnFour,
				hpLabelFour, hpProgressBarFour, hpValueLabelFour, 
				atkLabelFour, atkProgressBarFour, atkValueLabelFour,
				defLabelFour, defProgressBarFour, defValueLabelFour,
				spAtkLabelFour, spAtkProgressBarFour, spAtkValueLabelFour,
				spDefLabelFour, spDefProgressBarFour, spDefValueLabelFour, changeImgFour,
				nameLabelFour, idLabelFour,
				firstTypeImg4, secondTypeImg4, mainImageFour);
	}
	@FXML
	public void onActionChangeImgFiveClick() {
		updatePokemonInfoControlsAfterChange(searchIdLabelFive, searchIdTextFive, searchBtnFive,
				hpLabelFive, hpProgressBarFive, hpValueLabelFive, 
				atkLabelFive, atkProgressBarFive, atkValueLabelFive,
				defLabelFive, defProgressBarFive, defValueLabelFive,
				spAtkLabelFive, spAtkProgressBarFive, spAtkValueLabelFive,
				spDefLabelFive, spDefProgressBarFive, spDefValueLabelFive, changeImgFive,
				nameLabelFive, idLabelFive,
				firstTypeImg5, secondTypeImg5, mainImageFive);
	}
	@FXML
	public void onActionChangeImgSixClick() {
		updatePokemonInfoControlsAfterChange(searchIdLabelSix, searchIdTextSix, searchBtnSix,
				hpLabelSix, hpProgressBarSix, hpValueLabelSix, 
				atkLabelSix, atkProgressBarSix, atkValueLabelSix,
				defLabelSix, defProgressBarSix, defValueLabelSix,
				spAtkLabelSix, spAtkProgressBarSix, spAtkValueLabelSix,
				spDefLabelSix, spDefProgressBarSix, spDefValueLabelSix, changeImgSix,
				nameLabelSix, idLabelSix,
				firstTypeImg6, secondTypeImg6, mainImageSix);
	}
	
	private void pokemonImgUpdate(ImageView mainImage) {
		Image pokemonImg = new Image(pokemon.getImage());
		mainImage.setImage(pokemonImg);
	}

	private void pokemonTypeUpdate(ImageView imageOne, ImageView imageTwo) {
		imageOne.setImage(new Image(pokemon.getPokeType().get(0).getImage()));
		
		if(pokemon.getPokeType().size() == 1) {
			imageTwo.setImage(null);
		}
		else {	
			imageTwo.setImage(new Image(pokemon.getPokeType().get(1).getImage()));
		}
	}
	
	private void pokemonLabelUpdate(Label name, Label id) {
		name.setText(pokemon.getName());
		id.setText("N° " + Integer.toString(pokemon.getId()));
	}
	
//	private void updatePokemonStatsData() {
//		Label[] label = {hpLabel, atkLabel, defLabel, spAtkLabel, spDefLabel};
//		ProgressBar[] progressBar = {hpProgressBar, atkProgressBar, defProgressBar, spAtkProgressBar, spDefProgressBar};
//		Label[] labelValue = {hpValueLabel, atkValueLabel, defValueLabel, spAtkValueLabel, spDefValueLabel};
//		
//		for(int i = 0; i< pokemon.getStats().size() -1; i++) {
//			updateStatsInfo(pokemon.getStats().get(i), label[i], progressBar[i], labelValue[i]);
//		}
//	}
	
	private void updateStatsInfo(PokeStats stats, Label label, ProgressBar progressBar, Label labelValue) {
		label.setText(stats.getStat().toString().replace("_", " "));
		progressBar.setProgress((double) stats.getBaseStat() / 255);
		labelValue.setText(stats.getBaseStat().toString());
	}
	
	private void updatePokemonInfoControls(Label searchLbl, TextField searchTxt, Button searchBtn, 
											Label hp, ProgressBar hpBar, Label hpValue,
											Label atk, ProgressBar atkbar, Label atkValue,
											Label def, ProgressBar defBar, Label defValue,
											Label spAtk, ProgressBar spAtkBar, Label spAtkValue,
											Label spDef, ProgressBar spDefBar, Label spDefValue,
											ImageView changeImg) {
		searchLbl.setVisible(false);
		searchTxt.setVisible(false);
		searchBtn.setVisible(false);
		
		hp.setVisible(true);
		hpBar.setVisible(true);
		hpValue.setVisible(true);
		
		atk.setVisible(true);
		atkbar.setVisible(true);
		atkValue.setVisible(true);
		
		def.setVisible(true);
		defBar.setVisible(true);
		defValue.setVisible(true);
		
		spAtk.setVisible(true);
		spAtkBar.setVisible(true);
		spAtkValue.setVisible(true);
		
		spDef.setVisible(true);
		spDefBar.setVisible(true);
		spDefValue.setVisible(true);
		
		changeImg.setImage(new Image("file:assets/img/teams/pokemonChange.png"));
		
		Label[] label = {hp, atk, def, spAtk, spDef};
		ProgressBar[] progressBar = {hpBar, atkbar, defBar, spAtkBar, spDefBar};
		Label[] labelValue = {hpValue, atkValue, defValue, spAtkValue, spDefValue};
		
		for(int i = 0; i< pokemon.getStats().size() -1; i++) {
			updateStatsInfo(pokemon.getStats().get(i), label[i], progressBar[i], labelValue[i]);
		}
		
	}
	
	private void updatePokemonInfoControlsAfterChange(Label searchLbl, TextField searchTxt, Button searchBtn, 
											Label hp, ProgressBar hpBar, Label hpValue,
											Label atk, ProgressBar atkbar, Label atkValue,
											Label def, ProgressBar defBar, Label defValue,
											Label spAtk, ProgressBar spAtkBar, Label spAtkValue,
											Label spDef, ProgressBar spDefBar, Label spDefValue, ImageView changeImg,
											Label nameLbl, Label idLbl,
											ImageView typeImgOne, ImageView typeImgTwo, ImageView mainImg) {
			searchLbl.setVisible(true);
			searchTxt.setVisible(true);
			searchBtn.setVisible(true);
			
			hp.setVisible(false);
			hpBar.setVisible(false);
			hpValue.setVisible(false);
			
			atk.setVisible(false);
			atkbar.setVisible(false);
			atkValue.setVisible(false);
			
			def.setVisible(false);
			defBar.setVisible(false);
			defValue.setVisible(false);
			
			spAtk.setVisible(false);
			spAtkBar.setVisible(false);
			spAtkValue.setVisible(false);
			
			spDef.setVisible(false);
			spDefBar.setVisible(false);
			spDefValue.setVisible(false);
			
			nameLbl.setText("");
			idLbl.setText("");
			
			typeImgOne.setImage(null);
			typeImgTwo.setImage(null);
			mainImg.setImage(null);
			
			changeImg.setImage(null);
			
	}
	
	private void updateSearchInfoControls(ImageView image, Label label, TextField textField, Button button) {
		image.setVisible(false);
		
		label.setVisible(true);
		textField.setVisible(true);
		button.setVisible(true);
	}
	
	private void updatePokemonData(Integer jsonNumber, ImageView mainImage,
									ImageView firstType, ImageView secondtype,
									Label name, Label id){
		
		pokemonPokedexDeserializer = new PokemonPokedexDeserializer();
		pokemonPokedexDeserializer.setJson(jsonNumber);
		pokemon = pokemonPokedexDeserializer.createPokemon(pokemon);

		pokemonImgUpdate(mainImage);
		pokemonTypeUpdate(firstType, secondtype);
		pokemonLabelUpdate(name, id);
//		updatePokemonStatsData();
	}
	
	public void addPokemon() {
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}

//		List<Pokemon> list = service.findAll();
//		obsList = FXCollections.observableArrayList(list);
//		tableViewTeamBuilder.setItems(obsList);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initializeNodes();
	}
	
	private void initializeNodes() {
		Image addIcon = new Image("file:assets/img/teams/pokeball.png");
		addImgOne.setImage(addIcon);
		addImgTwo.setImage(addIcon);
		addImgThree.setImage(addIcon);
		addImgFour.setImage(addIcon);
		addImgFive.setImage(addIcon);
		addImgSix.setImage(addIcon);
		
		Constraints.setTextFieldNumericOnly(searchIdText);
		Constraints.setTextFieldMaxLength(searchIdText, 4);
		
		Constraints.setTextFieldNumericOnly(searchIdTextTwo);
		Constraints.setTextFieldMaxLength(searchIdTextTwo, 4);
		
		Constraints.setTextFieldNumericOnly(searchIdTextThree);
		Constraints.setTextFieldMaxLength(searchIdTextThree, 4);
		
		Constraints.setTextFieldNumericOnly(searchIdTextFour);
		Constraints.setTextFieldMaxLength(searchIdTextFour, 4);
		
		Constraints.setTextFieldNumericOnly(searchIdTextFive);
		Constraints.setTextFieldMaxLength(searchIdTextFive, 4);
		
		Constraints.setTextFieldNumericOnly(searchIdTextSix);
		Constraints.setTextFieldMaxLength(searchIdTextSix, 4);
	}
}
