package data.dao.mysql.servis_vozila;

import data.dao.servis_vozila.IzdavanjeDAO;
import data.dto.servis_vozila.IzdavanjeDTO;
import javafx.collections.ObservableList;

public class MySQLIzdavanjeDAO implements IzdavanjeDAO{

	@Override
	public ObservableList<IzdavanjeDTO> izdavanje(String jmb, String nazivDijela, int brojUsluge,
			int brojNaplateServisa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int dodajIzdavanje(IzdavanjeDTO izdavanje) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean azurirajIzdavanje(IzdavanjeDTO izdavanje) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean obrisiIzdavanje(String jmb, String nazivDijela, int brojUsluge, int brojNaplateServisa) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
