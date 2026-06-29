package data.dto.prodaja_vozila;

import java.io.Serializable;

@SuppressWarnings("serial")
public class KlijentDTO implements Serializable {

	private Integer idKlijenta;
	private String tipKlijenta;
	private String adresa;
	private String grad;
	private String drzava = "Bosna i Hercegovina";
	private String email;
	private KategorijaKlijentaDTO kategorijaKLijenta;

	public KlijentDTO(Integer idKlijenta, String tipKlijenta, String adresa, String grad, String drzava, String email,
			KategorijaKlijentaDTO kategorijaKLijenta) {
		super();
		this.idKlijenta = idKlijenta;
		this.tipKlijenta = tipKlijenta;
		this.adresa = adresa;
		this.grad = grad;
		this.drzava = drzava;
		this.email = email;
		this.kategorijaKLijenta = kategorijaKLijenta;
	}

	public KlijentDTO() {
		super();

	}

	public Integer getIdKlijenta() {
		return idKlijenta;
	}

	public void setIdKlijenta(Integer idKlijenta) {
		this.idKlijenta = idKlijenta;
	}

	public String getTipKlijenta() {
		return tipKlijenta;
	}

	public void setTipKlijenta(String tipKlijenta) {
		this.tipKlijenta = tipKlijenta;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public KategorijaKlijentaDTO getKategorijaKlijenta() {
		return kategorijaKLijenta;
	}

	public void setKategorijaKLijenta(KategorijaKlijentaDTO kategorijaKLijenta) {
		this.kategorijaKLijenta = kategorijaKLijenta;
	}

	@Override
	public String toString() {
		return "KlijentDTO [idKlijenta=" + idKlijenta + ", tipKlijenta=" + tipKlijenta + ", adresa=" + adresa
				+ ", grad=" + grad + ", drzava=" + drzava + ", email=" + email + ", kategorijaKLijenta="
				+ kategorijaKLijenta + "]";
	}

}
