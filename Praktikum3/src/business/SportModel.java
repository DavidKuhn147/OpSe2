package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import observer.Observable;
import observer.Observer;
import reader.ConcreteCSVReaderCreator;
import reader.ConcreteTXTReaderCreator;
import reader.ReaderCreator;
import reader.ReaderProduct;


public class SportModel implements Observable{
	
	//Observers
	ArrayList<Observer> observer = new ArrayList<Observer>();
	
	ArrayList<Sportverein> sportvereine = new ArrayList<Sportverein>();
	
	Sportverein sportVerein;

	
	//Realisierung von singleton
		
	private static SportModel instance = null;
	
	private SportModel() {
	}
	
	public static SportModel getInstance() {
		if(instance == null) {
			instance = new SportModel();
			return instance;
		} else {
			return instance;
		}
	}
	
	
	void leseAusDateiCSV() throws Exception{
		
		ReaderCreator readerCreator = new ConcreteCSVReaderCreator();
		//gibt ConcreteCSVReaderProduct zurueck
		ReaderProduct reader = readerCreator.factoryMethod();
		
		
	    //Die Zeilen sind hier in diesem Array gespeichert
      	String[] sportvereine = reader.leseAusDatei();
   
      		/*this.sportVerein = new Sportverein(zeile[0], 
      			Float.parseFloat(zeile[1]), 
      			Float.parseFloat(zeile[2]), 
      			zeile[3], zeile[4].split("_"));
      		
      		reader.schliesseDatei();*/
      	
      	/*for(String sp: sportvereine) {
      		System.out.println(sp);
      	}*/
      	
      	
      	for(String sp : sportvereine) {
      		String[] el = sp.split(";");
      		
      		 this.sportVerein = new Sportverein(el[0], 
          			Float.parseFloat(el[1]), 
          			Float.parseFloat(el[2]), 
          			el[3], el[4].split("_"));
      		
      		this.sportvereine.add(sportVerein);
      		
      		
      		
      		
      	}
      	
      	reader.schliesseDatei();
      		
      	//Observer aufrufen
      	notifyObservers();
      		
      		
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
  	//Observer aufrufen
  		notifyObservers();
		
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

		BufferedWriter aus = new BufferedWriter(new FileWriter("Sportverein.csv", false));
		
		for(Sportverein s : sportvereine) {
			aus.write(s.gibSportVereinZurueck(';'));
		}
		
		
		
		aus.close();
		//Observer aufrufen
  		notifyObservers();
	}
	
	
	
	
	//getter und setter NOTWENDIG lese unten
	public ArrayList<Sportverein> getSportVereine() {
		return this.sportvereine;
	}
	
	public void setSportVereine(ArrayList<Sportverein> sportvereine) {
		this.sportvereine = sportvereine;
	}
	
	
	public void addSportverein(Sportverein sportVerein) {
		this.sportVerein = sportVerein;
		this.sportvereine.add(sportVerein);
		
		//Test um zu gucken ob Objekt initialisiert wurde
		//System.out.println(this.sportVerein.gibSportVereinZurueck(' ') + "Objekt initialisiert");
	}
	
	public Sportverein getVerein() {
		return this.sportVerein;
	}
	
	public void setVerein(Sportverein sportVerein) {
		this.sportVerein = sportVerein;
	}
	
	

	@Override
	public void addObserver(Observer obs) {
		this.observer.add(obs);
		
	}

	@Override
	public void removeObserver(Observer obs) {
		this.observer.remove(obs);
		
	}

	@Override
	public void notifyObservers() {
		for(Observer o : this.observer) {
			o.update();
		}
	}
	
	
	
	
	

}
