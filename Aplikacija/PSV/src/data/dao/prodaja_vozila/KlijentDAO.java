package data.dao.prodaja_vozila;

import data.dto.prodaja_vozila.KlijentDTO;
import javafx.collections.ObservableList;

public interface KlijentDAO {

	public KlijentDTO klijent(int idKlijenta);
	
	public ObservableList<KlijentDTO> klijent();
	
	public int dodajKlijent(KlijentDTO klijent);

	public boolean azurirajKlijent(KlijentDTO klijent);

	public boolean obrisiKlijent(int idKlijenta);
}
