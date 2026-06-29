package controller.kupovina_vozila;

import java.sql.Date;
import java.time.LocalDate;

import data.dto.prodaja_vozila.NabavkaVozilaDTO;
import data.dto.prodaja_vozila.VozilaDTO;
import data.dto.prodaja_vozila.VoziloUVlasnistvuDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import utility.PSVUtilities;

public class KupovinaVozilaKontroler {

    @FXML
    private ImageView fotografija;

    @FXML
    private Button cancelDugme;

    @FXML
    private ChoiceBox<String> tipVozilaIzbor;

    @FXML
    private RadioButton rb2oc;

    @FXML
    private DatePicker datumRegistrovanja;

    @FXML
    private RadioButton rb1oc;

    @FXML
    private TextField godinaProizvodnjePolje;

    @FXML
    private TextField brojRegistracijePolje;

    @FXML
    private RadioButton rb2tp;

    @FXML
    private Button okDugme;

    @FXML
    private RadioButton rb1tp;

    @FXML
    private TextField bojaPolje;

    @FXML
    private TextField proizvodjacPolje;

    @FXML
    private TextField cijenaNabavkePolje;

    @FXML
    private TextField brojGarazePolje;

    @FXML
    private ToggleGroup grupa1;

    @FXML
    private RadioButton rb2sv;

    @FXML
    private TextField kilometrazaPolje;

    @FXML
    private RadioButton rb1sv;

    @FXML
    private ToggleGroup grupa2;

    @FXML
    private ToggleGroup grupa3;

    @FXML
    private ChoiceBox<?> vrstaGorivaIzbor;

    @FXML
    private Button unesiteFotografijuDugme;

    @FXML
    private TextField modelPolje;
    
	VozilaDTO vozilo = new VozilaDTO();
	VoziloUVlasnistvuDTO voziloUVlasnistvu = new VoziloUVlasnistvuDTO();
	NabavkaVozilaDTO nabavkaVozila = new NabavkaVozilaDTO();

    @FXML
    void tehnickaProvjeraPostoji(ActionEvent event) {

    }

    @FXML
    void tehnickaProvjeraNePostoji(ActionEvent event) {

    }

    @FXML
    void novoVozilo(ActionEvent event) {

    }


    @FXML
    void polovnoVozilo(ActionEvent event) {

    }

    @FXML
    void ocarinjenoDa(ActionEvent event) {

    }

    @FXML
    void ocarinjenoNe(ActionEvent event) {

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
		
		voziloUVlasnistvu.setVozila(vozilo);
		LocalDate locald = LocalDate.now();
		Date date = Date.valueOf(locald); 
		voziloUVlasnistvu.setDatumNabavke(date);
		voziloUVlasnistvu.setCijenaNabavke(Double.parseDouble(cijenaNabavkePolje.getText()));
		voziloUVlasnistvu.setStatus_Za_Prodaju("Ponuda");
		voziloUVlasnistvu.setKupac(null);
		voziloUVlasnistvu.setBrojGaraze(Integer.parseInt(brojGarazePolje.getText()));
		if (rb1tp.isSelected())
			voziloUVlasnistvu.setTehnickaProvjera("Realizovana");
		else
			voziloUVlasnistvu.setTehnickaProvjera("Nije realizovana");
		if (rb1sv.isSelected())
			voziloUVlasnistvu.setStanjeVozila("Novo");
		else
			voziloUVlasnistvu.setStanjeVozila("Polovno");
		if (rb1tp.isSelected())
			voziloUVlasnistvu.setOcarinjeno("Da");
		else
			voziloUVlasnistvu.setOcarinjeno("Ne");
		
		PSVUtilities.getDAOFactory().getVoziloUVlasnistvuDAO().dodajVoziloUVlasnistvu(voziloUVlasnistvu);
		
		nabavkaVozila.setDatumNabavke(date);
		nabavkaVozila.setCijenaNabavke(Double.parseDouble(cijenaNabavkePolje.getText()));
		nabavkaVozila.setVoziloUVlasnistvu(voziloUVlasnistvu);
		nabavkaVozila.setDistributer(KupovinaVozilaGlavnaStranaKontroler.odabraniDistributer);
		PSVUtilities.getDAOFactory().getNabavkaVozilaDAO().dodajNabavka(nabavkaVozila);		
		
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
