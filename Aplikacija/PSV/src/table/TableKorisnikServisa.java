package table;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TableKorisnikServisa implements Serializable{

	private Integer idKlijenta;
	private String tipKategorije;
	private String naziv;

	public TableKorisnikServisa() {
		super();
	}

	public TableKorisnikServisa(Integer idKlijenta, String tipKategorije, String naziv) {
		super();
		this.idKlijenta = idKlijenta;
		this.tipKategorije = tipKategorije;
		this.naziv = naziv;
	}

	public Integer getIdKlijenta() {
		return idKlijenta;
	}

	public void setIdKlijenta(Integer idKlijenta) {
		this.idKlijenta = idKlijenta;
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

}
