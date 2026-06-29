package data.dto.zaposleni;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MenadzerDTO implements Serializable {

	private ZaposleniDTO zaposleni;
	private String sifra;

	public MenadzerDTO() {
		super();
	}

	public MenadzerDTO(ZaposleniDTO zaposleni, String sifra) {
		super();
		this.zaposleni = zaposleni;
		this.sifra = sifra;
	}

	public MenadzerDTO(ZaposleniDTO zaposleni) {
		this.zaposleni = zaposleni;
	}

	public ZaposleniDTO getZaposleni() {
		return zaposleni;
	}

	public void setZaposleni(ZaposleniDTO zaposleni) {
		this.zaposleni = zaposleni;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

}
