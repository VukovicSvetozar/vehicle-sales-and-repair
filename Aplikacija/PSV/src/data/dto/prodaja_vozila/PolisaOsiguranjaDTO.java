package data.dto.prodaja_vozila;

public class PolisaOsiguranjaDTO {

	private int idPolisa;
	private double odobrenIznos;
	private int periodReklamacije;
	private OsiguravajuceDrustvoDTO osiguravajuceDrustvo;
	private ProdajaDTO prodaja;

	public PolisaOsiguranjaDTO(int idPolisa, double odobrenIznos, int periodReklamacije,
			OsiguravajuceDrustvoDTO osiguravajuceDrustvo, ProdajaDTO prodaja) {
		super();
		this.idPolisa = idPolisa;
		this.odobrenIznos = odobrenIznos;
		this.periodReklamacije = periodReklamacije;
		this.osiguravajuceDrustvo = osiguravajuceDrustvo;
		this.prodaja = prodaja;
	}

	public PolisaOsiguranjaDTO() {
		super();
	}

	public int getIdPolisa() {
		return idPolisa;
	}

	public void setIdPolisa(int idPolisa) {
		this.idPolisa = idPolisa;
	}

	public double getOdobrenIznos() {
		return odobrenIznos;
	}

	public void setOdobrenIznos(double odobrenIznos) {
		this.odobrenIznos = odobrenIznos;
	}

	public int getPeriodReklamacije() {
		return periodReklamacije;
	}

	public void setPeriodReklamacije(int periodReklamacije) {
		this.periodReklamacije = periodReklamacije;
	}

	public OsiguravajuceDrustvoDTO getOsiguravajuceDrustvo() {
		return osiguravajuceDrustvo;
	}

	public void setOsiguravajuceDrustvo(OsiguravajuceDrustvoDTO osiguravajuceDrustvo) {
		this.osiguravajuceDrustvo = osiguravajuceDrustvo;
	}

	public ProdajaDTO getProdaja() {
		return prodaja;
	}

	public void setProdaja(ProdajaDTO prodaja) {
		this.prodaja = prodaja;
	}

	@Override
	public String toString() {
		return "PolisaOsiguranjaDTO [idPolisa=" + idPolisa + ", odobrenIznos=" + odobrenIznos + ", periodReklamacije="
				+ periodReklamacije + ", osiguravajuceDrustvo=" + osiguravajuceDrustvo + ", prodaja=" + prodaja + "]";
	}

}
