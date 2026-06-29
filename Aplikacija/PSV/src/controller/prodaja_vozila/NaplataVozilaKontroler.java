package controller.prodaja_vozila;

import java.sql.Date;
import java.time.LocalDate;

import org.controlsfx.control.CheckComboBox;

import data.dto.prodaja_vozila.NaplataKupovineDTO;
import data.dto.prodaja_vozila.ProdajaDTO;
import data.dto.zaposleni.ZiroRacunPreduzecaDTO;
import data.dto.zaposleni.ZiroRacunPreduzecaMenadzerDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import utility.PSVUtilities;

public class NaplataVozilaKontroler {

	@FXML
	private Label ziroRacunKupca;

	@FXML
	private HBox ziroRacunKontejner;

	@FXML
	private Label zaNaplatu;

	@FXML
	private Label preostaliIznos;

	@FXML
	private Label statusPlacanja;

	@FXML
	private Button okDugme;

	@FXML
	private Button cancelDugme;
	
	CheckComboBox<String> checkComboBoxZRP;
	CheckComboBox<String> checkComboBoxZRK;
	
	private NaplataKupovineDTO naplataKupovine = new NaplataKupovineDTO();
	private int idOdabraneProdaje;
	private ProdajaDTO prodaja;
	private int brojIsplata;
	private int brojRata;
	private double realniIznosRate;
	
	@FXML
	void initialize() {
		ucitajPodatke();
		kreirajListuZiroRacunaPreduzeca();
		prikaziPodatke();		
	}
	
	@FXML
	void potvrdi(ActionEvent event) {
		naplataKupovine.setDatumNaplate(Date.valueOf(LocalDate.now()));
		
		naplataKupovine.setProdaja(prodaja);		
		for (String s : checkComboBoxZRP.getCheckModel().getCheckedItems()) {
			ZiroRacunPreduzecaDTO ziroRacunPreduzeca = PSVUtilities.getDAOFactory().getZiroRacunPreduzecaDAO().ziroRacunPreduzeca(s);
			naplataKupovine.setZiroracunpreduzeca(ziroRacunPreduzeca);
		}	
		PSVUtilities.getDAOFactory().getNaplataKupovineDAO().dodajNaplataKupovine(naplataKupovine);
		
		// Azuriranje podataka o prodaji.	
		++brojIsplata;
		prodaja.setStatus_za_naplatu(brojIsplata + "/" + brojRata);		
		
		prodaja.setUkupnoNaplaceno(prodaja.getUkupnoNaplaceno() + realniIznosRate);
		
		if (brojIsplata == brojRata)
			prodaja.setSledecaUplata("Zavrseno");
		else {
			LocalDate localDate = LocalDate.parse(prodaja.getSledecaUplata());
			prodaja.setSledecaUplata(Date.valueOf(localDate.plusDays(30)).toString());
		}
		
		PSVUtilities.getDAOFactory().getProdajaDAO().azurirajProdaja(prodaja);
		
		ProdajaVozilaGlavnaStranaKontroler.prikaziTabeluProdatihVozila();
		Stage stage = (Stage) okDugme.getScene().getWindow();
		stage.close();
	}

	@FXML
	void otkazi(ActionEvent event) {
		Stage stage = (Stage) cancelDugme.getScene().getWindow();
		stage.close();
	}
	
	private void ucitajPodatke() {
		idOdabraneProdaje = ProdajaVozilaGlavnaStranaKontroler.odabranoProdatoVoziloIzTabele.getIdProdaja();
		prodaja = PSVUtilities.getDAOFactory().getProdajaDAO().prodaja(idOdabraneProdaje);
		
		String [] dijeloviStatusa = prodaja.getStatus_za_naplatu().split("/");
		brojIsplata = Integer.parseInt(dijeloviStatusa[0]);
		brojRata = Integer.parseInt(dijeloviStatusa[1]);
		
		realniIznosRate = prodaja.getProdatoVozilo().getCijenaProdaje() / brojRata;
		
	}
	
	private void kreirajListuZiroRacunaPreduzeca() {

		final ObservableList<ZiroRacunPreduzecaMenadzerDTO> ziroRacuni = PSVUtilities.getDAOFactory().getZiroRacunPreduzecaMenadzerDAO()
				.ziroRacunPreduzecaMenadzer();
		final ObservableList<String> brojRacuna = FXCollections.observableArrayList();
	
		int idProdajaOV = ProdajaVozilaGlavnaStranaKontroler.odabranoProdatoVoziloIzTabele.getIdProdaja();
		String sifraMenadzera = PSVUtilities.getDAOFactory().getProdajaDAO().prodaja(idProdajaOV).getUgovor().getMenadzer().getSifra();

		for (ZiroRacunPreduzecaMenadzerDTO zrp : ziroRacuni) {
					if(zrp.getMenader().getSifra().equals(sifraMenadzera))
				brojRacuna.add(zrp.getZiroRacunPreduzeca().getBrojZiroRacunaPreduzeca());
		}		
		checkComboBoxZRP = new CheckComboBox<String>(brojRacuna);
		checkComboBoxZRP.setPrefWidth(150);
		checkComboBoxZRP.setPrefHeight(25);
		ziroRacunKontejner.getChildren().add(checkComboBoxZRP);
	}
	
	private void prikaziPodatke() {
		zaNaplatu.setText(String.format("%.2f", realniIznosRate));
		preostaliIznos.setText(String.format("%.2f", (realniIznosRate * (brojRata - brojIsplata - 1))));
		statusPlacanja.setText((brojIsplata+1) + "/" + brojRata);
	}

}
