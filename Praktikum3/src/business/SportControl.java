package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import observer.Observer;

public class SportControl implements Observer{
	
	private SportView sportView;
	private SportModel sportModel;
	
	public SportControl(Stage primaryStage) {
		this.sportModel = sportModel.getInstance();
		sportView = new SportView(this, sportModel, primaryStage);
		sportModel.addObserver(this);
		
	}
	
	
	void nehmeSportVereinAuf(){
	    try {
			this.sportView.nehmeSportVereinAuf();
		} catch (Exception e) {
			// TODO Auto-generated catch block
	       	this.sportView.zeigeFehlermeldungsfensterAn(e.getMessage());
		}
	}
	
	
	void leseAusDatei(String typ){
		
		
		try {
      		if("csv".equals(typ)){
      			this.sportModel.leseAusDateiCSV();
      			/*this.sportView.zeigeInformationsfensterAn(
	  	   			"Die Sportvereine wurden gelesen!");*/
      			
      		} else {
      			
      			this.sportModel.leseAusDateiTXT();
      			
      			/*this.sportView.zeigeInformationsfensterAn(
		   				"Noch nicht implementiert!");*/
		   	}
		}
		catch(IOException exc){
			this.sportView.zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
		}
		catch(Exception exc){
			this.sportView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
		}
		

	
	}
	
	
	void schreibeSportVereinInCsv() {
		try {
			this.sportModel.schreibeSportVereinInCsv();
			

   			this.sportView.zeigeInformationsfensterAn(
	   			"Die Sportvereine wurden gespeichert!");
   			
		}	
		catch(IOException exc){
			this.sportView.zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			this.sportView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}
	
	
	public void update() {
		sportView.zeigeSportVereineAn();
	}


	

}
