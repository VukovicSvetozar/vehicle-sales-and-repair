package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import utility.MyFXMLLoader;

public class KomandnaTablaKontroler {

	@FXML
	public Button PregledVozilaDugme;

	@FXML
	public ImageView PregledVozilaSlika;

	@FXML
	public Button ProdajaVozilaDugme;

	@FXML
	public ImageView ProdajaVozilaSlika;

	@FXML
	public Button KupovinaVozilaDugme;

	@FXML
	public ImageView KupovinaVozilaSlika;

	@FXML
	public Button ServisVozilaDugme;

	@FXML
	public ImageView ServisVozilaSlika;

	@FXML
	public Button KlijentiDugme;

	@FXML
	public ImageView KlijentiSlika;

	@FXML
	public Button ZaposleniDugme;

	@FXML
	public ImageView ZaposleniSlika;

	@FXML
	public Button IzvjestajiDugme;

	@FXML
	public ImageView IzvjestajiSlika;

	@FXML
	public Button PodesavanjaDugme;

	@FXML
	public ImageView PodesavanjaaSlika;

	@FXML
	public Button IzlazDugme;

	@FXML
	public ImageView IzlazSlika;

	@FXML
	public synchronized void PokreniPregledVozila(ActionEvent event) {
		MyFXMLLoader.load(getClass(), "/view/pregled_vozila/PregledVozila.fxml", "Pregled Vozila");
	}

	@FXML
	public synchronized void PokreniProdajaVozila(ActionEvent event) {
		MyFXMLLoader.load(getClass(), "/view/prodaja_vozila/ProdajaVozilaGlavnaStrana.fxml", "Prodaja Vozila");
	}

	@FXML
	public synchronized void PokreniKupovinaVozila(ActionEvent event) {
		MyFXMLLoader.load(getClass(), "/view/kupovina_vozila/KupovinaVozilaGlavnaStrana.fxml", "Kupovina Vozila");
	}

	@FXML
	public synchronized void PokreniServisVozila(ActionEvent event) {
		MyFXMLLoader.load(getClass(), "/view/servis_vozila/ServisVozila.fxml", "Servis Vozila");
	}

	@FXML
	public synchronized void PokreniKlijenti(ActionEvent event) {
		MyFXMLLoader.load(getClass(), "/view/klijenti/PregledKlijenata.fxml", "Klijenti");
	}

	@FXML
	public synchronized void PokreniZaposleni(ActionEvent event) {
		MyFXMLLoader.load(getClass(), "/view/zaposleni/ZaposleniGlavnaStrana.fxml", "Zaposleni radnici");
	}

	@FXML
	public synchronized void PokreniIzvjestaj(ActionEvent event) {
		// MyFXMLLoader.load(getClass(), "/view/Izvjestaj.fxml", "Izvjestaj");
	}

	@FXML
	public synchronized void PokreniPodesavanja(ActionEvent event) {
		// MyFXMLLoader.load(getClass(), "/view/Podesavanja.fxml", "Podesavanja");
	}

	@FXML
	public synchronized void PokreniIzlaz(ActionEvent event) {
		Platform.exit();
	}

}
