package aplisens.view.controllers;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aplisens.db.DbDirector;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class MainController {

	protected final Logger log = LoggerFactory.getLogger(getClass());

	@FXML
	private BorderPane mainBorderPane;

	private TablesController tablesController;

	@FXML
	public void initialize() {
		setWindow("/fxml/Tables.fxml",tablesController);
		log.debug("Wczytano okno Tables");
	}

	@FXML
	public void load() {
		log.info("jeszcze nie ustawiona fnkcjonalność");
	}
	
	@FXML
	public void exit() {
		Platform.exit();
	}

	public void setWindow(String fxmlPath, ViewControllerInterface controller) {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource(fxmlPath));
		Parent window = null;
		try {
			window = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		mainBorderPane.setCenter(window);
		controller = loader.getController();
		controller.setMainController(this);
	}
	
	

	
}
