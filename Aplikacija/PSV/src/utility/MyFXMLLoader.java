package utility;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MyFXMLLoader {

	public static void load(Class<?> c, String fxml, String naslov) {
		try {
			Stage s = new Stage();
			Pane root = (Pane) FXMLLoader.load(c.getResource(fxml));
			Scene scene = new Scene(root);
			s.setScene(scene);
			s.setTitle(naslov);
			s.setResizable(false);
			s.initStyle(StageStyle.UNDECORATED);
			s.show();
		} catch (IOException ex) {
			ex.printStackTrace();
			AlertsUtilities.showErrorDialog("Greška", "Greška tokom učitavanja FXML strane!",
					"Na datoj adresi nije moguće učiti FXML stranu.");
		}
	}
}
