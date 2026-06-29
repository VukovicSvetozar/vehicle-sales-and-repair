package data.dao.prodaja_vozila;

import java.sql.Date;

import data.dto.prodaja_vozila.NabavkaVozilaDTO;
import javafx.collections.ObservableList;

public interface NabavkaVozilaDAO {

	public NabavkaVozilaDTO nabavkaVozila(int idVozila, Date datumNabavke);

	public ObservableList<NabavkaVozilaDTO> nabavkaVozila();

	public boolean dodajNabavka(NabavkaVozilaDTO nabavka);

	public boolean azurirajNabavka(NabavkaVozilaDTO nabavka);

	public boolean obrisiNabavka(int idVozila, Date datumNabavke);
	
}
