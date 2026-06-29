package data.dao.servis_vozila;

import data.dto.servis_vozila.DobavljacDTO;
import javafx.collections.ObservableList;

public interface DobavljacDAO {

	public ObservableList<DobavljacDTO> dobavljac(int IdKlijenta);
	
	public boolean dodajDobavljac(DobavljacDTO dobavljac);

	public boolean azurirajDobavljac(DobavljacDTO dobavljac);

	public boolean obrisiDobavljac(int IdKlijenta);
	
}
