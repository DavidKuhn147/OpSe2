package gui;
/*<<<<<<< HEAD
import business.CsvDateiLeser;
public class Main {
	
	public static void main(String[] args) {
		CsvDateiLeser cdl = new CsvDateiLeser();
		String ueberschrift = cdl.getUeberschrift();
		System.out.println(ueberschrift);
	}
}
=======*/
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	 @Override
	 public void start(Stage primaryStage) {
		 new Anwendersystem(primaryStage);
	 }

	 public static void main(String[] args){
		 launch(args);
	 }
}
//>>>>>>> branch 'master' of file:///C:\Users\David\Desktop\Objektorientieres Programmieren\Listings\Uebung_1_Git_EntwicklerB_LokalesRepository
