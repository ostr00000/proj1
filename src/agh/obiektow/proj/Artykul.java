package agh.obiektow.proj;

public class Artykul {
	String napis="";
	int artNr;
	
	public Artykul(int art) {
		this.artNr=art;
	}
	
	public void add(String s){
		napis=napis+" "+s;
	}

	@Override
	public String toString() {
		return napis;
	}
	public void addbezspacji(String s){
		napis=napis+s;
	}
	public void addnl(String s) {
		napis=napis+s+"\n";		
	}

}
