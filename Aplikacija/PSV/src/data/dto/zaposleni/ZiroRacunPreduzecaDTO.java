package data.dto.zaposleni;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ZiroRacunPreduzecaDTO implements Serializable {

	private String brojZiroRacunaPreduzeca;
	private BankaDTO banka;

	public String getBrojZiroRacunaPreduzeca() {
		return brojZiroRacunaPreduzeca;
	}

	public void setBrojZiroRacunaPreduzeca(String brojZiroRacunaPreduzeca) {
		this.brojZiroRacunaPreduzeca = brojZiroRacunaPreduzeca;
	}

	public BankaDTO getBanka() {
		return banka;
	}

	public void setBanka(BankaDTO banka) {
		this.banka = banka;
	}

	public ZiroRacunPreduzecaDTO() {
		super();
	}

	public ZiroRacunPreduzecaDTO(String brojZiroRacunaPreduzeca, BankaDTO banka) {
		super();
		this.brojZiroRacunaPreduzeca = brojZiroRacunaPreduzeca;
		this.banka = banka;
	}

}
