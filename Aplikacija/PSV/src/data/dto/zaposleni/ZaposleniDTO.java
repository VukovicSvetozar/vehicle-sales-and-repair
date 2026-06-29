package data.dto.zaposleni;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class ZaposleniDTO implements Serializable {

	private String jmb;
	private String ime;
	private String prezime;
	private Date datumRodjenja;
	private Date datumZaposljavanja;
	private String funkcija;
	private Double satnica;
	private Date lijecnickiPregled;
	private Date datumIstekaUgovora;
	private String fotografija;

	public ZaposleniDTO(String jmb) {
		super();
		this.jmb = jmb;
	}

	public ZaposleniDTO(String jmb, String ime, String prezime, Date datumRodjenja, Date datumZaposljavanja,
			String funkcija, Double satnica, Date lijecnickiPregled, Date datumIstekaUgovora, String fotografija) {
		super();
		this.jmb = jmb;
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.datumZaposljavanja = datumZaposljavanja;
		this.funkcija = funkcija;
		this.satnica = satnica;
		this.lijecnickiPregled = lijecnickiPregled;
		this.datumIstekaUgovora = datumIstekaUgovora;
		this.fotografija = fotografija;
	}

	public ZaposleniDTO() {
		super();
	}

	public String getJmb() {
		return jmb;
	}

	public void setJmb(String jmb) {
		this.jmb = jmb;
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

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public Date getDatumZaposljavanja() {
		return datumZaposljavanja;
	}

	public void setDatumZaposljavanja(Date datumZaposljavanja) {
		this.datumZaposljavanja = datumZaposljavanja;
	}

	public String getFunkcija() {
		return funkcija;
	}

	public void setFunkcija(String funkcija) {
		this.funkcija = funkcija;
	}

	public Double getSatnica() {
		return satnica;
	}

	public void setSatnica(Double satnica) {
		this.satnica = satnica;
	}

	public Date getLijecnickiPregled() {
		return lijecnickiPregled;
	}

	public void setLijecnickiPregled(Date lijecnickiPregled) {
		this.lijecnickiPregled = lijecnickiPregled;
	}

	public Date getDatumIstekaUgovora() {
		return datumIstekaUgovora;
	}

	public void setDatumIstekaUgovora(Date datumIstekaUgovora) {
		this.datumIstekaUgovora = datumIstekaUgovora;
	}

	public String getFotografija() {
		return fotografija;
	}

	public void setFotografija(String fotografija) {
		this.fotografija = fotografija;
	}

}
