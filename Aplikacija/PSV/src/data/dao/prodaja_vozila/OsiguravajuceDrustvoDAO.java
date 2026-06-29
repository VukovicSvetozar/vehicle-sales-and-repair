package data.dao.prodaja_vozila;

import data.dto.prodaja_vozila.OsiguravajuceDrustvoDTO;
import javafx.collections.ObservableList;

public interface OsiguravajuceDrustvoDAO {

	public OsiguravajuceDrustvoDTO osiguravajuceDrustvo(String jib);

	public ObservableList<OsiguravajuceDrustvoDTO> osiguravajuceDrustvo();

	public boolean dodajOsiguravajuceDrustvo(OsiguravajuceDrustvoDTO osiguravajuceDrustvo);

	public boolean azurirajOsiguravajuceDrustvo(OsiguravajuceDrustvoDTO osiguravajuceDrustvo);

	public boolean obrisiOsiguravajuceDrustvo(String jib);

}
