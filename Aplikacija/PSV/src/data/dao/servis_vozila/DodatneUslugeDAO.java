package data.dao.servis_vozila;

import data.dto.servis_vozila.DodatneUslugeDTO;
import javafx.collections.ObservableList;

public interface DodatneUslugeDAO {
	
	public DodatneUslugeDTO dodatneUsluge(String tipUsluge);
	
	public ObservableList<DodatneUslugeDTO> dodatneUsluge();
	
	public boolean dodajDodatneUsluge(DodatneUslugeDTO dodatneUsluge);

	public boolean azurirajDodatneUsluge(DodatneUslugeDTO dodatneUsluge);

	public boolean obrisiDodatneUsluge(String tipUsluge);
	
}
