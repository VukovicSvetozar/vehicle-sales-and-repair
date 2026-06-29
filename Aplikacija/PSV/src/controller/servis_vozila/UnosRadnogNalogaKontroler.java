package controller.servis_vozila;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;

public class UnosRadnogNalogaKontroler {

    @FXML
    private RadioButton rb1;

    @FXML
    private TableColumn<?, ?> kolonaPrezime1;

    @FXML
    private TableView<?> tabelaOdabraniMehanicari;

    @FXML
    private Button cancelDugme;

    @FXML
    private RadioButton rb3;

    @FXML
    private RadioButton rb2;

    @FXML
    private TableColumn<?, ?> kolonaPrezime2;

    @FXML
    private TableColumn<?, ?> kolonaZauzet1;

    @FXML
    private TableColumn<?, ?> kolonaZauzet2;

    @FXML
    private Button naprijedDugme;

    @FXML
    private TableView<?> tabelaDostupniMehanicari;

    @FXML
    private Button okDugme;

    @FXML
    private Label tabekaAktiviranih;

    @FXML
    private TableColumn<?, ?> kolonaIme2;

    @FXML
    private TableColumn<?, ?> kolonaIme1;

    @FXML
    private Button nazadPolje;

    @FXML
    private ToggleGroup grupa;

    @FXML
    private ChoiceBox<?> izborServisniRadovi;

    @FXML
    void potvrdiRadniNalog(ActionEvent event) {

    }

    @FXML
    void otkaziRadniNalog(ActionEvent event) {

    }

    @FXML
    void aktivirajMehanicara(ActionEvent event) {

    }

    @FXML
    void otkaziMehanicara(ActionEvent event) {

    }

}
