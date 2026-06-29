package data.dao.zaposleni;

import data.dto.zaposleni.KontaktZaposlenogDTO;
import javafx.collections.ObservableList;

public interface KontaktZaposlenogDAO {

	public KontaktZaposlenogDTO kontakt(String maticniBroj);

	public ObservableList<KontaktZaposlenogDTO> kontakt();

	public boolean dodajKontaktZaposlenog(KontaktZaposlenogDTO KontaktZaposlenog);

	public boolean azurirajKontaktZaposlenog(KontaktZaposlenogDTO KontaktZaposlenog);

	public boolean obrisiKontaktZaposlenog(int idKontakt);

}
