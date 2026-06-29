package controller.zaposleni;

import java.io.File;
import java.sql.Date;
import java.time.LocalDate;

import org.controlsfx.control.CheckComboBox;

import data.dto.zaposleni.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import utility.PSVUtilities;

public class UnosNovogZaposlenogKontroler {

	@FXML
	private ToggleGroup grupa1;

	@FXML
	private RadioButton rbMenadzer;

	@FXML
	private RadioButton rbDobavljac;

	@FXML
	private RadioButton rbProdavac;

	@FXML
	private RadioButton rbRukSkladista;

	@FXML
	private RadioButton rbRukServisa;

	@FXML
	private RadioButton rbMehanicar;

	@FXML
	private TextField jmbPolje;

	@FXML
	private TextField imePolje;

	@FXML
	private TextField prezimePolje;

	@FXML
	private DatePicker rodjenDate;

	@FXML
	private Button fotografijaDugme;

	@FXML
	private ImageView ivFotografija;

	@FXML
	private DatePicker zaposlenDate;

	@FXML
	private DatePicker ugovorDate;

	@FXML
	private TextField satnicaPolje;

	@FXML
	private DatePicker lijecnickiDate;

	@FXML
	private TextField telefonPolje;

	@FXML
	private TextField emailPolje;

	@FXML
	private TextField gradPolje;

	@FXML
	private TextField adresaPolje;

	@FXML
	private TextField sifraMenadzerPolje;

	@FXML
	private HBox ziroRacunKontejner;

	@FXML
	private TextField licniBrojDobavljacPolje;

	@FXML
	private TextField sifraProdavacPolje;

	@FXML
	private TextField licniBrojRukServisaPolje;

	@FXML
	private TextField licniBrojRukSkladistaPolje;

	@FXML
	private ChoiceBox<String> brojSmjene;

	@FXML
	private HBox listaKvalifikacijaKontejner;

	@FXML
	private Button okDugme;

	@FXML
	private Button otkaziDugme;

	CheckComboBox<String> checkComboBoxZR;
	CheckComboBox<String> checkComboBoxSR;
	String relativnaPutanjaFotografije;
	
	ZaposleniDTO zaposleni = new ZaposleniDTO();
	KontaktZaposlenogDTO kontakt = new KontaktZaposlenogDTO();

	MenadzerDTO menadzer = new MenadzerDTO();
	ProdavacDTO prodavac = new ProdavacDTO();
	RukovodilacServisaDTO rukovodilacServisa = new RukovodilacServisaDTO();
	RukovodilacSkladistaDTO rukovodilacSkladista = new RukovodilacSkladistaDTO();
	MehanicarDTO mehanicar = new MehanicarDTO();

	ZiroRacunPreduzecaMenadzerDTO ziroRacuniPreduzecaMenadzera;
	KvalifikacijaDTO kvalifikacija;
	ServisniRadoviDTO servisniRadovi;

	@FXML
	void initialize() {
		onemoguciPolja();
		kreirajListuZiroRacuna();
		kreirajListuSmjena();
		kreirajListuServisnihRadova();
	}

	@FXML
	void unesiFotografiju(ActionEvent event) {
		ivFotografija.setSmooth(true);
		ivFotografija.setCache(true);
		fotografijaDugme.setOnAction(e -> ucitajFotografiju(event));
	}

