package gui;
import business.CsvDateiLeser;
public class Main {
	
	public static void main(String[] args) {
		CsvDateiLeser cdl = new CsvDateiLeser();
		String ueberschrift = cdl.getUeberschrift();
		System.out.println(ueberschrift);
	}
}
