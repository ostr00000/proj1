package agh.obiektow.proj;

public class Artykul {
	String napis = "";
	int artNr;

	public Artykul(int art) {
		this.artNr = art;
	}

	public void add(String s) {
		if (napis.equals(""))
			napis = s;
		else
			napis = napis + " " + s;
	}

	public void addln() {
		if (!napis.equals(""))
			napis = napis + "\n";
	}

	public void addNoSpace(String s) {
		napis = napis + s;
	}

	@Override
	public String toString() {
		return napis;
	}

}
