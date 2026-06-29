package data.dao.mysql.servis_vozila;

import data.dao.servis_vozila.DobavljacDAO;
import data.dto.servis_vozila.DobavljacDTO;
import javafx.collections.ObservableList;

public class MySQLDobavljacDAO implements DobavljacDAO{

	@Override
	public ObservableList<DobavljacDTO> dobavljac(int IdKlijenta) {
		return null;
	}

	@Override
	public boolean dodajDobavljac(DobavljacDTO dobavljac) {

		return false;
	}

	@Override
	public boolean azurirajDobavljac(DobavljacDTO dobavljac) {
		return false;
	}

	@Override
	public boolean obrisiDobavljac(int IdKlijenta) {
		return false;
	}
	
}
