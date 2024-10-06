package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		System.out.print("Guten Tagal");
		launch(args);
	}

	@Override
	public void start(Stage st) throws Exception {
		st.setTitle("TestWindow");
		
		Pane pane = new Pane();
		
		Scene scene = new Scene(pane,500,300);
		
		
		st.setScene(scene);
		st.show();
		
		
	}

}
