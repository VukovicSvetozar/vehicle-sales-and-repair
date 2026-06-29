package data.dto.prodaja_vozila;

public class KupacDTO {

	private KlijentDTO klijent;

	public KupacDTO(KlijentDTO klijent) {
		super();
		this.klijent = klijent;
	}

	public KupacDTO() {
		super();
	}

	public KlijentDTO getKlijent() {
		return klijent;
	}

	public void setKlijent(KlijentDTO klijent) {
		this.klijent = klijent;
	}

	@Override
	public String toString() {
		return "KupacDTO [klijent=" + klijent + "]";
	}

}
