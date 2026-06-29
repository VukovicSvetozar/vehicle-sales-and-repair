package data.dao.servis_vozila;

import data.dto.servis_vozila.NaplataServisaDTO;
import javafx.collections.ObservableList;

public interface NaplataServisaDAO {
	
	public ObservableList<NaplataServisaDTO> naplataServisa(int brojNaplateServisa);
	
	public boolean dodajNaplataServisa(NaplataServisaDTO naplataServisa);

	public boolean azurirajNaplataServisa(NaplataServisaDTO naplataServisa);

	public boolean obrisiNaplataServisa(int brojNaplateServisa);
}
