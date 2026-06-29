package data.dao.zaposleni;

import data.dto.zaposleni.RukovodilacServisaDTO;
import javafx.collections.ObservableList;

public interface RukovodilacServisaDAO {

	public RukovodilacServisaDTO rukovodilacServisa(String jmb);

	public ObservableList<RukovodilacServisaDTO> rukovodilacServisa();

	public boolean dodajRukovodilacServisa(RukovodilacServisaDTO rukovodilacServisa);

	public boolean azurirajRukovodilacServisa(RukovodilacServisaDTO rukovodilacServisa);

	public boolean obrisiRukovodilacServisa(String jmb);
}
