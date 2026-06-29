package data.dto.zaposleni;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MehanicarDTO implements Serializable {

	private ZaposleniDTO zaposleni;
	private String brojSmjene;
	private int trenutniBrojAktivnosti;

	public MehanicarDTO() {
		super();
	}

	public MehanicarDTO(ZaposleniDTO zaposleni) {
		super();
		this.zaposleni = zaposleni;
	}

	public MehanicarDTO(ZaposleniDTO zaposleni, String brojSmjene, int trenutniBrojAktivnosti) {
		super();
		this.zaposleni = zaposleni;
		this.brojSmjene = brojSmjene;
		this.trenutniBrojAktivnosti = trenutniBrojAktivnosti;
	}

	public ZaposleniDTO getZaposleni() {
		return zaposleni;
	}

	public void setZaposleni(ZaposleniDTO zaposleni) {
		this.zaposleni = zaposleni;
	}

	public String getBrojSmjene() {
		return brojSmjene;
	}

	public void setBrojSmjene(String brojSmjene) {
		this.brojSmjene = brojSmjene;
	}

	public int getTrenutniBrojAktivnosti() {
		return trenutniBrojAktivnosti;
	}

	public void setTrenutniBrojAktivnosti(int trenutniBrojAktivnosti) {
		this.trenutniBrojAktivnosti = trenutniBrojAktivnosti;
	}

}
