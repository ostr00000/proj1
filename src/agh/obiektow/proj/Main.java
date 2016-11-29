package agh.obiektow.proj;

public class Main {
	public static void main(String[] args) {
		try {
			System.out.println("Nazwa wczytywanego pliku \"" + args[0] + "\"");
			Konstytucja kon = Wczytaj.odczytaj(args[0]);
			//System.out.println(kon.getRozdz(13));
			System.out.println(kon.getArt(243));
			//System.out.println(kon.getRozdzialArt(9, 211, 213));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Brak takiego pragarfu " + e.getMessage());
		}
	}
}
