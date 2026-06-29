package data.dao.prodaja_vozila;

import data.dto.prodaja_vozila.UgovorDTO;
import javafx.collections.ObservableList;

public interface UgovorDAO {

	public UgovorDTO ugovor(int idUgovora);

	public ObservableList<UgovorDTO> ugovor();

	public int dodajUgovor(UgovorDTO ugovor);

	public boolean azurirajUgovor(UgovorDTO ugovor);

	public boolean obrisiUgovor(int idUgovora);
	
}
