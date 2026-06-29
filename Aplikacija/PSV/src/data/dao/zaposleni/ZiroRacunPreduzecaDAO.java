package data.dao.zaposleni;

import data.dto.zaposleni.ZiroRacunPreduzecaDTO;
import javafx.collections.ObservableList;

public interface ZiroRacunPreduzecaDAO {

	public ZiroRacunPreduzecaDTO ziroRacunPreduzeca(String brojZiroRacuna);

	public ObservableList<ZiroRacunPreduzecaDTO> ziroRacunPreduzeca();

	public boolean dodajZiroRacunPreduzeca(ZiroRacunPreduzecaDTO ziroRacunPreduzeca);

	public boolean azurirajZiroRacunPreduzeca(ZiroRacunPreduzecaDTO ziroRacunPreduzeca);

	public boolean obrisiZiroRacunPreduzeca(String brojZiroRacuna);

}