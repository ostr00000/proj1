package agh.obiektow.proj;

public class Main {
	public static void main(String[] args) {
		try {
			System.out.println("Nazwa wczytywanego pliku \""+args[0]+"\"");
			Konstytucja kon = Wczytaj.odczytaj(args[0]);
			System.out.println(kon.getArt(0));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Podaj jako 1. argument nazwe pliku");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Brak takiego pragarfu " + e.getMessage());
		}
	}
}
