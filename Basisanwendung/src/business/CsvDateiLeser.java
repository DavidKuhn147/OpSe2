package business;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
 /**
 * Klasse, welche Kunden.csv liest
 */
public class CsvDateiLeser {
	 /**
	 * Gibt die Ueberschrift fuer das Grundfenster heraus
	 * @return String, Ueberschrift fuer das Grundfenster
	 */
	 public String getUeberschrift(){
		 return "Hallo";
	 }
	
	 /**
	 * liest die Datei Kunden.csv und gibt sie als String- Array
	* zurueck.
	 * @return String[], enthaelt die Zeilen der Datei Kunden.csv
	 * @throws FileNotFoundException,
	 wird geworfen, wenn csv-Datei nicht vorhanden
	 * @throws IOException, wird geworfen, wenn ein Fehler beim Lesen
	 * auftaucht
	 */
 
	 public String[] leseKunden()
			 throws FileNotFoundException, IOException{
			 Vector<String> ergebnis = new Vector<String>();
			 	String zeile = null;
			 BufferedReader ein = new BufferedReader(new FileReader("Kunden.csv"));
			 zeile = ein.readLine();
			 while(zeile != null && zeile.length() != 0){
				 ergebnis.add(zeile);
				 zeile = ein.readLine();
			 }
			 ein.close();
			 return ergebnis.toArray(new String[]{});
	 }
}
 
 
 
 
 
 
 