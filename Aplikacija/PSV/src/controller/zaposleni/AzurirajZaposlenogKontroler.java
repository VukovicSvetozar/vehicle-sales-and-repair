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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import utility.PSVUtilities;

public class AzurirajZaposlenogKontroler {

	@FXML
	private Label funkcijaLabela;

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
	private TextField sifraProdavacPolje;

	@FXML
	private TextField licniBrojDobavljacPolje;

	@FXML
	private TextField licniBrojRukSkladistaPolje;

	@FXML
	private TextField licniBrojRukServisaPolje;

	@FXML
	private ChoiceBox<String> brojSmjene;

	@FXML
	private HBox listaKvalifikacijaKontejner;

	@FXML
	private Button okDugme;

	@FXML
	private Button otkaziDugme;

	ZaposleniDTO odabraniZaposleni = new ZaposleniDTO();
	
	CheckComboBox<String> checkComboBoxZR;
	CheckComboBox<String> checkComboBoxSR;
	ObservableList<String> servisniRadovi;
	String relativnaPutanjaFotografije;
	
	@FXML
	void unesiFotografiju(ActionEvent event) {
		ivFotografija.setSmooth(true);
		ivFotografija.setCache(true);
		fotografijaDugme.setOnAction(e -> ucitajFotografiju(event));
	}

