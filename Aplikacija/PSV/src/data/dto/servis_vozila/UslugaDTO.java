package data.dto.servis_vozila;

public class UslugaDTO {

	private int brojUsluge;
	private RadniNalogDTO radniNalog;
	private NaplataServisaDTO naplataServisa;
	private double cijenaUsluge;
	private double brojUtrosenihSati;
	private double koeficijentRadova;
	private double cijenaDijelova;

	public int getBrojUsluge() {
		return brojUsluge;
	}

	public void setBrojUsluge(int brojUsluge) {
		this.brojUsluge = brojUsluge;
	}

	public RadniNalogDTO getRadniNalog() {
		return radniNalog;
	}

	public void setRadniNalog(RadniNalogDTO radniNalog) {
		this.radniNalog = radniNalog;
	}

	public NaplataServisaDTO getNaplataServisa() {
		return naplataServisa;
	}

	public void setNaplataServisa(NaplataServisaDTO naplataServisa) {
		this.naplataServisa = naplataServisa;
	}

	public double getCijenaUsluge() {
		return cijenaUsluge;
	}

	public void setCijenaUsluge(double cijenaUsluge) {
		this.cijenaUsluge = cijenaUsluge;
	}

	public double getBrojUtrosenihSati() {
		return brojUtrosenihSati;
	}

	public void setBrojUtrosenihSati(double brojUtrosenihSati) {
		this.brojUtrosenihSati = brojUtrosenihSati;
	}

	public double getKoeficijentRadova() {
		return koeficijentRadova;
	}

	public void setKoeficijentRadova(double koeficijentRadova) {
		this.koeficijentRadova = koeficijentRadova;
	}

	public double getCijenaDijelova() {
		return cijenaDijelova;
	}

	public void setCijenaDijelova(double cijenaDijelova) {
		this.cijenaDijelova = cijenaDijelova;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + brojUsluge;
		long temp;
		temp = Double.doubleToLongBits(brojUtrosenihSati);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(cijenaDijelova);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(cijenaUsluge);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(koeficijentRadova);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((naplataServisa == null) ? 0 : naplataServisa.hashCode());
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
		UslugaDTO other = (UslugaDTO) obj;
		if (brojUsluge != other.brojUsluge)
			return false;
		if (Double.doubleToLongBits(brojUtrosenihSati) != Double.doubleToLongBits(other.brojUtrosenihSati))
			return false;
		if (Double.doubleToLongBits(cijenaDijelova) != Double.doubleToLongBits(other.cijenaDijelova))
			return false;
		if (Double.doubleToLongBits(cijenaUsluge) != Double.doubleToLongBits(other.cijenaUsluge))
			return false;
		if (Double.doubleToLongBits(koeficijentRadova) != Double.doubleToLongBits(other.koeficijentRadova))
			return false;
		if (naplataServisa == null) {
			if (other.naplataServisa != null)
				return false;
		} else if (!naplataServisa.equals(other.naplataServisa))
			return false;
		if (radniNalog == null) {
			if (other.radniNalog != null)
				return false;
		} else if (!radniNalog.equals(other.radniNalog))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UslugaDTO [brojUsluge=" + brojUsluge + ", radniNalog=" + radniNalog + ", naplataServisa="
				+ naplataServisa + ", cijenaUsluge=" + cijenaUsluge + ", brojUtrosenihSati=" + brojUtrosenihSati
				+ ", koeficijentRadova=" + koeficijentRadova + ", cijenaDijelova=" + cijenaDijelova + "]";
	}

	public UslugaDTO(int brojUsluge, RadniNalogDTO radniNalog, NaplataServisaDTO naplataServisa, double cijenaUsluge,
			double brojUtrosenihSati, double koeficijentRadova, double cijenaDijelova) {
		super();
		this.brojUsluge = brojUsluge;
		this.radniNalog = radniNalog;
		this.naplataServisa = naplataServisa;
		this.cijenaUsluge = cijenaUsluge;
		this.brojUtrosenihSati = brojUtrosenihSati;
		this.koeficijentRadova = koeficijentRadova;
		this.cijenaDijelova = cijenaDijelova;
	}

	public UslugaDTO() {
		super();
	}

}
