package data.dto.servis_vozila;

import data.dto.zaposleni.ServisniRadoviDTO;

public class RadniNalogDTO {

	private int idRadniNalog;
	private VoziloNaServisuDTO voziloNaServisu;
	private ServisniRadoviDTO servisniRadovi;
	private String termin;

	public RadniNalogDTO() {
		super();
	}

	public RadniNalogDTO(int idRadniNalog, VoziloNaServisuDTO voziloNaServisu, ServisniRadoviDTO servisniRadovi,
			String termin) {
		super();
		this.idRadniNalog = idRadniNalog;
		this.voziloNaServisu = voziloNaServisu;
		this.servisniRadovi = servisniRadovi;
		this.termin = termin;
	}

	@Override
	public String toString() {
		return "RadniNalogDTO [idRadniNalog=" + idRadniNalog + ", voziloNaServisu=" + voziloNaServisu
				+ ", servisniRadovi=" + servisniRadovi + ", termin=" + termin + "]";
	}

	public int getIdRadniNalog() {
		return idRadniNalog;
	}

	public void setIdRadniNalog(int idRadniNalog) {
		this.idRadniNalog = idRadniNalog;
	}

	public VoziloNaServisuDTO getVoziloNaServisu() {
		return voziloNaServisu;
	}

	public void setVoziloNaServisu(VoziloNaServisuDTO voziloNaServisu) {
		this.voziloNaServisu = voziloNaServisu;
	}

	public ServisniRadoviDTO getServisniRadovi() {
		return servisniRadovi;
	}

	public void setServisniRadovi(ServisniRadoviDTO servisniRadovi) {
		this.servisniRadovi = servisniRadovi;
	}

	public String getTermin() {
		return termin;
	}

	public void setTermin(String termin) {
		this.termin = termin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idRadniNalog;
		result = prime * result + ((servisniRadovi == null) ? 0 : servisniRadovi.hashCode());
		result = prime * result + ((termin == null) ? 0 : termin.hashCode());
		result = prime * result + ((voziloNaServisu == null) ? 0 : voziloNaServisu.hashCode());
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
		RadniNalogDTO other = (RadniNalogDTO) obj;
		if (idRadniNalog != other.idRadniNalog)
			return false;
		if (servisniRadovi == null) {
			if (other.servisniRadovi != null)
				return false;
		} else if (!servisniRadovi.equals(other.servisniRadovi))
			return false;
		if (termin == null) {
			if (other.termin != null)
				return false;
		} else if (!termin.equals(other.termin))
			return false;
		if (voziloNaServisu == null) {
			if (other.voziloNaServisu != null)
				return false;
		} else if (!voziloNaServisu.equals(other.voziloNaServisu))
			return false;
		return true;
	}

}
