package agh.obiektow.proj;

import java.util.ArrayList;
import java.util.List;

public class Konstytucja {
	private List<Rozdzial> rozd;
	private String naglowek;

	public Konstytucja() {
		this.rozd = new ArrayList<>();
		naglowek = null;
	}

	public void setNag(String nag) {
		if (this.naglowek == null)
			this.naglowek = nag;
		else
			this.naglowek = this.naglowek + " " + nag;
	}

	public void addRozdz(Rozdzial r) {
		this.rozd.add(r);
	}

	public void wypisz(ArgumentyProgramu arg) {
		String napis;
		if (arg.czyRozdzial)
			napis = this.getRozdz(arg.arg1);
		else {
			if (arg.czy2Parametry)
				napis = this.getArt(arg.arg1, arg.arg2);
			else
				napis = this.getArt(arg.arg1, arg.arg1);
		}
		System.out.println(napis);
	}

	private String getArt(int nrA, int nrB) {
		if (nrA <= 0)
			throw new ArrayIndexOutOfBoundsException("Artykul musi byc liczba dodatnia");
		if (nrA > nrB)
			throw new ArrayIndexOutOfBoundsException("1. arg. " + nrA + " ma byc niewiekszy niz 2. arg. " + nrB);
		String ret = naglowek + "\n";
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
		if (!ret.equals(naglowek + "\n") && nrA == nrB)
			return ret;
		throw new ArrayIndexOutOfBoundsException("brak artykulu o nr. " + nrA);
	}

	private String getRozdz(int nr) {
		if (nr < 0)
			throw new ArrayIndexOutOfBoundsException("Rozdzial musi byc liczba dodatnia");
		if (nr > rozd.size())
			throw new ArrayIndexOutOfBoundsException("brak Rozdzialu " + nr);
		return naglowek + "\n" + rozd.get(nr).toString();

	}
}
