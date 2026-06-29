package data.dao.prodaja_vozila;

import data.dto.prodaja_vozila.KreditDTO;
import javafx.collections.ObservableList;

public interface KreditDAO {

	public KreditDTO kredit(int IdKredit);

	public ObservableList<KreditDTO> kredit();

	public boolean dodajKredit(KreditDTO kredit);

	public boolean azurirajKredit(KreditDTO kredit);

	public boolean obrisiKredit(int idKredit);

}
