package data.dto.servis_vozila;

import java.io.Serializable;
import java.sql.Date;
import data.dto.zaposleni.RukovodilacServisaDTO;

@SuppressWarnings("serial")
public class ZahtjevDTO implements Serializable {

	private int brojZahtjeva;
	private KorisniciServisaDTO korisnikServisa;
	private Date datumZahtjeva;
	private Date krajnjiRok;
	private RukovodilacServisaDTO rukovodilacServisa;

	public ZahtjevDTO() {
		super();
	}

	public ZahtjevDTO(int brojZahtjeva, KorisniciServisaDTO korisnikServisa, Date datumZahtjeva, Date krajnjiRok,
			RukovodilacServisaDTO rukovodilacServisa) {
		super();
		this.brojZahtjeva = brojZahtjeva;
		this.korisnikServisa = korisnikServisa;
		this.datumZahtjeva = datumZahtjeva;
		this.krajnjiRok = krajnjiRok;
		this.rukovodilacServisa = rukovodilacServisa;
	}

	public int getBrojZahtjeva() {
		return brojZahtjeva;
	}

	public void setBrojZahtjeva(int brojZahtjeva) {
		this.brojZahtjeva = brojZahtjeva;
	}

	public KorisniciServisaDTO getKorisnikServisa() {
		return korisnikServisa;
	}

	public void setKorisnikServisa(KorisniciServisaDTO korisnikServisa) {
		this.korisnikServisa = korisnikServisa;
	}

	public Date getDatumZahtjeva() {
		return datumZahtjeva;
	}

	public void setDatumZahtjeva(Date datumZahtjeva) {
		this.datumZahtjeva = datumZahtjeva;
	}

	public Date getKrajnjiRok() {
		return krajnjiRok;
	}

	public void setKrajnjiRok(Date krajnjiRok) {
		this.krajnjiRok = krajnjiRok;
	}

	public RukovodilacServisaDTO getRukovodilacServisa() {
		return rukovodilacServisa;
	}

	public void setRukovodilacServisa(RukovodilacServisaDTO rukovodilacServisa) {
		this.rukovodilacServisa = rukovodilacServisa;
	}

}
