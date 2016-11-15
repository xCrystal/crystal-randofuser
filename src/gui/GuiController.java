package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import data.Settings;
import engine.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class GuiController implements Initializable {
	
	private static final GuiController guiController = new GuiController();
	
	@FXML private ToggleGroup baseStats;
	@FXML private RadioButton averageBaseStats;
	@FXML private RadioButton averageBaseStatPatterns;
	
	@FXML private CheckBox homogenizeGrowthRates;
	@FXML private CheckBox separateLegends, separateWeak1StageEvos, separateWeak3StageEvos;
	
	private List<Integer> johtoLevels = new ArrayList<Integer>();
	private List<Integer> kantoLevels = new ArrayList<Integer>();
	@FXML private ChoiceBox<Integer> johto, kanto;
	
	@FXML private Button classic, balanced, difficult, crazy;
	
	public static GuiController getGuicontroller() {
		return guiController;
	}
	
	@FXML
	private void beginProgram() {
		Main.main();
	}
	
	private void initChoiceBoxes() {
		
		johtoLevels.addAll(Arrays.asList(0, 10, 20));
		kantoLevels.addAll(Arrays.asList(0, 10, 20, 30, 40));
		johto.getItems().addAll(johtoLevels);
		kanto.getItems().addAll(kantoLevels);
		johto.setValue(0);
		kanto.setValue(0);
	}

	@Override
	public void initialize (URL location, ResourceBundle resources) {
		averageBaseStatPatterns.setSelected(true);
		separateLegends.setSelected(true);
		initChoiceBoxes();
		choiceBoxesListener();
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
	
	@FXML
	private void defaultClassic() {
		
		Settings.averageBaseStats = false;
		averageBaseStats.setSelected(false);
		averageBaseStatPatterns.setSelected(true);
		
		Settings.homogenizeGrowthRates = false;
		homogenizeGrowthRates.setSelected(false);
		
		Settings.johtoLevelBump = 0;
		Settings.kantoLevelBump = 0;
		johto.setValue(0);
		kanto.setValue(0);
		
		Settings.setLegends();
		separateLegends.setSelected(true);
		Settings.ignoreWeakOneStagePokemon();
		separateWeak1StageEvos.setSelected(false);
		Settings.ignoreWeakThreeStageEvos();
		separateWeak3StageEvos.setSelected(false);
	}
	
	@FXML
	private void defaultBalanced() {
		
		Settings.averageBaseStats = false;
		averageBaseStats.setSelected(false);
		averageBaseStatPatterns.setSelected(true);
		
		Settings.homogenizeGrowthRates = true;
		homogenizeGrowthRates.setSelected(true);
		
		Settings.johtoLevelBump = 0;
		Settings.kantoLevelBump = 20;
		johto.setValue(0);
		kanto.setValue(20);
		
		Settings.setLegends();
		separateLegends.setSelected(true);
		Settings.ignoreWeakOneStagePokemon();
		separateWeak1StageEvos.setSelected(false);
		Settings.ignoreWeakThreeStageEvos();
		separateWeak3StageEvos.setSelected(false);
	}
	
	@FXML
	private void defaultDifficult() {
		
		Settings.averageBaseStats = true;
		averageBaseStats.setSelected(true);
		averageBaseStatPatterns.setSelected(false);
		
		Settings.homogenizeGrowthRates = false;
		homogenizeGrowthRates.setSelected(false);
		
		Settings.johtoLevelBump = 10;
		Settings.kantoLevelBump = 30;
		johto.setValue(10);
		kanto.setValue(30);
		
		Settings.setLegends();
		separateLegends.setSelected(true);
		Settings.setWeakOneStagePokemon();
		separateWeak1StageEvos.setSelected(true);
		Settings.setWeakThreeStageEvos();
		separateWeak3StageEvos.setSelected(true);
	}
	
	@FXML
	private void defaultCrazy() {
		
		Settings.averageBaseStats = true;
		averageBaseStats.setSelected(true);
		averageBaseStatPatterns.setSelected(false);
		
		Settings.homogenizeGrowthRates = false;
		homogenizeGrowthRates.setSelected(false);
		
		Settings.johtoLevelBump = 20;
		Settings.kantoLevelBump = 40;
		johto.setValue(20);
		kanto.setValue(40);
		
		Settings.ignoreLegends();
		separateLegends.setSelected(false);
		Settings.ignoreWeakOneStagePokemon();
		separateWeak1StageEvos.setSelected(false);
		Settings.ignoreWeakThreeStageEvos();
		separateWeak3StageEvos.setSelected(false);
	}
	
	private void choiceBoxesListener() {
	
		johto.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
				Settings.johtoLevelBump = johtoLevels.get(newValue.intValue());
			}
		});
	
		kanto.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
				Settings.kantoLevelBump = kantoLevels.get(newValue.intValue());
			}
		});
	}
}
