package data.dao.prodaja_vozila;

import data.dto.prodaja_vozila.DistributerVozilaDTO;
import javafx.collections.ObservableList;

public interface DistributerVozilaDAO {

	public DistributerVozilaDTO distributer(int idKlijent);

	public ObservableList<DistributerVozilaDTO> distributer();

	public boolean dodajDistributeraVozila(DistributerVozilaDTO distributer);

	public boolean azurirajDistributeraVozila(DistributerVozilaDTO distributer);

	public boolean obrisiDistributeraVozila(int idKlijenta);
	
}
