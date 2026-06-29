package data.dto.prodaja_vozila;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class VozilaDTO implements Serializable {

	private int idVozila;
	private String tipVozila;
	private String proizvodjac;
	private String model;
	private int kilometraza;
	private int godinaProizvodnje;
	private String boja;
	private String vrstaGoriva;
	private String brojRegistracije;
	private Date datumRegistracije;
	private String fotografija;

	public VozilaDTO(int idVozila, String tipVozila, String proizvodjac, String model, int kilometraza,
			int godinaProizvodnje, String boja, String vrstaGoriva, String brojRegistracije, Date datumRegistracije,
			String fotografija) {
		super();
		this.idVozila = idVozila;
		this.tipVozila = tipVozila;
		this.proizvodjac = proizvodjac;
		this.model = model;
		this.kilometraza = kilometraza;
		this.godinaProizvodnje = godinaProizvodnje;
		this.boja = boja;
		this.vrstaGoriva = vrstaGoriva;
		this.brojRegistracije = brojRegistracije;
		this.datumRegistracije = datumRegistracije;
		this.fotografija = fotografija;
	}

	public VozilaDTO() {
		super();
	}

	public int getIdVozila() {
		return idVozila;
	}

	public void setIdVozila(int idVozila) {
		this.idVozila = idVozila;
	}

	public String getTipVozila() {
		return tipVozila;
	}

	public void setTipVozila(String tipVozila) {
		this.tipVozila = tipVozila;
	}

	public String getProizvodjac() {
		return proizvodjac;
	}

	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getKilometraza() {
		return kilometraza;
	}

	public void setKilometraza(int kilometraza) {
		this.kilometraza = kilometraza;
	}

	public int getGodinaProizvodnje() {
		return godinaProizvodnje;
	}

	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}

	public String getBoja() {
		return boja;
	}

	public void setBoja(String boja) {
		this.boja = boja;
	}

	public String getVrstaGoriva() {
		return vrstaGoriva;
	}

	public void setVrstaGoriva(String vrstaGoriva) {
		this.vrstaGoriva = vrstaGoriva;
	}

	public String getBrojRegistracije() {
		return brojRegistracije;
	}

	public void setBrojRegistracije(String brojRegistracije) {
		this.brojRegistracije = brojRegistracije;
	}

	public Date getDatumRegistracije() {
		return datumRegistracije;
	}

	public void setDatumRegistracije(Date datumRegistracije) {
		this.datumRegistracije = datumRegistracije;
	}

	public String getFotografija() {
		return fotografija;
	}

	public void setFotografija(String fotografija) {
		this.fotografija = fotografija;
	}

	@Override
	public String toString() {
		return "VozilaDTO [idVozila=" + idVozila + ", tipVozila=" + tipVozila + ", proizvodjac=" + proizvodjac
				+ ", model=" + model + ", kilometraza=" + kilometraza + ", godinaProizvodnje=" + godinaProizvodnje
				+ ", boja=" + boja + ", vrstaGoriva=" + vrstaGoriva + ", brojRegistracije=" + brojRegistracije
				+ ", datumRegistracije=" + datumRegistracije + ", fotografija=" + fotografija + "]";
	}

}
