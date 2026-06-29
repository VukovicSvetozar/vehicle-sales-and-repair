package data.dto.prodaja_vozila;

import java.sql.Date;

public class NabavkaVozilaDTO {

	private VoziloUVlasnistvuDTO voziloUVlasnistvu;
	private Date datumNabavke;
	private double cijenaNabavke;
	private DistributerVozilaDTO distributer;

	public NabavkaVozilaDTO() {
		super();
	}

	public NabavkaVozilaDTO(VoziloUVlasnistvuDTO voziloUVlasnistvu, Date datumNabavke, double cijenaNabavke,
			DistributerVozilaDTO distributer) {
		super();
		this.voziloUVlasnistvu = voziloUVlasnistvu;
		this.datumNabavke = datumNabavke;
		this.cijenaNabavke = cijenaNabavke;
		this.distributer = distributer;
	}

	public VoziloUVlasnistvuDTO getVoziloUVlasnistvu() {
		return voziloUVlasnistvu;
	}

	public void setVoziloUVlasnistvu(VoziloUVlasnistvuDTO voziloUVlasnistvu) {
		this.voziloUVlasnistvu = voziloUVlasnistvu;
	}

	public Date getDatumNabavke() {
		return datumNabavke;
	}

	public void setDatumNabavke(Date datumNabavke) {
		this.datumNabavke = datumNabavke;
	}

	public double getCijenaNabavke() {
		return cijenaNabavke;
	}

	public void setCijenaNabavke(double cijenaNabavke) {
		this.cijenaNabavke = cijenaNabavke;
	}

	public DistributerVozilaDTO getDistributer() {
		return distributer;
	}

	public void setDistributer(DistributerVozilaDTO distributer) {
		this.distributer = distributer;
	}

}
