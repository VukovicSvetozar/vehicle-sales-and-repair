package data.dto.servis_vozila;

public class DijeloviIMaterijaliDTO {
	
	private String nazivDijela;
	private int cijena;
	private String tip;
	private String proizvodjac;
	private int kolicinaNaSkladistu;
	
	public DijeloviIMaterijaliDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DijeloviIMaterijaliDTO(String nazivDijela, int cijena, String tip, String proizvodjac,
			int kolicinaNaSkladistu) {
		super();
		this.nazivDijela = nazivDijela;
		this.cijena = cijena;
		this.tip = tip;
		this.proizvodjac = proizvodjac;
		this.kolicinaNaSkladistu = kolicinaNaSkladistu;
	}

	@Override
	public String toString() {
		return "DijeloviIMaterijaliDTO [nazivDijela=" + nazivDijela + ", cijena=" + cijena + ", tip=" + tip
				+ ", proizvodjac=" + proizvodjac + ", kolicinaNaSkladistu=" + kolicinaNaSkladistu + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cijena;
		result = prime * result + kolicinaNaSkladistu;
		result = prime * result + ((nazivDijela == null) ? 0 : nazivDijela.hashCode());
		result = prime * result + ((proizvodjac == null) ? 0 : proizvodjac.hashCode());
		result = prime * result + ((tip == null) ? 0 : tip.hashCode());
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
		DijeloviIMaterijaliDTO other = (DijeloviIMaterijaliDTO) obj;
		if (cijena != other.cijena)
			return false;
		if (kolicinaNaSkladistu != other.kolicinaNaSkladistu)
			return false;
		if (nazivDijela == null) {
			if (other.nazivDijela != null)
				return false;
		} else if (!nazivDijela.equals(other.nazivDijela))
			return false;
		if (proizvodjac == null) {
			if (other.proizvodjac != null)
				return false;
		} else if (!proizvodjac.equals(other.proizvodjac))
			return false;
		if (tip == null) {
			if (other.tip != null)
				return false;
		} else if (!tip.equals(other.tip))
			return false;
		return true;
	}

	public String getNazivDijela() {
		return nazivDijela;
	}

	public void setNazivDijela(String nazivDijela) {
		this.nazivDijela = nazivDijela;
	}

	public int getCijena() {
		return cijena;
	}

	public void setCijena(int cijena) {
		this.cijena = cijena;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getProizvodjac() {
		return proizvodjac;
	}

	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
	}

	public int getKolicinaNaSkladistu() {
		return kolicinaNaSkladistu;
	}

	public void setKolicinaNaSkladistu(int kolicinaNaSkladistu) {
		this.kolicinaNaSkladistu = kolicinaNaSkladistu;
	}
	
	
	
}
