package data.dto.servis_vozila;

import java.io.Serializable;

import data.dto.prodaja_vozila.KlijentDTO;

@SuppressWarnings("serial")
public class KorisniciServisaDTO implements Serializable {

	private String napomenaKorisnika;
	private KlijentDTO klijent;

	public String getNapomenaKorisnika() {
		return napomenaKorisnika;
	}

	public void setNapomenaKorisnika(String napomenaKorisnika) {
		this.napomenaKorisnika = napomenaKorisnika;
	}

	public KlijentDTO getKlijent() {
		return klijent;
	}

	public void setKlijent(KlijentDTO klijent) {
		this.klijent = klijent;
	}

	public KorisniciServisaDTO(KlijentDTO klijent, String napomenaKorisnika) {
		super();
		this.napomenaKorisnika = napomenaKorisnika;
		this.klijent = klijent;
	}

	public KorisniciServisaDTO() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KorisniciServisaDTO other = (KorisniciServisaDTO) obj;
		if (klijent == null) {
			if (other.klijent != null)
				return false;
		} else if (!klijent.equals(other.klijent))
			return false;
		if (napomenaKorisnika == null) {
			if (other.napomenaKorisnika != null)
				return false;
		} else if (!napomenaKorisnika.equals(other.napomenaKorisnika))
			return false;
		return true;
	}

}
