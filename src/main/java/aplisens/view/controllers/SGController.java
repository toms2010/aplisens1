package aplisens.view.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aplisens.db.DbDirector;
import aplisens.db.listsTypes.ProductParameters;
import aplisens.db.listsTypes.ProductVersion;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.converter.NumberStringConverter;
import toms.aplisens1.Logic;

public class SGController implements ViewControllerInterface {

	protected final Logger log = LoggerFactory.getLogger(getClass());
	private MainController mainController;
	private DbDirector dbDirector = new DbDirector();
	private Properties properties = Properties.getInstance();
	private Logic logic = new Logic();

	@FXML
	private Label productName;
	@FXML
	private TextField range;
	@FXML
	private TextField length;
	@FXML
	private ChoiceBox<String> cableType;
	@FXML
	private TextField price;

	@FXML
	private CheckBox checkBox1;
	@FXML
	private CheckBox checkBox2;
	@FXML
	private CheckBox checkBox3;
	@FXML
	private CheckBox checkBox4;
	@FXML
	private CheckBox checkBox5;

	@FXML
	private TableView<ProductParameters> parametersTableView;
	@FXML
	private TableColumn<ProductParameters, String> parametersNameColumn;
	@FXML
	private TableColumn<ProductParameters, String> parametersValueColumn;

	@FXML
	public void initialize() {
// --------Rodzaje kabli
		cableType.getItems().addAll("PCV", "Teflon", "Inny", "Jeszcze inny");
		cableType.getSelectionModel().selectFirst();
		cableType.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				properties.setCableType(new SimpleStringProperty(newValue));
			}
		});
// --------Wykonania -- ok
		checkBoxText();
		checkBoxBinds();
// --------Nagłówek --- ok
		productName.setText(properties.getModelTag().get());
		range.textProperty().bindBidirectional(properties.getRange(), new NumberStringConverter());
		length.textProperty().bindBidirectional(properties.getLength(), new NumberStringConverter());
// --------Tabela ProductParameters -ok
		ObservableList<ProductParameters> data = FXCollections
				.observableArrayList(dbDirector.odczytParameters().getDbList());
		parametersNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		parametersValueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
		parametersTableView.setItems(data);
		price.textProperty().bindBidirectional(properties.getPrice(), new NumberStringConverter());
	}

	@FXML
	public void goBack() {
		Properties.resetProperties();
		mainController.setWindow("/fxml/Tables.fxml", new TablesController());
		log.info("Wybrano okno Tables");
	}

	@FXML
	public void countPrice() {
		log.debug(properties.getCableType().get());
		logic.wyswietl();
		log.error("Wybrano okno Tables");
	}

	public void checkBoxText() {
		List<ProductVersion> versionList = new ArrayList<>();
		versionList = dbDirector.odczytVersion().getDbList();
		checkBox1.setText(versionList.get(0).getName() + ": " + versionList.get(0).getDescription());
		checkBox2.setText(versionList.get(1).getName() + ": " + versionList.get(1).getDescription());
		// checkBox3.setText(versionList.get(2).getName()+": "+
		// versionList.get(2).getDescription());
		// checkBox4.setText(versionList.get(3).getName()+": "+
		// versionList.get(3).getDescription());
		// checkBox5.setText(versionList.get(4).getName()+": "+
		// versionList.get(4).getDescription());
		properties.setCheckBox1Price(new SimpleFloatProperty(versionList.get(0).getPrice()));
		properties.setCheckBox2Price(new SimpleFloatProperty(versionList.get(1).getPrice()));
		// properties.setCheckBox3Price(new
		// SimpleFloatProperty(versionList.get(2).getPrice()));
		// properties.setCheckBox4Price(new
		// SimpleFloatProperty(versionList.get(3).getPrice()));
		// properties.setCheckBox5Price(new
		// SimpleFloatProperty(versionList.get(4).getPrice()));
		log.info(String.valueOf(versionList.get(0).getPrice()));
		log.info(String.valueOf(versionList.get(1).getPrice()));
	}

	private void checkBoxBinds() {
		checkBox1.selectedProperty().bindBidirectional(properties.getCheckBox1());
		checkBox2.selectedProperty().bindBidirectional(properties.getCheckBox2());
		// checkBox3.selectedProperty().bindBidirectional(properties.getCheckBox3());
		// checkBox4.selectedProperty().bindBidirectional(properties.getCheckBox4());
		// checkBox5.selectedProperty().bindBidirectional(properties.getCheckBox5());
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

}
