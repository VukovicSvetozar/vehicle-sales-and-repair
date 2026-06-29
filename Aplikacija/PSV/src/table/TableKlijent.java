package table;

public class TableKlijent {

	private Integer idKlijenta;
	private String tipKlijenta;
	private String tipKategorije;
	private String naziv;
	private String adresaKupca;
	private String email;

	public TableKlijent() {
		super();
	}

	public TableKlijent(Integer idKlijenta, String tipKlijenta, String tipKategorije, String naziv, String adresaKupca,
			String email) {
		super();
		this.idKlijenta = idKlijenta;
		this.tipKlijenta = tipKlijenta;
		this.tipKategorije = tipKategorije;
		this.naziv = naziv;
		this.adresaKupca = adresaKupca;
		this.email = email;
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

	public String getTipKategorije() {
		return tipKategorije;
	}

	public void setTipKategorije(String tipKategorije) {
		this.tipKategorije = tipKategorije;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresaKupca() {
		return adresaKupca;
	}

	public void setAdresaKupca(String adresaKupca) {
		this.adresaKupca = adresaKupca;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "TableKlijent [idKlijenta=" + idKlijenta + ", tipKlijenta=" + tipKlijenta + ", tipKategorije="
				+ tipKategorije + ", naziv=" + naziv + ", adresaKupca=" + adresaKupca + ", email=" + email + "]";
	}

}
