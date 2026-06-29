package data.dao.zaposleni;

import data.dto.zaposleni.ZiroRacunPreduzecaMenadzerDTO;
import javafx.collections.ObservableList;

public interface ZiroRacunPreduzecaMenadzerDAO {

	public ZiroRacunPreduzecaMenadzerDTO ziroRacunPreduzecaMenadzer(String brojZiroRacuna, String jmb);

	public ObservableList<ZiroRacunPreduzecaMenadzerDTO> ziroRacunPreduzecaMenadzer();

	public boolean dodajZiroRacunPreduzecaMenadzer(ZiroRacunPreduzecaMenadzerDTO ziroRacunPreduzecaMenadzer);

	public boolean azurirajZiroRacunPreduzecaMenadzer(ZiroRacunPreduzecaMenadzerDTO ziroRacunPreduzecaMenadzer);

	public boolean obrisiZiroRacunPreduzecaMenadzer(String brojZiroRacuna, String jmb);

	public boolean obrisiZiroRacunPreduzecaMenadzer(String jmb);
	
}