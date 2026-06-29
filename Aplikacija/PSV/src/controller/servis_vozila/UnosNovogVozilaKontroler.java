package controller.servis_vozila;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class UnosNovogVozilaKontroler {

	@FXML
	ChoiceBox<?> tipVozilaIzbor;	
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
	ChoiceBox<?> vrstaGorivaIzbor;
	@FXML
	TextField brojRegistracijePolje;
	@FXML
	DatePicker datumRegistrovanja;
	@FXML
	Button unesiteFotografijuDugme;
	@FXML
	ImageView fotografija;
	@FXML
	Button okDugme;
	@FXML
	Button cancelDugme;
//	
//	KategorijaKlijentaDTO kategorijaKlijenta = new KategorijaKlijentaDTO();
//	IndividualnoLiceDTO individualnoLice = new IndividualnoLiceDTO();
//	KompanijaDTO kompanija = new KompanijaDTO();
//	KlijentDTO klijent = new KlijentDTO();
//	TelefonKlijentaDTO telefon1 = new TelefonKlijentaDTO();
//	TelefonKlijentaDTO telefon2 = new TelefonKlijentaDTO();
//	KorisniciServisaDTO korisniciServisa = new KorisniciServisaDTO();
//	ZiroRacunKlijentaDTO ziroRacunKlijenta = new ZiroRacunKlijentaDTO();
//	
	
	@FXML
	void potvrdi(ActionEvent event) {
//		
//		if(rb1.isSelected())
//			kategorijaKlijenta.setTipKategorije("Individualno lice");
//		else
//			kategorijaKlijenta.setTipKategorije("Kompanija");
//		int idKategorija = PSVUtilities.getDAOFactory().getKategorijaKlijentaDAO().dodajKategorijaKlijenta(kategorijaKlijenta);
//		kategorijaKlijenta.setIdKategorija(idKategorija);
//		
//		if(rb1.isSelected()) {
//			individualnoLice.setKategorijaKlijenta(kategorijaKlijenta);
//			individualnoLice.setIme(imePolje.getText());
//			individualnoLice.setPrezime(prezimePolje.getText());
//			individualnoLice.setPol(polIzbor.getValue().toString());	
//			PSVUtilities.getDAOFactory().getIndividualnoLiceDAO().dodajIndividualnoLice(individualnoLice);
//		}
//		else {
//			kompanija.setKategorijaKlijenta(kategorijaKlijenta);
//			kompanija.setNaziv(imeKompanijePolje.getText());
//			PSVUtilities.getDAOFactory().getKompanijaDAO().dodajKompanija(kompanija);
//		}
//	
//		klijent.setKategorijaKLijenta(kategorijaKlijenta);
//		klijent.setTipKlijenta("Korisnik servisa");
//		klijent.setAdresa(adresaPolje.getText());
//		klijent.setGrad(gradPolje.getText());
//		klijent.setDrzava(drzavaPolje.getText());
//		klijent.setEmail(emailPolje.getText());
//		int idKlijenta = PSVUtilities.getDAOFactory().getKlijentDAO().dodajKlijent(klijent);
//		klijent.setIdKlijenta(idKlijenta);
//		
//		synchronized(this) {
//			telefon1.setKlijent(klijent);
//			telefon1.setBrojTelefona(telefon1Polje.getText());	
//			telefon1.setOpis(opis1Izbor.getValue().toString());		
//			PSVUtilities.getDAOFactory().getTelefonKlijentaDAO().dodajTelefonKlijenta(telefon1);
//			
//			telefon2.setKlijent(klijent);
//			telefon2.setOpis(opis2Izbor.getValue().toString());
//			telefon2.setBrojTelefona(telefon2Polje.getText());		
//			PSVUtilities.getDAOFactory().getTelefonKlijentaDAO().dodajTelefonKlijenta(telefon2);
//		}
//		ziroRacunKlijenta.setKlijent(klijent);
//		ziroRacunKlijenta.setBrojZiroRacuna(ziroRacunPolje.getText());
//		PSVUtilities.getDAOFactory().getZiroRacunKlijentaDAO().dodajZiroRacunKlijenta(ziroRacunKlijenta);
//		
//		korisniciServisa.setKlijent(klijent);
//		korisniciServisa.setNapomenaKorisnika(oKorisniku.getText());
//		PSVUtilities.getDAOFactory().getKorisniciServisaDAO().dodajKorisniciServis(korisniciServisa);
//				
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
