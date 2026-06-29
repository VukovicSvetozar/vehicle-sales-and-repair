package data.dao.servis_vozila;

import data.dto.servis_vozila.VoziloNaServisuDTO;
import javafx.collections.ObservableList;

public interface VoziloNaServisuDAO {
	
	public VoziloNaServisuDTO voziloNaServisu(int IdVozilaNaServisu);
	
	public ObservableList<VoziloNaServisuDTO> voziloNaServisu();
	
	public boolean dodajVoziloNaServisu(VoziloNaServisuDTO voziloNaServisu);

	public boolean azurirajVoziloNaServisu(VoziloNaServisuDTO voziloNaServisu);

	public boolean obrisiVoziloNaServisu(int IdVozilaNaServisu);

}
