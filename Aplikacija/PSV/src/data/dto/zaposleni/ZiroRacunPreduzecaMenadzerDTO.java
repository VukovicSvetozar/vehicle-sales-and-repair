package data.dto.zaposleni;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ZiroRacunPreduzecaMenadzerDTO implements Serializable {

	private ZiroRacunPreduzecaDTO ziroRacunPreduzeca;
	private MenadzerDTO menader;

	public ZiroRacunPreduzecaMenadzerDTO(ZiroRacunPreduzecaDTO ziroRacunPreduzeca, MenadzerDTO menader) {
		super();
		this.ziroRacunPreduzeca = ziroRacunPreduzeca;
		this.menader = menader;
	}

	public ZiroRacunPreduzecaMenadzerDTO() {
		super();
	}

	public ZiroRacunPreduzecaDTO getZiroRacunPreduzeca() {
		return ziroRacunPreduzeca;
	}

	public void setZiroRacunPreduzeca(ZiroRacunPreduzecaDTO ziroRacunPreduzeca) {
		this.ziroRacunPreduzeca = ziroRacunPreduzeca;
	}

	public MenadzerDTO getMenader() {
		return menader;
	}

	public void setMenader(MenadzerDTO menader) {
		this.menader = menader;
	}

}
