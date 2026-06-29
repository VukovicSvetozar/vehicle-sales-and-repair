 package controller.servis_vozila;

import java.sql.Date;
import java.time.LocalDate;

import data.dto.prodaja_vozila.VozilaDTO;
import data.dto.servis_vozila.*;
import data.dto.zaposleni.RukovodilacServisaDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import table.TableKorisnikServisa;
import utility.MyFXMLLoader;
import utility.PSVUtilities;

public class UnosNovogZahtjevaKontroler{


	@FXML  
	Button novoVoziloDugme;
	@FXML
	TextField brojServisaPolje;
	@FXML
	DatePicker datumPoslednjegServisa;
	@FXML
	TextField rukovodilacServisaPolje;
	@FXML
	TextArea oPrethodnimPopravkama;
	@FXML
	TextArea oProblemu;
	@FXML
	Button okDugme;
	@FXML
	Button cancelDugme;
	
	// vozilo
	
	@FXML
	ChoiceBox<String> tipVozilaIzbor;	
	@FXML  
	TextField proizvodjacPolje;
	@FXML
	TextField modelPolje;
	@FXML
	TextField godinaProizvodnjePolje;
	@FXML
	TextField kilometrazaPolje;
	@FXML
	TextField bojaPolje;
	@FXML
	ChoiceBox<String> vrstaGorivaIzbor;
	@FXML
	TextField brojRegistracijePolje;
	@FXML
	DatePicker datumRegistrovanja;
	@FXML
	Button unesiteFotografijuDugme;
	@FXML
	ImageView fotografija;
	

	TableKorisnikServisa odabraniKlijent = new TableKorisnikServisa();
	ZahtjevDTO zahtjev = new ZahtjevDTO();	
	VozilaDTO vozilo = new VozilaDTO();
	ServisnaKnjigaVozilaDTO servisnaKnjigaVozila = new ServisnaKnjigaVozilaDTO();
	
	void initData(TableKorisnikServisa klijent) {
	    odabraniKlijent = klijent;		
	}
	
	
	@FXML
	void initialize(ActionEvent event) {
		kilometrazaPolje.setText("0");
		rukovodilacServisaPolje.setText("1208651234567");
	}
	
	@FXML
	void novoVozilo(ActionEvent event) {
		MyFXMLLoader.load(getClass(), "/view/servis_vozila/UnosNovogVozila.fxml", "Unos novog vozila");
	}
	
	@FXML
	void potvrdi(ActionEvent event) {
		
		int x = odabraniKlijent.getIdKlijenta();
		KorisniciServisaDTO lokalni = PSVUtilities.getDAOFactory().getKorisniciServisaDAO().korisniciServisa(x);
		zahtjev.setKorisnikServisa(lokalni);
		
		LocalDate locald = LocalDate.now();
		Date date = Date.valueOf(locald); 
		zahtjev.setDatumZahtjeva(date);
		zahtjev.setKrajnjiRok(Date.valueOf(locald.plusDays(10)));
		RukovodilacServisaDTO rs = PSVUtilities.getDAOFactory().getRukovodilacServisaDAO().rukovodilacServisa(rukovodilacServisaPolje.getText());
		zahtjev.setRukovodilacServisa(rs);
		int brojZahtjeva = PSVUtilities.getDAOFactory().getZahtjevDAO().dodajZahtjev(zahtjev);
		zahtjev.setBrojZahtjeva(brojZahtjeva);		

		vozilo.setTipVozila(tipVozilaIzbor.getValue().toString());
		vozilo.setProizvodjac(proizvodjacPolje.getText());
		vozilo.setModel(modelPolje.getText());
		vozilo.setKilometraza(Integer.parseInt(kilometrazaPolje.getText()));
		vozilo.setGodinaProizvodnje(Integer.parseInt(godinaProizvodnjePolje.getText()));
		vozilo.setBoja(bojaPolje.getText());
		vozilo.setVrstaGoriva(vrstaGorivaIzbor.getValue().toString());
		vozilo.setBrojRegistracije(brojRegistracijePolje.getText());
		LocalDate localDate = datumRegistrovanja.getValue();
		Date datum = Date.valueOf(localDate); 
		vozilo.setDatumRegistracije(datum);
		//byte[] slika;
		vozilo.setFotografija(null);
		int idVozila = PSVUtilities.getDAOFactory().getVozilaDAO().dodajVozila(vozilo);
		vozilo.setIdVozila(idVozila);
		
		servisnaKnjigaVozila.setVozila(vozilo);
		servisnaKnjigaVozila.setZahtjev(zahtjev);
		servisnaKnjigaVozila.setUkupanBrojServisa(Integer.parseInt(brojServisaPolje.getText()));
		LocalDate localDate2 = datumPoslednjegServisa.getValue();
		Date datum2 = Date.valueOf(localDate2);
		servisnaKnjigaVozila.setDatumPoslednjegServisa(datum2);
		servisnaKnjigaVozila.setOpisRanijihPopravki(oPrethodnimPopravkama.getText());
		servisnaKnjigaVozila.setStatus("Obrada");
		servisnaKnjigaVozila.setOpisProblema(oProblemu.getText());
		
		PSVUtilities.getDAOFactory().getServisnaKnjigaVozilaDAO().dodajServisnaKnjigaVozila(servisnaKnjigaVozila);
		
		
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
