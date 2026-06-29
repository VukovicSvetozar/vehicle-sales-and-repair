package data.dao.zaposleni;

import data.dto.zaposleni.RukovodilacSkladistaDTO;
import javafx.collections.ObservableList;

public interface RukovodilacSkladistaDAO {

	public RukovodilacSkladistaDTO rukovodilacSkladista(String jmb);

	public ObservableList<RukovodilacSkladistaDTO> rukovodilacSkladista();

	public boolean dodajRukovodilacSkladista(RukovodilacSkladistaDTO rukovodilacSkladista);

	public boolean azurirajRukovodilacSkladista(RukovodilacSkladistaDTO rukovodilacSkladista);

	public boolean obrisiRukovodilacSkladista(String jmb);
}
