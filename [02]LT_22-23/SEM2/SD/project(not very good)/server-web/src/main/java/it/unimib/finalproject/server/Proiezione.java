package it.unimib.finalproject.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Proiezione {

	private int id;
	private String titolo;
	private String descrizione;
	private String genere1;
	private String genere2;
	private String imgLink;
	private String casaProduttrice;
	private Date data;
	private int durata;
	private List<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public void setGenere1(String genere1) {
		this.genere1 = genere1;
	}

	public String getGenere1() {
		return genere1;
	}

	public void setGenere2(String genere2) {
		this.genere2 = genere2;
	}

	public String getGenere2() {
		return genere2;
	}

	public String getimgLink() {
		return imgLink;
	}

	public void setimgLink(String imgLink) {
		this.imgLink = imgLink;
	}

	public String getcasaProduttrice() {
		return casaProduttrice;
	}

	public void setcasaProduttrice(String casaProduttrice) {
		this.casaProduttrice = casaProduttrice;
	}

	public Date getdata() {
		return data;
	}

	public void setdata(Date data) {
		this.data = data;
	}

	public int getdurata() {
		return durata;
	}

	public void setdurata(int durata) {
		this.durata = durata;
	}

	public List<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}
}
