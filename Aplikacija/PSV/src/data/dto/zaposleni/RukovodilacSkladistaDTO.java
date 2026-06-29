package data.dto.zaposleni;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RukovodilacSkladistaDTO implements Serializable {

	private ZaposleniDTO zaposleni;
	private String licniBroj;

	public ZaposleniDTO getZaposleni() {
		return zaposleni;
	}

	public void setZaposleni(ZaposleniDTO zaposleni) {
		this.zaposleni = zaposleni;
	}

	public String getLicniBroj() {
		return licniBroj;
	}

	public void setLicniBroj(String licniBroj) {
		this.licniBroj = licniBroj;
	}

	public RukovodilacSkladistaDTO() {
		super();
	}

	public RukovodilacSkladistaDTO(ZaposleniDTO zaposleni, String licniBroj) {
		super();
		this.zaposleni = zaposleni;
		this.licniBroj = licniBroj;
	}

}
