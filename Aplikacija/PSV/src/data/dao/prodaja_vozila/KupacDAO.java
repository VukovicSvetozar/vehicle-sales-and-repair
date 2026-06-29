package data.dao.prodaja_vozila;

import data.dto.prodaja_vozila.KupacDTO;
import javafx.collections.ObservableList;

public interface KupacDAO {

	public KupacDTO kupac(int idKlijent);

	public ObservableList<KupacDTO> kupac();

	public boolean dodajKupac(KupacDTO kupac);

	public boolean azurirajKupac(KupacDTO kupac);

	public boolean obrisiKupac(int idKlijenta);
	
}
