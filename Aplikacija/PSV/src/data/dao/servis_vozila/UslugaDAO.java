package data.dao.servis_vozila;

import data.dto.servis_vozila.UslugaDTO;
import javafx.collections.ObservableList;

public interface UslugaDAO {
	
	public ObservableList<UslugaDTO> usluga(String tipUsluge);
	
	public int dodajUsluga(UslugaDTO usluga);

	public boolean azurirajUsluga(UslugaDTO usluga);

	public boolean obrisiUsluga(String tipUsluge);
}
