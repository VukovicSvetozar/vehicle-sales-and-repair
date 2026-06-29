package data.dto.prodaja_vozila;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ZiroRacunKlijentaDTO implements Serializable {
	
	private KlijentDTO klijent;
	private String brojZiroRacuna;

	public ZiroRacunKlijentaDTO() {
		super();
	}

	public ZiroRacunKlijentaDTO(KlijentDTO klijent, String brojZiroRacuna) {
		super();
		this.klijent = klijent;
		this.brojZiroRacuna = brojZiroRacuna;
	}

	public KlijentDTO getKlijent() {
		return klijent;
	}

	public void setKlijent(KlijentDTO klijent) {
		this.klijent = klijent;
	}

	public String getBrojZiroRacuna() {
		return brojZiroRacuna;
	}

	public void setBrojZiroRacuna(String brojZiroRacuna) {
		this.brojZiroRacuna = brojZiroRacuna;
	}

	@Override
	public String toString() {
		return "ZiroRacunKlijentaDTO [klijent=" + klijent + ", brojZiroRacuna=" + brojZiroRacuna + "]";
	}

}
