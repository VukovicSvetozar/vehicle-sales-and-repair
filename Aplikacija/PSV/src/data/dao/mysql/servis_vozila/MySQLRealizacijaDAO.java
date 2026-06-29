package data.dao.mysql.servis_vozila;

import data.dao.servis_vozila.RealizacijaDAO;
import data.dto.servis_vozila.RealizacijaDTO;
import javafx.collections.ObservableList;

public class MySQLRealizacijaDAO implements RealizacijaDAO {

	@Override
	public RealizacijaDTO realizacija(int idRadniNalog, String jmb) {
		return null;
	}

	@Override
	public ObservableList<RealizacijaDTO> realizacija() {
		return null;
	}

	@Override
	public int dodajRealizacija(RealizacijaDTO realizacija) {
		return 0;
	}

	@Override
	public boolean azurirajRealizacija(RealizacijaDTO realizacija) {
		return false;
	}

	@Override
	public boolean obrisiRealizacija(int idRadniNalog, String jmb) {
		return false;
	}

}
