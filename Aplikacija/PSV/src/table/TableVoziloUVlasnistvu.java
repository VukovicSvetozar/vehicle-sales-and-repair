package table;

import java.sql.Date;

public class TableVoziloUVlasnistvu {
	private int idVozila;
	private String tipVozila;
	private String model;
	private int godinaProizvodnje;
	private Date datumNabavke;
	private double cijenaNabavke;
	private String status_Za_Prodaju;		// nije kolona u tabeli

	public TableVoziloUVlasnistvu() {
		super();
	}

	public TableVoziloUVlasnistvu(int idVozila, String tipVozila, String model, int godinaProizvodnje,
			Date datumNabavke, double cijenaNabavke, String status_Za_Prodaju) {
		super();
		this.idVozila = idVozila;
		this.tipVozila = tipVozila;
		this.model = model;
		this.godinaProizvodnje = godinaProizvodnje;
		this.datumNabavke = datumNabavke;
		this.cijenaNabavke = cijenaNabavke;
		this.status_Za_Prodaju = status_Za_Prodaju;
	}

	public int getIdVozila() {
		return idVozila;
	}

	public void setIdVozila(int idVozila) {
		this.idVozila = idVozila;
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

	public int getGodinaProizvodnje() {
		return godinaProizvodnje;
	}

	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
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

	@Override
	public String toString() {
		return "TableVoziloUVlasnistvu [idVozila=" + idVozila + ", tipVozila=" + tipVozila + ", model=" + model
				+ ", godinaProizvodnje=" + godinaProizvodnje + ", datumNabavke=" + datumNabavke + ", cijenaNabavke="
				+ cijenaNabavke + ", status_Za_Prodaju=" + status_Za_Prodaju + "]";
	}

}
