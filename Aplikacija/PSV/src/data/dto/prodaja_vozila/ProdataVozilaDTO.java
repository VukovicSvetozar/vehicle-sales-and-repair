package data.dto.prodaja_vozila;

public class ProdataVozilaDTO {

	private VozilaDTO vozila;
	private double cijenaProdaje;
	private Integer periodGarancije;

	public ProdataVozilaDTO(VozilaDTO vozila, double cijenaProdaje, Integer periodGarancije) {
		super();
		this.vozila = vozila;
		this.cijenaProdaje = cijenaProdaje;
		this.periodGarancije = periodGarancije;
	}

	public ProdataVozilaDTO() {
		super();
	}

	public VozilaDTO getVozila() {
		return vozila;
	}

	public void setVozila(VozilaDTO vozila) {
		this.vozila = vozila;
	}

	public double getCijenaProdaje() {
		return cijenaProdaje;
	}

	public void setCijenaProdaje(double cijenaProdaje) {
		this.cijenaProdaje = cijenaProdaje;
	}

	public Integer getPeriodGarancije() {
		return periodGarancije;
	}

	public void setPeriodGarancije(Integer periodGarancije) {
		this.periodGarancije = periodGarancije;
	}

	@Override
	public String toString() {
		return "ProdataVozilaDTO [vozila=" + vozila + ", cijenaProdaje=" + cijenaProdaje + ", periodGarancije="
				+ periodGarancije + "]";
	}

}
