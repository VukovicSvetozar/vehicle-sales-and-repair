package data.dao.servis_vozila;

import data.dto.servis_vozila.ServisnaKnjigaVozilaDTO;
import javafx.collections.ObservableList;

public interface ServisnaKnjigaVozilaDAO {
	
	public ServisnaKnjigaVozilaDTO servisnaKnjigaVozila(int BrojKarticeVozila, int IdVozila);
	
	public ObservableList<ServisnaKnjigaVozilaDTO> servisnaKnjigaVozila();
	
	public int dodajServisnaKnjigaVozila(ServisnaKnjigaVozilaDTO servisnaKnjigaVozila);

	public boolean azurirajServisnaKnjigaVozila(ServisnaKnjigaVozilaDTO servisnaKnjigaVozila);

	public boolean obrisiServisnaKnjigaVozila(int BrojKarticeVozila, int IdVozila);
}
