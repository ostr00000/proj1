package agh.obiektow.proj;

import java.io.FileNotFoundException;

public class Main {
	final static String invalidArgs = "Zle argumenty:\n"
			+ "\"lokalizacjaPliku -r Liczba\" dla wyboru rozdzialu Liczba\n"
			+ "\"lokalizacjaPliku -a Liczba\" dla wyboru artyklu Liczba\n"
			+ "\"lokalizacjaPliku -a Liczba1 Liczba2\" dla wyboru przedzialu artykolow [Liczba1,Liczba2]";

	public static void main(String[] args) {
		try {
			ArgumentyProgramu argum=new ArgumentyProgramu(args);
			Konstytucja kon = Czytacz.odczytaj(args[0]);
			kon.wypisz(argum);

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		} catch (NumberFormatException e) {
			System.out.println(invalidArgs);
		} catch (FileNotFoundException e) {
			System.out.println("Nie znaleziono pliku \"" + args[0] + "\" ");
		}
	}
}
