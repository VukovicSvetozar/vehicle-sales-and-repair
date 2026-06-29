package data.dao.prodaja_vozila;

import data.dto.prodaja_vozila.TelefonKlijentaDTO;
import javafx.collections.ObservableList;

public interface TelefonKlijentaDAO {

	public TelefonKlijentaDTO telefonKlijenta(String brojTelefona, int idKlijenta);

	public ObservableList<TelefonKlijentaDTO> telefonKlijenta();

	public boolean dodajTelefonKlijenta(TelefonKlijentaDTO telefonKlijenta);

	public boolean azurirajTelefonKlijenta(TelefonKlijentaDTO telefonKlijenta);

	public boolean obrisiTelefonKlijenta(String brojTelefona, int idKlijenta);
	
}
