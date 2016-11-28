package agh.obiektow.proj;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Testing {
	static void testy() {
		Pattern newArt = Pattern.compile("[0-9]+\\.");

		Scanner scan = new Scanner("Art. 194. Oglasza sie co nastepuje");
		while (scan.hasNext()) {
			if (scan.hasNext(newArt)) {
				System.out.println(scan.next(newArt));
			} else
				System.out.println("Nie znaleziono \""+scan.next()+"\"");
		}
		scan.close();
	}

}
