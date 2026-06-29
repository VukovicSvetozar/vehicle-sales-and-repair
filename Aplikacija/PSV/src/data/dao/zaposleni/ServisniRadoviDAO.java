package data.dao.zaposleni;

import data.dto.zaposleni.ServisniRadoviDTO;
import javafx.collections.ObservableList;

public interface ServisniRadoviDAO {

	public ServisniRadoviDTO servisniRadovi(String vrstaServisnihRadova);

	public ObservableList<ServisniRadoviDTO> servisniRadovi();

	public boolean dodajServisniRadovi(ServisniRadoviDTO servisniRadovi);

	public boolean azurirajServisniRadovi(ServisniRadoviDTO servisniRadovi);

	public boolean obrisiServisniRadovi(String vrstaServisnihRadova);

}