	@FXML
	void zaposli(ActionEvent event) {

		zaposleni.setJmb(jmbPolje.getText());
		zaposleni.setIme(imePolje.getText());
		zaposleni.setPrezime(prezimePolje.getText());

		LocalDate localDate = rodjenDate.getValue();
		Date datum = Date.valueOf(localDate);
		zaposleni.setDatumRodjenja(datum);

		LocalDate localDate2 = zaposlenDate.getValue();
		Date datum2 = Date.valueOf(localDate2);
		zaposleni.setDatumZaposljavanja(datum2);

		if (rbMenadzer.isSelected()) {
			zaposleni.setFunkcija("Menadzer");
		} else if (rbProdavac.isSelected()) {
			zaposleni.setFunkcija("Prodavac");
		} else if (rbDobavljac.isSelected()) {
			zaposleni.setFunkcija("Dobavljac");
		} else if (rbRukSkladista.isSelected()) {
			zaposleni.setFunkcija("Rukovodilac skladista");
		} else if (rbRukServisa.isSelected()) {
			zaposleni.setFunkcija("Rukovodilac servisa");
		} else if (rbMehanicar.isSelected()) {
			zaposleni.setFunkcija("Mehanicar");
		} else
			throw null;

		zaposleni.setSatnica(Double.parseDouble(satnicaPolje.getText()));

		LocalDate localDate3 = lijecnickiDate.getValue();
		Date datum3 = Date.valueOf(localDate3);
		zaposleni.setLijecnickiPregled(datum3);

		LocalDate localDate4 = ugovorDate.getValue();
		Date datum4 = Date.valueOf(localDate4);
		zaposleni.setDatumIstekaUgovora(datum4);
		
		zaposleni.setFotografija(relativnaPutanjaFotografije);

		String JMBZaposlenog = PSVUtilities.getDAOFactory().getZaposleniDAO().dodajZaposleni(zaposleni);
		zaposleni.setJmb(JMBZaposlenog);

		kontakt.setGrad(gradPolje.getText());
		kontakt.setAdresa(adresaPolje.getText());
		kontakt.setTelefon(telefonPolje.getText());
		kontakt.setEmail(emailPolje.getText());
		kontakt.setZaposleni(zaposleni);
		PSVUtilities.getDAOFactory().getKontaktZaposlenogDAO().dodajKontaktZaposlenog(kontakt);

		String izborZaposlenog = zaposleni.getFunkcija();

		switch (izborZaposlenog) {

		case "Menadzer":
			menadzer.setSifra(sifraMenadzerPolje.getText());
			menadzer.setZaposleni(zaposleni);
			PSVUtilities.getDAOFactory().getMenadzerDAO().dodajMenadzer(menadzer);

			for (String s : checkComboBoxZR.getCheckModel().getCheckedItems()) {
				ZiroRacunPreduzecaDTO zrp = PSVUtilities.getDAOFactory().getZiroRacunPreduzecaDAO()
						.ziroRacunPreduzeca(s);
				ziroRacuniPreduzecaMenadzera = new ZiroRacunPreduzecaMenadzerDTO(zrp, menadzer);
				PSVUtilities.getDAOFactory().getZiroRacunPreduzecaMenadzerDAO()
						.dodajZiroRacunPreduzecaMenadzer(ziroRacuniPreduzecaMenadzera);
			}
			break;

		case "Prodavac":
			prodavac.setSifra(sifraProdavacPolje.getText());
			prodavac.setBrojProdatihVozila(0);
			prodavac.setZaposleni(zaposleni);
			PSVUtilities.getDAOFactory().getProdavacDAO().dodajProdavac(prodavac);
			break;

		case "Dobavljac":

			break;

		case "Rukovodilac skladista":
			rukovodilacSkladista.setLicniBroj(licniBrojRukSkladistaPolje.getText());
			rukovodilacSkladista.setZaposleni(zaposleni);
			PSVUtilities.getDAOFactory().getRukovodilacSkladistaDAO().dodajRukovodilacSkladista(rukovodilacSkladista);
			break;

		case "Rukovodilac servisa":
			rukovodilacServisa.setLicniBroj(licniBrojRukServisaPolje.getText());
			rukovodilacServisa.setZaposleni(zaposleni);
			PSVUtilities.getDAOFactory().getRukovodilacServisaDAO().dodajRukovodilacServisa(rukovodilacServisa);
			break;

		case "Mehanicar":
			mehanicar.setTrenutniBrojAktivnosti(0);
			mehanicar.setZaposleni(zaposleni);
			mehanicar.setBrojSmjene(brojSmjene.getSelectionModel().getSelectedItem());
			PSVUtilities.getDAOFactory().getMehanicarDAO().dodajMehanicar(mehanicar);

			for (String s : checkComboBoxSR.getCheckModel().getCheckedItems()) {
				servisniRadovi = PSVUtilities.getDAOFactory().getServisniRadoviDAO().servisniRadovi(s);
				kvalifikacija = new KvalifikacijaDTO();
				kvalifikacija.setMehanicar(mehanicar);
				kvalifikacija.setOpis("opis");
				kvalifikacija.setServisniRadovi(servisniRadovi);
				PSVUtilities.getDAOFactory().getKvalifikacijaDAO().dodajKvalifikacija(kvalifikacija);
			}
			break;

		}

		ZaposleniGlavnaStranaKontroler.popuniTabelu();
		
		final Node source = (Node) event.getSource();
		final Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
	}

	@FXML
	void otkazi(ActionEvent event) {
		final Node source = (Node) event.getSource();
		final Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
	}

	@FXML
	void omoguciMenadzera(ActionEvent event) {
		if (rbMenadzer.isSelected()) {
			onemoguciPolja();
			sifraMenadzerPolje.setDisable(false);
			ziroRacunKontejner.setDisable(false);

		} else {
			onemoguciPolja();
		}
	}

	@FXML
	void omoguciDobavljaca(ActionEvent event) {
		if (rbDobavljac.isSelected()) {
			onemoguciPolja();
			licniBrojDobavljacPolje.setDisable(false);
		} else {
			onemoguciPolja();
		}
	}

	@FXML
	void omoguciProdavaca(ActionEvent event) {
		if (rbProdavac.isSelected()) {
			onemoguciPolja();
			sifraProdavacPolje.setDisable(false);
		} else {
			onemoguciPolja();
		}
	}

