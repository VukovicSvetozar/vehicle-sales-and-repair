package controller.servis_vozila;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class NaplateKontroler implements RefreshableController{

    @FXML
    private Button dugmeNaplati;

    @FXML
    private TableColumn<?, ?> kolonaBrojUsluge;

    @FXML
    private TableColumn<?, ?> kolonaImeKlijenta;

    @FXML
    private TableColumn<?, ?> kolonaDatumRealizacije;

    @FXML
    private TableView<?> tabelaRealizovaneUsluge;

    @FXML
    private TableColumn<?, ?> kolonaIdVozila;

    @FXML
    private Button dugmePopust;

    @FXML
    private TableColumn<?, ?> kolonaServisniRadovi;

    @FXML
    private TableColumn<?, ?> kolonaBrojNaplate;

    @FXML
    private TableColumn<?, ?> kolonaStatus;

    @FXML
    private TableColumn<?, ?> kolonaCijenaUsluge;

    @FXML
    private TableColumn<?, ?> kolonaDatumPrijema;

    @FXML
    private TableView<?> tabelaListaNaplata;

    @FXML
    private TableColumn<?, ?> kolonaModel;

    @FXML
    private Button dugmeDodatneUsluge;

    @FXML
    private TableColumn<?, ?> kolonaIdKlijenta;

    @FXML
    void dodatneUsluge(ActionEvent event) {

    }

    @FXML
    void naplati(ActionEvent event) {

    }

    @FXML
    void popust(ActionEvent event) {

    }

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}

}
