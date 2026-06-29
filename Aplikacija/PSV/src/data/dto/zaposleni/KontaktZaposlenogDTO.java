package data.dto.zaposleni;

import java.io.Serializable;

@SuppressWarnings("serial")
public class KontaktZaposlenogDTO implements Serializable {

	private int idKontak;
	private String grad;
	private String adresa;
	private String telefon;
	private String email;
	private ZaposleniDTO zaposleni;

	public int getIdKontak() {
		return idKontak;
	}

	public void setIdKontak(int idKontak) {
		this.idKontak = idKontak;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ZaposleniDTO getZaposleni() {
		return zaposleni;
	}

	public void setZaposleni(ZaposleniDTO zaposleni) {
		this.zaposleni = zaposleni;
	}

	public KontaktZaposlenogDTO(int idKontak, String grad, String adresa, String telefon, String email,
			ZaposleniDTO zaposleni) {
		super();
		this.idKontak = idKontak;
		this.grad = grad;
		this.adresa = adresa;
		this.telefon = telefon;
		this.email = email;
		this.zaposleni = zaposleni;
	}

	public KontaktZaposlenogDTO() {
		super();
	}

}
