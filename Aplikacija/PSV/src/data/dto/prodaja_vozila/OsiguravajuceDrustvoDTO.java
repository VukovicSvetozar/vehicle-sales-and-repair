package data.dto.prodaja_vozila;

public class OsiguravajuceDrustvoDTO {

	private String jib;
	private String naziv;

	public OsiguravajuceDrustvoDTO(String jib, String naziv) {
		super();
		this.jib = jib;
		this.naziv = naziv;
	}

	public OsiguravajuceDrustvoDTO() {
		super();
	}

	public String getJib() {
		return jib;
	}

	public void setJib(String jib) {
		this.jib = jib;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	@Override
	public String toString() {
		return "OsiguravajuceDrustvoDTO [jib=" + jib + ", naziv=" + naziv + "]";
	}

}
