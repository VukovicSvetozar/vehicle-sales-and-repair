package controller.prodaja_vozila;

import data.dto.prodaja_vozila.KupacDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import table.MySQLTableKupac;
import table.TableKupac;
import utility.PSVUtilities;

public class ListaPostojecihKupacaKontroler {

    @FXML
    private TableView<TableKupac> tabelaKupaca;

    @FXML
    private TableColumn<TableKupac, String> idKolona;

    @FXML
    private TableColumn<TableKupac, String> emailKolona;

    @FXML
    private TableColumn<TableKupac, String> nazivKolona;

    @FXML
    private TableColumn<TableKupac, String> adresaKolona;

    @FXML
    private TableColumn<TableKupac, String> kategorijaKolona;

    @FXML
    private Button Dugme;

    @FXML
    private Button cancelDugme;


	private ObservableList<TableKupac> listaKupaca;
	private TableKupac odabraniKupacIzTabele;
	private KupacDTO odabraniKupac;
	
	@FXML
	void initialize() {

		listaKupaca = MySQLTableKupac.tabelaKupaca();
		
		idKolona.setCellValueFactory(new PropertyValueFactory<>("IdKlijenta"));
		kategorijaKolona .setCellValueFactory(new PropertyValueFactory<>("tipKategorije"));
		nazivKolona.setCellValueFactory(new PropertyValueFactory<>("Naziv"));
		adresaKolona.setCellValueFactory(new PropertyValueFactory<>("AdresaKupca"));
		emailKolona.setCellValueFactory(new PropertyValueFactory<>("Email"));
		
		tabelaKupaca.setItems(listaKupaca);
	}

    @FXML
    void potvrdi(ActionEvent event) {
    	odabraniKupacIzTabele = tabelaKupaca.getSelectionModel().getSelectedItem();
    	odabraniKupac = PSVUtilities.getDAOFactory().getKupacDAO().kupac(odabraniKupacIzTabele.getIdKlijenta());
    	
    	ProdajaVozilaGlavnaStranaKontroler.odabranoVozilo.setStatus_Za_Prodaju("Obrada");
		ProdajaVozilaGlavnaStranaKontroler.odabranoVozilo.setKupac(odabraniKupac);
		PSVUtilities.getDAOFactory().getVoziloUVlasnistvuDAO().azurirajVoziloUVlasnistvu(ProdajaVozilaGlavnaStranaKontroler.odabranoVozilo);

		ProdajaVozilaGlavnaStranaKontroler.prikaziTabeluVozilaUVlasnistvu();
		
    	Stage stage = (Stage) Dugme.getScene().getWindow();
		stage.close();
    }

    @FXML
    void otkazi(ActionEvent event) {
    	Stage stage = (Stage) cancelDugme.getScene().getWindow();
		stage.close();
    }

}
