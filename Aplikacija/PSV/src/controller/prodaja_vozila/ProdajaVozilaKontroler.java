package controller.prodaja_vozila;

import java.sql.Date;
import java.time.LocalDate;

import data.dto.prodaja_vozila.*;
import data.dto.zaposleni.BankaDTO;
import data.dto.zaposleni.MenadzerDTO;
import data.dto.zaposleni.ProdavacDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import utility.PSVUtilities;

public class ProdajaVozilaKontroler {

	@FXML
	private Button cancelDugme;

	@FXML
	private TextField iznosPolisePolje;
	
    @FXML
    private TextField marzaPolje;

	@FXML
	private Label osnovnaCijenaLabela;

	@FXML
	private TextField nazivBankePolje;

	@FXML
	private TextField nazivOsiguranjePolje;

	@FXML
	private TextField periodOtplatePolje;

	@FXML
	private ChoiceBox<String> cbSifraMenadzera;

	@FXML
	private Label ukupnaCijenaLabela;

	@FXML
	private RadioButton rbOsiguranjeDa;

	@FXML
	private Label labelaIznosPlacanja;

	@FXML
	private Button okDugme;

	@FXML
	private TextField periodGarancijePolje;

	@FXML
	private RadioButton rbPrekoBanke;

	@FXML
	private TextField jibOsiguranjePolje;

	@FXML
	private TextField periodPolisePolje;

	@FXML
	private RadioButton rbOsiguranjeNe;

	@FXML
	private ToggleGroup grupa2;

	@FXML
	private Label labelaIznosOsnovneRate;

	@FXML
	private ToggleGroup grupa;

	@FXML
	private TextField jibBankePolje;

	@FXML
	private ChoiceBox<String> cbSifraProdavaca;

	@FXML
	private RadioButton rbDirektno;

	@FXML
	private Label labelaIznosRata;
	
	private ProdavacDTO prodavac = new ProdavacDTO();
	private MenadzerDTO menadzer = new MenadzerDTO();
	private ProdataVozilaDTO prodatoVozilo = new ProdataVozilaDTO();
	private UgovorDTO ugovor = new UgovorDTO();
	private ProdajaDTO prodaja = new ProdajaDTO();
	private KreditDTO kredit = new KreditDTO();
	private BankaDTO banka = new BankaDTO();
	private PolisaOsiguranjaDTO polisa = new PolisaOsiguranjaDTO();
	private OsiguravajuceDrustvoDTO osiguravajuceDrustvo = new OsiguravajuceDrustvoDTO();

	private VoziloUVlasnistvuDTO voziloZaProdaju = PSVUtilities.getDAOFactory().getVoziloUVlasnistvuDAO()
			.voziloUVlasnistvu(ProdajaVozilaGlavnaStranaKontroler.odabranoVozilo.getVozila().getIdVozila());
	private KupacDTO kupac = PSVUtilities.getDAOFactory().getKupacDAO()
			.kupac(ProdajaVozilaGlavnaStranaKontroler.odabranoVozilo.getKupac().getKlijent().getIdKlijenta());

	private Integer brojRata=1;
	private Double iznosOsnovneRate;
	private Double osnovnaCijenaVozila;
	private Double ukupnaCijenaVozila;

	@FXML
	void initialize() {
		
		kreirajListuSifaraProdavaca();
		kreirajListuSifaraMenadzera();
		osnovnaCijenaVozila = voziloZaProdaju.getCijenaNabavke();
		osnovnaCijenaLabela.setText(Double.toString(osnovnaCijenaVozila));
		periodGarancijePolje.setText("0");
		labelaIznosRata.setText("1");
		marzaPolje.setText("10");
		labelaIznosPlacanja.setText(String.format("%.2f", obracunajUkupnuCijenu()));
		ukupnaCijenaLabela.setText(String.format("%.2f", obracunajUkupnuCijenu()));
		
	}

	@FXML
	void direktnoOmoguci(ActionEvent event) {
		nazivBankePolje.setDisable(true);
		jibBankePolje.setDisable(true);
		periodOtplatePolje.setDisable(true);
		labelaIznosOsnovneRate.setDisable(true);
		
		brojRata = 1;
		labelaIznosRata.setText(brojRata.toString());
		labelaIznosPlacanja.setText(String.format("%.2f", obracunajUkupnuCijenu()));
		ukupnaCijenaLabela.setText(String.format("%.2f", obracunajUkupnuCijenu()));
	}

	@FXML
	void prekoBankeOmoguci(ActionEvent event) {
		nazivBankePolje.setDisable(false);
		jibBankePolje.setDisable(false);
		periodOtplatePolje.setDisable(false);
		labelaIznosOsnovneRate.setDisable(false);
		
		if(! periodOtplatePolje.getText().equals(""))
			brojRata = Integer.parseInt(periodOtplatePolje.getText());
		labelaIznosRata.setText(brojRata.toString());
		labelaIznosPlacanja.setText(String.format("%.2f", obracunajUkupnuCijenu()/brojRata));
		ukupnaCijenaLabela.setText(String.format("%.2f", obracunajUkupnuCijenu()));
	}

