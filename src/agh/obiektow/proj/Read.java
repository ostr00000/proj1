package agh.obiektow.proj;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Read {

	public static Konstytucja odczytaj(String nazwa) {
		Pattern newArt = Pattern.compile("Art\\.");
		Pattern newArt2 = Pattern.compile("[0-9]+\\.");
		Pattern pomin = Pattern.compile("©Kancelaria");
		Pattern pomin2 = Pattern.compile("Sejmu");
		Pattern pomin3 = Pattern.compile("[0-9\\-]+");
		Pattern newRozd = Pattern.compile("Rozdzia³ [IVX]+");
		Pattern newLine = Pattern.compile("([0-9])+(\\.|\\))");
		Pattern endLine = Pattern.compile("[\\S]+\\-");
		Pattern endLineRead = Pattern.compile("[\\S]+");
		Pattern normalString = Pattern.compile("[\\S]+");

		Konstytucja kon = new Konstytucja();
		try (Scanner scan = new Scanner(new BufferedReader(new FileReader(nazwa)))) {
			Rozdzial rozd = new Rozdzial(0);
			int rozdNr = 1;
			Artykul art = new Artykul(0);
			int artNr = 1;
			while (scan.hasNext()) {
				String s = null;
				if (scan.hasNext(newArt)) { // Artyku³
					s = scan.next(newArt);
					System.out.println("artykul " + s);
					rozd.addArt(art);
					art = new Artykul(artNr++);
					art.addln();
					art.add(s);
				} else if (omijaj(scan, pomin)) { // Pominiecie
					if (omijaj(scan, pomin2))
						if (omijaj(scan, pomin3))
							;
				} else if (scan.hasNext(newRozd)) { // Rozdzial
					s = scan.next(newRozd);
					System.out.println("rozdzial " + s);
					rozd.addArt(art);
					kon.addRozdz(rozd);
					rozd = new Rozdzial(rozdNr++);
					rozd.setNag(s);
					art = new Artykul(artNr = 0);
				} else if (scan.hasNext(newLine)) { // Wypunktownie 1) 1.
					s = scan.next(newLine);
					art.addln();
					art.add(s);
					System.out.println("wypunktowanie " + s);
				} else if (scan.hasNext(endLine)) { // koniec lini "zadlugie-"
					if (scan.hasNext(endLineRead))
						s = scan.next(endLineRead);
					else
						throw new InputMismatchException("dlaczego? " + endLineRead + " " + endLine);
					art.add(s);
					System.out.println("endline " + s);
				} else if (scan.hasNext(normalString)) {
					s = scan.next(normalString);
					System.out.println("normal " + s);
					art.add(s);
				} else {// nie powinno tu dojœæ
					s = scan.nextLine();
					System.out.println("b³¹d " + s);
				}

			}
		} catch (

		FileNotFoundException e) {
			System.out.println("Nie znaleziono pliku \"" + nazwa + "\" ");
		} catch (InputMismatchException a) {
			System.out.println("Niedopasowano " + a);
		}
		return kon;
	}

	static private Boolean omijaj(Scanner scan, Pattern p) {
		if (scan.hasNext(p)) {
			String s = scan.next(p);
			System.out.println("pomin " + s);
			return true;
		} else
			return false;
	}
}
