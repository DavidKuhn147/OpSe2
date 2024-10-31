package business;

import javafx.stage.Stage;

public class SportControl {
	
	SportView sportView;
	SportModel sportModel;
	
	public SportControl(Stage primaryStage) {
		this.sportModel = new SportModel();
		sportView = new SportView(this, sportModel, primaryStage);
		
	}
	
	  private void nehmeBuergeramtAuf(){
	    	Sportverein sportverein = this.sportModel.getSportVerein();
		    
	    	thi
		    
		    
	    }
	   
	    private void zeigeBuergeraemterAn(){
	    	if(this.sportVerein != null){
	    		txtAnzeige.setText(
	    			this.sportVerein.gibBuergeramtZurueck(' '));
	    	}
	    	else{
	    		zeigeInformationsfensterAn("Bisher wurde kein Bürgeramt aufgenommen!");
	    	}
	    } 

}
