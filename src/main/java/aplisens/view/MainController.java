package aplisens.view;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class MainController {

	private static final String TABLES_FXML = "/fxml/Tables.fxml";
	private final Logger log = LoggerFactory.getLogger(getClass());
	private TablesController tablesController;

	@FXML
	private BorderPane mainBorderPane;

	@FXML
	public void initialize() {
		setWindow(TABLES_FXML, tablesController);
		log.debug("Wczytano okno Tables");
	}

	@FXML
	public void load() {
		log.error("jeszcze nie ustawiona funkcjonalności");
	}
	
	@FXML
	public void about() {
		log.error("jeszcze nie ustawiona funkcjonalności");
	}

	@FXML
	public void exit() {
		Platform.exit();
	}

	public void setWindow(String fxmlPath, ViewControllersInterface controller) {
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
