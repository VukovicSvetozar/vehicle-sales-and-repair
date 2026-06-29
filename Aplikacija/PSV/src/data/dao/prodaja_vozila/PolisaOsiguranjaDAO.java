package data.dao.prodaja_vozila;

import data.dto.prodaja_vozila.PolisaOsiguranjaDTO;
import javafx.collections.ObservableList;

public interface PolisaOsiguranjaDAO {

	public PolisaOsiguranjaDTO polisaOsiguranja(int idPolisa);

	public ObservableList<PolisaOsiguranjaDTO> polisaOsiguranja();

	public boolean dodajPolisaOsiguranja(PolisaOsiguranjaDTO polisaOsiguranja);

	public boolean azurirajPolisaOsiguranja(PolisaOsiguranjaDTO polisaOsiguranja);

	public boolean obrisiPolisaOsiguranja(int idPolisa);

}
