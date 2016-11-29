package agh.obiektow.proj;

import java.util.ArrayList;
import java.util.List;

public class Konstytucja {
	List<Rozdzial> rozd;
	String naglowek = "";

	public Konstytucja() {
		this.rozd = new ArrayList<>();
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

	public String getArt(int nr) {
		if(nr<=0)
			throw new ArrayIndexOutOfBoundsException("Artykul musi byc liczba dodatnia");
		for (int i = 0; i < this.rozd.size(); i++) {
			Rozdzial r = this.rozd.get(i);
			if (nr <= r.getMaxArt())
				return naglowek+ "\n"+ r.getArt(nr);
		}
		throw new ArrayIndexOutOfBoundsException("brak artykulu o nr. " + nr);
	}

	public String getArt(int nrA, int nrB) {
		if(nrA<=0)
			throw new ArrayIndexOutOfBoundsException("Artykul musi byc liczba dodatnia");
		if (nrA > nrB)
			throw new ArrayIndexOutOfBoundsException("1. arg. " + nrA + " ma byc niewiekszy niz 2. arg. " + nrB);
		String ret = naglowek+"\n";
		for (int i = 0; i < this.rozd.size(); i++) {
			Rozdzial r = this.rozd.get(i);
			if (nrA <= r.getMaxArt()) {
				if (nrB <= r.getMaxArt()) {
					ret = ret + r.getArt(nrA, nrB);
					return ret;
				}
				ret = ret + r.getArt(nrA, r.getMaxArt());
				nrA = r.getMaxArt() + 1;
			}
		}
		if (!ret.equals(naglowek+"\n") && nrA==nrB)
			return ret;
		throw new ArrayIndexOutOfBoundsException("brak artykulu o nr. " + nrA);
	}
	public String getRozdz(int nr){
		if(nr<0)
			throw new ArrayIndexOutOfBoundsException("Rozdzial musi byc liczba dodatnia");
		if(nr>rozd.size())
			throw new ArrayIndexOutOfBoundsException("brak Rozdzialu "+nr);
		return naglowek+"\n"+rozd.get(nr).toString();

	}
}
