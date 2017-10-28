package aplisens.view;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class View extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("/Scenka.fxml"));
		Pane stackPane = loader.load();

		// Controller controller = loader.getController();

		Scene scene = new Scene(stackPane);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Aplisens");
		primaryStage.show();
	}

}
