package controller.servis_vozila;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
public class ServisVozilaKontroler {

    @FXML
    private Button izlazDugme;

    @FXML
    private TabPane tabKontejner;

    @FXML
    private Tab tab1;

    @FXML
    private Tab tab2;
    
    @FXML
    private Tab tab3;

    @FXML
    private Tab tab4;

    @FXML
	void initialize() {
		try {
			ucitajTab(tab1, "/view/servis_vozila/Zahtjevi.fxml");
			ucitajTab(tab2, "/view/servis_vozila/VozilaNaServisu.fxml");
			ucitajTab(tab3, "/view/servis_vozila/Naplate.fxml");

		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
    
    @FXML
    void izadji(ActionEvent event) {
    	Stage stage = (Stage) izlazDugme.getScene().getWindow();
		stage.close();
    }
    
	/* Pomocna metoda za ucitavanje fxml fajlova u tabove ovog kontrolera.*/
	 
	private void ucitajTab(Tab tab, String fxml) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
		Parent root = loader.load();
		RefreshableController controller = loader.getController();
		
		AnchorPane pane = (AnchorPane) tab.getContent();
		pane.getChildren().add(root);
		AnchorPane.setBottomAnchor(root, 0.0);
		AnchorPane.setLeftAnchor(root, 0.0);
		AnchorPane.setRightAnchor(root, 0.0);
		AnchorPane.setTopAnchor(root, 0.0);
		
		// Azuriraj podatke svaki put kada se otvori dati tab
		tab.setOnSelectionChanged(e -> {
			if (tab.selectedProperty().get())
				controller.refresh();
		});
	}	
	
}
