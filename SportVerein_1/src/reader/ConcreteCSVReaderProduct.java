package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteCSVReaderProduct extends ReaderProduct{
	
	private BufferedReader ein;
	
	//Wird im Konsturkotr initialsiert nicht übergeben!!

	public ConcreteCSVReaderProduct() throws FileNotFoundException {
		super();
		this.ein = new BufferedReader(new FileReader("Sportverein.csv"));
	}

	@Override
	public String[] leseAusDatei() throws IOException {
      	
      	String[] arr = ein.readLine().split(";");
      	
		return arr;
	}

	@Override
	public void schliesseDatei() throws IOException {
		this.ein.close();
	}

}
