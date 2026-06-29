package controller.zaposleni;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Optional;

import data.dto.zaposleni.KontaktZaposlenogDTO;
import data.dto.zaposleni.ZaposleniDTO;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import utility.MyFXMLLoader;
import utility.PSVUtilities;

public class ZaposleniGlavnaStranaKontroler {

	@FXML
	private Button zaposliDugme;

	@FXML
	private ImageView zaposliSlika;

	@FXML
	private Button editDugme;

	@FXML
	private ImageView editSlika;

	@FXML
	private Button otpustiDugme;

	@FXML
	private ImageView otpustiSlika;

	@FXML
	private Button izlazDugme;

	@FXML
	private ImageView izlazSlika;

	@FXML
	private TextField pretragaPolje;

	@FXML
	private Label datumPotpisaUgovora;

	@FXML
	private Label datumIstekaUgovora;

	@FXML
	private Label satnica;

	@FXML
	private ImageView zaposleniSlika;

	@FXML
	private HBox kontejner;

	@FXML
	private Label datumRodjenja;

	@FXML
	private Label telefon;

	@FXML
	private Label adresa;

	@FXML
	private HBox kontejnerTabela;

	private static TableView<ZaposleniDTO> tabelaZaposlenih;
	private static TableColumn<ZaposleniDTO, String> imeKolona;
	private static TableColumn<ZaposleniDTO, String> prezimeKolona;
	private static TableColumn<ZaposleniDTO, String> zanimanjeKolona;

	private static ObservableList<ZaposleniDTO> zaposleni;
	private KontaktZaposlenogDTO kontakti;
	private ZaposleniDTO odabraniZaposleni = new ZaposleniDTO();
	public String JMBOdabranogZaposlenog;

	@FXML
	void initialize() {

		kreirajTabelu();
		popuniTabelu();
		pretrazi();
	
	}

	@FXML
	void zaposli(ActionEvent event) {
		MyFXMLLoader.load(getClass(), "/view/zaposleni/UnosNovogZaposlenog.fxml", "Zaposleni");
	}

