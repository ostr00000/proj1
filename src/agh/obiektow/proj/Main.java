package agh.obiektow.proj;

public class Main {
	public static void main(String[] args) {
		try {
			System.out.println("Nazwa wczytywanego pliku \"" + args[0] + "\"");
			Konstytucja kon = Wczytaj3.odczytaj(args[0]);
			//System.out.println(kon.getRozdz(0));
			System.out.println(kon.getRozdzialArt(0, 1));
			//System.out.println(kon.getRozdzialArt(1, 1, 5));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Brak takiego pragarfu " + e.getMessage());
		}
	}
}
