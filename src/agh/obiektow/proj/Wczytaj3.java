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
		Pattern pomin = Pattern.compile("((©Kancelaria Sejmu)|([0-9]+\\-[0-9]+\\-[0-9]+))");
		Pattern newRozd = Pattern.compile("Rozdzia³ [IVX]+");
		Pattern newLine = Pattern.compile("[0-9]+(\\.|\\)) ");
		Pattern endLine = Pattern.compile(".*\\-");
		//Pattern endLineRead = Pattern.compile(".*[^\\-\\n]");

		Konstytucja kon = new Konstytucja();
		try (Scanner scan = new Scanner(new BufferedReader(new FileReader(nazwa)))) {
			Rozdzial rozd = new Rozdzial(0);
			int rozdNr = 1;
			Artykul art = new Artykul(0);
			int artNr = 1;
			Boolean lastMinus=false;
			while (scan.hasNextLine()) {
				String s=scan.nextLine();
				if(newArt.matcher(s).matches()){			//utworzenie nowego artykulu
					rozd.addArt(art);
					art=new Artykul(artNr++);
					art.add(s);
				}else if(pomin.matcher(s).matches()){		//pominiecie
					continue;
				}else if(newRozd.matcher(s).matches()){		//utworzenie nowego rozdzialu
					rozd.addArt(art);
					kon.addRozdz(rozd);
					rozd=new Rozdzial(rozdNr++);
					rozd.setNag(s);
				}else if(newLine.matcher(s).matches()){		//przejscie do nowej lini np. "32)","9."
					art.addln(s);
					lastMinus=true;
				}else if(endLine.matcher(s).matches()){		//koniec lini np. "urzeczywistniaj¹-"
					s=s.substring(0,s.length()-2)+"\n";
					art.add(s);
				}else{
					if(lastMinus){
						lastMinus=false;
						art.addNoSpace(s);
					}else{
						art.add(s);
					}
				}
				System.out.println(s);
			}
		} catch (

		FileNotFoundException e) {
			System.out.println("Nie znaleziono pliku \"" + nazwa + "\" ");
		} catch (InputMismatchException a) {
			System.out.println("Niedopasowano " + a);
		}
		return kon;
	}
}
