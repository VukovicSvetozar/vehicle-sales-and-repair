package data.dao.zaposleni;

import data.dto.zaposleni.MehanicarDTO;
import javafx.collections.ObservableList;

public interface MehanicarDAO {

	public MehanicarDTO mehanicar(String jmb);

	public ObservableList<MehanicarDTO> mehanicar();

	public boolean dodajMehanicar(MehanicarDTO mehanicar);

	public boolean azurirajMehanicar(MehanicarDTO Mehanicar);

	public boolean obrisiMehanicar(String jmb);

}
