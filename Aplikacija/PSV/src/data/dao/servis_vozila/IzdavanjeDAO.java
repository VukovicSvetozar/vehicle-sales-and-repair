package data.dao.servis_vozila;

import data.dto.servis_vozila.IzdavanjeDTO;
import javafx.collections.ObservableList;

public interface IzdavanjeDAO {
	
	public ObservableList<IzdavanjeDTO> izdavanje(String jmb, String nazivDijela, int brojUsluge, int brojNaplateServisa);
	
	public int dodajIzdavanje(IzdavanjeDTO izdavanje);

	public boolean azurirajIzdavanje(IzdavanjeDTO izdavanje);

	public boolean obrisiIzdavanje(String jmb, String nazivDijela, int brojUsluge, int brojNaplateServisa);
}
