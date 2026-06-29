package controller.servis_vozila;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import data.dto.servis_vozila.ServisnaKnjigaVozilaDTO;
import data.dto.servis_vozila.ZahtjevDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import table.MySQLTableKorisnikServisa;
import table.TableKorisnikServisa;
import utility.MyFXMLLoader;
import utility.PSVUtilities;

public class ZahtjeviKontroler implements RefreshableController, Initializable {

	@FXML
	private Button noviKlijentDugme;

	@FXML
	private Button noviZahtjevDugme;

	@FXML
	private Button novoVoziloDugme;

	@FXML
	private Button prihvatiZahtjevDugme;

	@FXML
	private Button odbijZahtjevDugme;

	@FXML
	private TableView<TableKorisnikServisa> tabelaListaKorisnika;

	@FXML
	private TableColumn<TableKorisnikServisa, String> kolonaId;

	@FXML
	private TableColumn<TableKorisnikServisa, String> kolonaKategorija;

	@FXML
	private TableColumn<TableKorisnikServisa, String> kolonaIme;

	@FXML
	private TableView<ZahtjevDTO> tabelaListaZahtjeva;

	@FXML
	private TableColumn<ZahtjevDTO, String> kolonaBrojZahtjeva;

	@FXML
	private TableColumn<ZahtjevDTO, String> kolonaDatumZahtjeva;

	@FXML
	private TableColumn<ZahtjevDTO, String> KolonaKrajnjiRokObrade;

	@FXML
	private TableView<ServisnaKnjigaVozilaDTO> tabelaServisnaKnjigaVozila;

	@FXML
	private TableColumn<ServisnaKnjigaVozilaDTO, String> KolonaIdVozila;

	@FXML
	private TableColumn<ServisnaKnjigaVozilaDTO, String> kolonaZadnjiServis;

	@FXML
	private TableColumn<ServisnaKnjigaVozilaDTO, String> kolonaOpisProblema;

	private ObservableList<TableKorisnikServisa> korisniciServisa;
	private ObservableList<ZahtjevDTO> zahtjevi;
	private ObservableList<ServisnaKnjigaVozilaDTO> servisnaKnjiga;
	private ObservableList<ServisnaKnjigaVozilaDTO> servisnaKnjigaOdabranih = FXCollections.observableArrayList();

	private TableKorisnikServisa odabraniKlijent = new TableKorisnikServisa();
	private ZahtjevDTO odabraniZahtjev = new ZahtjevDTO();

	
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		korisniciServisa = MySQLTableKorisnikServisa.tabelaKorisnikaServisa();
		kolonaId.setCellValueFactory(new PropertyValueFactory<>("idKlijenta"));
		kolonaKategorija.setCellValueFactory(new PropertyValueFactory<>("tipKategorije"));
		kolonaIme.setCellValueFactory(new PropertyValueFactory<>("naziv"));
		tabelaListaKorisnika.setItems(korisniciServisa);

		zahtjevi = PSVUtilities.getDAOFactory().getZahtjevDAO().zahtjev();
		kolonaBrojZahtjeva.setCellValueFactory(new PropertyValueFactory<>("brojZahtjeva"));
		kolonaDatumZahtjeva.setCellValueFactory(new PropertyValueFactory<>("datumZahtjeva"));
		KolonaKrajnjiRokObrade.setCellValueFactory(new PropertyValueFactory<>("krajnjiRok"));
		tabelaListaZahtjeva.setItems(zahtjevi);

		servisnaKnjiga = PSVUtilities.getDAOFactory().getServisnaKnjigaVozilaDAO().servisnaKnjigaVozila();

		prikaziOdabranePodatke(null);
		tabelaListaZahtjeva.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> prikaziOdabranePodatke(newValue));

		KolonaIdVozila.setCellValueFactory(new PropertyValueFactory<>("idVozila"));
		kolonaZadnjiServis.setCellValueFactory(new PropertyValueFactory<>("datumPoslednjegServisa"));
		kolonaOpisProblema.setCellValueFactory(new PropertyValueFactory<>("opisProblema"));
		tabelaServisnaKnjigaVozila.setItems(servisnaKnjigaOdabranih);

	}

	private void prikaziOdabranePodatke(ZahtjevDTO podaci) {
		if (podaci != null) {
			servisnaKnjigaOdabranih.clear();
			int brojZahtjeva = podaci.getBrojZahtjeva();
			servisnaKnjiga.forEach((tab) -> {
				if (tab.getZahtjev().getBrojZahtjeva() == brojZahtjeva)
					servisnaKnjigaOdabranih.add(tab);
			});
		}
	}

	public void osvjeziTabelu() {
		korisniciServisa.removeAll(korisniciServisa);
		tabelaListaKorisnika.setItems(korisniciServisa);
	}

	@FXML
	void noviKlijent(ActionEvent event) {
		MyFXMLLoader.load(getClass(), "/view/servis_vozila/UnosNovogKlijenta.fxml", "Unos novog klijenta");
	}

	@FXML
	void noviZahtjev(ActionEvent event) {

		if (tabelaListaKorisnika.getSelectionModel().getSelectedItem() == null) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Upozorenje");
			alert.setContentText("Morate odabrati klijenta!");
			alert.showAndWait();
		} else {
			odabraniKlijent = tabelaListaKorisnika.getSelectionModel().getSelectedItem();

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/servis_vozila/UnosNovogZahtjeva.fxml"));

			Stage stage = new Stage(StageStyle.DECORATED);
			try {
				stage.setScene(new Scene((Pane) loader.load()));
			} catch (IOException e) {
				e.printStackTrace();
			}
			UnosNovogZahtjevaKontroler controller = loader.<UnosNovogZahtjevaKontroler>getController();
			controller.initData(odabraniKlijent);
			stage.setTitle("Unos novog zahtjeva");
			stage.show();

		}
	}

	@FXML
	void novoVozilo(ActionEvent event) {
		if (tabelaListaZahtjeva.getSelectionModel().getSelectedItem() == null) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Upozorenje");
			alert.setContentText("Morate odabrati zahtjev");
			alert.showAndWait();
		} else {
			odabraniZahtjev = tabelaListaZahtjeva.getSelectionModel().getSelectedItem();

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/servis_vozila/UnosNovogVozilaZaZahtjev.fxml"));
			Stage stage = new Stage(StageStyle.DECORATED);
			try {
				stage.setScene(new Scene((Pane) loader.load()));
			} catch (IOException e) {
				e.printStackTrace();
			}
			UnosNovogVozilaZaZahtjevKontroler controller = loader.<UnosNovogVozilaZaZahtjevKontroler>getController();
			controller.initData(odabraniZahtjev);
			stage.setTitle("Unos novog vozila");
			stage.show();
			tabelaServisnaKnjigaVozila.refresh();
		}
	}

	@Override
	public void refresh() {
		
	}

}
