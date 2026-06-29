package data.dao.servis_vozila;

import data.dto.servis_vozila.RadniNalogDTO;
import javafx.collections.ObservableList;

public interface RadniNalogDAO {
	
	public RadniNalogDTO radniNalog(int idRadniNalog);
			
	public ObservableList<RadniNalogDTO> radniNalog();
	
	public boolean dodajRadniNalog(RadniNalogDTO radniNalog);
	
	public boolean azurirajRadniNalog(RadniNalogDTO radniNalog);
		
	public boolean obrisiRadniNalog(int idRadniNalog);

}
