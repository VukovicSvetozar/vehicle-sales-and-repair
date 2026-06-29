package data.dao.servis_vozila;

import data.dto.servis_vozila.ZahtjevDTO;
import javafx.collections.ObservableList;

public interface ZahtjevDAO {
	
	public ZahtjevDTO zahtjev(int brojZahtjeva);
	
	public ObservableList<ZahtjevDTO> zahtjev();
	
	public int dodajZahtjev(ZahtjevDTO zahtjev);

	public boolean azurirajZahtjev(ZahtjevDTO zahtjev);

	public boolean obrisiZahtjev(int brojZahtjeva);

}
