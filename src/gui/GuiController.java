package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import data.Settings;
import engine.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class GuiController implements Initializable {
	
	private static final GuiController guiController = new GuiController();
	
	private List<Integer> JohtoLevels = new ArrayList<Integer>();
	private List<Integer> KantoLevels = new ArrayList<Integer>();
	
	@FXML private ToggleGroup baseStats;
	@FXML private RadioButton averageBaseStats;
	@FXML private RadioButton averageBaseStatPatterns;
	
	@FXML private CheckBox homogenizeGrowthRates;
	@FXML private CheckBox separateLegends, separateWeak1StageEvos, separateWeak3StageEvos;
	
	public static GuiController getGuicontroller() {
		return guiController;
	}

	@Override
	public void initialize (URL location, ResourceBundle resources) {
		averageBaseStatPatterns.setSelected(true);
	}
	
	@FXML
	private void beginProgram() {
		Main.main();
	}
	
	@FXML
	private void handleAverageBaseStatsClick() {
		Settings.averageBaseStats = true;
	}
	
	@FXML
	private void handleAverageBaseStatPatternsClick() {
		Settings.averageBaseStats = false;
	}
		
	@FXML
	private void handleHomogenizeGrowthRatesClick() {
		Settings.homogenizeGrowthRates ^= true;
	}
	
	@FXML
	private void handleSeparateWeak1StageEvosClick() {
		if (separateWeak1StageEvos.isSelected())
			Settings.setWeakOneStagePokemon();
		else
			Settings.ignoreWeakOneStagePokemon();
	}
	
	@FXML
	private void handleSeparateWeak3StageEvos() {
		if (separateWeak3StageEvos.isSelected())
			Settings.setWeakThreeStageEvos();
		else
			Settings.ignoreWeakThreeStageEvos();
	}
	
	@FXML
	private void handleSeparateLegendsClick() {
		if (separateLegends.isSelected())
			Settings.setLegends();
		else
			Settings.ignoreLegends();
	}
}
