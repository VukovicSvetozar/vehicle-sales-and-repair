package controller.kupovina_vozila;

import data.dto.prodaja_vozila.DistributerVozilaDTO;
import data.dto.prodaja_vozila.IndividualnoLiceDTO;
import data.dto.prodaja_vozila.KategorijaKlijentaDTO;
import data.dto.prodaja_vozila.KlijentDTO;
import data.dto.prodaja_vozila.KompanijaDTO;
import data.dto.prodaja_vozila.TelefonKlijentaDTO;
import data.dto.prodaja_vozila.ZiroRacunKlijentaDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import utility.PSVUtilities;

public class UnosNovogDistributeraKontroler {

	@FXML
	private RadioButton rb1;

	@FXML
	private TextField prezimePolje;

	@FXML
	private TextField ziroRacunPolje;

	@FXML
	private Button cancelDugme;

	@FXML
	private RadioButton rb2;

	@FXML
	private TextField webPolje;

	@FXML
	private TextField telefon1Polje;

	@FXML
	private ChoiceBox<String> opis1Izbor;

	@FXML
	private ChoiceBox<String> polIzbor;

	@FXML
	private TextField emailPolje;

	@FXML
	private TextField rejtingPolje;

	@FXML
	private Button uReduDugme;

	@FXML
	private TextField imeKompanijePolje;

	@FXML
	private ChoiceBox<String> opis2Izbor;

	@FXML
	private TextField imePolje;

	@FXML
	private TextField gradPolje;

	@FXML
	private TextField drzavaPolje;

	@FXML
	private TextField adresaPolje;

	@FXML
	private ToggleGroup grupa;

	@FXML
	private TextField telefon2Polje;

	KategorijaKlijentaDTO kategorijaKlijenta = new KategorijaKlijentaDTO();
	IndividualnoLiceDTO individualnoLice = new IndividualnoLiceDTO();
	KompanijaDTO kompanija = new KompanijaDTO();
	KlijentDTO klijent = new KlijentDTO();
	TelefonKlijentaDTO telefon1 = new TelefonKlijentaDTO();
	TelefonKlijentaDTO telefon2 = new TelefonKlijentaDTO();
	DistributerVozilaDTO distributer = new DistributerVozilaDTO();
	ZiroRacunKlijentaDTO ziroRacunKlijenta = new ZiroRacunKlijentaDTO();

	@FXML
	void individualniKorisnikOmoguci(ActionEvent event) {
		if (rb1.isSelected()) {
			imePolje.setDisable(false);
			prezimePolje.setDisable(false);
			polIzbor.setDisable(false);
			imeKompanijePolje.setDisable(true);
		} else {
			imePolje.setDisable(true);
			prezimePolje.setDisable(true);
			polIzbor.setDisable(true);
			imeKompanijePolje.setDisable(false);
		}
	}

	@FXML
	void KompanijaOmoguci(ActionEvent event) {
		if (rb2.isSelected()) {
			imePolje.setDisable(true);
			prezimePolje.setDisable(true);
			polIzbor.setDisable(true);
			imeKompanijePolje.setDisable(false);
		} else {
			imePolje.setDisable(false);
			prezimePolje.setDisable(false);
			polIzbor.setDisable(false);
			imeKompanijePolje.setDisable(true);
		}
	}

	@FXML
	void potvrdi(ActionEvent event) {
		if (rb1.isSelected())
			kategorijaKlijenta.setTipKategorije("Individualno lice");
		else
			kategorijaKlijenta.setTipKategorije("Kompanija");

		int idKategorija = PSVUtilities.getDAOFactory().getKategorijaKlijentaDAO()
				.dodajKategorijaKlijenta(kategorijaKlijenta);
		kategorijaKlijenta.setIdKategorija(idKategorija);

		if (rb1.isSelected()) {
			individualnoLice.setKategorijaKlijenta(kategorijaKlijenta);
			individualnoLice.setIme(imePolje.getText());
			individualnoLice.setPrezime(prezimePolje.getText());
			individualnoLice.setPol(polIzbor.getValue().toString());
			PSVUtilities.getDAOFactory().getIndividualnoLiceDAO().dodajIndividualnoLice(individualnoLice);
		} else {
			kompanija.setKategorijaKlijenta(kategorijaKlijenta);
			kompanija.setNaziv(imeKompanijePolje.getText());
			PSVUtilities.getDAOFactory().getKompanijaDAO().dodajKompanija(kompanija);
		}

		klijent.setKategorijaKLijenta(kategorijaKlijenta);
		klijent.setTipKlijenta("Distributer vozila");
		klijent.setAdresa(adresaPolje.getText());
		klijent.setGrad(gradPolje.getText());
		klijent.setDrzava(drzavaPolje.getText());
		klijent.setEmail(emailPolje.getText());
		int idKlijenta = PSVUtilities.getDAOFactory().getKlijentDAO().dodajKlijent(klijent);
		klijent.setIdKlijenta(idKlijenta);

		synchronized (this) {
			telefon1.setKlijent(klijent);
			telefon1.setBrojTelefona(telefon1Polje.getText());
			telefon1.setOpis(opis1Izbor.getValue().toString());
			PSVUtilities.getDAOFactory().getTelefonKlijentaDAO().dodajTelefonKlijenta(telefon1);

			telefon2.setKlijent(klijent);
			telefon2.setOpis(opis2Izbor.getValue().toString());
			telefon2.setBrojTelefona(telefon2Polje.getText());
			PSVUtilities.getDAOFactory().getTelefonKlijentaDAO().dodajTelefonKlijenta(telefon2);
		}

		ziroRacunKlijenta.setKlijent(klijent);
		ziroRacunKlijenta.setBrojZiroRacuna(ziroRacunPolje.getText());
		PSVUtilities.getDAOFactory().getZiroRacunKlijentaDAO().dodajZiroRacunKlijenta(ziroRacunKlijenta);

		distributer.setKlijent(klijent);
		distributer.setRejting(rejtingPolje.getText());
		PSVUtilities.getDAOFactory().getDistributerVozilaDAO().dodajDistributeraVozila(distributer);

		KupovinaVozilaGlavnaStranaKontroler.prikaziTabeluDistributera();
		
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

}
