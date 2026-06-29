package controller.kupovina_vozila;

import data.dto.prodaja_vozila.DistributerVozilaDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import table.MySQLTableKlijent;
import table.TableKlijent;
import utility.AlertsUtilities;
import utility.MyFXMLLoader;
import utility.PSVUtilities;

public class KupovinaVozilaGlavnaStranaKontroler {

	@FXML
	private HBox kontejnerTabelaDistributera;

	@FXML
	private Button dugmeIzadji;

	@FXML
	private Button dugmeKupi;

	@FXML
	private Button dugmeNoviDistributer;

	private static TableView<TableKlijent> tabelaDistributera;

	private static TableColumn<TableKlijent, String> idKolona;

	private static TableColumn<TableKlijent, String> kategorijaKolona;

	private static TableColumn<TableKlijent, String> nazivKolona;

	private static TableColumn<TableKlijent, String> adresaKolona;

	private static TableColumn<TableKlijent, String> emailKolona;

	private static TableKlijent odabraniDistributerIzTabele;
	private static ObservableList<TableKlijent> distributeri;
	private static ObservableList<TableKlijent> trenutniDistributeri = FXCollections
			.observableArrayList();

	public static DistributerVozilaDTO odabraniDistributer;

	@FXML
	void initialize() {

		kreirajTabeluDistributera();
		prikaziTabeluDistributera();

	}

	@FXML
	void dodajNovogDistributera(ActionEvent event) {
		MyFXMLLoader.load(getClass(), "/view/kupovina_vozila/UnosNovogDistributera.fxml", "Novi distirbuter vozila");
	}

	@FXML
	void kupiVozilo(ActionEvent event) {
		odabraniDistributerIzTabele = tabelaDistributera.getSelectionModel().getSelectedItem();
		if (odabraniDistributerIzTabele == null) {
			AlertsUtilities.showWarningDialog("Upozorenje", "Niste odabrali distributera!",
					"Morate je odabrati distributera iz date tabele.");
		} else {
			odabraniDistributer = PSVUtilities.getDAOFactory().getDistributerVozilaDAO().distributer(odabraniDistributerIzTabele.getIdKlijenta());
			MyFXMLLoader.load(getClass(), "/view/kupovina_vozila/KupovinaVozila.fxml", "Kupovina");
		}
	}

	@FXML
	void izadji(ActionEvent event) {
		Stage stage = (Stage) dugmeIzadji.getScene().getWindow();
		stage.close();
	}

	@SuppressWarnings("unchecked")
	private void kreirajTabeluDistributera() {
		tabelaDistributera = new TableView<TableKlijent>();
		tabelaDistributera.setId("tabelaDistributera");
		tabelaDistributera.setMaxHeight(180.0);
		tabelaDistributera.setPrefHeight(180.0);
		tabelaDistributera.setMinHeight(180.0);
		tabelaDistributera.setMaxWidth(770.0);
		tabelaDistributera.setPrefWidth(770.0);
		tabelaDistributera.setMinWidth(770.0);

		idKolona = new TableColumn<TableKlijent, String>();
		kategorijaKolona = new TableColumn<TableKlijent, String>();
		nazivKolona = new TableColumn<TableKlijent, String>();
		adresaKolona = new TableColumn<TableKlijent, String>();
		emailKolona = new TableColumn<TableKlijent, String>();

		idKolona.setId("kolonaIdVozilaZaProdaju");
		idKolona.setEditable(false);
		idKolona.setMaxWidth(100.0);
		idKolona.setMinWidth(100.0);
		idKolona.setPrefWidth(100.0);
		idKolona.setText("Id");

		kategorijaKolona.setId("kategorijaKolona");
		kategorijaKolona.setEditable(false);
		kategorijaKolona.setMaxWidth(160.0);
		kategorijaKolona.setMinWidth(160.0);
		kategorijaKolona.setPrefWidth(160.0);
		kategorijaKolona.setText("Kategorija");

		nazivKolona.setId("nazivKolona");
		nazivKolona.setEditable(false);
		nazivKolona.setMaxWidth(160.0);
		nazivKolona.setMinWidth(160.0);
		nazivKolona.setPrefWidth(160.0);
		nazivKolona.setText("Naziv");

		adresaKolona.setId("adresaKolona");
		adresaKolona.setEditable(false);
		adresaKolona.setMaxWidth(170.0);
		adresaKolona.setMinWidth(170.0);
		adresaKolona.setPrefWidth(170.0);
		adresaKolona.setText("Adresa");

		emailKolona.setId("emailKolona");
		emailKolona.setEditable(false);
		emailKolona.setMaxWidth(170.0);
		emailKolona.setMinWidth(170.0);
		emailKolona.setPrefWidth(170.0);
		emailKolona.setText("Email");

		tabelaDistributera.getColumns().addAll(idKolona, nazivKolona, kategorijaKolona, adresaKolona,
				emailKolona);
		tabelaDistributera.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		kontejnerTabelaDistributera.getChildren().add(tabelaDistributera);

	}

	public static void prikaziTabeluDistributera() {

		tabelaDistributera.getItems().clear();
		distributeri = MySQLTableKlijent.tabelaKlijenata();
		trenutniDistributeri.clear();

		idKolona.setCellValueFactory(new PropertyValueFactory<>("idKlijenta"));
		kategorijaKolona.setCellValueFactory(new PropertyValueFactory<>("tipKategorije"));
		nazivKolona.setCellValueFactory(new PropertyValueFactory<>("naziv"));
		adresaKolona.setCellValueFactory(new PropertyValueFactory<>("adresaKupca"));
		emailKolona.setCellValueFactory(new PropertyValueFactory<>("email"));

		for (TableKlijent dist : distributeri)
			if ("Distributer vozila".equals(dist.getTipKlijenta()))
				trenutniDistributeri.add(dist);
		
		tabelaDistributera.setItems(trenutniDistributeri);

	}

}
