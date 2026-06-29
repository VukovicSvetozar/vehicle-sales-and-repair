package controller.servis_vozila;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class UnosNovogVozilaNaServisuKontroler {

    
    @FXML
    private RadioButton rbPrihvacen;

    @FXML
    private Label labelaProizvodjac;

    @FXML
    private TextField procjenaTroskovaPolje;

    @FXML
    private Label labelaTipVozila;

    @FXML
    private Label labelaModel;

    @FXML
    private Button cancelDugmeObrada;

    @FXML
    private Label labelaGodinaProizvodnje;

    @FXML
    private RadioButton rbNaCekanju;

    @FXML
    private TextField licniBroj;

    @FXML
    private RadioButton rbOdbijen;

    @FXML
    private Button okDugmeObrada;

    @FXML
    private ToggleGroup grupa;

    @FXML
    private DatePicker procjenaZavrsetka;


    @FXML
    void naCekanju(ActionEvent event) {

    }

    @FXML
    void prihvacen(ActionEvent event) {

    }

    @FXML
    void odbijen(ActionEvent event) {

    }
    @FXML
    void potvrdiObrada(ActionEvent event) {

    }

    @FXML
    void otkaziObrada(ActionEvent event) {

    }

    @FXML
    void initialize() {
     
    }
}
