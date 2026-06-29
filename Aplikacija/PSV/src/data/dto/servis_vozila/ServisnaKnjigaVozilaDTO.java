package data.dto.servis_vozila;

import java.io.Serializable;
import java.sql.Date;

import data.dto.prodaja_vozila.VozilaDTO;

@SuppressWarnings("serial")
public class ServisnaKnjigaVozilaDTO implements Serializable {

	private int brojKarticeVozila;
	private VozilaDTO vozila;
	private ZahtjevDTO zahtjev;
	private int ukupanBrojServisa;
	private Date datumPoslednjegServisa;
	private String opisRanijihPopravki;
	private String status;
	private String opisProblema;
	private int idVozila; // zbog tabele

	public ServisnaKnjigaVozilaDTO(int brojKarticeVozila, VozilaDTO vozila, ZahtjevDTO zahtjev, int ukupanBrojServisa,
			Date datumPoslednjegServisa, String opisRanijihPopravki, String status, String opisProblema, int idVozila) {
		super();
		this.brojKarticeVozila = brojKarticeVozila;
		this.vozila = vozila;
		this.zahtjev = zahtjev;
		this.ukupanBrojServisa = ukupanBrojServisa;
		this.datumPoslednjegServisa = datumPoslednjegServisa;
		this.opisRanijihPopravki = opisRanijihPopravki;
		this.status = status;
		this.opisProblema = opisProblema;
		this.idVozila = idVozila;
	}

	public ServisnaKnjigaVozilaDTO() {
		super();
	}

	public int getBrojKarticeVozila() {
		return brojKarticeVozila;
	}

	public void setBrojKarticeVozila(int brojKarticeVozila) {
		this.brojKarticeVozila = brojKarticeVozila;
	}

	public VozilaDTO getVozila() {
		return vozila;
	}

	public void setVozila(VozilaDTO vozila) {
		this.vozila = vozila;
	}

	public ZahtjevDTO getZahtjev() {
		return zahtjev;
	}

	public void setZahtjev(ZahtjevDTO zahtjev) {
		this.zahtjev = zahtjev;
	}

	public int getUkupanBrojServisa() {
		return ukupanBrojServisa;
	}

	public void setUkupanBrojServisa(int ukupanBrojServisa) {
		this.ukupanBrojServisa = ukupanBrojServisa;
	}

	public Date getDatumPoslednjegServisa() {
		return datumPoslednjegServisa;
	}

	public void setDatumPoslednjegServisa(Date datumPoslednjegServisa) {
		this.datumPoslednjegServisa = datumPoslednjegServisa;
	}

	public String getOpisRanijihPopravki() {
		return opisRanijihPopravki;
	}

	public void setOpisRanijihPopravki(String opisRanijihPopravki) {
		this.opisRanijihPopravki = opisRanijihPopravki;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOpisProblema() {
		return opisProblema;
	}

	public void setOpisProblema(String opisProblema) {
		this.opisProblema = opisProblema;
	}

	public int getIdVozila() {
		return idVozila;
	}

	public void setIdVozila(int idVozila) {
		this.idVozila = idVozila;
	}

}
