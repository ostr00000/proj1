package agh.obiektow.proj;

public class Podtytul {
	private String name;
	private int dodanyPoArt;
	
	public Podtytul(String name, int dodanyPoArt) {
		this.name = name;
		this.dodanyPoArt = dodanyPoArt;
	}

	@Override
	public String toString() {
		return this.name;
	}
	public int lastArt(){
		return this.dodanyPoArt;
	}
}
