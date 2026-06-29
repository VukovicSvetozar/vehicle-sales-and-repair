package data.dao.servis_vozila;

import data.dto.servis_vozila.KarticaVozilaDTO;
import javafx.collections.ObservableList;

public interface KarticaVozilaDAO {
	
	public ObservableList<KarticaVozilaDTO> karticaVozila(int idKarticaVozila);
	
	public boolean dodajKarticaVozila(KarticaVozilaDTO karticaVozila);
	
	public boolean azurirajKarticaVozila(KarticaVozilaDTO KarticaVozila);
		
	public boolean obrisiKarticaVozila(int idKarticaVozila);

}
