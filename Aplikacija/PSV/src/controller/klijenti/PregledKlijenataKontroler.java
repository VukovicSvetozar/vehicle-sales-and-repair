package controller.klijenti;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import table.MySQLTableKlijent;
import table.TableKlijent;

public class PregledKlijenataKontroler {

	@FXML
	private TableView<TableKlijent> tabelaKlijenata;

	@FXML
	private TableColumn<TableKlijent, String> idKolona;

	@FXML
	private TableColumn<TableKlijent, String> tipKolona;

	@FXML
	private TableColumn<TableKlijent, String> kategorijaKolona;

	@FXML
	private TableColumn<TableKlijent, String> nazivKolona;

	@FXML
	private TableColumn<TableKlijent, String> adresaKolona;

	@FXML
	private TableColumn<TableKlijent, String> emailKolona;

	@FXML
	private Button cancelDugme;

	private ObservableList<TableKlijent> listaKlijenata;

	@FXML
	void initialize() {

		listaKlijenata = MySQLTableKlijent.tabelaKlijenata();

		idKolona.setCellValueFactory(new PropertyValueFactory<>("IdKlijenta"));
		tipKolona.setCellValueFactory(new PropertyValueFactory<>("tipKlijenta"));
		kategorijaKolona.setCellValueFactory(new PropertyValueFactory<>("tipKategorije"));
		nazivKolona.setCellValueFactory(new PropertyValueFactory<>("Naziv"));
		adresaKolona.setCellValueFactory(new PropertyValueFactory<>("AdresaKupca"));
		emailKolona.setCellValueFactory(new PropertyValueFactory<>("Email"));

		tabelaKlijenata.setItems(listaKlijenata);
	}

	@FXML
	void otkazi(ActionEvent event) {
		Stage stage = (Stage) cancelDugme.getScene().getWindow();
		stage.close();
	}

}
