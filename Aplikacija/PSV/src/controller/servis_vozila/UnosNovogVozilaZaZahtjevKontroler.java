package controller.servis_vozila;

import java.sql.Date;
import java.time.LocalDate;

import data.dto.prodaja_vozila.VozilaDTO;
import data.dto.servis_vozila.ServisnaKnjigaVozilaDTO;
import data.dto.servis_vozila.ZahtjevDTO;
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
import utility.PSVUtilities;

public class UnosNovogVozilaZaZahtjevKontroler {

    @FXML
    private TextField brojServisaPolje;

    @FXML
    private ImageView fotografija;

    @FXML
    private Button cancelDugme;

    @FXML
    private ChoiceBox<String> tipVozilaIzbor;

    @FXML
    private DatePicker datumRegistrovanja;

    @FXML
    private TextField godinaProizvodnjePolje;

    @FXML
    private TextField brojRegistracijePolje;

    @FXML
    private TextArea oPrethodnimPopravkama;

    @FXML
    private Button okDugme;

    @FXML
    private DatePicker datumPoslednjegServisa;

    @FXML
    private TextField bojaPolje;

    @FXML
    private TextField proizvodjacPolje;

    @FXML
    private TextField kilometrazaPolje;

    @FXML
    private TextArea oProblemu;

    @FXML
    private ChoiceBox<String> vrstaGorivaIzbor;

    @FXML
    private Button unesiteFotografijuDugme;

    @FXML
    private TextField modelPolje;

	ZahtjevDTO odabraniZahtjev = new ZahtjevDTO();	
	VozilaDTO vozilo = new VozilaDTO();
	ServisnaKnjigaVozilaDTO servisnaKnjigaVozila = new ServisnaKnjigaVozilaDTO();
	
	@FXML
	void initialize(ActionEvent event) {
		kilometrazaPolje.setText("0");
	}
	
	void initData(ZahtjevDTO zahtjev) {
	    odabraniZahtjev = zahtjev;		
	}
	
    @FXML
    void potvrdi(ActionEvent event) {

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
		servisnaKnjigaVozila.setZahtjev(odabraniZahtjev);
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
