package data.dto.zaposleni;

public class BankaDTO {

	private String jib;
	private String sjediste;
	private String naziv;
	private String ziroRacunBanke;

	public BankaDTO() {
		super();
	}

	public BankaDTO(String jib, String sjediste, String naziv, String ziroRacunBanke) {
		super();
		this.jib = jib;
		this.sjediste = sjediste;
		this.naziv = naziv;
		this.ziroRacunBanke = ziroRacunBanke;
	}

	public BankaDTO(String jib, String naziv) {
		super();
		this.jib = jib;
		this.naziv = naziv;
	}

	public String getJib() {
		return jib;
	}

	public void setJib(String jib) {
		this.jib = jib;
	}

	public String getSjediste() {
		return sjediste;
	}

	public void setSjediste(String sjediste) {
		this.sjediste = sjediste;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getZiroRacunBanke() {
		return ziroRacunBanke;
	}

	public void setZiroRacunBanke(String ziroRacunBanke) {
		this.ziroRacunBanke = ziroRacunBanke;
	}

}
