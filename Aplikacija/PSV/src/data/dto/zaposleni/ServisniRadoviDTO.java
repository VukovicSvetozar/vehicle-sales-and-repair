package data.dto.zaposleni;

public class ServisniRadoviDTO {

	private String vrstaServisnihRadova;
	private double koeficijent;

	public String getVrstaServisnihRadova() {
		return vrstaServisnihRadova;
	}

	public void setVrstaServisnihRadova(String vrstaServisnihRadova) {
		this.vrstaServisnihRadova = vrstaServisnihRadova;
	}

	public double getKoeficijent() {
		return koeficijent;
	}

	public void setKoeficijent(double koeficijent) {
		this.koeficijent = koeficijent;
	}

	public ServisniRadoviDTO(String vrstaServisnihRadova, double koeficijent) {
		super();
		this.vrstaServisnihRadova = vrstaServisnihRadova;
		this.koeficijent = koeficijent;
	}

	public ServisniRadoviDTO() {
		super();
	}

	public ServisniRadoviDTO(String vrstaServisnihRadova) {
		super();
		this.vrstaServisnihRadova = vrstaServisnihRadova;
	}

}
