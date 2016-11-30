package agh.obiektow.proj;

public class Artykul {
	private String napis = null;
	private int artNr;

	public Artykul(int art) {
		this.artNr = art;
	}

	public int getNr() {
		return artNr;
	}

	public void add(String s) {
		if (napis == null)
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
