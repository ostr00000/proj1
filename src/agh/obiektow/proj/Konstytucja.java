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
		if(nr>=rozd.size()||nr<0)throw new ArrayIndexOutOfBoundsException("nie ma rozdzialu o nr. "+nr);
		return rozd.get(nr).toString();
	}

	public String getRozdzialArt(int roz, int art) {
		if(roz>=rozd.size()||roz<0)throw new ArrayIndexOutOfBoundsException("nie ma rozdzialu o nr. "+roz);
		return rozd.get(roz).getArt(art).toString();
	}

	public String getRozdzialArt(int roz, int artstart, int artend) {
		if(roz>=rozd.size()||roz<0)throw new ArrayIndexOutOfBoundsException("nie ma rozdzialu o nr. "+roz);
		return rozd.get(roz).getArt(artstart,artend).toString();
	}
}
