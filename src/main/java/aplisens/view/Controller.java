package aplisens.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

	@FXML
	private Button przycisk1;

	public Controller() {
		System.out.println("Działa?");
	}

	@FXML
	void initialize() {
		przycisk1.setText("naciśnij");
	}
	
	@FXML
	public void akcja2(ActionEvent e) {
		
		System.out.println("Napis"+e.getSource());
		
	}
}
