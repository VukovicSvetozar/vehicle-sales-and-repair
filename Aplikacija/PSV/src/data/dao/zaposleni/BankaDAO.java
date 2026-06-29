package data.dao.zaposleni;

import data.dto.zaposleni.BankaDTO;
import javafx.collections.ObservableList;

public interface BankaDAO {
	
	public BankaDTO banka(String jib);

	public ObservableList<BankaDTO> banka();

	public boolean dodajBanka(BankaDTO banka);

	public boolean azurirajBanka(BankaDTO banka);

	public boolean obrisiBanka(String jib);

}
