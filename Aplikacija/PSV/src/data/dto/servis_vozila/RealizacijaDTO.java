package data.dto.servis_vozila;

import java.sql.Date;

import data.dto.zaposleni.MehanicarDTO;

public class RealizacijaDTO {
	  private RadniNalogDTO radniNalog;
	  private MehanicarDTO mehanicar;
	  private Date datumRealizacije;
	@Override
	public String toString() {
		return "RealizacijaDTO [radniNalog=" + radniNalog + ", mehanicar=" + mehanicar + ", datumRealizacije="
				+ datumRealizacije + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datumRealizacije == null) ? 0 : datumRealizacije.hashCode());
		result = prime * result + ((mehanicar == null) ? 0 : mehanicar.hashCode());
		result = prime * result + ((radniNalog == null) ? 0 : radniNalog.hashCode());
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
		RealizacijaDTO other = (RealizacijaDTO) obj;
		if (datumRealizacije == null) {
			if (other.datumRealizacije != null)
				return false;
		} else if (!datumRealizacije.equals(other.datumRealizacije))
			return false;
		if (mehanicar == null) {
			if (other.mehanicar != null)
				return false;
		} else if (!mehanicar.equals(other.mehanicar))
			return false;
		if (radniNalog == null) {
			if (other.radniNalog != null)
				return false;
		} else if (!radniNalog.equals(other.radniNalog))
			return false;
		return true;
	}
	public RealizacijaDTO(RadniNalogDTO radniNalog, MehanicarDTO mehanicar, Date datumRealizacije) {
		super();
		this.radniNalog = radniNalog;
		this.mehanicar = mehanicar;
		this.datumRealizacije = datumRealizacije;
	}
	public RealizacijaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RadniNalogDTO getRadniNalog() {
		return radniNalog;
	}
	public void setRadniNalog(RadniNalogDTO radniNalog) {
		this.radniNalog = radniNalog;
	}
	public MehanicarDTO getMehanicar() {
		return mehanicar;
	}
	public void setMehanicar(MehanicarDTO mehanicar) {
		this.mehanicar = mehanicar;
	}
	public Date getDatumRealizacije() {
		return datumRealizacije;
	}
	public void setDatumRealizacije(Date datumRealizacije) {
		this.datumRealizacije = datumRealizacije;
	}
	  
	  
	  
}
