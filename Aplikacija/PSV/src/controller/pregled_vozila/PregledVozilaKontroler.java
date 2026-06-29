package controller.pregled_vozila;

import java.io.File;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import table.MySQLTablePregledVozila;
import table.TablePregledVozila;

public class PregledVozilaKontroler {

	@FXML
	private TextField pretragaPolje;

	@FXML
	private ImageView voziloFotografija;

	@FXML
	private TableView<TablePregledVozila> tabelaVozila;

	@FXML
	private TableColumn<TablePregledVozila, String> idKolona;

	@FXML
	private TableColumn<TablePregledVozila, String> statusKolona;
	
	@FXML
	private TableColumn<TablePregledVozila, String> tipKolona;

	@FXML
	private TableColumn<TablePregledVozila, String> modelKolona;

	@FXML
	private TableColumn<TablePregledVozila, String> godinaProizvodnjeKolona;

	@FXML
	private TableColumn<TablePregledVozila, String> vrstaGorivaKolona;

	@FXML
	private TableColumn<TablePregledVozila, String> registracijaKolona;

	@FXML
	private TableColumn<TablePregledVozila, String> cijenaNabavkeKolona;

	@FXML
	private TableColumn<TablePregledVozila, String> cijenaProdajeKolona;

	@FXML
	private Button izlazDugme;

	@FXML
	void pretrazi(MouseEvent event) {
		pretrazi();
	}

	private ObservableList<TablePregledVozila> listaVozila;

	@FXML
	void initialize() {

		listaVozila = MySQLTablePregledVozila.tabelaVozila();

		idKolona.setCellValueFactory(new PropertyValueFactory<>("idVozila"));
		statusKolona.setCellValueFactory(new PropertyValueFactory<>("status"));
		tipKolona.setCellValueFactory(new PropertyValueFactory<>("tipVozila"));
		modelKolona.setCellValueFactory(new PropertyValueFactory<>("model"));
		godinaProizvodnjeKolona.setCellValueFactory(new PropertyValueFactory<>("godinaProizvodnje"));
		vrstaGorivaKolona.setCellValueFactory(new PropertyValueFactory<>("vrstaGoriva"));
		registracijaKolona.setCellValueFactory(new PropertyValueFactory<>("brojRegistracije"));
		cijenaNabavkeKolona.setCellValueFactory(new PropertyValueFactory<>("cijenaNabavke"));
		cijenaProdajeKolona.setCellValueFactory(new PropertyValueFactory<>("cijenaProdaje"));

		tabelaVozila.setItems(listaVozila);

		pretrazi();
				
	}

	@FXML
	void izadji(ActionEvent event) {
		Stage stage = (Stage) izlazDugme.getScene().getWindow();
		stage.close();
	}

	private void pretrazi() {
		// pretraga

		FilteredList<TablePregledVozila> filteredData = new FilteredList<>(listaVozila, p -> true);

		pretragaPolje.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(vozilo -> {
				// ukoliko je polje pretrage prazno prikazi sva vozila
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				// poredjenje
				String lowerCaseFilter = newValue.toLowerCase();

				if (vozilo.getBrojRegistracije().contains(lowerCaseFilter)) {
					return true;
				} else if (vozilo.getTipVozila().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				} else if (vozilo.getStatus().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				} else if (vozilo.getModel().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				} else if (vozilo.getVrstaGoriva().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				} else
					return false; // nema podudaranja
			});
		});

		// obmotaj FilteredList u SortedListu
		SortedList<TablePregledVozila> sortedData = new SortedList<>(filteredData);

		// povezi SortedList komparator sa TableView komparator
		sortedData.comparatorProperty().bind(tabelaVozila.comparatorProperty());

		tabelaVozila.setItems(sortedData);
		
		prikaziSliku(null);
		tabelaVozila.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> prikaziSliku(newValue));

	}
	
	private void prikaziSliku(TablePregledVozila podaci) {
		if (podaci != null) {
			File putanja = new File(podaci.getFotografija());
			voziloFotografija.setImage(new Image(putanja.toURI().toString()));
		}
	}


}
