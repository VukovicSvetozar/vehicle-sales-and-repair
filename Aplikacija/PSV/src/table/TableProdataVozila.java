package table;

import java.sql.Date;

public class TableProdataVozila {

	private int idVozila;
	private String model;
	private int idKlijenta;
	private String status_za_naplatu; // nije kolona u tabeli
	private Date datumProdaje;
	private double cijenaProdaje;
	private String ukupnoNaplaceno;
	private String sledecaUplata;
	private int idProdaja;

	public TableProdataVozila() {
		super();
	}

	public TableProdataVozila(int idProdaja, int idVozila, String model, int idKlijenta, String status_za_naplatu,
			Date datumProdaje, double cijenaProdaje, String ukupnoNaplaceno, String sledecaUplata) {
		super();
		this.idProdaja = idProdaja;
		this.idVozila = idVozila;
		this.model = model;
		this.idKlijenta = idKlijenta;
		this.status_za_naplatu = status_za_naplatu;
		this.datumProdaje = datumProdaje;
		this.cijenaProdaje = cijenaProdaje;
		this.ukupnoNaplaceno = ukupnoNaplaceno;
		this.sledecaUplata = sledecaUplata;
	}

	public int getIdProdaja() {
		return idProdaja;
	}

	public void setIdProdaja(int idProdaja) {
		this.idProdaja = idProdaja;
	}

	public int getIdVozila() {
		return idVozila;
	}

	public void setIdVozila(int idVozila) {
		this.idVozila = idVozila;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getIdKlijenta() {
		return idKlijenta;
	}

	public void setIdKlijenta(int idKlijenta) {
		this.idKlijenta = idKlijenta;
	}

	public String getStatus_za_naplatu() {
		return status_za_naplatu;
	}

	public void setStatus_za_naplatu(String status_za_naplatu) {
		this.status_za_naplatu = status_za_naplatu;
	}

	public Date getDatumProdaje() {
		return datumProdaje;
	}

	public void setDatumProdaje(Date datumProdaje) {
		this.datumProdaje = datumProdaje;
	}

	public double getCijenaProdaje() {
		return cijenaProdaje;
	}

	public void setCijenaProdaje(double cijenaProdaje) {
		this.cijenaProdaje = cijenaProdaje;
	}

	public String getUkupnoNaplaceno() {
		return ukupnoNaplaceno;
	}

	public void setUkupnoNaplaceno(String ukupnoNaplaceno) {
		this.ukupnoNaplaceno = ukupnoNaplaceno;
	}

	public String getSledecaUplata() {
		return sledecaUplata;
	}

	public void setSledecaUplata(String sledecaUplata) {
		this.sledecaUplata = sledecaUplata;
	}

}
