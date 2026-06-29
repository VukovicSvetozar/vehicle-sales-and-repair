package controller.prodaja_vozila;

import java.util.Optional;

import data.dto.prodaja_vozila.KupacDTO;
import data.dto.prodaja_vozila.VoziloUVlasnistvuDTO;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import table.MySQLTableKupac;
import table.MySQLTableProdataVozila;
import table.MySQLTableVoziloUVlasnistvu;
import table.TableKupac;
import table.TableProdataVozila;
import table.TableVoziloUVlasnistvu;
import utility.AlertsUtilities;
import utility.MyFXMLLoader;
import utility.PSVUtilities;

public class ProdajaVozilaGlavnaStranaKontroler {

	@FXML
	private Button dugmeNoviKupac;

	@FXML
	private Button dugmePoznatiKupac;

	@FXML
	private Button dugmeProdaj;

	@FXML
	private Button dugmeIzadji;

	@FXML
	private HBox kontejnerTabelaVozila;

	@FXML
	private HBox kontejnerPodaciKupaca;

	@FXML
	private Label imeKupcaLabela;

	@FXML
	private Label adresaLabela;

	@FXML
	private Label emailLabela;

	private static TableView<TableVoziloUVlasnistvu> tabelaVozilaZaProdaju;

	private static TableColumn<TableVoziloUVlasnistvu, String> kolonaIdVozilaZaProdaju;

	private static TableColumn<TableVoziloUVlasnistvu, String> kolonaTipVozilaZaProdaju;

	private static TableColumn<TableVoziloUVlasnistvu, String> kolonaModelVozilaZaProdaju;

	private static TableColumn<TableVoziloUVlasnistvu, String> kolonaGodinaProizvodnje;

	private static TableColumn<TableVoziloUVlasnistvu, String> kolonaDatumNabavke;

	private static TableColumn<TableVoziloUVlasnistvu, String> kolonaNabavnaCijena;

	@FXML
	private HBox kontejnerTabelaProdatihVozila;

	private static TableView<TableProdataVozila> tabelaProdatihVozila;

	private static TableColumn<TableProdataVozila, String> kolonaIdProdatogVozila;

	private static TableColumn<TableProdataVozila, String> kolonaModelProdatogVozila;

	private static TableColumn<TableProdataVozila, String> kolonaImeKupca;

	private static TableColumn<TableProdataVozila, String> kolonaDatumProdaje;

	private static TableColumn<TableProdataVozila, String> kolonaCijenaProdaje;

	private static TableColumn<TableProdataVozila, String> kolonaPlacenoDoSada;

	private static TableColumn<TableProdataVozila, String> kolonaStatusNaplate;

	private static TableColumn<TableProdataVozila, String> KolonaDatumSledeceUplate;

	@FXML
	private TextField poljePretraga;

	@FXML
	private Button dugmeNaplati;

	private static ObservableList<TableVoziloUVlasnistvu> vozilaUVlasnistvu;
	private static ObservableList<TableVoziloUVlasnistvu> trenutnaVozilaUVlasnistvu = FXCollections
			.observableArrayList();
	private static ObservableList<TableProdataVozila> prodataVozila;
	private static TableVoziloUVlasnistvu odabranoVoziloIzTabele;
	public static TableProdataVozila odabranoProdatoVoziloIzTabele;
	public static VoziloUVlasnistvuDTO odabranoVozilo;

	@FXML
	void initialize() {

		kreirajTabeluVozilaUVlasnistvu();
		prikaziTabeluVozilaUVlasnistvu();

		kreirajTabeluProdatihVozila();
		prikaziTabeluProdatihVozila();

		pretrazi();
	}

