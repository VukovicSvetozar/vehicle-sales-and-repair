package data.dao.prodaja_vozila;

import data.dto.prodaja_vozila.KategorijaKlijentaDTO;
import javafx.collections.ObservableList;

public interface KategorijaKlijentaDAO {

	public KategorijaKlijentaDTO kategorijaKlijenta(int idKategorija);

	public ObservableList<KategorijaKlijentaDTO> kategorijaKlijenta();

	public int dodajKategorijaKlijenta(KategorijaKlijentaDTO kategorijaKlijenta);

	public boolean azurirajKategorijaKlijenta(KategorijaKlijentaDTO kategorijaKlijenta);

	public boolean obrisiKategorijaKlijenta(int idKategorija);
}
