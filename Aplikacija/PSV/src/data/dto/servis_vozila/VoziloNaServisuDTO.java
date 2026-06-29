package data.dto.servis_vozila;

import java.io.Serializable;
import java.sql.Date;

import data.dto.prodaja_vozila.VozilaDTO;

@SuppressWarnings("serial")
public class VoziloNaServisuDTO implements Serializable {

	private int idVozilaNaServisu;
	private VozilaDTO vozila;
	private ServisnaKnjigaVozilaDTO servisnaKnjigaVozila;
	private Date datumPrijemaVozila;
	private Double procjenaTroSkova;
	private Date procjenaZavrsetkaRadova;

	public VoziloNaServisuDTO() {
		super();
	}

	public VoziloNaServisuDTO(int idVozilaNaServisu, VozilaDTO vozila, ServisnaKnjigaVozilaDTO servisnaKnjigaVozila,
			Date datumPrijemaVozila, Double procjenaTroSkova, Date procjenaZavrsetkaRadova) {
		super();
		this.idVozilaNaServisu = idVozilaNaServisu;
		this.vozila = vozila;
		this.servisnaKnjigaVozila = servisnaKnjigaVozila;
		this.datumPrijemaVozila = datumPrijemaVozila;
		this.procjenaTroSkova = procjenaTroSkova;
		this.procjenaZavrsetkaRadova = procjenaZavrsetkaRadova;
	}

	public int getIdVozilaNaServisu() {
		return idVozilaNaServisu;
	}

	public void setIdVozilaNaServisu(int idVozilaNaServisu) {
		this.idVozilaNaServisu = idVozilaNaServisu;
	}

	public VozilaDTO getVozila() {
		return vozila;
	}

	public void setVozila(VozilaDTO vozila) {
		this.vozila = vozila;
	}

	public ServisnaKnjigaVozilaDTO getServisnaKnjigaVozila() {
		return servisnaKnjigaVozila;
	}

	public void setServisnaKnjigaVozila(ServisnaKnjigaVozilaDTO servisnaKnjigaVozila) {
		this.servisnaKnjigaVozila = servisnaKnjigaVozila;
	}

	public Date getDatumPrijemaVozila() {
		return datumPrijemaVozila;
	}

	public void setDatumPrijemaVozila(Date datumPrijemaVozila) {
		this.datumPrijemaVozila = datumPrijemaVozila;
	}

	public Double getProcjenaTroSkova() {
		return procjenaTroSkova;
	}

	public void setProcjenaTroSkova(Double procjenaTroSkova) {
		this.procjenaTroSkova = procjenaTroSkova;
	}

	public Date getProcjenaZavrsetkaRadova() {
		return procjenaZavrsetkaRadova;
	}

	public void setProcjenaZavrsetkaRadova(Date procjenaZavrsetkaRadova) {
		this.procjenaZavrsetkaRadova = procjenaZavrsetkaRadova;
	}

}
