package data.dto.prodaja_vozila;

import java.io.Serializable;

@SuppressWarnings("serial")
public class IndividualnoLiceDTO implements Serializable {

	private String ime;
	private String prezime;
	private String pol;
	private KategorijaKlijentaDTO kategorijaKlijenta;

	public IndividualnoLiceDTO() {
		super();
	}

	public IndividualnoLiceDTO(String ime, String prezime, String pol, KategorijaKlijentaDTO kategorijaKlijenta) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.pol = pol;
		this.kategorijaKlijenta = kategorijaKlijenta;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public KategorijaKlijentaDTO getKategorijaKlijenta() {
		return kategorijaKlijenta;
	}

	public void setKategorijaKlijenta(KategorijaKlijentaDTO kategorijaKlijenta) {
		this.kategorijaKlijenta = kategorijaKlijenta;
	}

	@Override
	public String toString() {
		return "IndividualnoLiceDTO [ime=" + ime + ", prezime=" + prezime + ", pol=" + pol + ", kategorijaKlijenta="
				+ kategorijaKlijenta + "]";
	}

}
