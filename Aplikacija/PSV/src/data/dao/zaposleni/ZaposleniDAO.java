package data.dao.zaposleni;

import data.dto.zaposleni.ZaposleniDTO;
import javafx.collections.ObservableList;

public interface ZaposleniDAO {

	public ZaposleniDTO zaposleni(String jmb);

	public ObservableList<ZaposleniDTO> zaposleni();

	public String dodajZaposleni(ZaposleniDTO zaposleni);

	public boolean azurirajZaposleni(ZaposleniDTO zaposleni);

	public boolean obrisiZaposleni(String jmb);
}
