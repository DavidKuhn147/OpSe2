package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
<<<<<<< HEAD
		System.out.print("Guten TagAAAA");
=======
		System.out.print("Guten Tagal");
>>>>>>> branch 'master' of https://github.com/DavidKuhn147/OpSe2
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
