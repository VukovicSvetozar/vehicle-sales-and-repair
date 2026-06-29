package controller.servis_vozila;

import java.io.IOException;

import data.dto.servis_vozila.RadniNalogDTO;
import data.dto.servis_vozila.VoziloNaServisuDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import utility.PSVUtilities;

public class VozilaNaServisuKontroler implements RefreshableController {

	@FXML
	private TabPane tabKontejner;
	@FXML
	private Tab tab1;
	@FXML
	private Tab tab2;

	@FXML
    private TableView<VoziloNaServisuDTO> tabelaVozila;

    @FXML
    private TableColumn<VoziloNaServisuDTO, String> kolonaIdVozila;

    @FXML
    private TableColumn<VoziloNaServisuDTO, String> kolonaDatumPrijema;

    @FXML
    private TableColumn<VoziloNaServisuDTO, String> kolonaTroskovi;

    @FXML
    private TableColumn<VoziloNaServisuDTO, String> kolonaZadrzavanje;
    
    @FXML
    private TableView<RadniNalogDTO> tabelaRadniNalozi;

	@FXML
    private TableColumn<RadniNalogDTO, String> kolonaTermin;

    @FXML
    private TableColumn<RadniNalogDTO, String> kolonaDatumRealizacije;

    @FXML
    private TableColumn<RadniNalogDTO, String> kolonaMehanicara;

    @FXML
    private TableColumn<RadniNalogDTO, String> kolonaServisniRadovi;
    
    @FXML
    private TableColumn<RadniNalogDTO, String> kolonaIdRadnogNaloga;

    @FXML
    private Button dugmeNoviNalog;

    @FXML
    private Button dugmeUsluga;

	@Override
	public void refresh() {
	}

	private ObservableList<VoziloNaServisuDTO> vozilaNaServisu;
	private ObservableList<RadniNalogDTO> radniNalozi;
	
	@FXML
	void initialize() {
		try {
			ucitajTab(tab1, "/view/servis_vozila/VozilaNaServisuTab1.fxml");
			ucitajTab(tab2, "/view/servis_vozila/VozilaNaServisuTab2.fxml");

		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		vozilaNaServisu = PSVUtilities.getDAOFactory().getVoziloNaServisuDAO().voziloNaServisu();
		kolonaIdVozila.setCellValueFactory(new PropertyValueFactory<>("idVozilaNaServisu"));
		kolonaDatumPrijema.setCellValueFactory(new PropertyValueFactory<>("datumPrijemaVozila"));
		kolonaTroskovi.setCellValueFactory(new PropertyValueFactory<>("procjenaTroSkova"));
		kolonaZadrzavanje.setCellValueFactory(new PropertyValueFactory<>("procjenaZavrsetkaRadova"));
		tabelaVozila.setItems(vozilaNaServisu);
		
		radniNalozi = PSVUtilities.getDAOFactory().getRadniNalogDAO().radniNalog();
		kolonaIdVozila.setCellValueFactory(new PropertyValueFactory<>(""));
		kolonaDatumPrijema.setCellValueFactory(new PropertyValueFactory<>(""));
		kolonaTroskovi.setCellValueFactory(new PropertyValueFactory<>(""));
		kolonaZadrzavanje.setCellValueFactory(new PropertyValueFactory<>(""));
		tabelaRadniNalozi.setItems(radniNalozi);
		
		
	}
		
	
	/* Pomocna metoda za ucitavanje fxml fajlova u tabove ovog kontrolera.*/
	 
	private void ucitajTab(Tab tab, String fxml) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
		Parent root = loader.load();
		RefreshableController controller = loader.getController();
		
		AnchorPane pane = (AnchorPane) tab.getContent();
		pane.getChildren().add(root);
		AnchorPane.setBottomAnchor(root, 0.0);
		AnchorPane.setLeftAnchor(root, 0.0);
		AnchorPane.setRightAnchor(root, 0.0);
		AnchorPane.setTopAnchor(root, 0.0);
		
		// Azuriraj podatke svaki put kada se otvori dati tab
		tab.setOnSelectionChanged(e -> {
			if (tab.selectedProperty().get())
				controller.refresh();
		});
	}	
	
        @FXML
    void dodajNoviNalog(ActionEvent event) {

    }

    @FXML
    void prebaciNaUsluge(ActionEvent event) {

    }
	
}
