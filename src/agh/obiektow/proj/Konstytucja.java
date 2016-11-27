package agh.obiektow.proj;

import java.util.ArrayList;
import java.util.List;

public class Konstytucja {
	List<Rozdzial> rozd;

	public Konstytucja() {
		rozd = new ArrayList<>();
	}

	public void addRozdz(Rozdzial r) {
		rozd.add(r);
	}

	public String getRozdz(int nr) {
		return rozd.get(nr).toString();
	}

	public String getRozdzialArt(int roz, int art) {
		return rozd.get(roz).getArt(art).toString();
	}

	public String getRozdzialArt(int roz, int artstart, int artend) {
		return rozd.get(roz).getArt(artstart,artend).toString();
	}
}
