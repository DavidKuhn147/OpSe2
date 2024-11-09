
//Diese Klasse wo ich meine Objekte für Sportvereine speichere, habe ich im Praktikum schon umbenenannt.
//Vorher war das die Klasse BuergerAemter (glaube ich)

package business;

public class Sportverein {
	
	// Name des Buergeramtes
    private String name;
    // Oeffnungszeiten
    private float anzahlEhemaligerMitglieder;
    private float anzahlMitglieder;
    // Strasse und Hausnummer des Buergeramtes
    private String ort;
    // Dienstleistungen des Buergeramtes
    private String[] sportarten;

   
	
	/*public Sportverein(String name, float anzahlEhemaligerMitglieder, float anzahlMitglieder, String ort, String[] sportarten) {
		super();
		this.name = name;
		this.anzahlEhemaligerMitglieder = anzahlEhemaligerMitglieder;
		this.anzahlMitglieder = anzahlMitglieder;
		this.ort = ort;
		this.sportarten = sportarten;
	}*/
	
	public Sportverein(String name, float anzahlEhemaligerMitglieder, float anzahlMitglieder, String ort, String[] sportarten) {
		super();
		this.name = name;
		this.anzahlEhemaligerMitglieder = anzahlEhemaligerMitglieder;
		this.anzahlMitglieder = anzahlMitglieder;
		this.ort = ort;
		this.sportarten = sportarten;
	}
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public float getAnzahlEhemaligerMitglieder() {
		return anzahlEhemaligerMitglieder;
	}



	public void setAnzahlEhemaligerMitglieder(float anzahlEhemaligerMitglieder) {
		this.anzahlEhemaligerMitglieder = anzahlEhemaligerMitglieder;
	}



	public float getAnzahlMitglieder() {
		return anzahlMitglieder;
	}



	public void setAnzahlMitglieder(float anzahlMitglieder) {
		this.anzahlMitglieder = anzahlMitglieder;
	}



	public String getOrt() {
		return ort;
	}



	public void setOrt(String ort) {
		this.ort = ort;
	}



	public String[] getSportarten() {
		return sportarten;
	}



	public void setSportarten(String[] sportarten) {
		this.sportarten = sportarten;
	}



	public String getSportArtenAlsString(char trenner) {
		//System.out.println("getSportArtenAlsString");
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getSportarten().length - 1; i++) {
			ergebnis = ergebnis + this.getSportarten()[i] + trenner; 
		}
		return ergebnis	+ this.getSportarten()[i];
	}
	
	//Hier ein Fehler der Datei deswegn hat das die ganze Zeit nicht funktioniert siehe(innerhalb der Methode das was auskommentiert ist) soll das so sein????
	public String gibSportVereinZurueck(char trenner){
  		return this.getName() + trenner 
  			+ this.getAnzahlEhemaligerMitglieder() + trenner
  		    + this.getAnzahlMitglieder() + trenner
  		    + this.getOrt() + trenner + /*"\n"
  		    +*/ this.getSportArtenAlsString(trenner) + "\n";
  	}
}

