package agh.obiektow.proj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rozdzial {
	private List<Artykul> art;
	private Map<Integer, String> pod;
	private String nagRoz;
	private String nagText;
	private int rozdNr;

	Rozdzial(int nr) {
		this.rozdNr = nr;
		this.art = new ArrayList<>();
		this.pod = new HashMap<>();
		this.nagRoz = null;
		this.nagText = null;
	}

	public void setNagRoz(String nag) {
		this.nagRoz = nag;
	}

	public void setNagText(String nag) {
		this.nagText = nag;
	}

	public void setPodNag(String s) {
		int lastArt = art.size();
		this.pod.put(lastArt, s);
	}

	public void addArt(Artykul a) {
		this.art.add(a);
	}

	@Override
	public String toString() {
		return this.getArt(this.getMinArt(), this.getMaxArt());
	}

	public String getArt(int nr) {
		return this.getArt(nr, nr);
	}

	public String getArt(int nrA, int nrB) {
		if (art.size() == 0)
			throw new ArrayIndexOutOfBoundsException("rozdzial " + rozdNr + " jest pusty");
		int indPocz = art.get(0).getNr();
		nrA -= indPocz;
		nrB -= indPocz;
		String ret = "";
		if (this.nagRoz != null)
			ret = this.nagRoz + "\n";
		if (this.nagText != null)
			ret = ret + this.nagText + "\n";
		while (nrA <= nrB) {
			String podtytul = pod.get(nrA);
			if (podtytul != null) {
				ret = ret + podtytul + "\n";
			}
			ret = ret + this.art.get(nrA).toString() + "\n";
			nrA++;
		}
		return ret;
	}

	public int getMaxArt() {
		if (art.size() == 0)
			throw new ArrayIndexOutOfBoundsException("rozdzial " + rozdNr + " jest pusty");
		return art.get(art.size() - 1).getNr();
	}

	public int getMinArt() {
		if (art.size() == 0)
			throw new ArrayIndexOutOfBoundsException("rozdzial " + rozdNr + " jest pusty");
		return art.get(0).getNr();
	}
}
