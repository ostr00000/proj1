package agh.obiektow.proj;

import java.util.ArrayList;
import java.util.List;

public class Rozdzial {
	List<Artykul> art;
	String nag;
	int rozdNr;
	
	Rozdzial(int nr){
		this.rozdNr=nr;
		art=new ArrayList<>();
	}
	public void setNag(String nag){
		this.nag=nag;
	}
	
	@Override
	public String toString() {
		return this.getArt(0,art.size()-1);
	}

	public void addArt(Artykul a){
		art.add(a);
	}
	public String getArt(int nr){
		return art.get(nr).toString();
	}
	public String getArt(int nrA,int nrB){
		StringBuilder ret = new StringBuilder(art.get(nrA++).toString());
		while(nrA<=nrB){
			ret.append(art.get(nrA++).toString());
		}
		return ret.toString();
	}
	
}
