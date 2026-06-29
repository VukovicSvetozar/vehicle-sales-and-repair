package data.dao.prodaja_vozila;

import data.dto.prodaja_vozila.NaplataKupovineDTO;
import javafx.collections.ObservableList;

public interface NaplataKupovineDAO {

	public NaplataKupovineDTO naplataKupovine(int brojNaplateKupovine);

	public ObservableList<NaplataKupovineDTO> naplataKupovine();

	public boolean dodajNaplataKupovine(NaplataKupovineDTO naplataKupovine);

	public boolean azurirajNaplataKupovine(NaplataKupovineDTO naplataKupovine);

	public boolean obrisiNaplataKupovine(int brojNaplateKupovine);

}
