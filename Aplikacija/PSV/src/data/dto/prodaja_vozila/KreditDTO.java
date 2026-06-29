package data.dto.prodaja_vozila;

import data.dto.zaposleni.BankaDTO;

public class KreditDTO {

	private int idKredit;
	private double iznosRateKredita;
	private int brojRata;
	private BankaDTO banka;
	private ProdajaDTO prodaja;

	public KreditDTO(int idKredit, double iznosRateKredita, int brojRata, BankaDTO banka, ProdajaDTO prodaja) {
		super();
		this.idKredit = idKredit;
		this.iznosRateKredita = iznosRateKredita;
		this.brojRata = brojRata;
		this.banka = banka;
		this.prodaja = prodaja;
	}

	public KreditDTO() {
		super();
	}

	public int getIdKredit() {
		return idKredit;
	}

	public void setIdKredit(int idKredit) {
		this.idKredit = idKredit;
	}

	public double getIznosRateKredita() {
		return iznosRateKredita;
	}

	public void setIznosRateKredita(double iznosRateKredita) {
		this.iznosRateKredita = iznosRateKredita;
	}

	public int getBrojRata() {
		return brojRata;
	}

	public void setBrojRata(int brojRata) {
		this.brojRata = brojRata;
	}

	public BankaDTO getBanka() {
		return banka;
	}

	public void setBanka(BankaDTO banka) {
		this.banka = banka;
	}

	public ProdajaDTO getProdaja() {
		return prodaja;
	}

	public void setProdaja(ProdajaDTO prodaja) {
		this.prodaja = prodaja;
	}

	@Override
	public String toString() {
		return "KreditDTO [idKredit=" + idKredit + ", iznosRateKredita=" + iznosRateKredita + ", brojRata="
				+ brojRata + ", banka=" + banka + ", prodaja=" + prodaja + "]";
	}

}
