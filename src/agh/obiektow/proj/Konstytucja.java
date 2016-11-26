package agh.obiektow.proj;

import java.util.ArrayList;
import java.util.List;

public class Konstytucja {
	List<Artykul> art;

	public Konstytucja() {
		art=new ArrayList<>();
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
