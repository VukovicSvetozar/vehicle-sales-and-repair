package data.dto.prodaja_vozila;

import java.io.Serializable;

@SuppressWarnings("serial")
public class KompanijaDTO implements Serializable {

	private String naziv;
	private String InternetStranica;
	private KategorijaKlijentaDTO kategorijaKlijenta;

	public KompanijaDTO() {
		super();
	}

	public KompanijaDTO(String naziv, String internetStranica, KategorijaKlijentaDTO kategorijaKlijenta) {
		super();
		this.naziv = naziv;
		InternetStranica = internetStranica;
		this.kategorijaKlijenta = kategorijaKlijenta;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getInternetStranica() {
		return InternetStranica;
	}

	public void setInternetStranica(String internetStranica) {
		InternetStranica = internetStranica;
	}

	public KategorijaKlijentaDTO getKategorijaKlijenta() {
		return kategorijaKlijenta;
	}

	public void setKategorijaKlijenta(KategorijaKlijentaDTO kategorijaKlijenta) {
		this.kategorijaKlijenta = kategorijaKlijenta;
	}

	@Override
	public String toString() {
		return "KompanijaDTO [naziv=" + naziv + ", InternetStranica=" + InternetStranica + ", kategorijaKlijenta="
				+ kategorijaKlijenta + "]";
	}

}
