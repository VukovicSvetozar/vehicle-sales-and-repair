package data.dao.mysql.servis_vozila;

import data.dao.servis_vozila.DijeloviIMaterijaliDAO;
import data.dto.servis_vozila.DijeloviIMaterijaliDTO;
import javafx.collections.ObservableList;

public class MySQLDijeloviIMaterijaliDAO implements DijeloviIMaterijaliDAO {

	@Override
	public DijeloviIMaterijaliDTO dijeloviIMaterijali(String nazivDijela) {
		return null;
	}

	@Override
	public ObservableList<DijeloviIMaterijaliDTO> dijeloviIMaterijali() {
		return null;
	}

	@Override
	public boolean dodajDijeloviIMaterijali(DijeloviIMaterijaliDTO dijeloviIMaterijali) {
		return false;
	}

	@Override
	public boolean azurirajDijeloviIMaterijali(DijeloviIMaterijaliDTO dijeloviIMaterijali) {
		return false;
	}

	@Override
	public boolean obrisiDijeloviIMaterijali(String nazivDijela) {
		return false;
	}

}
