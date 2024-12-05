//Herr Jonker vielleicht nochmal fragen, warum ich die Reihenfolge von den TextFields nicht ändern konnte
//Hab es irgendwie relativ "normal" hingekriegt, würde es aber dennoch gerne wissen.
//Generell auch auf andere Fragen ACHTEN!!!!

//Prüfen ob Observer eine instanz von observable ist (nur bei schon java implementierten)
    /*@Override
    public void update(Observable o, Object arg){

    	if(o instanceof BaelleModel) {	*/

package business;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import ownUtil.MeldungsfensterAnzeiger;

public class SportView {
	
	private SportControl sportControl;
	private SportModel sportModel;
	
	
	//Nur zu Info Sportverein Objekt wurde in Model erstellt

	
    //---Anfang Attribute der grafischen Oberflaeche---
    private Pane pane     					= new  Pane();
    private Label lblEingabe    	 		= new Label("Eingabe");
    private Label lblAnzeige   	 	    	= new Label("Anzeige");
    
    private Label lblName 					= new Label("Name: ");
    private Label lblOrt   					= new Label("Ort:");
    private Label lblEhemalige  	 		= new Label("Anzahl Ehemalige: ");
    private Label lblAnzahlMitglieder   	= new Label("Anzahl Mitglieder: ");
    private Label lblSportarten  			= new Label("Sportarten: ");
    
    private TextField name 	 				= new TextField();
    private TextField ort					= new TextField();
    private TextField anzahlEhemaligerMitglieder = new TextField();
    private TextField anzahlMitglieder1			= new TextField();
    private TextField sportArten1			= new TextField();

    private TextArea txtAnzeige  			= new TextArea();
    private Button btnEingabe 		 		= new Button("Eingabe");
    private Button btnAnzeige 		 		= new Button("Anzeige");
    private MenuBar mnbrMenuLeiste  		= new MenuBar();
    private Menu mnDatei             		= new Menu("Datei");
    private MenuItem mnItmCsvImport 		= new MenuItem("csv-Import");
    private MenuItem mnItmTxtImport 		= new MenuItem("txt-Import");
    private MenuItem mnItmCsvExport 		= new MenuItem("csv-Export");  
	
	
	public SportView(SportControl sportControl, SportModel sportModel, Stage primaryStage ) {
		this.sportControl = sportControl;
		this.sportModel = sportModel;
				
		
		//Entweder für das Hauptfenster in eigene Methode auslagern, oder im Construktor reinpacken (glaube beides möglich/richtig/okay)
		Scene scene = new Scene(this.pane, 700, 340);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Verwaltung von SportVereinen");
    	primaryStage.show();
    	
    	this.initKomponenten();
    	
		this.initListener();
		
		//Fall beim schließen z.B iwas gemacht werden soll wie z.B. den Observer abmelden
		//primaryStage.setOnCloseRequest(event -> handleWindowClosing(event, primaryStage));
		
	}
	
