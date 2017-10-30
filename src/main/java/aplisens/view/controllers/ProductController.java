package aplisens.view.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.fxml.FXML;

public class ProductController implements ViewControllerInterface{

	
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	private MainController mainController;
	
	@FXML
	public void goBack() {
		mainController.setWindow("/fxml/Tables.fxml", new TablesController());
		log.info("Wybrano okno Tables");
	}
	
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	

}
