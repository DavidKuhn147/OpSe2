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
import ownUtil.MeldungsfensterAnzeiger;

public class SportView {
	
	SportControl sportControl;
	SportModel sportModel;
	
	 private Pane pane     					= new  Pane();
	 private Label lblEingabe    	 		= new Label("Eingabe");
	 private Label lblAnzeige   	 	    	= new Label("Anzeige");
	 private Label lblName 					= new Label("Name:");
	 private Label lblGeoeffnetVon   		= new Label("Geöffnet von:");
	 private Label lblGeoeffnetBis  	 		= new Label("Geöffnet bis:");
	 private Label lblStrasseHNr   			= new Label("Straße und Hausnummer:");
	 private Label lblDienstleistungen  		= new Label("Dienstleistungen:");
	 private TextField name 	 			= new TextField();
	 private TextField ort		= new TextField();
	    private TextField anzahlMitglieder	= new TextField();
	    private TextField anzahlEhemaligerMitglieder = new TextField();
	    private TextField sportarten			= new TextField();
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
		this.sportModel = new SportModel();
		
		
		
		//hier noch Objekt von sportModel erzeugen
		
		
		Scene scene = new Scene(this.pane, 700, 340);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Verwaltung von SportVereinen");
    	primaryStage.show();
    	
  
    	this.initKomponenten();
		this.initListener();
		
		
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
    	lblGeoeffnetVon.setLayoutX(20);
    	lblGeoeffnetVon.setLayoutY(130);
    	lblGeoeffnetBis.setLayoutX(20);
    	lblGeoeffnetBis.setLayoutY(170);
    	lblStrasseHNr.setLayoutX(20);
    	lblStrasseHNr.setLayoutY(210);
    	lblDienstleistungen.setLayoutX(20);
    	lblDienstleistungen.setLayoutY(250);    	
       	pane.getChildren().addAll(lblEingabe, lblAnzeige, 
       		lblName, lblGeoeffnetVon, lblGeoeffnetBis,
       		lblStrasseHNr, lblDienstleistungen);
    
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
      	sportarten.setLayoutX(170);
    	sportarten.setLayoutY(210);
    	sportarten.setPrefWidth(200);
    	anzahlMitglieder.setLayoutX(170);
    	anzahlMitglieder.setLayoutY(250);
    	anzahlMitglieder.setPrefWidth(200);
      	pane.getChildren().addAll( 
     		name, ort, anzahlEhemaligerMitglieder,
     		sportarten, anzahlMitglieder);
     	
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
	
	private void initListener() {
	    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	Sportverein sportverein = new Sportverein(name.getText(), ort.getText(), anzahlEhemaligerMitglieder.getText(), anzahlMitglieder.getText(), sportarten.getText());
            	this.sportModel.setSportverein(sportverein);
            	//this.sportControl.nehmeBuergeramtauf();
            	
            }
	    });
	    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	            zeigeBuergeraemterAn();
	        } 
   	    });
	    mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	       	 	leseAusDatei("csv");
	    	}
	    });
	    mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent e) {
		     	leseAusDatei("txt");
		    }
    	});
	    mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				schreibeBuergeraemterInCsvDatei();
			}	
	    });
    }
	
	
	
	
	
	
	private void zeigeInformationsfensterAn(String meldung){
    	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
    		"Information", meldung).zeigeMeldungsfensterAn();
    }	
    
    void zeigeFehlermeldungsfensterAn(String meldung){
       	new MeldungsfensterAnzeiger(AlertType.ERROR,
        	"Fehler", meldung).zeigeMeldungsfensterAn();
    }

}
