package agh.obiektow.proj;

public class Artykul {
	String napis="";
	int artNr;
	
	public Artykul(int art) {
		this.artNr=art;
	}
	
	public void add(String s){
		if(napis.equals(""))napis=s;
		else napis=napis+" "+s;
	}
	public void addln(String s) {
		if(napis.equals(""))napis=s;
		else napis=napis+"\n"+s;		
	}
	public void addNoSpace(String s){
		napis=napis+s;
	}
	@Override
	public String toString() {
		return napis;
	}

}
