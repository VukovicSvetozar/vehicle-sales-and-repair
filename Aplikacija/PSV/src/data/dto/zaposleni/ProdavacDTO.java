package data.dto.zaposleni;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProdavacDTO implements Serializable {

	private ZaposleniDTO zaposleni;
	private int brojProdatihVozila;
	private String sifra;

	public ZaposleniDTO getZaposleni() {
		return zaposleni;
	}

	public void setZaposleni(ZaposleniDTO zaposleni) {
		this.zaposleni = zaposleni;
	}

	public int getBrojProdatihVozila() {
		return brojProdatihVozila;
	}

	public void setBrojProdatihVozila(int brojProdatihVozila) {
		this.brojProdatihVozila = brojProdatihVozila;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public ProdavacDTO(ZaposleniDTO zaposleni, int brojProdatihVozila, String sifra) {
		super();
		this.zaposleni = zaposleni;
		this.brojProdatihVozila = brojProdatihVozila;
		this.sifra = sifra;
	}

	public ProdavacDTO() {
		super();
	}

}
