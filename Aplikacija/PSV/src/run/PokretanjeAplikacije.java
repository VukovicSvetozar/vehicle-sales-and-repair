package run;

import javafx.application.Application;
import javafx.stage.Stage;
import utility.MyFXMLLoader;

public class PokretanjeAplikacije extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		MyFXMLLoader.load(getClass(), "/view/NaslovnaStrana.fxml", "Naslovna Strana");
	}

	public static void main(String[] args) {
		launch(args);
	}

}
