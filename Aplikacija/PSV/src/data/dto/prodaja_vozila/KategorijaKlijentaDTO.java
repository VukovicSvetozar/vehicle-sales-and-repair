package data.dto.prodaja_vozila;

import java.io.Serializable;

@SuppressWarnings("serial")
public class KategorijaKlijentaDTO implements Serializable {

	private int idKategorija;
	private String tipKategorije;

	public KategorijaKlijentaDTO(int idKategorija, String tipKategorije) {
		super();
		this.idKategorija = idKategorija;
		this.tipKategorije = tipKategorije;
	}

	public KategorijaKlijentaDTO() {
		super();
	}

	public int getIdKategorija() {
		return idKategorija;
	}

	public void setIdKategorija(int idKategorija) {
		this.idKategorija = idKategorija;
	}

	public String getTipKategorije() {
		return tipKategorije;
	}

	public void setTipKategorije(String tipKategorije) {
		this.tipKategorije = tipKategorije;
	}

	@Override
	public String toString() {
		return "KategorijaKlijentaDTO [idKategorija=" + idKategorija + ", tipKategorije=" + tipKategorije + "]";
	}

}
