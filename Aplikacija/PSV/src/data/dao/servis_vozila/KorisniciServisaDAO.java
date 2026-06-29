package data.dao.servis_vozila;

import data.dto.servis_vozila.KorisniciServisaDTO;
import javafx.collections.ObservableList;

public interface KorisniciServisaDAO {
	
	public KorisniciServisaDTO korisniciServisa(int idKlijent);
	
	public ObservableList<KorisniciServisaDTO> korisniciServisa();
	
	public boolean dodajKorisniciServisa(KorisniciServisaDTO korisniciServisa);

	public boolean azurirajKorisniciServisa(KorisniciServisaDTO korisniciServisa);

	public boolean obrisiKorisniciServis(int idKlijenta);

}
