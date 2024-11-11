package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteTXTReaderProduct extends ReaderProduct{
	private BufferedReader ein;
	
	//Wird im Konsturkotr initialsiert nicht übergeben!!

	public ConcreteTXTReaderProduct() throws FileNotFoundException {
		super();
		this.ein = new BufferedReader(new FileReader("Sportverein.txt"));
	}

	@Override
	public String[] leseAusDatei() throws IOException {
      	
		String[] arr = new String[5];
		
		String line;
		
		int index = 0;
	
		
		 while ((line = ein.readLine()) != null) {
		        
			 	System.out.println(line);
			 
			 	arr[index] = line;
			 	
			 	index++;
		      
		        
		        
		        		        
		    }
		
      	
		return arr;
	}

	@Override
	public void schliesseDatei() throws IOException {
		this.ein.close();
	}

}
