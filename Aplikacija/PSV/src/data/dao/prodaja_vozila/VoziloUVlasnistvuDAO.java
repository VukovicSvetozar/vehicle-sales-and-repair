package data.dao.prodaja_vozila;

import data.dto.prodaja_vozila.VoziloUVlasnistvuDTO;
import javafx.collections.ObservableList;

public interface VoziloUVlasnistvuDAO {
	
	public VoziloUVlasnistvuDTO voziloUVlasnistvu(int idVozila);

	public ObservableList<VoziloUVlasnistvuDTO> voziloUVlasnistvu();

	public boolean dodajVoziloUVlasnistvu(VoziloUVlasnistvuDTO voziloUVlasnistvu);

	public boolean azurirajVoziloUVlasnistvu(VoziloUVlasnistvuDTO voziloUVlasnistvu);

	public boolean obrisiVoziloUVlasnistvu(int idVozila);
	
}