	@FXML
	void osiguranjeDaOmoguci(ActionEvent event) {
		nazivOsiguranjePolje.setDisable(false);
		jibOsiguranjePolje.setDisable(false);
		periodPolisePolje.setDisable(false);
		iznosPolisePolje.setDisable(false);
	}

	@FXML
	void osiguranjeNeOmoguci(ActionEvent event) {
		nazivOsiguranjePolje.setDisable(true);
		jibOsiguranjePolje.setDisable(true);
		periodPolisePolje.setDisable(true);
		iznosPolisePolje.setDisable(true);
	}

	@FXML
	void prikaziIznosPocetneRate(KeyEvent event) {
	
		if (periodOtplatePolje.getText().equals("")) {
			labelaIznosRata.setText("1");
			labelaIznosPlacanja.setText(String.format("%.2f", obracunajUkupnuCijenu()));
			ukupnaCijenaLabela.setText(String.format("%.2f", obracunajUkupnuCijenu()));
		}
		else
			brojRata = Integer.parseInt(periodOtplatePolje.getText());
		iznosOsnovneRate = izracunajMjesecnuRatu(brojRata);
		labelaIznosOsnovneRate.setText(String.format("%.2f", iznosOsnovneRate));
		labelaIznosRata.setText(periodOtplatePolje.getText());
		labelaIznosPlacanja.setText(String.format("%.2f", obracunajUkupnuCijenu()/brojRata));
		ukupnaCijenaLabela.setText(String.format("%.2f", obracunajUkupnuCijenu()));
	}

    @FXML
    void prikaziIznosePlacanja(KeyEvent event) {	
		iznosOsnovneRate = izracunajMjesecnuRatu(brojRata);
		labelaIznosRata.setText(brojRata.toString());
		labelaIznosPlacanja.setText(String.format("%.2f", obracunajUkupnuCijenu()/brojRata));
		ukupnaCijenaLabela.setText(String.format("%.2f", obracunajUkupnuCijenu()));	
    }

