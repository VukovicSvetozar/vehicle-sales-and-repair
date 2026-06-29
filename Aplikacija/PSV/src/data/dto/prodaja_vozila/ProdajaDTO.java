package data.dto.prodaja_vozila;

import java.sql.Date;

import data.dto.zaposleni.ProdavacDTO;

public class ProdajaDTO {

	private int idProdaja;
	private KupacDTO kupac;
	private ProdataVozilaDTO prodatoVozilo;
	private ProdavacDTO prodavac;
	private String nacinPlacanja;
	private double ukupnoNaplaceno;
	private String status_za_naplatu;
	private Date datumProdaje;
	private String sledecaUplata;
	private UgovorDTO ugovor;

	public ProdajaDTO(int idProdaja, KupacDTO kupac, ProdataVozilaDTO prodatoVozilo, ProdavacDTO prodavac,
			String nacinPlacanja, double ukupnoNaplaceno, String status_za_naplatu, Date datumProdaje,
			String sledecaUplata, UgovorDTO ugovor) {
		super();
		this.idProdaja = idProdaja;
		this.kupac = kupac;
		this.prodatoVozilo = prodatoVozilo;
		this.prodavac = prodavac;
		this.nacinPlacanja = nacinPlacanja;
		this.ukupnoNaplaceno = ukupnoNaplaceno;
		this.status_za_naplatu = status_za_naplatu;
		this.datumProdaje = datumProdaje;
		this.sledecaUplata = sledecaUplata;
		this.ugovor = ugovor;
	}

	public ProdajaDTO() {
		super();
	}

	public int getIdProdaja() {
		return idProdaja;
	}

	public void setIdProdaja(int idProdaja) {
		this.idProdaja = idProdaja;
	}

	public KupacDTO getKupac() {
		return kupac;
	}

	public void setKupac(KupacDTO kupac) {
		this.kupac = kupac;
	}

	public ProdataVozilaDTO getProdatoVozilo() {
		return prodatoVozilo;
	}

	public void setProdatoVozilo(ProdataVozilaDTO prodatoVozilo) {
		this.prodatoVozilo = prodatoVozilo;
	}

	public ProdavacDTO getProdavac() {
		return prodavac;
	}

	public void setProdavac(ProdavacDTO prodavac) {
		this.prodavac = prodavac;
	}

	public String getNacinPlacanja() {
		return nacinPlacanja;
	}

	public void setNacinPlacanja(String nacinPlacanja) {
		this.nacinPlacanja = nacinPlacanja;
	}

	public double getUkupnoNaplaceno() {
		return ukupnoNaplaceno;
	}

	public void setUkupnoNaplaceno(double ukupnoNaplaceno) {
		this.ukupnoNaplaceno = ukupnoNaplaceno;
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

	public String getSledecaUplata() {
		return sledecaUplata;
	}

	public void setSledecaUplata(String sledecaUplata) {
		this.sledecaUplata = sledecaUplata;
	}

	public UgovorDTO getUgovor() {
		return ugovor;
	}

	public void setUgovor(UgovorDTO ugovor) {
		this.ugovor = ugovor;
	}

	@Override
	public String toString() {
		return "ProdajaDTO [kupac=" + kupac + ", prodatoVozilo=" + prodatoVozilo + ", prodavac=" + prodavac
				+ ", nacinPlacanja=" + nacinPlacanja + ", ukupnoNaplaceno=" + ukupnoNaplaceno + ", status_za_naplatu="
				+ status_za_naplatu + ", datumProdaje=" + datumProdaje + ", sledecaUplata=" + sledecaUplata
				+ ", ugovor=" + ugovor + "]";
	}

}