	@FXML
	void potvrdi(ActionEvent event) {
		String JMBOdabranogZaposlenog = odabraniZaposleni.getJmb();

		azurirajPodatke(JMBOdabranogZaposlenog);
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

	public void initData(ZaposleniDTO zaposleni) {
		odabraniZaposleni = zaposleni;
		postaviPolja();
	}

	private void postaviPolja() {

		funkcijaLabela.setText(odabraniZaposleni.getFunkcija());
		jmbPolje.setText(odabraniZaposleni.getJmb());
		imePolje.setText(odabraniZaposleni.getIme());
		prezimePolje.setText(odabraniZaposleni.getPrezime());
		rodjenDate.setValue(odabraniZaposleni.getDatumRodjenja().toLocalDate());
		zaposlenDate.setValue(odabraniZaposleni.getDatumZaposljavanja().toLocalDate());
		ugovorDate.setValue(odabraniZaposleni.getDatumIstekaUgovora().toLocalDate());
		satnicaPolje.setText(odabraniZaposleni.getSatnica().toString());
		lijecnickiDate.setValue(odabraniZaposleni.getLijecnickiPregled().toLocalDate());

		KontaktZaposlenogDTO kz = PSVUtilities.getDAOFactory().getKontaktZaposlenogDAO()
				.kontakt(odabraniZaposleni.getJmb());
		;
		telefonPolje.setText(kz.getTelefon());
		emailPolje.setText(kz.getEmail());
		gradPolje.setText(kz.getGrad());
		adresaPolje.setText(kz.getAdresa());

		onemoguciPolja();
		omoguciSpecijalnaPolja();
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

	private void omoguciSpecijalnaPolja() {
		String izborZaposlenog = odabraniZaposleni.getFunkcija();

		switch (izborZaposlenog) {

		case "Menadzer":
			sifraMenadzerPolje.setDisable(false);
			ziroRacunKontejner.setDisable(false);

			MenadzerDTO menadzer = PSVUtilities.getDAOFactory().getMenadzerDAO().menadzer(odabraniZaposleni.getJmb());
			sifraMenadzerPolje.setText(menadzer.getSifra());

			kreirajListuZiroRacuna();
			ObservableList<ZiroRacunPreduzecaMenadzerDTO> olzrpm = PSVUtilities.getDAOFactory().getZiroRacunPreduzecaMenadzerDAO().
					ziroRacunPreduzecaMenadzer();

			for (ZiroRacunPreduzecaMenadzerDTO zr : olzrpm) {
				if(zr.getMenader().getSifra().equals(menadzer.getSifra())) {
					String s = zr.getZiroRacunPreduzeca().getBrojZiroRacunaPreduzeca();
					checkComboBoxZR.getCheckModel().check(s);
				}
			}
			
			break;

		case "Prodavac":
			sifraProdavacPolje.setDisable(false);
			ProdavacDTO prodavac = PSVUtilities.getDAOFactory().getProdavacDAO().prodavac(odabraniZaposleni.getJmb());
			sifraProdavacPolje.setText(prodavac.getSifra());
			break;

		case "Dobavljac":
			licniBrojDobavljacPolje.setDisable(false);
			break;

		case "Rukovodilac skladista":
			licniBrojRukSkladistaPolje.setDisable(false);
			RukovodilacSkladistaDTO rukSklad = PSVUtilities.getDAOFactory().getRukovodilacSkladistaDAO()
					.rukovodilacSkladista(odabraniZaposleni.getJmb());
			licniBrojRukSkladistaPolje.setText(rukSklad.getLicniBroj());
			break;

		case "Rukovodilac servisa":
			licniBrojRukServisaPolje.setDisable(false);
			RukovodilacServisaDTO rukServ = PSVUtilities.getDAOFactory().getRukovodilacServisaDAO()
					.rukovodilacServisa(odabraniZaposleni.getJmb());
			licniBrojRukServisaPolje.setText(rukServ.getLicniBroj());
			break;

		case "Mehanicar":
			brojSmjene.setDisable(false);
			listaKvalifikacijaKontejner.setDisable(false);

			kreirajListuSmjena();
			MehanicarDTO mehanicar = PSVUtilities.getDAOFactory().getMehanicarDAO()
					.mehanicar(odabraniZaposleni.getJmb());
			brojSmjene.setValue(mehanicar.getBrojSmjene());

			kreirajListuServisnihRadova();
			ObservableList<KvalifikacijaDTO> olkval = PSVUtilities.getDAOFactory().getKvalifikacijaDAO()
					.kvalifikacija();

			for (KvalifikacijaDTO kv : olkval) {
				if(kv.getMehanicar().getZaposleni().getJmb().equals(mehanicar.getZaposleni().getJmb())) {
					String s = kv.getServisniRadovi().getVrstaServisnihRadova();
					checkComboBoxSR.getCheckModel().check(s);
				}
			}
			break;
		}

	}

	private void azurirajPodatke(String jmb) {

		odabraniZaposleni.setJmb(jmbPolje.getText());
		jmbPolje.setEditable(false);
		odabraniZaposleni.setIme(imePolje.getText());
		odabraniZaposleni.setPrezime(prezimePolje.getText());

		LocalDate localDate = rodjenDate.getValue();
		Date datum = Date.valueOf(localDate);
		odabraniZaposleni.setDatumRodjenja(datum);
		rodjenDate.setEditable(false);

		LocalDate localDate2 = zaposlenDate.getValue();
		Date datum2 = Date.valueOf(localDate2);
		odabraniZaposleni.setDatumZaposljavanja(datum2);

		odabraniZaposleni.setSatnica(Double.parseDouble(satnicaPolje.getText()));

		LocalDate localDate3 = lijecnickiDate.getValue();
		Date datum3 = Date.valueOf(localDate3);
		odabraniZaposleni.setLijecnickiPregled(datum3);

		LocalDate localDate4 = ugovorDate.getValue();
		Date datum4 = Date.valueOf(localDate4);
		odabraniZaposleni.setDatumIstekaUgovora(datum4);

		odabraniZaposleni.setFotografija(relativnaPutanjaFotografije);
		
		PSVUtilities.getDAOFactory().getZaposleniDAO().azurirajZaposleni(odabraniZaposleni);

		KontaktZaposlenogDTO kontakt = PSVUtilities.getDAOFactory().getKontaktZaposlenogDAO().kontakt(jmb);
		kontakt.setGrad(gradPolje.getText());
		kontakt.setAdresa(adresaPolje.getText());
		kontakt.setTelefon(telefonPolje.getText());
		kontakt.setEmail(emailPolje.getText());
		kontakt.setZaposleni(odabraniZaposleni);
		PSVUtilities.getDAOFactory().getKontaktZaposlenogDAO().azurirajKontaktZaposlenog(kontakt);

		String izborZaposlenog = odabraniZaposleni.getFunkcija();

		switch (izborZaposlenog) {

		case "Menadzer":
			MenadzerDTO menadzer = PSVUtilities.getDAOFactory().getMenadzerDAO().menadzer(jmb);
			menadzer.setSifra(sifraMenadzerPolje.getText());
			menadzer.setZaposleni(odabraniZaposleni);
			PSVUtilities.getDAOFactory().getMenadzerDAO().azurirajMenadzer(menadzer);
			
			PSVUtilities.getDAOFactory().getZiroRacunPreduzecaMenadzerDAO().obrisiZiroRacunPreduzecaMenadzer(jmb);
			for (String s : checkComboBoxZR.getCheckModel().getCheckedItems()) {
				ZiroRacunPreduzecaDTO ziroRacunPreduzeca = PSVUtilities.getDAOFactory().getZiroRacunPreduzecaDAO().ziroRacunPreduzeca(s);
				ZiroRacunPreduzecaMenadzerDTO ziroRacunPreduzecaMenadzer = new ZiroRacunPreduzecaMenadzerDTO();
				ziroRacunPreduzecaMenadzer.setMenader(menadzer);
				ziroRacunPreduzecaMenadzer.setZiroRacunPreduzeca(ziroRacunPreduzeca);
				PSVUtilities.getDAOFactory().getZiroRacunPreduzecaMenadzerDAO().dodajZiroRacunPreduzecaMenadzer(ziroRacunPreduzecaMenadzer);
			}			
			break;

		case "Prodavac":
			ProdavacDTO prodavac = PSVUtilities.getDAOFactory().getProdavacDAO().prodavac(jmb);
			prodavac.setSifra(sifraProdavacPolje.getText());
			prodavac.setZaposleni(odabraniZaposleni);
			PSVUtilities.getDAOFactory().getProdavacDAO().azurirajProdavac(prodavac);
			break;

		case "Dobavljac":
			break;

		case "Rukovodilac skladista":
			RukovodilacSkladistaDTO rukovodilacSkladista = PSVUtilities.getDAOFactory().getRukovodilacSkladistaDAO()
					.rukovodilacSkladista(jmb);
			rukovodilacSkladista.setLicniBroj(licniBrojRukSkladistaPolje.getText());
			rukovodilacSkladista.setZaposleni(odabraniZaposleni);
			PSVUtilities.getDAOFactory().getRukovodilacSkladistaDAO()
					.azurirajRukovodilacSkladista(rukovodilacSkladista);
			break;

		case "Rukovodilac servisa":
			RukovodilacServisaDTO rukovodilacServisa = PSVUtilities.getDAOFactory().getRukovodilacServisaDAO()
					.rukovodilacServisa(jmb);
			rukovodilacServisa.setLicniBroj(licniBrojRukServisaPolje.getText());
			rukovodilacServisa.setZaposleni(odabraniZaposleni);
			PSVUtilities.getDAOFactory().getRukovodilacServisaDAO().azurirajRukovodilacServisa(rukovodilacServisa);
			break;

		case "Mehanicar":
			MehanicarDTO mehanicar = PSVUtilities.getDAOFactory().getMehanicarDAO().mehanicar(jmb);

			mehanicar.setZaposleni(odabraniZaposleni);
			mehanicar.setBrojSmjene(brojSmjene.getSelectionModel().getSelectedItem());
			PSVUtilities.getDAOFactory().getMehanicarDAO().azurirajMehanicar(mehanicar);

			PSVUtilities.getDAOFactory().getKvalifikacijaDAO().obrisiKvalifikacija(jmb);
			for (String s : checkComboBoxSR.getCheckModel().getCheckedItems()) {
				ServisniRadoviDTO servisniRadovi = new ServisniRadoviDTO(s);
				KvalifikacijaDTO kvalifikacija = new KvalifikacijaDTO();
				kvalifikacija.setMehanicar(mehanicar);
				kvalifikacija.setOpis("opis");
				kvalifikacija.setServisniRadovi(servisniRadovi);
				PSVUtilities.getDAOFactory().getKvalifikacijaDAO().dodajKvalifikacija(kvalifikacija);
			}

			break;

		}

	}

	private void kreirajListuSmjena() {
		brojSmjene.getItems().add("Prva");
		brojSmjene.getItems().add("Druga");
		brojSmjene.getItems().add("Treca");
	}

	private void kreirajListuServisnihRadova() {

		servisniRadovi = FXCollections.observableArrayList();
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
//		File odabranaFotografija = fileChooser.showOpenDialog(rbMehanicar.getScene().getWindow());

		if (odabranaFotografija != null) {
			String apsolutnaPutanja = odabranaFotografija.getAbsolutePath();
			String roditeljskaPutanja = odabranaFotografija.getParent();
			relativnaPutanjaFotografije = new File(roditeljskaPutanja).toURI()
					.relativize(new File(apsolutnaPutanja).toURI()).getPath();
			relativnaPutanjaFotografije = "." + File.separator + PUTANJA_DO_SLIKA_KORISNIKA + relativnaPutanjaFotografije;
			ivFotografija.setImage(new Image(odabranaFotografija.toURI().toString()));
		}
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
	
}
