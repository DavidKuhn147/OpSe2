package reader;

import java.io.IOException;

public abstract class ReaderProduct {
	
	public abstract String[] leseAusDatei() throws IOException;
	
	//Ist mit schlie�e Datei gemeint die CSV Datei oder der Reader?
	public abstract void schliesseDatei() throws IOException;
}
