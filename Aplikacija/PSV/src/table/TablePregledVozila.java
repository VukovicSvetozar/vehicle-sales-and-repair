package table;

public class TablePregledVozila {

	private int idVozila;
	private String status;
	private String tipVozila;
	private String model;
	private Integer godinaProizvodnje;
	private String status_za_prodaju; // nije kolona u tabeli
	private String vrstaGoriva;
	private String brojRegistracije;
	private String cijenaNabavke;
	private String cijenaProdaje;
	private String fotografija;

	public TablePregledVozila(int idVozila, String status, String tipVozila, String model, Integer godinaProizvodnje,
			String status_za_prodaju, String vrstaGoriva, String brojRegistracije, String cijenaNabavke,
			String cijenaProdaje, String fotografija) {
		super();
		this.idVozila = idVozila;
		this.status = status;
		this.tipVozila = tipVozila;
		this.model = model;
		this.godinaProizvodnje = godinaProizvodnje;
		this.status_za_prodaju = status_za_prodaju;
		this.vrstaGoriva = vrstaGoriva;
		this.brojRegistracije = brojRegistracije;
		this.cijenaNabavke = cijenaNabavke;
		this.cijenaProdaje = cijenaProdaje;
		this.fotografija = fotografija;
	}

	public TablePregledVozila() {
		super();
	}

	public int getIdVozila() {
		return idVozila;
	}

	public void setIdVozila(int idVozila) {
		this.idVozila = idVozila;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTipVozila() {
		return tipVozila;
	}

	public void setTipVozila(String tipVozila) {
		this.tipVozila = tipVozila;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getGodinaProizvodnje() {
		return godinaProizvodnje;
	}

	public void setGodinaProizvodnje(Integer godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}

	public String getStatus_za_prodaju() {
		return status_za_prodaju;
	}

	public void setStatus_za_prodaju(String status_za_prodaju) {
		this.status_za_prodaju = status_za_prodaju;
	}

	public String getVrstaGoriva() {
		return vrstaGoriva;
	}

	public void setVrstaGoriva(String vrstaGoriva) {
		this.vrstaGoriva = vrstaGoriva;
	}

	public String getBrojRegistracije() {
		return brojRegistracije;
	}

	public void setBrojRegistracije(String brojRegistracije) {
		this.brojRegistracije = brojRegistracije;
	}

	public String getCijenaNabavke() {
		return cijenaNabavke;
	}

	public void setCijenaNabavke(String cijenaNabavke) {
		this.cijenaNabavke = cijenaNabavke;
	}

	public String getCijenaProdaje() {
		return cijenaProdaje;
	}

	public void setCijenaProdaje(String cijenaProdaje) {
		this.cijenaProdaje = cijenaProdaje;
	}

	public String getFotografija() {
		return fotografija;
	}

	public void setFotografija(String fotografija) {
		this.fotografija = fotografija;
	}

}
