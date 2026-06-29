package data.dao.prodaja_vozila;

import data.dto.prodaja_vozila.VozilaDTO;
import javafx.collections.ObservableList;

public interface VozilaDAO {

	public VozilaDTO vozila(int idVozila);

	public ObservableList<VozilaDTO> vozila();

	public int dodajVozila(VozilaDTO vozila);

	public boolean azurirajVozila(VozilaDTO vozila);

	public boolean obrisiVozila(int idVozila);

}
