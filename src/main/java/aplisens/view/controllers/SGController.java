package aplisens.view.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aplisens.Logic;
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
	private Label price;
	
	@FXML
	private CheckBox checkBox1SG;
	@FXML
	private CheckBox checkBox2SG;
	@FXML
	private CheckBox checkBox3SG;
	@FXML
	private CheckBox checkBox4SG;
	@FXML
	private CheckBox checkBox5SG;

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
		properties.setCableType(new SimpleStringProperty(cableType.getSelectionModel().getSelectedItem()));
		cableType.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				properties.setCableType(new SimpleStringProperty(newValue));
			}
		});
		// --------Wykonania
		checkBoxText();
		checkBoxBinds();
		// --------Nagłówek
		productName.setText(properties.getModelTag().get());
		range.textProperty().bindBidirectional(properties.getMeasurementRange(), new NumberStringConverter());
		length.textProperty().bindBidirectional(properties.getCableLength(), new NumberStringConverter());
		// --------Tabela ProductParameters
		ObservableList<ProductParameters> data = FXCollections
				.observableArrayList(dbDirector.odczytParameters().getDbList());
		parametersNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		parametersValueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
		parametersTableView.setItems(data);
	}

	@FXML
	public void goBack() {
		Properties.resetProperties();
		mainController.setWindow("/fxml/Tables.fxml", new TablesController());
		log.info("Wybrano okno Tables");
	}

	@FXML
	public void countPrice() {
		price.textProperty().setValue(String.valueOf(logic.finalPrice()));
	}

	public void checkBoxText() {
		List<ProductVersion> versionList = new ArrayList<>();
		versionList = dbDirector.odczytVersion().getDbList();
		checkBox1SG.setText(versionList.get(0).getName() + ": " + versionList.get(0).getDescription());
		checkBox2SG.setText(versionList.get(1).getName() + ": " + versionList.get(1).getDescription());
		// checkBox3SG.setText(versionList.get(2).getName()+": "+
		// versionList.get(2).getDescription());
		// checkBox4SG.setText(versionList.get(3).getName()+": "+
		// versionList.get(3).getDescription());
		// checkBox5SG.setText(versionList.get(4).getName()+": "+
		// versionList.get(4).getDescription());
		properties.setCheckBox1SGPrice(new SimpleFloatProperty(versionList.get(0).getPrice()));
		properties.setCheckBox2SGPrice(new SimpleFloatProperty(versionList.get(1).getPrice()));
		// properties.setCheckBox3SGPrice(new
		// SimpleFloatProperty(versionList.get(2).getPrice()));
		// properties.setCheckBox4SGPrice(new
		// SimpleFloatProperty(versionList.get(3).getPrice()));
		// properties.setCheckBox5SGPrice(new
		// SimpleFloatProperty(versionList.get(4).getPrice()));
	}

	private void checkBoxBinds() {
		checkBox1SG.selectedProperty().bindBidirectional(properties.getCheckBox1SG());
		checkBox2SG.selectedProperty().bindBidirectional(properties.getCheckBox2SG());
		// checkBox3SG.selectedProperty().bindBidirectional(properties.getCheckBox3SG());
		// checkBox4SG.selectedProperty().bindBidirectional(properties.getCheckBox4SG());
		// checkBox5SG.selectedProperty().bindBidirectional(properties.getCheckBox5SG());
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

}
