package data.dto.servis_vozila;

import data.dto.prodaja_vozila.KlijentDTO;

public class DobavljacDTO {
	 
	private KlijentDTO klijent;
	private String internetStranica;
	public KlijentDTO getKlijent() {
		return klijent;
	}
	public void setKlijent(KlijentDTO klijent) {
		this.klijent = klijent;
	}
	public String getInternetStranica() {
		return internetStranica;
	}
	public void setInternetStranica(String internetStranica) {
		this.internetStranica = internetStranica;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((internetStranica == null) ? 0 : internetStranica.hashCode());
		result = prime * result + ((klijent == null) ? 0 : klijent.hashCode());
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
		DobavljacDTO other = (DobavljacDTO) obj;
		if (internetStranica == null) {
			if (other.internetStranica != null)
				return false;
		} else if (!internetStranica.equals(other.internetStranica))
			return false;
		if (klijent == null) {
			if (other.klijent != null)
				return false;
		} else if (!klijent.equals(other.klijent))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DobavljacDTO [klijent=" + klijent + ", internetStranica=" + internetStranica + "]";
	}
	public DobavljacDTO(KlijentDTO klijent, String internetStranica) {
		super();
		this.klijent = klijent;
		this.internetStranica = internetStranica;
	}
	public DobavljacDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	  
}
