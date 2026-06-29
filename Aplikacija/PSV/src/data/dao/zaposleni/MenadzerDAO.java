package data.dao.zaposleni;

import data.dto.zaposleni.MenadzerDTO;
import javafx.collections.ObservableList;

public interface MenadzerDAO {

	public MenadzerDTO menadzer(String jmb);

	public MenadzerDTO menadzerSifra(String sifra);

	public ObservableList<MenadzerDTO> menadzer();

	public boolean dodajMenadzer(MenadzerDTO menadzer);

	public boolean azurirajMenadzer(MenadzerDTO menadzer);

	public boolean obrisiMenadzer(String jmb);

}
