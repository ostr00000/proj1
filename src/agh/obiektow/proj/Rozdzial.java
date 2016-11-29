package agh.obiektow.proj;

import java.util.ArrayList;
import java.util.List;

public class Rozdzial {
	private List<Artykul> art;
	private List<Podtytul> pod;
	private String nag;
	private int rozdNr;

	Rozdzial(int nr) {
		this.rozdNr = nr;
		art = new ArrayList<>();
		pod = new ArrayList<>();
		nag = null;
	}

	public void setNag(String nag) {
		this.nag = nag;
	}

	public void setPodNag(String s) {
		int lastArt = art.size();
		this.pod.add(new Podtytul(s, lastArt));
	}

	public void dolaczNag(String s) {
		String last = this.pod.remove(this.pod.size() - 1).toString();
		last = last + " " + s;
		this.setPodNag(last);
	}

	@Override
	public String toString() {
		return this.getArt(1, art.size());
	}

	public void addArt(Artykul a) {
		this.art.add(a);
	}

	public String getArt(int nr) {
		if (nr > art.size() || nr <= 0)
			throw new ArrayIndexOutOfBoundsException("nie ma atykulu o nr. " + nr+" w rozdziale "+ rozdNr);
		String ret = this.getTitle();
		int indexDopasowany=this.dopasujIndex(0,nr);
		if (indexDopasowany != 0) {
			ret = ret + this.pod.get(indexDopasowany).toString() + "\n";
		}
		ret = ret + this.art.get(--nr).toString();
		return ret;
	}

	public String getArt(int nrA, int nrB) {
		if (nrA <= 0)
			throw new ArrayIndexOutOfBoundsException("nie ma atykulu o nr. " + nrA +" w rozdziale "+ rozdNr);
		if (nrB > art.size())
			throw new ArrayIndexOutOfBoundsException("nie ma atykulu o nr. " + nrB+" w rozdziale "+ rozdNr);
		if (nrA > nrB)
			throw new ArrayIndexOutOfBoundsException("1. arg. " + nrA + " ma byc niewiekszy niz 2. arg. " + nrB);
		String ret = this.getTitle();
		int indexDopasowany=this.dopasujIndex(0,nrA);
		do{
			if (indexDopasowany != 0) {
				ret = ret + this.pod.get(indexDopasowany).toString() + "\n";
			}
			ret = ret + this.art.get(nrA - 1).toString() + "\n";
			nrA++;
			indexDopasowany=this.dopasujIndex(nrA-1, nrA);
		}while (nrA <= nrB);
		return ret;
	}
	
	private String getTitle(){
		String ret = "";
		if (this.nag != null)
			ret = this.nag + "\n";
		if (this.pod.size() != 0)
			ret = ret + this.pod.get(0) + "\n";
		return ret;
	}
	private int dopasujIndex(int pozycja,int nr){
		int indexDopasowany = 0;
		while (pozycja < this.pod.size()) {
			int geted = this.pod.get(pozycja).lastArt();
			if (geted < nr) {
				pozycja++;
				indexDopasowany = geted;
			} else
				break;
		}
		return indexDopasowany;
	}
}
