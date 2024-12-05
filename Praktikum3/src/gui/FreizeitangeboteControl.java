package gui;

import business.SportModel;

import javafx.stage.Stage;
import observer.Observer;
public class FreizeitangeboteControl implements Observer{	
	private FreizeitangeboteView
 		freizeitangeboteView;
	private SportModel sportvereineModel;
	
	
	public FreizeitangeboteControl(Stage primaryStage){
 		this.sportvereineModel = sportvereineModel.getInstance(); 		
		this.freizeitangeboteView = new FreizeitangeboteView(this, primaryStage, sportvereineModel);
		this.sportvereineModel.addObserver(this);
	}


	@Override
	public void update() {
		this.freizeitangeboteView.zeigeSportvereineAn();
		
	}
}
