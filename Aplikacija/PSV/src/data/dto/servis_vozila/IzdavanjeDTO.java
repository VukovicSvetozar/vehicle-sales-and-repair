package data.dto.servis_vozila;

import data.dto.zaposleni.RukovodilacServisaDTO;

public class IzdavanjeDTO {
	
	private RukovodilacServisaDTO rukovodilacServisa;
	private DijeloviIMaterijaliDTO dijloviIMaterijali;
	private UslugaDTO usluga;
	private int kolicinaUtrosenogDijela;
	public RukovodilacServisaDTO getRukovodilacServisa() {
		return rukovodilacServisa;
	}
	public void setRukovodilacServisa(RukovodilacServisaDTO rukovodilacServisa) {
		this.rukovodilacServisa = rukovodilacServisa;
	}
	public DijeloviIMaterijaliDTO getDijloviIMaterijali() {
		return dijloviIMaterijali;
	}
	public void setDijloviIMaterijali(DijeloviIMaterijaliDTO dijloviIMaterijali) {
		this.dijloviIMaterijali = dijloviIMaterijali;
	}
	public UslugaDTO getUsluga() {
		return usluga;
	}
	public void setUsluga(UslugaDTO usluga) {
		this.usluga = usluga;
	}
	public int getKolicinaUtrosenogDijela() {
		return kolicinaUtrosenogDijela;
	}
	public void setKolicinaUtrosenogDijela(int kolicinaUtrosenogDijela) {
		this.kolicinaUtrosenogDijela = kolicinaUtrosenogDijela;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dijloviIMaterijali == null) ? 0 : dijloviIMaterijali.hashCode());
		result = prime * result + kolicinaUtrosenogDijela;
		result = prime * result + ((rukovodilacServisa == null) ? 0 : rukovodilacServisa.hashCode());
		result = prime * result + ((usluga == null) ? 0 : usluga.hashCode());
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
		IzdavanjeDTO other = (IzdavanjeDTO) obj;
		if (dijloviIMaterijali == null) {
			if (other.dijloviIMaterijali != null)
				return false;
		} else if (!dijloviIMaterijali.equals(other.dijloviIMaterijali))
			return false;
		if (kolicinaUtrosenogDijela != other.kolicinaUtrosenogDijela)
			return false;
		if (rukovodilacServisa == null) {
			if (other.rukovodilacServisa != null)
				return false;
		} else if (!rukovodilacServisa.equals(other.rukovodilacServisa))
			return false;
		if (usluga == null) {
			if (other.usluga != null)
				return false;
		} else if (!usluga.equals(other.usluga))
			return false;
		return true;
	}
	public IzdavanjeDTO(RukovodilacServisaDTO rukovodilacServisa, DijeloviIMaterijaliDTO dijloviIMaterijali,
			UslugaDTO usluga, int kolicinaUtrosenogDijela) {
		super();
		this.rukovodilacServisa = rukovodilacServisa;
		this.dijloviIMaterijali = dijloviIMaterijali;
		this.usluga = usluga;
		this.kolicinaUtrosenogDijela = kolicinaUtrosenogDijela;
	}
	public IzdavanjeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "IzdavanjeDTO [rukovodilacServisa=" + rukovodilacServisa + ", dijloviIMaterijali=" + dijloviIMaterijali
				+ ", usluga=" + usluga + ", kolicinaUtrosenogDijela=" + kolicinaUtrosenogDijela + "]";
	}

	
	
	
}
