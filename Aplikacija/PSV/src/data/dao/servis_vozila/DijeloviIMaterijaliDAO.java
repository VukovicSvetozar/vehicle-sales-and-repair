package data.dao.servis_vozila;

import data.dto.servis_vozila.DijeloviIMaterijaliDTO;
import javafx.collections.ObservableList;

public interface DijeloviIMaterijaliDAO {
	
	public DijeloviIMaterijaliDTO dijeloviIMaterijali(String nazivDijela);
	
	public ObservableList<DijeloviIMaterijaliDTO> dijeloviIMaterijali();

	public boolean dodajDijeloviIMaterijali(DijeloviIMaterijaliDTO dijeloviIMaterijali);

	public boolean azurirajDijeloviIMaterijali(DijeloviIMaterijaliDTO dijeloviIMaterijali);

	public boolean obrisiDijeloviIMaterijali(String nazivDijela);

}
