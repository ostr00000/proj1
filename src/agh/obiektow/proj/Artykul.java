package agh.obiektow.proj;

public class Artykul {
	String napis;

	public Artykul() {
	}
	
	public void add(String s){
		napis=napis+s+"\n";
	}

	@Override
	public String toString() {
		return napis;
	}

}
