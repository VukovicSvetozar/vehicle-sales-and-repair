package data.dao.mysql.servis_vozila;

import data.dao.servis_vozila.DodatneUslugeDAO;
import data.dto.servis_vozila.DodatneUslugeDTO;
import javafx.collections.ObservableList;

public class MySQLDodatneUslugeDAO implements DodatneUslugeDAO {

	@Override
	public DodatneUslugeDTO dodatneUsluge(String tipUsluge) {
		return null;
	}

	@Override
	public ObservableList<DodatneUslugeDTO> dodatneUsluge() {
		return null;
	}

	@Override
	public boolean dodajDodatneUsluge(DodatneUslugeDTO dodatneUsluge) {
		return false;
	}

	@Override
	public boolean azurirajDodatneUsluge(DodatneUslugeDTO dodatneUsluge) {
		return false;
	}

	@Override
	public boolean obrisiDodatneUsluge(String tipUsluge) {
		return false;
	}

}
