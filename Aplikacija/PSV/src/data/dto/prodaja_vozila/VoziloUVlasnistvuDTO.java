package data.dto.prodaja_vozila;

import java.sql.Date;

public class VoziloUVlasnistvuDTO {

	private VozilaDTO vozila;
	private Date datumNabavke;
	private double cijenaNabavke;
	private String status_Za_Prodaju;
	private String tehnickaProvjera;
	private KupacDTO kupac;
	private int BrojGaraze;
	private String Ocarinjeno;
	private String StanjeVozila;

	public VoziloUVlasnistvuDTO(VozilaDTO vozila, Date datumNabavke, double cijenaNabavke, String status_Za_Prodaju,
			String tehnickaProvjera, KupacDTO kupac, int brojGaraze, String ocarinjeno, String stanjeVozila) {
		super();
		this.vozila = vozila;
		this.datumNabavke = datumNabavke;
		this.cijenaNabavke = cijenaNabavke;
		this.status_Za_Prodaju = status_Za_Prodaju;
		this.tehnickaProvjera = tehnickaProvjera;
		this.kupac = kupac;
		BrojGaraze = brojGaraze;
		Ocarinjeno = ocarinjeno;
		StanjeVozila = stanjeVozila;
	}

	public VoziloUVlasnistvuDTO() {
		super();
	}

	public VozilaDTO getVozila() {
		return vozila;
	}

	public void setVozila(VozilaDTO vozila) {
		this.vozila = vozila;
	}

	public Date getDatumNabavke() {
		return datumNabavke;
	}

	public void setDatumNabavke(Date datumNabavke) {
		this.datumNabavke = datumNabavke;
	}

	public double getCijenaNabavke() {
		return cijenaNabavke;
	}

	public void setCijenaNabavke(double cijenaNabavke) {
		this.cijenaNabavke = cijenaNabavke;
	}

	public String getStatus_Za_Prodaju() {
		return status_Za_Prodaju;
	}

	public void setStatus_Za_Prodaju(String status_Za_Prodaju) {
		this.status_Za_Prodaju = status_Za_Prodaju;
	}

	public String getTehnickaProvjera() {
		return tehnickaProvjera;
	}

	public void setTehnickaProvjera(String tehnickaProvjera) {
		this.tehnickaProvjera = tehnickaProvjera;
	}

	public KupacDTO getKupac() {
		return kupac;
	}

	public void setKupac(KupacDTO kupac) {
		this.kupac = kupac;
	}

	public int getBrojGaraze() {
		return BrojGaraze;
	}

	public void setBrojGaraze(int brojGaraze) {
		BrojGaraze = brojGaraze;
	}

	public String getOcarinjeno() {
		return Ocarinjeno;
	}

	public void setOcarinjeno(String ocarinjeno) {
		Ocarinjeno = ocarinjeno;
	}

	public String getStanjeVozila() {
		return StanjeVozila;
	}

	public void setStanjeVozila(String stanjeVozila) {
		StanjeVozila = stanjeVozila;
	}

}
