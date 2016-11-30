package agh.obiektow.proj;

import java.io.FileNotFoundException;

public class Main {
	final static String invalidArgs="Zle argumenty:\n" + "\"lokalizacjaPliku -r Liczba\" dla wyboru rozdzialu Liczba\n"
			+ "\"lokalizacjaPliku -a Liczba\" dla wyboru artyklu Liczba\n"
			+ "\"lokalizacjaPliku -a Liczba1 Liczba2\" dla wyboru przedzialu artykolow [Liczba1,Liczba2]";
	
	public static void main(String[] args) {
		try {
			System.out.println("Argumenty programu: ");
			for (String arg : args)
				System.out.print("\"" + arg + "\" ");
			System.out.print("\n\n");

			if(args.length<3){
				System.out.println(invalidArgs);
				return;
			}
			Konstytucja kon = Wczytaj.odczytaj(args[0]);
			String napis;
			switch (args[1]) {
			case "-r":
				napis = kon.getRozdz(Integer.valueOf(args[2]));
				break;
			case "-a":
				if (args.length == 3)
					napis = kon.getArt(Integer.valueOf(args[2]));
				else
					napis = kon.getArt(Integer.valueOf(args[2]), Integer.valueOf(args[3]));
				break;
			default:
				napis=invalidArgs;
			}
			System.out.println(napis);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}catch (NumberFormatException e){
			System.out.println(invalidArgs);
		}catch (FileNotFoundException e) {
			System.out.println("Nie znaleziono pliku \"" + args[0] + "\" ");
		}
	}
}