	 private void initKomponenten(){
	       	// Labels
	    	lblEingabe.setLayoutX(20);
	    	lblEingabe.setLayoutY(40);
	    	Font font = new Font("Arial", 24); 
	    	lblEingabe.setFont(font);
	    	lblEingabe.setStyle("-fx-font-weight: bold;"); 
	    	lblAnzeige.setLayoutX(400);
	    	lblAnzeige.setLayoutY(40);
	      	lblAnzeige.setFont(font);
	       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 
	       	lblName.setLayoutX(20);
	    	lblName.setLayoutY(90);
	    	lblOrt.setLayoutX(20);
	    	lblOrt.setLayoutY(130);
	    	lblEhemalige.setLayoutX(20);
	    	lblEhemalige.setLayoutY(170);
	    	lblAnzahlMitglieder.setLayoutX(20);
	    	lblAnzahlMitglieder.setLayoutY(210);
	    	lblSportarten.setLayoutX(20);
	    	lblSportarten.setLayoutY(250);    	
	       	pane.getChildren().addAll(lblEingabe, lblAnzeige, 
	       		lblName, lblOrt, lblEhemalige,
	       		lblAnzahlMitglieder, lblSportarten);
	    
	    	// Textfelder
	     	name.setLayoutX(170);
	    	name.setLayoutY(90);
	    	name.setPrefWidth(200);
	    	
	    	ort.setLayoutX(170);
	    	ort.setLayoutY(130);
	    	ort.setPrefWidth(200);
	    	anzahlEhemaligerMitglieder.setLayoutX(170);
	    	anzahlEhemaligerMitglieder.setLayoutY(170);
	    	anzahlEhemaligerMitglieder.setPrefWidth(200);
	      	anzahlMitglieder1.setLayoutX(170);
	    	anzahlMitglieder1.setLayoutY(210);
	    	anzahlMitglieder1.setPrefWidth(200);
	    	sportArten1.setLayoutX(170);
	    	sportArten1.setLayoutY(250);
	    	sportArten1.setPrefWidth(200);
	      	pane.getChildren().addAll( 
	     		name, ort, anzahlEhemaligerMitglieder,
	     		anzahlMitglieder1, sportArten1);
	     	
	        // Textbereich	
	        txtAnzeige.setEditable(false);
	     	txtAnzeige.setLayoutX(400);
	    	txtAnzeige.setLayoutY(90);
	     	txtAnzeige.setPrefWidth(270);
	    	txtAnzeige.setPrefHeight(185);
	       	pane.getChildren().add(txtAnzeige); 
	       	
	        // Buttons
	        btnEingabe.setLayoutX(20);
	        btnEingabe.setLayoutY(290);
	        btnAnzeige.setLayoutX(400);
	        btnAnzeige.setLayoutY(290);
	        pane.getChildren().addAll(btnEingabe, btnAnzeige); 
	        
	 		// Menue
	  	    this.mnbrMenuLeiste.getMenus().add(mnDatei);
	  	    this.mnDatei.getItems().add(mnItmCsvImport);
	  	    this.mnDatei.getItems().add(mnItmTxtImport);
	  	    this.mnDatei.getItems().add(new SeparatorMenuItem());
	  	    this.mnDatei.getItems().add(mnItmCsvExport);
	 	    pane.getChildren().add(mnbrMenuLeiste);
	   }
	
