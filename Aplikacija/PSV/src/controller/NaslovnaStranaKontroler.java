package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import utility.MyFXMLLoader;

public class NaslovnaStranaKontroler {

	@FXML
	public Button NaslovnoDugme;

	@FXML
	public ImageView NaslovnaSlikaDugme;

	@FXML
	public synchronized void PokreniAplikaciju(ActionEvent event) {

		MyFXMLLoader.load(getClass(), "/view/KomandnaTabla.fxml", "Komandna Tabla");

	}

}
