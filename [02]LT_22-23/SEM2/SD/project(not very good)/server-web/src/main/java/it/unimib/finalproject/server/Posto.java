package it.unimib.finalproject.server;

public class Posto {

	private int id;
	public enum Status {
			OCCUPATO,
			LIBERO,
			PRENOTATO
	}
	private Status stato;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Status getStato() {
		return stato;
	}
	public void setStato(Status stato) {
		this.stato = stato;
	}
	
}
