package main;

import business.SportControl;
import gui.BuergeraemterAnwendersystem;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		//Aufruf der Vorgabe, um Buerger aufzunehmen/speichern und sie in eine txt/csv Datei zu schreiben
		//new BuergeraemterAnwendersystem(primaryStage);
		new SportControl(primaryStage);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