	@FXML
	void dodajNovogKupca(ActionEvent event) {
		odabranoVoziloIzTabele = tabelaVozilaZaProdaju.getSelectionModel().getSelectedItem();
		if (odabranoVoziloIzTabele == null) {
			AlertsUtilities.showWarningDialog("Upozorenje", "Niste odabrali ni jednu stavku!",
					"Morate odabrati vozilo za prodaju iz date tabele.");
		} else {
			odabranoVozilo = PSVUtilities.getDAOFactory().getVoziloUVlasnistvuDAO()
					.voziloUVlasnistvu(odabranoVoziloIzTabele.getIdVozila());
			if (!odabranoVozilo.getStatus_Za_Prodaju().equals("Ponuda"))
				AlertsUtilities.showWarningDialog("Upozorenje", "Odabrali ste pogresnu stavku!",
						"Odabrano vozilo je vec u obradi.");
			else
				MyFXMLLoader.load(getClass(), "/view/prodaja_vozila/UnosNovogKupca.fxml", "Novi kupac");
		}
	}

	@FXML
	void dodajPoznatogKupca(ActionEvent event) {
		odabranoVoziloIzTabele = tabelaVozilaZaProdaju.getSelectionModel().getSelectedItem();
		if (odabranoVoziloIzTabele == null) {
			AlertsUtilities.showWarningDialog("Upozorenje", "Niste odabrali ni jednu stavku!",
					"Morate odabrati vozilo za prodaju iz date tabele.");
		} else {
			odabranoVozilo = PSVUtilities.getDAOFactory().getVoziloUVlasnistvuDAO()
					.voziloUVlasnistvu(odabranoVoziloIzTabele.getIdVozila());
			if (!odabranoVozilo.getStatus_Za_Prodaju().equals("Ponuda"))
				AlertsUtilities.showWarningDialog("Upozorenje", "Odabrali ste pogresnu stavku!",
						"Odabrano vozilo je vec u obradi.");
			else
				MyFXMLLoader.load(getClass(), "/view/prodaja_vozila/ListaPostojecihKupaca.fxml", "Poznati kupac");
		}
	}

