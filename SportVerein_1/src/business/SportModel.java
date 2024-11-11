package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import reader.ConcreteCSVReaderCreator;
import reader.ConcreteTXTReaderCreator;
import reader.ReaderCreator;
import reader.ReaderProduct;


public class SportModel {
	
	Sportverein sportVerein;
	
	public SportModel() {
	}
	
	
	//Methode um z.B. mehrere Einträge aus einer CSV Datei zu lesen
	//Dann müsste man aber hier im SportModel ein Sportverein[] erzeugen und diese mit Werte belegen.
	//Diese müsste man dann auch in alle anderen Klassen ändern wie z.B. bei zeigeSportVereineAn und nehmeSportVerein auf
		
	/*void leseAusDatei(String typ) throws Exception {
	    BufferedReader ein = new BufferedReader(new FileReader("Sportverein.csv"));
	    
	    String line;
	    int index = 0;
	    
	    while ((line = ein.readLine()) != null) {
	        String[] zeile = line.split(";");
	        
	        this.sportVerein = new Sportverein(
	            zeile[0],
	            Float.parseFloat(zeile[1]),
	            Float.parseFloat(zeile[2]),
	            zeile[3],
	            zeile[4].split("_")
	        );
	        
	        index++;
	        
	        System.out.println(index + ". Sportvereine: " + this.sportVerein.gibSportVereinZurueck(' '));
	    }
	    
	    ein.close();
	}*/
	
	
	
	//FABRIKMETHODE: VORHERIGE KLASSE

	//Allgemeine Info: Eine Exception kann über mehrere Klassen geleitet werden.
	//Wird eine Exception nigendswo "aufgefangen" mit try-catch ensteht eine RuntimeException
	/*void leseAusDatei(String typ) throws Exception{
    
      	BufferedReader ein = new BufferedReader(new FileReader("Sportverein.csv"));
      	String[] zeile = ein.readLine().split(";");
   
      		this.sportVerein = new Sportverein(zeile[0], 
      			Float.parseFloat(zeile[1]), 
      			Float.parseFloat(zeile[2]), 
      			zeile[3], zeile[4].split("_"));
      	ein.close();
	}*/
		
	
	void leseAusDateiCSV() throws Exception{
		
		ReaderCreator readerCreator = new ConcreteCSVReaderCreator();
		//gibt ConcreteCSVReaderProduct zurueck
		ReaderProduct reader = readerCreator.factoryMethod();
		
		
	    
      	String[] zeile = reader.leseAusDatei();
   
      		this.sportVerein = new Sportverein(zeile[0], 
      			Float.parseFloat(zeile[1]), 
      			Float.parseFloat(zeile[2]), 
      			zeile[3], zeile[4].split("_"));
      		
      		reader.schliesseDatei();
	}
	
	void leseAusDateiTXT() throws Exception{
		
		ReaderCreator readerTXTCreator = new ConcreteTXTReaderCreator();
		ReaderProduct readettxt = readerTXTCreator.factoryMethod();
		
		String[] zeile = readettxt.leseAusDatei();
		   
  		this.sportVerein = new Sportverein(zeile[0], 
  			Float.parseFloat(zeile[1]), 
  			Float.parseFloat(zeile[2]), 
  			zeile[3], zeile[4].split("_"));
  		
  		readettxt.schliesseDatei();
		
	}
	
	
	
	//hier noch mit Control für die Fehlerbehebung verknüpfen + in Buergeramt-Klasse schreiben, dass man das im Model und Control gemacht hat
	//Der Kommentar war eine Merkhilfe für mich, hab ich umgesetzt genause wie für die anderen schreibe/lese Methoden
	void schreibeSportVereinInCsv() throws Exception{
		
		//Test ob das Objekt korrekt übergeben wird
		/*System.out.println("schreibeSportVereinInCsv AUFRUF");
		//System.out.println("csv " + this.sportVerein.gibSportVereinZurueck(' '));
		
		if(this.sportVerein == null) {
			System.out.println("Objekt ist null");
		}*/

		BufferedWriter aus = new BufferedWriter(new FileWriter("Sportverein.csv", true));
		
		aus.write(this.sportVerein.gibSportVereinZurueck(';'));
		aus.close();
	}
	
	
	
	
	//getter und setter NOTWENDIG lese unten
	public Sportverein getSportVerein() {
		return sportVerein;
	}
	
	
	//ist unbedingt nötig um dem Model das Sportverein zu übergeben (siehe Methode nehmeSportVereinAuf(...))!!!
	public void setSportVerein(Sportverein sportVerein) {
		this.sportVerein = sportVerein;
		
		//Test um zu gucken ob Objekt initialisiert wurde
		//System.out.println(this.sportVerein.gibSportVereinZurueck(' ') + "Objekt initialisiert");
	}
	
	
	
	
	

}
