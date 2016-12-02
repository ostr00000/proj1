package agh.obiektow.proj;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Czytacz {

	public static Konstytucja odczytaj(String nazwa) throws FileNotFoundException {
		Pattern newArt = Pattern.compile("Art\\. [0-9]+\\.?");
		Pattern pomin = Pattern.compile("©Kancelaria Sejmu|[0-9]+\\-[0-9]+\\-[0-9]+|.?");
		Pattern newRozd = Pattern.compile("Rozdzia≥ [IVX]+");
		Pattern newLine = Pattern.compile("[0-9]+(\\.|\\)) .*");
		Pattern endLine = Pattern.compile(".*\\-");
		Pattern wielkieLitery = Pattern.compile("[A-ZØè∆•å £”— \\,]+");

		Konstytucja kon = new Konstytucja();
		try (Scanner scan = new Scanner(new BufferedReader(new FileReader(nazwa)))) {
			Rozdzial rozd = new Rozdzial(0);
			int rozdNr = 1;
			Artykul art = new Artykul(0);
			int artNr = 1;
			Boolean hasLastCharMinus = false;
			Boolean isNowaLinia = false;
			Boolean hasKonNaglowek = false;
			Boolean isPominAddArt = false;
			Boolean isWczytacNaglowek = false;
			while (scan.hasNextLine()) {
				String s = scan.nextLine();
				if (artNr == 29) {
					//System.out.print("");
				}
				// pominiecie
				if (pomin.matcher(s).matches()) {
					//System.out.println("pominieto: " + s);
					continue;
				}
				// utworzenie nowego artykulu
				if (newArt.matcher(s).matches()) {
					if (!isPominAddArt)
						rozd.addArt(art);
					isPominAddArt = false;
					art = new Artykul(artNr++);
					art.add(s);
					//System.out.println("utworzono nowy artykul " + s);
					isNowaLinia = true;
					continue;
				}
				// utworzenie nowego rozdzialu
				if (newRozd.matcher(s).matches()) {
					rozd.addArt(art);
					kon.addRozdz(rozd);
					rozd = new Rozdzial(rozdNr++);
					rozd.setNagRoz(s);
					//System.out.println("utworzono nowy rozdzial: ");
					//System.out.println("dodano naglowek rozdzialu: " + s);
					isPominAddArt = true;
					isWczytacNaglowek = true;
					continue;
				}
				// Cala linia zapisana np. "KONSTYTUCJA"
				if (wielkieLitery.matcher(s).matches()) {
					if (!hasKonNaglowek) {
						kon.setNag(s);
						kon.setNag(scan.nextLine());
						kon.setNag(scan.nextLine());
						hasKonNaglowek = true;
						//System.out.println("dodano tytul konstytucji");
						continue;
					}
					if (isPominAddArt && isWczytacNaglowek) {
						isWczytacNaglowek = false;
						rozd.setNagText(s);
						//System.out.println("dodano naglowek tekst: " + s);
					} else {
						if (!isPominAddArt)
							rozd.addArt(art);
						rozd.setPodNag(s);
						isPominAddArt = true;
						//System.out.println("dodano subnaglowek: " + s);
					}
					continue;
				}
				// przejscie do nowej lini np. "32)","9."
				if (newLine.matcher(s).matches()) {
					isNowaLinia = false;
					art.addln();
					//System.out.println("dodano \"\\n\" a nastepnie: ");
				}
				// koniec lini np."urzeczywistniajπ-"
				if (endLine.matcher(s).matches()) {
					s = s.substring(0, s.length() - 1);
					if (hasLastCharMinus) {
						hasLastCharMinus = false;
						art.addNoSpace(s);
						//System.out.println("dolaczono: " + s);
					} else {
						if (isNowaLinia) {
							isNowaLinia = false;
							art.addln();
						}
						art.add(s);
						//System.out.println("dodano: " + s);
					}
					hasLastCharMinus = true;
					continue;
				}
				// normalnie (ze spacja albo bez)
				if (hasLastCharMinus) {
					hasLastCharMinus = false;
					art.addNoSpace(s);
					//System.out.println("dolaczono: " + s);
				} else {
					if (isNowaLinia) {
						isNowaLinia = false;
						art.addln();
					}
					art.add(s);
					//System.out.println("dodano: " + s);
				}
			}
			rozd.addArt(art);
			kon.addRozdz(rozd);
		}
		return kon;
	}
}
