package gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;


public class Gui extends Application {

	private Stage primaryStage;
	private ScrollPane sp;

	@Override
	public void start (Stage primaryStage) throws IOException {

		setPrimaryStage(primaryStage);
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("gui.fxml"));
		sp = loader.load();
		primaryStage.setTitle("Pokémon Crystal Randofuser");
		primaryStage.setScene(new Scene(sp));
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main (String[] args) {
		launch();
	}

	public Stage getPrimaryStage (Event e) {
		return primaryStage;
	}

	public void setPrimaryStage (Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

}