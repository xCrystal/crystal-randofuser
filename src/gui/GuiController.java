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
	@FXML private CheckBox replaceHappinessEvos;	
	@FXML private CheckBox separateLegends, separateWeak1StageEvos, separateWeak3StageEvos;
	
	private List<Integer> johtoLevels = new ArrayList<Integer>();
	private List<Integer> kantoLevels = new ArrayList<Integer>();
	@FXML private ChoiceBox<Integer> johto, kanto;
	
	@FXML private Button classic, balanced, difficult, crazy;
	
	@FXML private ToggleGroup gloom;
	@FXML private RadioButton vileplume;
	@FXML private RadioButton bellossom;
	
	@FXML private ToggleGroup poliwhirl;
	@FXML private RadioButton poliwrath;
	@FXML private RadioButton politoed;
	
	@FXML private ToggleGroup slowpoke;
	@FXML private RadioButton slowbro;
	@FXML private RadioButton slowking;
	
	@FXML private ToggleGroup scyther;
	@FXML private RadioButton scizor;
	@FXML private RadioButton none;
	
	@FXML private ToggleGroup tyrogue;
	@FXML private RadioButton hitmontop;
	@FXML private RadioButton hitmonlee;
	@FXML private RadioButton hitmonchan;
	
	@FXML private ToggleGroup eevee;
	@FXML private RadioButton vaporeon;
	@FXML private RadioButton jolteon;
	@FXML private RadioButton flareon;
	@FXML private RadioButton espeon;
	@FXML private RadioButton umbreon;
	
	private List<Integer> typePriorities = new ArrayList<Integer>();	
	@FXML private ChoiceBox<Integer> normal, grass, fire, water, bug, poison, flying, fighting;
	@FXML private ChoiceBox<Integer> rock, ground, electric, psychic, ice, ghost, dragon, dark, steel;	
	
	public static GuiController getGuicontroller() {
		return guiController;
	}
	
	@FXML
	private void beginProgram() {
		Main.main();
	}
	
	private void initChoiceBoxes() {
		
		johtoLevels.addAll(Arrays.asList(0, 10, 20));
		kantoLevels.addAll(Arrays.asList(0, 10, 20, 30, 40, 50));
		johto.getItems().addAll(johtoLevels);
		kanto.getItems().addAll(kantoLevels);
		johto.setValue(0);
		kanto.setValue(0);
		
		typePriorities.addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16));
		normal.getItems().addAll(typePriorities);
		grass.getItems().addAll(typePriorities);
		fire.getItems().addAll(typePriorities);
		water.getItems().addAll(typePriorities);
		bug.getItems().addAll(typePriorities);
		poison.getItems().addAll(typePriorities);
		flying.getItems().addAll(typePriorities);
		fighting.getItems().addAll(typePriorities);
		rock.getItems().addAll(typePriorities);
		ground.getItems().addAll(typePriorities);
		electric.getItems().addAll(typePriorities);
		psychic.getItems().addAll(typePriorities);
		ice.getItems().addAll(typePriorities);
		ghost.getItems().addAll(typePriorities);
		dragon.getItems().addAll(typePriorities);
		dark.getItems().addAll(typePriorities);
		steel.getItems().addAll(typePriorities);
		normal.setValue(7);
		grass.setValue(8);
		fire.setValue(8);
		water.setValue(8);
		bug.setValue(8);
		poison.setValue(8);
		flying.setValue(8);
		fighting.setValue(8);
		rock.setValue(8);
		ground.setValue(8);
		electric.setValue(8);
		psychic.setValue(8);
		ice.setValue(8);
		ghost.setValue(8);
		dragon.setValue(8);
		dark.setValue(8);
		steel.setValue(8);
	}
	
	private void selectDefaultEvoLines() {
		
		vileplume.setSelected(true);
		poliwrath.setSelected(true);
		slowbro.setSelected(true);
		scizor.setSelected(true);
		hitmontop.setSelected(true);
		vaporeon.setSelected(true);
	}

	@Override
	public void initialize (URL location, ResourceBundle resources) {
		
		averageBaseStatPatterns.setSelected(true);
		separateLegends.setSelected(true);
		initChoiceBoxes();
		choiceBoxesListener();
		selectDefaultEvoLines();
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
	private void handleReplaceHappinessEvosClick() {
		Settings.replaceHappinessEvos ^= true;
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
		Settings.replaceHappinessEvos = false;
		replaceHappinessEvos.setSelected(false);
		
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
		Settings.replaceHappinessEvos = true;
		replaceHappinessEvos.setSelected(true);
		
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
		Settings.replaceHappinessEvos = false;
		replaceHappinessEvos.setSelected(false);
		
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
		Settings.replaceHappinessEvos = false;
		replaceHappinessEvos.setSelected(false);
		
		Settings.johtoLevelBump = 20;
		Settings.kantoLevelBump = 50;
		johto.setValue(20);
		kanto.setValue(50);
		
		Settings.ignoreLegends();
		separateLegends.setSelected(false);
		Settings.ignoreWeakOneStagePokemon();
		separateWeak1StageEvos.setSelected(false);
		Settings.ignoreWeakThreeStageEvos();
		separateWeak3StageEvos.setSelected(false);
	}
	
	@FXML
	private void handleVileplumeClick() {
		Settings.setOddishGloomVileplume();
	}
	
	@FXML
	private void handleBellossomClick() {
		Settings.setOddishGloomBellossom();
	}
	
	@FXML
	private void handlePoliwrathClick() {
		Settings.setPoliwagPoliwhirlPoliwrath();
	}
	
	@FXML
	private void handlePolitoedClick() {
		Settings.setPoliwagPoliwhirlPolitoed();
	}
	
	@FXML
	private void handleSlowbroClick() {
		Settings.setSlowpokeSlowbro();
	}
	
	@FXML
	private void handleSlowkingClick() {
		Settings.setSlowpokeSlowking();
	}
	
	@FXML
	private void handleHitmontopClick() {
		Settings.setTyrogueHitmontop();
	}
	
	@FXML
	private void handleHitmonleeClick() {
		Settings.setTyrogueHitmonlee();
	}
	
	@FXML
	private void handleHitmonchanClick() {
		Settings.setTyrogueHitmonchan();
	}
	
	@FXML
	private void handleScizorClick() {
		Settings.keepScytherScizorEvolution();
	}
	
	@FXML
	private void handleNoneClick() {
		Settings.makeScytherScizorIndependent();
	}
	
	@FXML
	private void handleVaporeonClick() {
		Settings.setEeveeVaporeon();
	}
	
	@FXML
	private void handleJolteonClick() {
		Settings.setEeveeJolteon();
	}
	
	@FXML
	private void handleFlareonClick() {
		Settings.setEeveeFlareon();
	}
	
	@FXML
	private void handleEspeonClick() {
		Settings.setEeveeEspeon();
	}
	
	@FXML
	private void handleUmbreonClick() {
		Settings.setEeveeUmbreon();
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
		
		normal.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
				Settings.normal = typePriorities.get(newValue.intValue());
			}
		});
		
		grass.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
				Settings.grass = typePriorities.get(newValue.intValue());
			}
		});
		
		fire.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
				Settings.fire = typePriorities.get(newValue.intValue());
			}
		});
		
		water.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
				Settings.water = typePriorities.get(newValue.intValue());
			}
		});
		
		bug.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
				Settings.bug = typePriorities.get(newValue.intValue());
			}
		});
		
		poison.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
				Settings.poison = typePriorities.get(newValue.intValue());
			}
		});
		
		flying.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
				Settings.flying = typePriorities.get(newValue.intValue());
			}
		});
		
		fighting.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
				Settings.fighting = typePriorities.get(newValue.intValue());
			}
		});
		
		rock.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
				Settings.rock = typePriorities.get(newValue.intValue());
			}
		});
		
		ground.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
				Settings.ground = typePriorities.get(newValue.intValue());
			}
		});
		
		electric.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
				Settings.electric = typePriorities.get(newValue.intValue());
			}
		});
		
		psychic.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
				Settings.psychic = typePriorities.get(newValue.intValue());
			}
		});
		
		ice.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
				Settings.ice = typePriorities.get(newValue.intValue());
			}
		});
		
		ghost.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
				Settings.ghost = typePriorities.get(newValue.intValue());
			}
		});
		
		dragon.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
				Settings.dragon = typePriorities.get(newValue.intValue());
			}
		});
		
		dark.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
				Settings.dark = typePriorities.get(newValue.intValue());
			}
		});
		
		steel.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
				Settings.steel = typePriorities.get(newValue.intValue());
			}
		});
	}
}
