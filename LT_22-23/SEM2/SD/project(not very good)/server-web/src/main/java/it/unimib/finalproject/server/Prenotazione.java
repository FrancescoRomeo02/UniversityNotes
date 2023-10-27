package it.unimib.finalproject.server;

import java.util.ArrayList;
import java.util.List;

public class Prenotazione {

	private int id; // id della prenotazione, da prendere dal db (autoincrement)
	private List<Posto> postiPrenotati = new ArrayList<Posto>();

	public int getId() {
		return id;
	}

	public List<Posto> getPostiPrenotati() {
		return postiPrenotati;
	}
}
