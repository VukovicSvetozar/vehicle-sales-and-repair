package data.dto.servis_vozila;

public class DodatneUslugeDTO {

	 private String tipUsluge;
	 private int cijenaDodatneUsluge;
	public String getTipUsluge() {
		return tipUsluge;
	}
	public void setTipUsluge(String tipUsluge) {
		this.tipUsluge = tipUsluge;
	}
	public int getCijenaDodatneUsluge() {
		return cijenaDodatneUsluge;
	}
	public void setCijenaDodatneUsluge(int cijenaDodatneUsluge) {
		this.cijenaDodatneUsluge = cijenaDodatneUsluge;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cijenaDodatneUsluge;
		result = prime * result + ((tipUsluge == null) ? 0 : tipUsluge.hashCode());
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
		DodatneUslugeDTO other = (DodatneUslugeDTO) obj;
		if (cijenaDodatneUsluge != other.cijenaDodatneUsluge)
			return false;
		if (tipUsluge == null) {
			if (other.tipUsluge != null)
				return false;
		} else if (!tipUsluge.equals(other.tipUsluge))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DodatneUslugeDTO [tipUsluge=" + tipUsluge + ", cijenaDodatneUsluge=" + cijenaDodatneUsluge + "]";
	}
	public DodatneUslugeDTO(String tipUsluge, int cijenaDodatneUsluge) {
		super();
		this.tipUsluge = tipUsluge;
		this.cijenaDodatneUsluge = cijenaDodatneUsluge;
	}
	public DodatneUslugeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
	  
}
