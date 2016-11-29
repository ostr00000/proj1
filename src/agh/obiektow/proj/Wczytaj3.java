package agh.obiektow.proj;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Wczytaj3 {

	public static Konstytucja odczytaj(String nazwa) {
		Pattern newArt = Pattern.compile("Art\\. [0-9]+\\.");
		Pattern pomin = Pattern.compile("©Kancelaria Sejmu|[0-9]+\\-[0-9]+\\-[0-9]+|.?");
		Pattern newRozd = Pattern.compile("Rozdzia≥ [IVX]+");
		Pattern newLine = Pattern.compile("[0-9]+(\\.|\\)) .*");
		Pattern endLine = Pattern.compile(".*\\-");
		Pattern wielkieLitery = Pattern.compile("[A-ZØè∆•å £”— ]+");

		Konstytucja kon = new Konstytucja();
		try (Scanner scan = new Scanner(new BufferedReader(new FileReader(nazwa)))) {
			Rozdzial rozd = new Rozdzial(0);
			rozd.setNag("KONSTYTUCJA RP");
			int rozdNr = 1;
			Artykul art = new Artykul(0);
			int artNr = 1;
			Boolean lastMinus = false;
			Boolean nowaLinia = false;
			Boolean wielkaLitera =false;
			while (scan.hasNextLine()) {
				String s = scan.nextLine();
				// pominiecie
				if (pomin.matcher(s).matches()) {
					System.out.println("pominieto: " + s);
					continue;
				}
				// utworzenie nowego artykulu
				if (newArt.matcher(s).matches()) {
					rozd.addArt(art);
					art = new Artykul(artNr++);
					art.add(s);
					System.out.println("utworzono nowy artykul " + s);
					nowaLinia = true;
					continue;
				}
				// utworzenie nowego rozdzialu
				if (newRozd.matcher(s).matches()) {
					rozd.addArt(art);
					kon.addRozdz(rozd);
					rozd = new Rozdzial(rozdNr++);
					rozd.setNag(s);
					System.out.println("utworzono nowy rozdzial: " + s);
					continue;
				}
				// Cala linia zapisana np. "KONSTYTUCJA"
				if (wielkieLitery.matcher(s).matches()) {
					if(wielkaLitera){
						rozd.dolaczNag(s);
					}else{
					rozd.setPodNag(s);
					}
					wielkaLitera=true;
					System.out.println("dodano subnaglowek: " + s);
					continue;
				}else{
					wielkaLitera=false;
				}
				// przejscie do nowej lini np. "32)","9."
				if (newLine.matcher(s).matches()) {
					nowaLinia = false;
					art.addln();
					System.out.println("dodano \"\\n\" a nastepnie: ");
				}
				// koniec lini np."urzeczywistniajπ-"
				if (endLine.matcher(s).matches()) {
					s = s.substring(0, s.length() - 1);
					if (lastMinus) {
						lastMinus = false;
						art.addNoSpace(s);
						System.out.println("dolaczono: " + s);
					} else {
						if (nowaLinia) {
							nowaLinia = false;
							art.addln();
						}
						art.add(s);
						System.out.println("dodano: " + s);
					}
					lastMinus = true;
					continue;
				}
				// normalnie (ze spacja albo bez)
				if (lastMinus) {
					lastMinus = false;
					art.addNoSpace(s);
					System.out.println("dolaczono: " + s);
				} else {
					if (nowaLinia) {
						nowaLinia = false;
						art.addln();
					}
					art.add(s);
					System.out.println("dodano: " + s);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Nie znaleziono pliku \"" + nazwa + "\" ");
		} catch (InputMismatchException a) {
			System.out.println("Niedopasowano " + a);
		}
		return kon;
	}
}
