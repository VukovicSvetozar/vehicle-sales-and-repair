package data.dao.prodaja_vozila;

import data.dto.prodaja_vozila.ProdataVozilaDTO;
import javafx.collections.ObservableList;

public interface ProdataVozilaDAO {
	
	public ProdataVozilaDTO prodataVozila(int idVozila);
	
	public ObservableList<ProdataVozilaDTO> prodataVozila();
	
	public boolean dodajProdataVozila(ProdataVozilaDTO prodataVozila);

	public boolean azurirajProdataVozila(ProdataVozilaDTO prodataVozila);

	public boolean obrisiProdataVozila(int idVozila);
	
}