	@FXML
	void potvrdi(ActionEvent event) {

		String sifraProdavaca = cbSifraProdavaca.getSelectionModel().getSelectedItem();
		String sifraMenadzera = cbSifraMenadzera.getSelectionModel().getSelectedItem();
		prodavac = PSVUtilities.getDAOFactory().getProdavacDAO().prodavacSifra(sifraProdavaca);
		menadzer = PSVUtilities.getDAOFactory().getMenadzerDAO().menadzerSifra(sifraMenadzera);

//		voziloZaProdaju.setStatus_Za_Prodaju("Prodato");
		voziloZaProdaju.setStatus_Za_Prodaju(String.format("%.2f", obracunajUkupnuCijenu()));
		PSVUtilities.getDAOFactory().getVoziloUVlasnistvuDAO().azurirajVoziloUVlasnistvu(voziloZaProdaju);

		prodatoVozilo.setPeriodGarancije(Integer.parseInt(periodGarancijePolje.getText()));

		VozilaDTO vozilo = PSVUtilities.getDAOFactory().getVozilaDAO().vozila(voziloZaProdaju.getVozila().getIdVozila());
		prodatoVozilo.setVozila(vozilo);
		prodatoVozilo.setCijenaProdaje(0.0); 	// naknadni obracun i azuriranje
		PSVUtilities.getDAOFactory().getProdataVozilaDAO().dodajProdataVozila(prodatoVozilo);

		ugovor.setDatumSklapanjaUgovora(Date.valueOf(LocalDate.now()));
		ugovor.setMenadzer(menadzer);
		int idUgovora = PSVUtilities.getDAOFactory().getUgovorDAO().dodajUgovor(ugovor);
		ugovor = PSVUtilities.getDAOFactory().getUgovorDAO().ugovor(idUgovora);

		prodaja.setKupac(kupac);
		prodaja.setProdatoVozilo(prodatoVozilo);
		prodaja.setProdavac(prodavac);
		prodaja.setUkupnoNaplaceno(0.0);
		prodaja.setNacinPlacanja("Nepoznato");		// naknadno azuriranje
		prodaja.setStatus_za_naplatu("0/1");		// naknadni obracun i azuriranje
		prodaja.setDatumProdaje(Date.valueOf(LocalDate.now()));
		prodaja.setSledecaUplata(Date.valueOf(LocalDate.now().plusDays(3)).toString());
		prodaja.setUgovor(ugovor);
		int x = PSVUtilities.getDAOFactory().getProdajaDAO().dodajProdaja(prodaja);
		prodaja = PSVUtilities.getDAOFactory().getProdajaDAO().prodaja(x);
		
		if (rbPrekoBanke.isSelected()) {			
			banka.setJib(jibBankePolje.getText());
			banka.setNaziv(nazivBankePolje.getText());

			BankaDTO novaBanka = PSVUtilities.getDAOFactory().getBankaDAO().banka(banka.getJib());
			if (novaBanka == null)
				PSVUtilities.getDAOFactory().getBankaDAO().dodajBanka(banka);
			else
				PSVUtilities.getDAOFactory().getBankaDAO().azurirajBanka(banka);

			kredit.setBanka(banka);
			kredit.setProdaja(prodaja);
			kredit.setBrojRata(Integer.parseInt(periodOtplatePolje.getText()));
			iznosOsnovneRate = izracunajMjesecnuRatu(Integer.parseInt(periodOtplatePolje.getText()));
			kredit.setIznosRateKredita(iznosOsnovneRate);
			PSVUtilities.getDAOFactory().getKreditDAO().dodajKredit(kredit);
			
			prodaja.setNacinPlacanja("Kredit");
			prodaja.setStatus_za_naplatu("0/" + kredit.getBrojRata());
			PSVUtilities.getDAOFactory().getProdajaDAO().azurirajProdaja(prodaja);
		} else {
			prodaja.setNacinPlacanja("Gotovina");
			PSVUtilities.getDAOFactory().getProdajaDAO().azurirajProdaja(prodaja);
		}

		if (rbOsiguranjeDa.isSelected()) {
			osiguravajuceDrustvo.setJib(jibOsiguranjePolje.getText());
			osiguravajuceDrustvo.setNaziv(nazivOsiguranjePolje.getText());
			
			Boolean osiguravajuceDrustvoPostoji = PSVUtilities.getDAOFactory().getOsiguravajuceDrustvoDAO()
					.azurirajOsiguravajuceDrustvo(osiguravajuceDrustvo);
			if (!osiguravajuceDrustvoPostoji)
				PSVUtilities.getDAOFactory().getOsiguravajuceDrustvoDAO()
						.dodajOsiguravajuceDrustvo(osiguravajuceDrustvo);

			polisa.setOdobrenIznos(Double.parseDouble(iznosPolisePolje.getText()));
			polisa.setPeriodReklamacije(Integer.parseInt(periodPolisePolje.getText()));
			polisa.setOsiguravajuceDrustvo(osiguravajuceDrustvo);
			polisa.setProdaja(prodaja);
			PSVUtilities.getDAOFactory().getPolisaOsiguranjaDAO().dodajPolisaOsiguranja(polisa);

		}

		prodatoVozilo.setCijenaProdaje(obracunajUkupnuCijenu()); 
		PSVUtilities.getDAOFactory().getProdataVozilaDAO().azurirajProdataVozila(prodatoVozilo);
		
		ProdajaVozilaGlavnaStranaKontroler.prikaziTabeluVozilaUVlasnistvu();
		ProdajaVozilaGlavnaStranaKontroler.prikaziTabeluProdatihVozila();
		
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


	private void kreirajListuSifaraProdavaca() {
		ObservableList<ProdavacDTO> listaProdavaca = PSVUtilities.getDAOFactory().getProdavacDAO().prodavac();
		for (ProdavacDTO prodavac : listaProdavaca)
			cbSifraProdavaca.getItems().add(prodavac.getSifra());
	}


	private void kreirajListuSifaraMenadzera() {
		ObservableList<MenadzerDTO> listaMenadzera = PSVUtilities.getDAOFactory().getMenadzerDAO().menadzer();
		for (MenadzerDTO menadzer : listaMenadzera)
			cbSifraMenadzera.getItems().add(menadzer.getSifra());
	}


	private double izracunajMjesecnuRatu(int brojRata) {
		return ukupnaCijenaVozila / brojRata;
	}


	private Double obracunajUkupnuCijenu() {
		// za svaki dan garancije uvecaj cijenu za 0.01%
		int periodGarancije = 0;
		if (!periodGarancijePolje.getText().equals(""))
			periodGarancije = Integer.parseInt(periodGarancijePolje.getText());
		ukupnaCijenaVozila = osnovnaCijenaVozila + osnovnaCijenaVozila / 10000 * periodGarancije;
		
		// dodaj marzu na cijenu vozila
		int iznosMarze = 10;
		if (!marzaPolje.getText().equals(""))
			iznosMarze = Integer.parseInt(marzaPolje.getText());
		ukupnaCijenaVozila += osnovnaCijenaVozila * iznosMarze / 100;
		
		// za direktno placanje umanji cijenu za 3%
		if (rbDirektno.isSelected())
			ukupnaCijenaVozila -= ukupnaCijenaVozila / 97;
		// za placanje preko banke uvecaj cijenu za 1.5%
		else
			ukupnaCijenaVozila += ukupnaCijenaVozila / 98.5;

		return ukupnaCijenaVozila;
	}

}
