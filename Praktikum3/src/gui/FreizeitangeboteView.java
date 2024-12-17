package gui;

import java.util.ArrayList;

import business.SportModel;
import business.Sportverein;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class FreizeitangeboteView {
	
private FreizeitangeboteControl freizeitangeboteControl;
private SportModel sportvereineModel;	

    	//---Anfang Attribute der grafischen Oberflaeche---
    	private Pane pane = new  Pane();
    	private Label lblAnzeigeSportvereine     
 		= new Label("Anzeige Sportvereine");
    	private TextArea txtAnzeigeSportvereine  = new TextArea();
    	private Button btnAnzeigeSportvereine = new Button("Anzeige");
    	//-------Ende Attribute der grafischen Oberflaeche-------
    
    	public FreizeitangeboteView(
	 		FreizeitangeboteControl 
	 		freizeitangeboteControl, 
	   	 	Stage primaryStage, 
	 		SportModel sportvereineModel){
	    	Scene scene = new Scene(this.pane, 560, 340);
	    	primaryStage.setScene(scene);
	    	primaryStage.setTitle("Anzeige von Freizeitangeboten");
	    	primaryStage.show();
	    	this.freizeitangeboteControl = freizeitangeboteControl;
	 		this.sportvereineModel = sportvereineModel;
	 		this.initKomponenten();
			this.initListener();
    	}

 	private void initKomponenten(){
    		// Label
 		Font font = new Font("Arial", 20);
       	lblAnzeigeSportvereine.setLayoutX(310);
    		lblAnzeigeSportvereine.setLayoutY(40);
    		lblAnzeigeSportvereine.setFont(font);
    		lblAnzeigeSportvereine.setStyle("-fx-font-weight: bold;"); 
       	pane.getChildren().add(lblAnzeigeSportvereine);           
// Textbereich	
        	txtAnzeigeSportvereine.setEditable(false);
     		txtAnzeigeSportvereine.setLayoutX(310);
    		txtAnzeigeSportvereine.setLayoutY(90);
     		txtAnzeigeSportvereine.setPrefWidth(220);
    		txtAnzeigeSportvereine.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeigeSportvereine);        	
        	// Button
          	btnAnzeigeSportvereine.setLayoutX(310);
        	btnAnzeigeSportvereine.setLayoutY(290);
        	pane.getChildren().add(btnAnzeigeSportvereine); 
   }
   
   private void initListener() {
	    btnAnzeigeSportvereine.setOnAction(
 			new EventHandler<ActionEvent>() {
	    		@Override
	        	public void handle(ActionEvent e) {
	            	//zeigeSportvereineAn();
	        	} 
   	    });
    }
   
    void zeigeSportvereineAn(){

    		
    		//siehe BuergeraemterAnwendersystem für info
 		   if((this.sportvereineModel.getVerein()) != null){
 	    		/*txtAnzeige.setText(
 	    			sportModel.sportVerein.gibSportVereinZurueck(' '));*/
 	    		
 	    		String text = "";
 	    		
 	    		ArrayList<Sportverein> sportvereine = this.sportvereineModel.getSportVereine();
 	    		
 	    		for(Sportverein s : sportvereine) {
 	    			
 	    			System.out.println(s.gibSportVereinZurueck(' '));
 	 
 	    			//txtAnzeige.setText(
 	    	    		//	sportvereine.get(i).gibSportVereinZurueck(' '));
 	    			
 	    			text = text + s.gibSportVereinZurueck(' ');
 	    			
 	    		}
 	    		
 	    		txtAnzeigeSportvereine.setText(text);
 		   }
    		
    		else{
    			zeigeInformationsfensterAn(
 				"Bisher wurde kein Sportverein aufgenommen!");
    		}
    }	
   
    private void zeigeInformationsfensterAn(String meldung){
    	  	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
               	"Information", meldung).zeigeMeldungsfensterAn();
    }	
    
}
