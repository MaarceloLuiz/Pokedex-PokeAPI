package com.marceloluiz.Pokedex.gui;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import com.marceloluiz.Pokedex.models.PokeStats;
import com.marceloluiz.Pokedex.models.entities.PokemonPokedex;
import com.marceloluiz.Pokedex.util.Utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

@Component
public class StatsViewController implements Initializable{
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
	private Button closeBtn;
	
	@FXML
	private void onActionCloseBtn(ActionEvent event) {
		Utils.currentStage(event).close();
	}
	
	public void updatePokemonData(PokemonPokedex pokemon) {
		Label[] label = {hpLabel, atkLabel, defLabel, spAtkLabel, spDefLabel};
		ProgressBar[] progressBar = {hpProgressBar, atkProgressBar, defProgressBar, spAtkProgressBar, spDefProgressBar};
		Label[] labelValue = {hpValueLabel, atkValueLabel, defValueLabel, spAtkValueLabel, spDefValueLabel};
		
		for(int i = 0; i< pokemon.getStats().size() -1; i++) {
			updateInfo(pokemon.getStats().get(i), label[i], progressBar[i], labelValue[i]);
		}
	}
	
	private void updateInfo(PokeStats stats, Label label, ProgressBar progressBar, Label labelValue) {
		label.setText(stats.getStat().toString().replace("_", " "));
		progressBar.setProgress((double) stats.getBaseStat() / 255);
		labelValue.setText(stats.getBaseStat().toString());
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
}
