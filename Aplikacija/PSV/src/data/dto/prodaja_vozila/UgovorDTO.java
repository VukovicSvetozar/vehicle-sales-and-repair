package data.dto.prodaja_vozila;

import java.sql.Date;

import data.dto.zaposleni.MenadzerDTO;

public class UgovorDTO {

	private int idUgovora;
	private Date datumSklapanjaUgovora;
	private MenadzerDTO menadzer;

	public UgovorDTO(int idUgovora, Date datumSklapanjaUgovora, MenadzerDTO menadzer) {
		super();
		this.idUgovora = idUgovora;
		this.datumSklapanjaUgovora = datumSklapanjaUgovora;
		this.menadzer = menadzer;
	}

	public UgovorDTO() {
		super();
	}

	public int getIdUgovora() {
		return idUgovora;
	}

	public void setIdUgovora(int idUgovora) {
		this.idUgovora = idUgovora;
	}

	public Date getDatumSklapanjaUgovora() {
		return datumSklapanjaUgovora;
	}

	public void setDatumSklapanjaUgovora(Date datumSklapanjaUgovora) {
		this.datumSklapanjaUgovora = datumSklapanjaUgovora;
	}

	public MenadzerDTO getMenadzer() {
		return menadzer;
	}

	public void setMenadzer(MenadzerDTO menadzer) {
		this.menadzer = menadzer;
	}

	@Override
	public String toString() {
		return "UgovorDTO [idUgovora=" + idUgovora + ", datumSklapanjaUgovora=" + datumSklapanjaUgovora + ", menadzer="
				+ menadzer + "]";
	}

}
