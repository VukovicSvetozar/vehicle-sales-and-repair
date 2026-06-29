package data.dao.zaposleni;

import data.dto.zaposleni.KvalifikacijaDTO;
import javafx.collections.ObservableList;

public interface KvalifikacijaDAO {

	public KvalifikacijaDTO kvalifikacija(String vrstaServisnihRadova, String jmb);

	public ObservableList<KvalifikacijaDTO> kvalifikacija();

	public boolean dodajKvalifikacija(KvalifikacijaDTO kvalifikacija);

	public boolean azurirajKvalifikacija(KvalifikacijaDTO kvalifikacija);
	
	public boolean obrisiKvalifikacija(String jmb);
	
	public boolean obrisiKvalifikacija(String vrstaServisnihRadova, String jmb);
	
}
