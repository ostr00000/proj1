package agh.obiektow.proj;

import java.util.ArrayList;
import java.util.List;

public class Rozdzial {
	private List<Artykul> art;
	private List<Podtytul> pod;
	private String nag;
	private int rozdNr;
	
	Rozdzial(int nr){
		this.rozdNr=nr;
		art=new ArrayList<>();
		pod=new ArrayList<>();
	}
	public void setNag(String nag){
		this.nag=nag;
	}
	public void setPodNag(String s) {
		int lastArt=art.size();
		this.pod.add(new Podtytul(s,lastArt));
		
	}
	@Override
	public String toString() {
		return this.getArt(0,art.size()-1);
	}

	public void addArt(Artykul a){
		this.art.add(a);
	}
	public String getArt(int nr){
		return art.get(nr).toString();
	}
	public String getArt(int nrA,int nrB){
		StringBuilder ret = new StringBuilder(this.art.get(nrA++).toString());
		while(nrA<=nrB){
			ret.append(this.art.get(nrA++).toString());
		}
		return ret.toString();
	}
}