	@FXML
	void prodajVozilo(ActionEvent event) {
		odabranoVoziloIzTabele = tabelaVozilaZaProdaju.getSelectionModel().getSelectedItem();
		if (odabranoVoziloIzTabele == null) {
			AlertsUtilities.showWarningDialog("Upozorenje", "Niste odabrali ni jednu stavku!",
					"Morate odabrati vozilo za prodaju iz date tabele.");
		} else {
			int idOdabranogVozila = tabelaVozilaZaProdaju.getSelectionModel().getSelectedItem().getIdVozila();
			odabranoVozilo = PSVUtilities.getDAOFactory().getVoziloUVlasnistvuDAO()
					.voziloUVlasnistvu(idOdabranogVozila);

			if (odabranoVozilo.getStatus_Za_Prodaju().equals("Obrada")) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Prodaja vozila");
				alert.setHeaderText("Odaberite opciju.");

				ButtonType buttonTypeOne = new ButtonType("Prodaj vozilo");
				ButtonType buttonTypeTwo = new ButtonType("Odustani od prodaje");
				ButtonType buttonTypeCancel = new ButtonType("Izadji", ButtonData.CANCEL_CLOSE);

				alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);

				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == buttonTypeOne) {
					MyFXMLLoader.load(getClass(), "/view/prodaja_vozila/ProdajaVozila.fxml", "Prodaj vozilo");
				} else if (result.get() == buttonTypeTwo) {
					// vozilo vise nije u procesu obrade,
					odabranoVozilo.setStatus_Za_Prodaju("Ponuda");
					odabranoVozilo.getKupac().getKlijent().setIdKlijenta(0);
					PSVUtilities.getDAOFactory().getVoziloUVlasnistvuDAO().azurirajVoziloUVlasnistvu(odabranoVozilo);
					prikaziTabeluVozilaUVlasnistvu();
					;
				} else {
					// cancel
				}
			} else {
				AlertsUtilities.showWarningDialog("Upozorenje", "Odabranom vozilu nije dodat kupac!",
						"Morate odabrati vozilo u obradi.");

			}
		}
	}

	@FXML
	void izadji(ActionEvent event) {
		Stage stage = (Stage) dugmeIzadji.getScene().getWindow();
		stage.close();
	}

	@FXML
	void naplati(ActionEvent event) {
		odabranoProdatoVoziloIzTabele = tabelaProdatihVozila.getSelectionModel().getSelectedItem();
		if (odabranoProdatoVoziloIzTabele == null) {
			AlertsUtilities.showWarningDialog("Upozorenje", "Niste odabrali ni jednu stavku!",
					"Morate odabrati vozilo za naplatu iz date tabele.");
		} else {
			if (odabranoProdatoVoziloIzTabele.getSledecaUplata().equals("Zavrseno"))
				AlertsUtilities.showWarningDialog("Upozorenje", "Odabrali ste pogresnu stavku!",
						"Odabrano vozilo je vec isplaceno.");
			else
				MyFXMLLoader.load(getClass(), "/view/prodaja_vozila/NaplataVozila.fxml", "Naplati vozilo");
		}
	}

	@FXML
	void pretrazi(MouseEvent event) {
		pretrazi();
	}

	@SuppressWarnings("unchecked")
	private void kreirajTabeluVozilaUVlasnistvu() {
		tabelaVozilaZaProdaju = new TableView<TableVoziloUVlasnistvu>();
		tabelaVozilaZaProdaju.setId("tabelaVozilaZaProdaju");
		tabelaVozilaZaProdaju.setMaxHeight(140.0);
		tabelaVozilaZaProdaju.setPrefHeight(140.0);
		tabelaVozilaZaProdaju.setMinHeight(140.0);
		tabelaVozilaZaProdaju.setMaxWidth(420.0);
		tabelaVozilaZaProdaju.setPrefWidth(420.0);
		tabelaVozilaZaProdaju.setMinWidth(420.0);

		kolonaIdVozilaZaProdaju = new TableColumn<TableVoziloUVlasnistvu, String>();
		kolonaTipVozilaZaProdaju = new TableColumn<TableVoziloUVlasnistvu, String>();
		kolonaModelVozilaZaProdaju = new TableColumn<TableVoziloUVlasnistvu, String>();
		kolonaGodinaProizvodnje = new TableColumn<TableVoziloUVlasnistvu, String>();
		kolonaDatumNabavke = new TableColumn<TableVoziloUVlasnistvu, String>();
		kolonaNabavnaCijena = new TableColumn<TableVoziloUVlasnistvu, String>();

		kolonaIdVozilaZaProdaju.setId("kolonaIdVozilaZaProdaju");
		kolonaIdVozilaZaProdaju.setEditable(false);
		kolonaIdVozilaZaProdaju.setMaxWidth(50.0);
		kolonaIdVozilaZaProdaju.setMinWidth(50.0);
		kolonaIdVozilaZaProdaju.setPrefWidth(50.0);
		kolonaIdVozilaZaProdaju.setText("Id");

		kolonaTipVozilaZaProdaju.setId("kolonaTipVozilaZaProdaju");
		kolonaTipVozilaZaProdaju.setEditable(false);
		kolonaTipVozilaZaProdaju.setMaxWidth(103.0);
		kolonaTipVozilaZaProdaju.setMinWidth(80.0);
		kolonaTipVozilaZaProdaju.setPrefWidth(103.0);
		kolonaTipVozilaZaProdaju.setText("Tip vozila");

		kolonaModelVozilaZaProdaju.setId("kolonaModelVozilaZaProdaju");
		kolonaModelVozilaZaProdaju.setEditable(false);
		kolonaModelVozilaZaProdaju.setMaxWidth(80.0);
		kolonaModelVozilaZaProdaju.setMinWidth(75.0);
		kolonaModelVozilaZaProdaju.setPrefWidth(75.0);
		kolonaModelVozilaZaProdaju.setText("Model");

		kolonaGodinaProizvodnje.setId("kolonaGodinaProizvodnje");
		kolonaGodinaProizvodnje.setEditable(false);
		kolonaGodinaProizvodnje.setMaxWidth(60.0);
		kolonaGodinaProizvodnje.setMinWidth(60.0);
		kolonaGodinaProizvodnje.setPrefWidth(60.0);
		kolonaGodinaProizvodnje.setText("Proizvoden");

		kolonaDatumNabavke.setId("kolonaDatumNabavke");
		kolonaDatumNabavke.setEditable(false);
		kolonaDatumNabavke.setMaxWidth(70.0);
		kolonaDatumNabavke.setMinWidth(70.0);
		kolonaDatumNabavke.setPrefWidth(70.0);
		kolonaDatumNabavke.setText("Nabavljen");

		kolonaNabavnaCijena.setId("kolonaNabavnaCijena");
		kolonaNabavnaCijena.setEditable(false);
		kolonaNabavnaCijena.setMaxWidth(80.0);
		kolonaNabavnaCijena.setMinWidth(80.0);
		kolonaNabavnaCijena.setPrefWidth(80.0);
		kolonaNabavnaCijena.setText("Nab. cijena");

		tabelaVozilaZaProdaju.getColumns().addAll(kolonaIdVozilaZaProdaju, kolonaTipVozilaZaProdaju,
				kolonaModelVozilaZaProdaju, kolonaGodinaProizvodnje, kolonaDatumNabavke, kolonaNabavnaCijena);
		tabelaVozilaZaProdaju.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		kontejnerTabelaVozila.getChildren().add(tabelaVozilaZaProdaju);

	}

	public static void prikaziTabeluVozilaUVlasnistvu() {

		tabelaVozilaZaProdaju.getItems().clear();
		vozilaUVlasnistvu = MySQLTableVoziloUVlasnistvu.tabelaVoziloUVlasnistvu();

		kolonaIdVozilaZaProdaju.setCellValueFactory(new PropertyValueFactory<>("IdVozila"));
		kolonaTipVozilaZaProdaju.setCellValueFactory(new PropertyValueFactory<>("TipVozila"));
		kolonaModelVozilaZaProdaju.setCellValueFactory(new PropertyValueFactory<>("Model"));
		kolonaGodinaProizvodnje.setCellValueFactory(new PropertyValueFactory<>("GodinaProizvodnje"));
		kolonaDatumNabavke.setCellValueFactory(new PropertyValueFactory<>("DatumNabavke"));
		kolonaNabavnaCijena.setCellValueFactory(new PropertyValueFactory<>("CijenaNabavke"));

		for (TableVoziloUVlasnistvu vozila : vozilaUVlasnistvu)
			if ("Ponuda".equals(vozila.getStatus_Za_Prodaju()) || "Obrada".equals(vozila.getStatus_Za_Prodaju()))
				trenutnaVozilaUVlasnistvu.add(vozila);

		tabelaVozilaZaProdaju.setItems(trenutnaVozilaUVlasnistvu);

		tabelaVozilaZaProdaju
				.setRowFactory(new Callback<TableView<TableVoziloUVlasnistvu>, TableRow<TableVoziloUVlasnistvu>>() {

					@Override
					public TableRow<TableVoziloUVlasnistvu> call(TableView<TableVoziloUVlasnistvu> tableView) {
						final TableRow<TableVoziloUVlasnistvu> row = new TableRow<TableVoziloUVlasnistvu>() {
							@Override
							protected void updateItem(TableVoziloUVlasnistvu row, boolean empty) {
								super.updateItem(row, empty);
								if (!empty)
									styleProperty().bind(Bindings
											.when(Bindings.createBooleanBinding(
													() -> row.getStatus_Za_Prodaju().equals("Ponuda")))
											.then("-fx-background-color: aqua;")
											.otherwise("-fx-background-color: orange;"));
							}
						};
						return row;
					}
				});
	}

	@SuppressWarnings("unchecked")
	private void kreirajTabeluProdatihVozila() {
		tabelaProdatihVozila = new TableView<TableProdataVozila>();
		tabelaProdatihVozila.setId("tabelaProdatihVozila");
		tabelaProdatihVozila.setMaxHeight(230.0);
		tabelaProdatihVozila.setPrefHeight(230.0);
		tabelaProdatihVozila.setMinHeight(230.0);
		tabelaProdatihVozila.setMaxWidth(620.0);
		tabelaProdatihVozila.setPrefWidth(620.0);
		tabelaProdatihVozila.setMinWidth(620.0);

		kolonaIdProdatogVozila = new TableColumn<TableProdataVozila, String>();
		kolonaModelProdatogVozila = new TableColumn<TableProdataVozila, String>();
		kolonaImeKupca = new TableColumn<TableProdataVozila, String>();
		kolonaDatumProdaje = new TableColumn<TableProdataVozila, String>();
		kolonaCijenaProdaje = new TableColumn<TableProdataVozila, String>();
		kolonaPlacenoDoSada = new TableColumn<TableProdataVozila, String>();
		kolonaStatusNaplate = new TableColumn<TableProdataVozila, String>();
		KolonaDatumSledeceUplate = new TableColumn<TableProdataVozila, String>();

		kolonaIdProdatogVozila.setId("kolonaIdProdatogVozila");
		kolonaIdProdatogVozila.setEditable(false);
		kolonaIdProdatogVozila.setMaxWidth(70.0);
		kolonaIdProdatogVozila.setMinWidth(70.0);
		kolonaIdProdatogVozila.setPrefWidth(70.0);
		kolonaIdProdatogVozila.setText("Id vozila");

		kolonaModelProdatogVozila.setId("kolonaModelProdatogVozila");
		kolonaModelProdatogVozila.setEditable(false);
		kolonaModelProdatogVozila.setMaxWidth(70.0);
		kolonaModelProdatogVozila.setMinWidth(70.0);
		kolonaModelProdatogVozila.setPrefWidth(70.0);
		kolonaModelProdatogVozila.setText("Model");

		kolonaImeKupca.setId("kolonaImeKupca");
		kolonaImeKupca.setEditable(false);
		kolonaImeKupca.setMaxWidth(70.0);
		kolonaImeKupca.setMinWidth(70.0);
		kolonaImeKupca.setPrefWidth(70.0);
		kolonaImeKupca.setText("Id kupca");

		kolonaDatumProdaje.setId("kolonaDatumProdaje");
		kolonaDatumProdaje.setEditable(false);
		kolonaDatumProdaje.setMaxWidth(80.0);
		kolonaDatumProdaje.setMinWidth(80.0);
		kolonaDatumProdaje.setPrefWidth(80.0);
		kolonaDatumProdaje.setText("Datum Prodaje");

		kolonaCijenaProdaje.setId("kolonaCijenaProdaje");
		kolonaCijenaProdaje.setEditable(false);
		kolonaCijenaProdaje.setMaxWidth(70.0);
		kolonaCijenaProdaje.setMinWidth(70.0);
		kolonaCijenaProdaje.setPrefWidth(70.0);
		kolonaCijenaProdaje.setText("Cijena");

		kolonaPlacenoDoSada.setId("kolonaPlacenoDoSada");
		kolonaPlacenoDoSada.setEditable(false);
		kolonaPlacenoDoSada.setMaxWidth(80.0);
		kolonaPlacenoDoSada.setMinWidth(80.0);
		kolonaPlacenoDoSada.setPrefWidth(80.0);
		kolonaPlacenoDoSada.setText("Placeno");

		kolonaStatusNaplate.setId("kolonaStatusNaplate");
		kolonaStatusNaplate.setEditable(false);
		kolonaStatusNaplate.setMaxWidth(90.0);
		kolonaStatusNaplate.setMinWidth(90.0);
		kolonaStatusNaplate.setPrefWidth(90.0);
		kolonaStatusNaplate.setText("Status naplate");

		KolonaDatumSledeceUplate.setId("KolonaDatumSledeceUplate");
		KolonaDatumSledeceUplate.setEditable(false);
		KolonaDatumSledeceUplate.setMaxWidth(90.0);
		KolonaDatumSledeceUplate.setMinWidth(90.0);
		KolonaDatumSledeceUplate.setPrefWidth(90.0);
		KolonaDatumSledeceUplate.setText("Sledeca uplata");

		tabelaProdatihVozila.getColumns().addAll(kolonaIdProdatogVozila, kolonaModelProdatogVozila, kolonaImeKupca,
				kolonaDatumProdaje, kolonaCijenaProdaje, kolonaPlacenoDoSada, kolonaStatusNaplate,
				KolonaDatumSledeceUplate);
		tabelaProdatihVozila.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		kontejnerTabelaProdatihVozila.getChildren().add(tabelaProdatihVozila);

	}

	public static void prikaziTabeluProdatihVozila() {

//		tabelaProdatihVozila.getItems().clear();
		prodataVozila = MySQLTableProdataVozila.tabelaProdatihVozila();

		kolonaIdProdatogVozila.setCellValueFactory(new PropertyValueFactory<>("IdVozila"));
		kolonaModelProdatogVozila.setCellValueFactory(new PropertyValueFactory<>("Model"));
		kolonaImeKupca.setCellValueFactory(new PropertyValueFactory<>("IdKlijenta"));
		kolonaDatumProdaje.setCellValueFactory(new PropertyValueFactory<>("DatumProdaje"));
		kolonaCijenaProdaje.setCellValueFactory(new PropertyValueFactory<>("CijenaProdaje"));
		kolonaPlacenoDoSada.setCellValueFactory(new PropertyValueFactory<>("UkupnoNaplaceno"));
		kolonaStatusNaplate.setCellValueFactory(new PropertyValueFactory<>("Status_za_naplatu"));
		KolonaDatumSledeceUplate.setCellValueFactory(new PropertyValueFactory<>("SledecaUplata"));

		tabelaProdatihVozila.setItems(prodataVozila);

	}

	private void prikaziPodatkeKupaca(TableProdataVozila podaci) {
		if (podaci != null) {

			KupacDTO kupac = PSVUtilities.getDAOFactory().getKupacDAO().kupac(podaci.getIdKlijenta());
			TableKupac tKupac = MySQLTableKupac.tabelaKupaca(podaci.getIdKlijenta());

			imeKupcaLabela.setText(tKupac.getNaziv());
			adresaLabela.setText(tKupac.getAdresaKupca());
			emailLabela.setText(kupac.getKlijent().getKategorijaKlijenta().getTipKategorije());
		} else {
			imeKupcaLabela.setText("");
			adresaLabela.setText("");
			emailLabela.setText("");
		}
	}

	private void pretrazi() {

		FilteredList<TableProdataVozila> filteredData = new FilteredList<>(prodataVozila, p -> true);

		poljePretraga.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(vozilo -> {
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				String lowerCaseFilter = newValue.toLowerCase();

				if (vozilo.getModel().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				} else if (vozilo.getSledecaUplata().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				} else if (vozilo.getStatus_za_naplatu().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				} else if (vozilo.getUkupnoNaplaceno().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				} else
					return false;
			});
		});

		SortedList<TableProdataVozila> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(tabelaProdatihVozila.comparatorProperty());

		tabelaProdatihVozila.setItems(sortedData);

		prikaziPodatkeKupaca(null);
		tabelaProdatihVozila.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> prikaziPodatkeKupaca(newValue));

	}

}