	@FXML
	void izmjeni(ActionEvent event) {
		if (tabelaZaposlenih.getSelectionModel().getSelectedItem() == null) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Upozorenje");
			alert.setHeaderText("Niste odabrali ni jednu stavku!");
			alert.setContentText("Odaberite stavku.");
			alert.showAndWait();
		} else {
			odabraniZaposleni = tabelaZaposlenih.getSelectionModel().getSelectedItem();

			JMBOdabranogZaposlenog = odabraniZaposleni.getJmb();

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/zaposleni/AzurirajZaposlenog.fxml"));

			Stage stage = new Stage(StageStyle.DECORATED);
			try {
				stage.setScene(new Scene((Pane) loader.load()));
			} catch (IOException e) {
				e.printStackTrace();
			}
			AzurirajZaposlenogKontroler controller = loader.<AzurirajZaposlenogKontroler>getController();
			controller.initData(odabraniZaposleni);
			stage.setTitle("Azuriraj podatke o zaposlenom");
			stage.show();

		}
	}

	@FXML
	void otpusti(ActionEvent event) {
		if (tabelaZaposlenih.getSelectionModel().getSelectedItem() == null) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Upozorenje");
			alert.setHeaderText("Niste odabrali ni jednu stavku!");
			alert.setContentText("Odaberite stavku.");
			alert.showAndWait();
		} else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Dijalog potvrde");
			alert.setHeaderText("Zelite da otpustite zaposlenog!");
			alert.setContentText("Da li ste sigurni?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				String jmb = tabelaZaposlenih.getSelectionModel().getSelectedItem().getJmb();
				PSVUtilities.getDAOFactory().getZaposleniDAO().obrisiZaposleni(jmb);
				popuniTabelu();
			}
		}
	}

	@FXML
	void izadji(ActionEvent event) {
		Stage stage = (Stage) izlazDugme.getScene().getWindow();
		stage.close();
	}
	
    @FXML
    void pretrazi(MouseEvent event) {
		pretrazi();
    }

	private void prikaziDetalje(ZaposleniDTO podaci) {
		if (podaci != null) {

			Date datumZ = podaci.getDatumZaposljavanja();
			DateFormat dfz = new SimpleDateFormat("MM/dd/yyyy");
			String tekstZ = dfz.format(datumZ);
			datumPotpisaUgovora.setText(tekstZ);

			Date datumI = podaci.getDatumIstekaUgovora();
			DateFormat dfi = new SimpleDateFormat("MM/dd/yyyy");
			String tekstI = dfi.format(datumI);
			datumIstekaUgovora.setText(tekstI);

			double satnicaD = podaci.getSatnica();
			satnica.setText(String.valueOf(satnicaD));

			String maticniBroj = podaci.getJmb();

			if (podaci.getFotografija() != null) {
				File putanja = new File(podaci.getFotografija());
				zaposleniSlika.setImage(new Image(putanja.toURI().toString()));
			} else {
				File putanja = new File(".\\image\\Slike radnika\\Nema_Slike_Zena.png");
				zaposleniSlika.setImage(new Image(putanja.toURI().toString()));
			}

			kontakti = PSVUtilities.getDAOFactory().getKontaktZaposlenogDAO().kontakt(maticniBroj);

			Date datumR = podaci.getDatumRodjenja();
			DateFormat dfr = new SimpleDateFormat("MM/dd/yyyy");
			String tekstR = dfr.format(datumR);
			datumRodjenja.setText(tekstR);

			telefon.setText(kontakti.getTelefon());

			String adresaTekst = kontakti.getAdresa() + " " + kontakti.getGrad();
			adresa.setText(adresaTekst);

		} else {
			datumPotpisaUgovora.setText("");
			datumIstekaUgovora.setText("");
			satnica.setText("");
			datumRodjenja.setText("");
			telefon.setText("");
			adresa.setText("");
		}
	}

	@SuppressWarnings("unchecked")
	private void kreirajTabelu() {
		tabelaZaposlenih = new TableView<ZaposleniDTO>();
		tabelaZaposlenih.setId("tabelaZaposlenih");
		tabelaZaposlenih.setMaxHeight(330.0);
		tabelaZaposlenih.setPrefHeight(330.0);
		tabelaZaposlenih.setMinHeight(330.0);
		tabelaZaposlenih.setMaxWidth(380.0);
		tabelaZaposlenih.setPrefWidth(380.0);
		tabelaZaposlenih.setMinWidth(380.0);

		imeKolona = new TableColumn<ZaposleniDTO, String>();
		prezimeKolona = new TableColumn<ZaposleniDTO, String>();
		zanimanjeKolona = new TableColumn<ZaposleniDTO, String>();

		imeKolona.setId("imeKolona");
		imeKolona.setEditable(false);
		imeKolona.setMaxWidth(120.0);
		imeKolona.setMinWidth(120.0);
		imeKolona.setPrefWidth(120.0);
		imeKolona.setText("Ime");

		prezimeKolona.setId("prezimeKolona");
		prezimeKolona.setEditable(false);
		prezimeKolona.setMaxWidth(120);
		prezimeKolona.setMinWidth(120.0);
		prezimeKolona.setPrefWidth(120.0);
		prezimeKolona.setText("Prezime");

		zanimanjeKolona.setId("zanimanjeKolona");
		zanimanjeKolona.setEditable(false);
		zanimanjeKolona.setMaxWidth(120.0);
		zanimanjeKolona.setMinWidth(120.0);
		zanimanjeKolona.setPrefWidth(120.0);
		zanimanjeKolona.setText("Zanimanje");

		tabelaZaposlenih.getColumns().addAll(imeKolona, prezimeKolona, zanimanjeKolona);
		tabelaZaposlenih.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		kontejnerTabela.getChildren().add(tabelaZaposlenih);

	}

	public static void popuniTabelu() {
		zaposleni = PSVUtilities.getDAOFactory().getZaposleniDAO().zaposleni();

		imeKolona.setCellValueFactory(new PropertyValueFactory<>("Ime"));
		prezimeKolona.setCellValueFactory(new PropertyValueFactory<>("Prezime"));
		zanimanjeKolona.setCellValueFactory(new PropertyValueFactory<>("Funkcija"));
		tabelaZaposlenih.setItems(zaposleni);
	}
	
	private void pretrazi() {
		// pretraga

		FilteredList<ZaposleniDTO> filteredData = new FilteredList<>(zaposleni, p -> true);

		pretragaPolje.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(person -> {
				// ukoliko je polje pretrage prazno prikazi sve osobe
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				// poredjenje
				String lowerCaseFilter = newValue.toLowerCase();

				if (person.getFunkcija().toLowerCase().contains(lowerCaseFilter)) {
					return true; // pronalazi funkciju
				} else if (person.getIme().toLowerCase().contains(lowerCaseFilter)) {
					return true; // pronalazi ime
				} else if (person.getPrezime().toLowerCase().contains(lowerCaseFilter)) {
					return true; // pronalazi prezime
				} else
					return false; // nema podudaranja
			});
		});

		// obmotaj FilteredList u SortedListu
		SortedList<ZaposleniDTO> sortedData = new SortedList<>(filteredData);

		// povezi SortedList komparator sa TableView komparator
		sortedData.comparatorProperty().bind(tabelaZaposlenih.comparatorProperty());

		tabelaZaposlenih.setItems(sortedData);

		// prikaz podataka
		prikaziDetalje(null);
		tabelaZaposlenih.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> prikaziDetalje(newValue));

	}
	
}