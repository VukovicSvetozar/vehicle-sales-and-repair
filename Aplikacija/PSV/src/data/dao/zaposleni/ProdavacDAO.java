package data.dao.zaposleni;

import data.dto.zaposleni.ProdavacDTO;
import javafx.collections.ObservableList;

public interface ProdavacDAO {

	public ProdavacDTO prodavac(String jmb);

	public ProdavacDTO prodavacSifra(String sifra);

	public ObservableList<ProdavacDTO> prodavac();

	public boolean dodajProdavac(ProdavacDTO prodavac);

	public boolean azurirajProdavac(ProdavacDTO prodavac);

	public boolean obrisiProdavac(String jmb);
	
}
