package data.dao.prodaja_vozila;

import data.dto.prodaja_vozila.ProdajaDTO;
import javafx.collections.ObservableList;

public interface ProdajaDAO {

	public ProdajaDTO prodaja(int idProdaja);

	public ObservableList<ProdajaDTO> prodaja();

	public int dodajProdaja(ProdajaDTO prodaja);

	public boolean azurirajProdaja(ProdajaDTO prodaja);

	public boolean obrisiProdaja(int idProdaja);

}
