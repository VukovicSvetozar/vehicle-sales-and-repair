package data.dao.mysql.servis_vozila;

import data.dao.servis_vozila.UslugaDAO;
import data.dto.servis_vozila.UslugaDTO;
import javafx.collections.ObservableList;

public class MySQLUslugaDAO implements UslugaDAO {

	@Override
	public ObservableList<UslugaDTO> usluga(String tipUsluge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int dodajUsluga(UslugaDTO usluga) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean azurirajUsluga(UslugaDTO usluga) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean obrisiUsluga(String tipUsluge) {
		// TODO Auto-generated method stub
		return false;
	}


}
