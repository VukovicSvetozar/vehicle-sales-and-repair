package data.dao.prodaja_vozila;

import data.dto.prodaja_vozila.ZiroRacunKlijentaDTO;
import javafx.collections.ObservableList;

public interface ZiroRacunKlijentaDAO {
	
	public ZiroRacunKlijentaDTO ziroRacunKlijenta(String brojZiroRacuna);

	public ObservableList<ZiroRacunKlijentaDTO> ziroRacunKlijenta();

	public boolean dodajZiroRacunKlijenta(ZiroRacunKlijentaDTO ziroRacunKlijenta);

	public boolean azurirajZiroRacunKlijenta(ZiroRacunKlijentaDTO ziroRacunKlijenta);

	public boolean obrisiZiroRacunKlijenta(String brojZiroRacuna);
	
}
