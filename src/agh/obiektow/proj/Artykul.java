package agh.obiektow.proj;

public class Artykul {
	private String napis = null;
	private StringBuilder build =null;
	private int artNr;

	public Artykul(int art) {
		this.artNr = art;
	}

	public int getNr() {
		return artNr;
	}

	public void add(String s) {
		if (build == null)
			build = new StringBuilder(s);
		else
			build = build.append(" ").append(s);
	}

	public void addln() {
		if (build!=null)
			build = build.append("\n");
	}

	public void addNoSpace(String s) {
		build = build.append(s);
	}

	@Override
	public String toString() {
		return napis;
	}
	
	public void convertStrBuild(){
		napis=build.toString();
	}
	
}
