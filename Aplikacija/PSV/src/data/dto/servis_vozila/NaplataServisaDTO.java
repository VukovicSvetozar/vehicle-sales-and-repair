package data.dto.servis_vozila;

import java.sql.Date;

import data.dto.zaposleni.ZiroRacunPreduzecaDTO;

public class NaplataServisaDTO {
	
	private int brojNaplateServisa;
	private double popust;
	private VoziloNaServisuDTO voziloNaServisu;
	private Date datumNaplate;
	private double iznos;	
	private ZiroRacunPreduzecaDTO ziroRacunPreduzeca;
	private double ukupnaCijenaDodatnihUsluga;
	private String status;
	public int getBrojNaplateServisa() {
		return brojNaplateServisa;
	}
	public void setBrojNaplateServisa(int brojNaplateServisa) {
		this.brojNaplateServisa = brojNaplateServisa;
	}
	public double getPopust() {
		return popust;
	}
	public void setPopust(double popust) {
		this.popust = popust;
	}
	public VoziloNaServisuDTO getVoziloNaServisu() {
		return voziloNaServisu;
	}
	public void setVoziloNaServisu(VoziloNaServisuDTO voziloNaServisu) {
		this.voziloNaServisu = voziloNaServisu;
	}
	public Date getDatumNaplate() {
		return datumNaplate;
	}
	public void setDatumNaplate(Date datumNaplate) {
		this.datumNaplate = datumNaplate;
	}
	public double getIznos() {
		return iznos;
	}
	public void setIznos(double iznos) {
		this.iznos = iznos;
	}
	public ZiroRacunPreduzecaDTO getZiroRacunPreduzeca() {
		return ziroRacunPreduzeca;
	}
	public void setZiroRacunPreduzeca(ZiroRacunPreduzecaDTO ziroRacunPreduzeca) {
		this.ziroRacunPreduzeca = ziroRacunPreduzeca;
	}
	public double getUkupnaCijenaDodatnihUsluga() {
		return ukupnaCijenaDodatnihUsluga;
	}
	public void setUkupnaCijenaDodatnihUsluga(double ukupnaCijenaDodatnihUsluga) {
		this.ukupnaCijenaDodatnihUsluga = ukupnaCijenaDodatnihUsluga;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public NaplataServisaDTO(int brojNaplateServisa, double popust, VoziloNaServisuDTO voziloNaServisu,
			Date datumNaplate, double iznos, ZiroRacunPreduzecaDTO ziroRacunPreduzeca,
			double ukupnaCijenaDodatnihUsluga, String status) {
		super();
		this.brojNaplateServisa = brojNaplateServisa;
		this.popust = popust;
		this.voziloNaServisu = voziloNaServisu;
		this.datumNaplate = datumNaplate;
		this.iznos = iznos;
		this.ziroRacunPreduzeca = ziroRacunPreduzeca;
		this.ukupnaCijenaDodatnihUsluga = ukupnaCijenaDodatnihUsluga;
		this.status = status;
	}
	public NaplataServisaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "NaplataServisaDTO [brojNaplateServisa=" + brojNaplateServisa + ", popust=" + popust
				+ ", voziloNaServisu=" + voziloNaServisu + ", datumNaplate=" + datumNaplate + ", iznos=" + iznos
				+ ", ziroRacunPreduzeca=" + ziroRacunPreduzeca + ", ukupnaCijenaDodatnihUsluga="
				+ ukupnaCijenaDodatnihUsluga + ", status=" + status + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + brojNaplateServisa;
		result = prime * result + ((datumNaplate == null) ? 0 : datumNaplate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(iznos);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(popust);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		temp = Double.doubleToLongBits(ukupnaCijenaDodatnihUsluga);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((voziloNaServisu == null) ? 0 : voziloNaServisu.hashCode());
		result = prime * result + ((ziroRacunPreduzeca == null) ? 0 : ziroRacunPreduzeca.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NaplataServisaDTO other = (NaplataServisaDTO) obj;
		if (brojNaplateServisa != other.brojNaplateServisa)
			return false;
		if (datumNaplate == null) {
			if (other.datumNaplate != null)
				return false;
		} else if (!datumNaplate.equals(other.datumNaplate))
			return false;
		if (Double.doubleToLongBits(iznos) != Double.doubleToLongBits(other.iznos))
			return false;
		if (Double.doubleToLongBits(popust) != Double.doubleToLongBits(other.popust))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (Double.doubleToLongBits(ukupnaCijenaDodatnihUsluga) != Double
				.doubleToLongBits(other.ukupnaCijenaDodatnihUsluga))
			return false;
		if (voziloNaServisu == null) {
			if (other.voziloNaServisu != null)
				return false;
		} else if (!voziloNaServisu.equals(other.voziloNaServisu))
			return false;
		if (ziroRacunPreduzeca == null) {
			if (other.ziroRacunPreduzeca != null)
				return false;
		} else if (!ziroRacunPreduzeca.equals(other.ziroRacunPreduzeca))
			return false;
		return true;
	}

	

}
