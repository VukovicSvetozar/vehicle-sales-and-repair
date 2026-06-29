package data.dao.servis_vozila;

import data.dto.servis_vozila.RealizacijaDTO;
import javafx.collections.ObservableList;

public interface RealizacijaDAO {

	public RealizacijaDTO realizacija(int idRadniNalog, String jmb);
	
	public ObservableList<RealizacijaDTO> realizacija();
	
	public int dodajRealizacija(RealizacijaDTO realizacija);

	public boolean azurirajRealizacija(RealizacijaDTO realizacija);

	public boolean obrisiRealizacija(int idRadniNalog, String jmb);
}
