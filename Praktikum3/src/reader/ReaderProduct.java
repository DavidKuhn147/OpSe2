package reader;

import java.io.IOException;

public abstract class ReaderProduct {
	
	public abstract String[] leseAusDatei() throws IOException;
	
	//Ist mit schlie�e Datei ist das schließen des bufferedReader gemeint
	public abstract void schliesseDatei() throws IOException;
}
