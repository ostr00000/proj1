package agh.obiektow.proj;

import java.util.ArrayList;
import java.util.List;

public class Konstytucja {
	List<Rozdzial> rozd;
	String naglowek;

	public Konstytucja() {
		this.rozd = new ArrayList<>();
		naglowek = "";
	}

	public void setNag(String nag) {
		if (this.naglowek.equals(""))
			this.naglowek = nag;
		else
			this.naglowek = this.naglowek + " " + nag;
	}

	public void addRozdz(Rozdzial r) {
		this.rozd.add(r);
	}

	public String getRozdz(int nr) {
		if (nr >= this.rozd.size() || nr < 0)
			throw new ArrayIndexOutOfBoundsException("nie ma rozdzialu o nr. " + nr);
		return this.naglowek+"\n"+this.rozd.get(nr).toString();
	}

	public String getRozdzialArt(int roz, int art) {
		if (roz >= this.rozd.size() || roz < 0)
			throw new ArrayIndexOutOfBoundsException("nie ma rozdzialu o nr. " + roz);
		return this.naglowek+"\n"+this.rozd.get(roz).getArt(art).toString();
	}

	public String getRozdzialArt(int roz, int artstart, int artend) {
		if (roz >= this.rozd.size() || roz < 0)
			throw new ArrayIndexOutOfBoundsException("nie ma rozdzialu o nr. " + roz);
		return this.naglowek+"\n"+this.rozd.get(roz).getArt(artstart, artend).toString();
	}
}
