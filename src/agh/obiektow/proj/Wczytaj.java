package agh.obiektow.proj;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Wczytaj {

	public static Konstytucja odczytaj(String nazwa) {
		Konstytucja kon = new Konstytucja();
		try (Scanner scan = new Scanner(new BufferedReader(new FileReader(nazwa)))) {
			Artykul art = new Artykul();
			int liczbaPomin = 0;
			String fragment = "";
			Boolean sprawdzLiczbe, ostatnioArtyk = false;
			String dodatkowy = "", s;
			while (scan.hasNext()) {
				if (scan.hasNextInt()) {
					sprawdzLiczbe = true;
					int nr = scan.nextInt();
					dodatkowy = String.valueOf(nr);
				} else {
					sprawdzLiczbe = false;

				}

				s = scan.next();

				if (liczbaPomin == 0) {
					switch (s) {
					case "©Kancelaria":
						liczbaPomin = 2;
						break;
					case "Art.":
						art.add(fragment);
						fragment = s;
						kon.addArt(art);
						art = new Artykul();
						ostatnioArtyk = true;
						break;
					case ")":
					case ".":
						if (sprawdzLiczbe == true) {
							sprawdzLiczbe = false;
							if (ostatnioArtyk == true) {
								ostatnioArtyk = false;
								fragment = fragment + " " + dodatkowy + " " + s;
							} else {
								art.add(fragment);
								fragment = dodatkowy + " " + s;
							}
							break;

						}
					default:
						if (sprawdzLiczbe == true) {
							sprawdzLiczbe=false;
							fragment = fragment + " " + dodatkowy + " " + s;

						} else {
							fragment = fragment + " " + s;
						}
					}
				} else {
					liczbaPomin--;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Nie znaleziono pliku \"" + nazwa + "\" ");
		}
		return kon;
	}
}