	@FXML
	void omoguciRukSkladista(ActionEvent event) {
		if (rbRukSkladista.isSelected()) {
			onemoguciPolja();
			licniBrojRukSkladistaPolje.setDisable(false);
		} else {
			onemoguciPolja();
		}
	}

	@FXML
	void omoguciRukServisa(ActionEvent event) {
		if (rbRukServisa.isSelected()) {
			onemoguciPolja();
			licniBrojRukServisaPolje.setDisable(false);
		} else {
			onemoguciPolja();
		}
	}

	@FXML
	void omoguciMehanicara(ActionEvent event) {
		if (rbMehanicar.isSelected()) {
			onemoguciPolja();
			brojSmjene.setDisable(false);
			listaKvalifikacijaKontejner.setDisable(false);
		} else {
			onemoguciPolja();
		}
	}

	private void onemoguciPolja() {
		sifraMenadzerPolje.setDisable(true);
		ziroRacunKontejner.setDisable(true);
		licniBrojDobavljacPolje.setDisable(true);
		sifraProdavacPolje.setDisable(true);
		licniBrojRukSkladistaPolje.setDisable(true);
		licniBrojRukServisaPolje.setDisable(true);
		brojSmjene.setDisable(true);
		listaKvalifikacijaKontejner.setDisable(true);
	}

	private void kreirajListuZiroRacuna() {

		final ObservableList<ZiroRacunPreduzecaDTO> ziroRacuni = PSVUtilities.getDAOFactory().getZiroRacunPreduzecaDAO()
				.ziroRacunPreduzeca();
		final ObservableList<String> brojRacuna = FXCollections.observableArrayList();

		for (ZiroRacunPreduzecaDTO zrp : ziroRacuni)
			brojRacuna.add(zrp.getBrojZiroRacunaPreduzeca());

		checkComboBoxZR = new CheckComboBox<String>(brojRacuna);
		checkComboBoxZR.setPrefWidth(150);
		checkComboBoxZR.setPrefHeight(25);
		ziroRacunKontejner.getChildren().add(checkComboBoxZR);
	}

	private void kreirajListuSmjena() {
		brojSmjene.getItems().add("Prva");
		brojSmjene.getItems().add("Druga");
		brojSmjene.getItems().add("Treca");
	}

	private void kreirajListuServisnihRadova() {

		final ObservableList<String> servisniRadovi = FXCollections.observableArrayList();
		servisniRadovi.add("Zamjena ulja i filtera");
		servisniRadovi.add("Servis klima uredjaja");
		servisniRadovi.add("Zamjena guma");
		servisniRadovi.add("Zamjena diskova i disk plocica");
		servisniRadovi.add("Zamjena akumulatora");
		servisniRadovi.add("Zamjena prednjih amortizera i opruga");
		servisniRadovi.add("Zamjena zadnjih amortizera i opruga");
		servisniRadovi.add("Zamjena i popravka stakala");
		servisniRadovi.add("Zamjena svjecica");
		servisniRadovi.add("Farbanje i lakiranje elemenata");
		servisniRadovi.add("Zamjena selen blokova");
		servisniRadovi.add("Vanjsko pranje vozila");
		servisniRadovi.add("Unutrasnje pranje vozila");
		servisniRadovi.add("Reparacija turbine");
		servisniRadovi.add("Geometrija tockova");
		servisniRadovi.add("Zamjena i popravke izduvnih sistema");
		servisniRadovi.add("Veliki servis");

		checkComboBoxSR = new CheckComboBox<String>(servisniRadovi);
		checkComboBoxSR.setPrefWidth(150);
		checkComboBoxSR.setPrefHeight(25);
		listaKvalifikacijaKontejner.getChildren().add(checkComboBoxSR);
	}

	private void ucitajFotografiju(ActionEvent event) {
		String PUTANJA_DO_SLIKA_KORISNIKA = "image" + File.separator + "Slike radnika" + File.separator;
		FileChooser fileChooser = new FileChooser();

		fileChooser.setTitle("Otvori fotografiju");
		fileChooser.setInitialDirectory(new File(PUTANJA_DO_SLIKA_KORISNIKA));
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.jpg", "*.png"));

		final Node source = (Node) event.getSource();
		File odabranaFotografija = fileChooser.showOpenDialog((Stage) source.getScene().getWindow());

		if (odabranaFotografija != null) {
			String apsolutnaPutanja = odabranaFotografija.getAbsolutePath();
			String roditeljskaPutanja = odabranaFotografija.getParent();
			relativnaPutanjaFotografije = new File(roditeljskaPutanja).toURI()
					.relativize(new File(apsolutnaPutanja).toURI()).getPath();
			relativnaPutanjaFotografije = "." + File.separator + PUTANJA_DO_SLIKA_KORISNIKA + relativnaPutanjaFotografije;
			ivFotografija.setImage(new Image(odabranaFotografija.toURI().toString()));
		}
	}

}
