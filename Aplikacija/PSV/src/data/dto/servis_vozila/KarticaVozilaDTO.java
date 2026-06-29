package data.dto.servis_vozila;

import java.io.Serializable;
import java.sql.Date;

import data.dto.prodaja_vozila.VozilaDTO;

@SuppressWarnings("serial")
public class KarticaVozilaDTO implements Serializable {

	private int idKarticaVozila;
	private VozilaDTO vozila;
	private ZahtjevDTO zahtjev;
	private int ukupanBrojServisa;
	private Date datumPoslednjegServisa;
	private String opisRanijihPopravki;
	private String status;
	
	public KarticaVozilaDTO(int idKarticaVozila, VozilaDTO vozila, ZahtjevDTO zahtjev, int ukupanBrojServisa,
			Date datumPoslednjegServisa, String opisRanijihPopravki, String status) {
		super();
		this.idKarticaVozila = idKarticaVozila;
		this.vozila = vozila;
		this.zahtjev = zahtjev;
		this.ukupanBrojServisa = ukupanBrojServisa;
		this.datumPoslednjegServisa = datumPoslednjegServisa;
		this.opisRanijihPopravki = opisRanijihPopravki;
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getIdKarticaVozila() {
		return idKarticaVozila;
	}
	public void setIdKarticaVozila(int idKarticaVozila) {
		this.idKarticaVozila = idKarticaVozila;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datumPoslednjegServisa == null) ? 0 : datumPoslednjegServisa.hashCode());
		result = prime * result + idKarticaVozila;
		result = prime * result + ((opisRanijihPopravki == null) ? 0 : opisRanijihPopravki.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ukupanBrojServisa;
		result = prime * result + ((vozila == null) ? 0 : vozila.hashCode());
		result = prime * result + ((zahtjev == null) ? 0 : zahtjev.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KarticaVozilaDTO other = (KarticaVozilaDTO) obj;
		if (datumPoslednjegServisa == null) {
			if (other.datumPoslednjegServisa != null)
				return false;
		} else if (!datumPoslednjegServisa.equals(other.datumPoslednjegServisa))
			return false;
		if (idKarticaVozila != other.idKarticaVozila)
			return false;
		if (opisRanijihPopravki == null) {
			if (other.opisRanijihPopravki != null)
				return false;
		} else if (!opisRanijihPopravki.equals(other.opisRanijihPopravki))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (ukupanBrojServisa != other.ukupanBrojServisa)
			return false;
		if (vozila == null) {
			if (other.vozila != null)
				return false;
		} else if (!vozila.equals(other.vozila))
			return false;
		if (zahtjev == null) {
			if (other.zahtjev != null)
				return false;
		} else if (!zahtjev.equals(other.zahtjev))
			return false;
		return true;
	}
	public KarticaVozilaDTO(int idKarticaVozila, VozilaDTO vozila, ZahtjevDTO zahtjev, int ukupanBrojServisa,
			Date datumPoslednjegServisa, String opisRanijihPopravki) {
		super();
		this.idKarticaVozila = idKarticaVozila;
		this.vozila = vozila;
		this.zahtjev = zahtjev;
		this.ukupanBrojServisa = ukupanBrojServisa;
		this.datumPoslednjegServisa = datumPoslednjegServisa;
		this.opisRanijihPopravki = opisRanijihPopravki;
	}
	public KarticaVozilaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
