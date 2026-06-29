package data.dto.prodaja_vozila;

import java.sql.Date;

import data.dto.zaposleni.ZiroRacunPreduzecaDTO;

public class NaplataKupovineDTO {

	private int brojNaplateKupovine;
	private ProdajaDTO prodaja;
	private ZiroRacunPreduzecaDTO ziroracunpreduzeca;
	private Date datumNaplate;

	public NaplataKupovineDTO(int brojNaplateKupovine, ProdajaDTO prodaja, ZiroRacunPreduzecaDTO ziroracunpreduzeca,
			Date datumNaplate) {
		super();
		this.brojNaplateKupovine = brojNaplateKupovine;
		this.prodaja = prodaja;
		this.ziroracunpreduzeca = ziroracunpreduzeca;
		this.datumNaplate = datumNaplate;
	}

	public NaplataKupovineDTO() {
		super();
	}

	public int getBrojNaplateKupovine() {
		return brojNaplateKupovine;
	}

	public void setBrojNaplateKupovine(int brojNaplateKupovine) {
		this.brojNaplateKupovine = brojNaplateKupovine;
	}

	public ProdajaDTO getProdaja() {
		return prodaja;
	}

	public void setProdaja(ProdajaDTO prodaja) {
		this.prodaja = prodaja;
	}

	public ZiroRacunPreduzecaDTO getZiroracunpreduzeca() {
		return ziroracunpreduzeca;
	}

	public void setZiroracunpreduzeca(ZiroRacunPreduzecaDTO ziroracunpreduzeca) {
		this.ziroracunpreduzeca = ziroracunpreduzeca;
	}

	public Date getDatumNaplate() {
		return datumNaplate;
	}

	public void setDatumNaplate(Date datumNaplate) {
		this.datumNaplate = datumNaplate;
	}

	@Override
	public String toString() {
		return "NaplataKupovineDTO [brojNaplateKupovine=" + brojNaplateKupovine + ", prodaja=" + prodaja
				+ ", ziroracunpreduzeca=" + ziroracunpreduzeca + ", datumNaplate=" + datumNaplate + "]";
	}

}
