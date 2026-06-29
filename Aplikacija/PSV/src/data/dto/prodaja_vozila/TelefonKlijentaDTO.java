package data.dto.prodaja_vozila;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TelefonKlijentaDTO implements Serializable {

	private KlijentDTO klijent;
	private String brojTelefona;
	private String opis;

	public TelefonKlijentaDTO(KlijentDTO klijent, String brojTelefona, String opis) {
		super();
		this.klijent = klijent;
		this.brojTelefona = brojTelefona;
		this.opis = opis;
	}

	public TelefonKlijentaDTO() {
		super();
	}

	public KlijentDTO getKlijent() {
		return klijent;
	}

	public void setKlijent(KlijentDTO klijent) {
		this.klijent = klijent;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	@Override
	public String toString() {
		return "TelefonKlijentaDTO [klijent=" + klijent + ", brojTelefona=" + brojTelefona + ", opis=" + opis + "]";
	}

}
