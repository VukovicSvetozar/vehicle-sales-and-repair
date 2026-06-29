package data.dao.prodaja_vozila;

import data.dto.prodaja_vozila.KompanijaDTO;
import javafx.collections.ObservableList;

public interface KompanijaDAO {

	public KompanijaDTO kompanija(int idKategorija);

	public ObservableList<KompanijaDTO> kompanija();

	public boolean dodajKompanija(KompanijaDTO kompanija);

	public boolean azurirajKompanija(KompanijaDTO kompanija);

	public boolean obrisiKompanija(int idKategorija);
	
}
