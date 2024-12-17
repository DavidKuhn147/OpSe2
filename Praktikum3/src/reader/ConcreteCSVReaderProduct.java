package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ConcreteCSVReaderProduct extends ReaderProduct{
	
	private BufferedReader ein;
	
	//Wird im Konsturkotr initialsiert nicht �bergeben!!

	public ConcreteCSVReaderProduct() throws FileNotFoundException {
		super();
		this.ein = new BufferedReader(new FileReader("Sportverein.csv"));
	}

	@Override
	public String[] leseAusDatei() throws IOException {
		
		String line = null;
		ArrayList<String> sportvereine = new ArrayList<String>();
		
		while((line = ein.readLine()) != null) {
			if(!line.trim().isEmpty()) {
				sportvereine.add(line);
			}
		}
      	
      	//String[] arr = ein.readLine().split(";");
      	
		//3. Möglichkeiten
		//return (String[]) sportvereine.toArray();
		
		//Ist nur für den Typenparameter die Methode toArray ermittelt automatisch schon die größe
		return sportvereine.toArray(new String[0]);
		//return sportvereine.toArray(new String[sportvereine.size()]);
	}

	@Override
	public void schliesseDatei() throws IOException {
		this.ein.close();
	}

}
