package data.dto.zaposleni;

public class KvalifikacijaDTO {

	private ServisniRadoviDTO servisniRadovi;
	private MehanicarDTO mehanicar;
	private String opis;

	public ServisniRadoviDTO getServisniRadovi() {
		return servisniRadovi;
	}

	public void setServisniRadovi(ServisniRadoviDTO servisniRadovi) {
		this.servisniRadovi = servisniRadovi;
	}

	public MehanicarDTO getMehanicar() {
		return mehanicar;
	}

	public void setMehanicar(MehanicarDTO mehanicar) {
		this.mehanicar = mehanicar;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public KvalifikacijaDTO(ServisniRadoviDTO servisniRadovi, MehanicarDTO mehanicar, String opis) {
		super();
		this.servisniRadovi = servisniRadovi;
		this.mehanicar = mehanicar;
		this.opis = opis;
	}

	public KvalifikacijaDTO() {
		super();
	}

}
