package data.dao.prodaja_vozila;

import data.dto.prodaja_vozila.IndividualnoLiceDTO;
import javafx.collections.ObservableList;

public interface IndividualnoLiceDAO {

	public IndividualnoLiceDTO individualnoLice(int idKategorija);

	public ObservableList<IndividualnoLiceDTO> individualnoLice();

	public boolean dodajIndividualnoLice(IndividualnoLiceDTO individualnoLice);

	public boolean azurirajIndividualnoLice(IndividualnoLiceDTO individualnoLice);

	public boolean obrisiIndividualnoLice(int idKategorija);

}