		//Anmerkung: wenn ich be ->this<-.sportControl.nehmeSportVereinAuf geht das nicht (weiß nicht warum)
	   private void initListener() {
		    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent e) {
	        	    sportControl.nehmeSportVereinAuf();
	            }
		    });
		    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
		    	@Override
		        public void handle(ActionEvent e) {
		    		//methode unten gucken wegen info
		            //zeigeSportVereineAn();
		        } 
	   	    });
		    mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
		    	@Override
		        public void handle(ActionEvent e) {
		    		sportControl.leseAusDatei("csv");
		    	}
		    });
		    mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
			    @Override
			    public void handle(ActionEvent e) {
			    	sportControl.leseAusDatei("txt");
			    }
	    	});
		    mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					sportControl.schreibeSportVereinInCsv();
				}	
		    });
	    }
	
	   
	   void nehmeSportVereinAuf() throws Exception{
		   //Wenn man im Sportarten Feld es mit einem _ trennt und wieder einliest wird das Array richtig belegt
		   //Aber beim eingeben wird es so angezeigt, als wäre es ein Wort.
		   //Generell komisch muss man fragen
		   
		   Sportverein sportVerein = new Sportverein(
		   			name.getText(), 
		  	        Float.parseFloat(anzahlEhemaligerMitglieder.getText()),
		  	        Float.parseFloat(anzahlMitglieder1.getText()),
		   		    ort.getText(),
		   		    
		   		    
		   		    //Generell mit dem Splitten ist komisch zwischen ";" und "_" muss man gucken kp 
		   		    //Ich glaube, weil es sich um eine Excel handelt, splitet er den "Tabelleneintrag"
		   		    //Man soll es mit unterstrichen Eingeben, damit es richtig gelesen werden kann
		   		    //Eventuell muss man beim nächsten Praktikum dafür sorgen, das die ganze Excel angezeigt wird?
		   		    sportArten1.getText().split(";"));
		   			
		   
		   			//Test um zu gucken ob die Attribute des Objekts auch richtig gesetzt werden
		   			/*System.out.println("------------------------------------------------------------------");
		   			System.out.println(sportVerein.getName());
		   			System.out.println(sportVerein.getAnzahlEhemaligerMitglieder());
		   			System.out.println(sportVerein.getAnzahlMitglieder());
		   			System.out.println(sportVerein.getOrt());
		   			
		   			//Hier in dem Fall ist der Trenner einfach wie es ausgegeben wird. Weil in der Methode geht er durch das Array
		   			//und gibt einen Einzeiligen-String zurück der nach dem Zeichen getrennt wird, welches man ihm übergibt.
		 		    System.out.println("Sportarten: " + sportVerein.getSportArtenAlsString(' '));
		   			System.out.println("------------------------------------------------------------------");*/


		   			//Test ob Sportarten auch richtig getrennt werden
		   			String[] sportart = sportVerein.getSportarten();
		   			
		   			for(String e : sportart) {
		   				System.out.println(e);
		   			}

   		
	    		//Das Sporvereinobjekt was neu erzeugt wird, muss dem Sportmodel übergeben werden!!!
	    		//Andernfalls weiß es nicht, um welches Objekt es sich handelt
	    		 //System.out.println("Eingabe knopf wird gedrückt und setSportVerein aufgerufen");
	    	this.sportModel.setSportVerein(sportVerein);
	    	zeigeInformationsfensterAn("Der Sportverein wurde aufgenommen!");
	    	this.sportModel.notifyObservers();
	       	
	       
	    }   
	   
	   
	//Im Model lassen, weil das Textfield hier "gesettet"/belegt wird und falls noch kein Sportverein aufgenommen wurde
	//die methode zeigeInformationsfensterAn direkt hier in der View aufgerufen wird. Deswegen hier gelassen.   
	//private void zeigeSportVereineAn(){
	   
	   void zeigeSportVereineAn() {
	   
		//siehe BuergeraemterAnwendersystem für info
    	if(this.sportModel.sportVerein != null){
    		txtAnzeige.setText(
    			sportModel.sportVerein.gibSportVereinZurueck(' '));
    		
    		//Test ob Sportarten auch richtig getrennt werden wird mit _ getrennt + in der Klasse Sportverein_Methode: gibSportVereinZurueck
    		//Habe ich das zurückgeben des Strings geändert (siehe selbst)
   			String[] sportart = sportModel.sportVerein.getSportarten();
   			
   			for(String e : sportart) {
   				System.out.println(e);
   			}
    		
    	}
    	else{
    		zeigeInformationsfensterAn("Bisher wurde kein Sportverein aufgenommen!");
    	}
    }   

	
	void zeigeInformationsfensterAn(String meldung){
    	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
    		"Information", meldung).zeigeMeldungsfensterAn();
    }	
    
    void zeigeFehlermeldungsfensterAn(String meldung){
       	new MeldungsfensterAnzeiger(AlertType.ERROR,
        	"Fehler", meldung).zeigeMeldungsfensterAn();
    }
    
    
    //Fenster schließen und observer abmelden damit das Informationsfenster nicht angezeigt wird
    private void handleWindowClosing(WindowEvent event, Stage stage) {
    	//verhindert das automatische schließen des fensters
    	event.consume();
    	
    	//this.baelleModel.deleteObserver(this);
    	System.out.println("Fenster wird geschlossen!!!");
    	
    	stage.close();
    }

}
