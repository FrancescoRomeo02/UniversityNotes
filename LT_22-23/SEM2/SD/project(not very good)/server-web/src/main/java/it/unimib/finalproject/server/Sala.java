package it.unimib.finalproject.server;

import java.util.ArrayList;
import java.util.List;

public class Sala {

	private int id;
	private static int numPosti = 40;
	private List<Proiezione> proiezioni = new ArrayList<Proiezione>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumPosti() {
		return numPosti;
	}

	public List<Proiezione> getProiezioni() {
		return proiezioni;
	}

}
