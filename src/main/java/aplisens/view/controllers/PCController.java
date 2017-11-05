package aplisens.view.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aplisens.CountPC;
import aplisens.db.DbDirector;
import aplisens.db.listsTypes.ProductParameters;
import aplisens.db.listsTypes.ProductVersion;
import aplisens.view.ConnectorChoiceBox;
import aplisens.view.HousingChoiceBox;
import aplisens.view.Properties;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
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

public class PCController implements ViewControllersInterface {

	private static final String TABLES_FXML = "/fxml/Tables.fxml";
	private final Logger log = LoggerFactory.getLogger(getClass());
	private MainController mainController;
	private DbDirector dbDirector = new DbDirector();
	private Properties properties = Properties.getInstance();
	private CountPC countPC = new CountPC();

	@FXML
	private Label title;
	@FXML
	private Label productName;
	@FXML
	private TextField rangeLow;
	@FXML
	private TextField rangeHigh;
	@FXML
	private ChoiceBox<String> housingType;
	@FXML
	private ChoiceBox<String> connectorType;
	@FXML
	private Label price;
	@FXML
	private Label rangeLowWarning;
	@FXML
	private Label rangeHighWarning;

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
		// --------ChoiceBox
		housingType.getItems().addAll(HousingChoiceBox.getHousingTypeList());
		housingType.getSelectionModel().selectFirst();
		properties.setHousingType(new SimpleStringProperty(housingType.getSelectionModel().getSelectedItem()));
		housingType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
				properties.setHousingType(new SimpleStringProperty(newValue));
		});
		connectorType.getItems().addAll(ConnectorChoiceBox.getConnectorTypeList());
		connectorType.getSelectionModel().selectFirst();
		properties.setConnectorType(new SimpleStringProperty(housingType.getSelectionModel().getSelectedItem()));
		connectorType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
				properties.setConnectorType(new SimpleStringProperty(newValue));
		});
		// --------Wykonania
		checkBoxText();
		checkBoxBind();
		// --------Nagłówek
		title.setText(properties.getTitle().get());
		productName.setText(properties.getModelTag().get() + "/");
		rangeLow.textProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue.matches("\\d*")) {
				rangeLow.setText(newValue.replaceAll("[^\\d]", ""));
			}
		});
		rangeLow.textProperty().bindBidirectional(properties.getRangeLow(), new NumberStringConverter());
		rangeHigh.textProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue.matches("\\d*")) {
				rangeHigh.setText(newValue.replaceAll("[^\\d]", ""));
			}
		});
		rangeHigh.textProperty().bindBidirectional(properties.getRangeHigh(), new NumberStringConverter());
		// --------Tabela ProductParameters
		ObservableList<ProductParameters> data = FXCollections
				.observableArrayList(dbDirector.readParameters().getDbList());
		parametersNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		parametersValueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
		parametersTableView.setItems(data);
		// ---------Ostrzeżenia
		rangeHighWarning.visibleProperty().bind(properties.getRangeHighWarning());
	}

	@FXML
	public void back() {
		Properties.resetProperties();
		mainController.setWindow(TABLES_FXML, new TablesController());
		log.info("Wybrano okno Tables");
	}

	@FXML
	public void countPrice() {
		price.textProperty().setValue(String.valueOf(countPC.countFinalPrice()));
	}

	public void checkBoxText() {
		List<ProductVersion> versionList = new ArrayList<>();
		versionList = dbDirector.readVersion().getDbList();
		checkBox1.setText(versionList.get(0).getName() + ": " + versionList.get(0).getDescription());
		checkBox2.setText(versionList.get(1).getName() + ": " + versionList.get(1).getDescription());
		checkBox3.setText(versionList.get(2).getName() + ": " + versionList.get(2).getDescription());
		checkBox4.setText(versionList.get(3).getName() + ": " + versionList.get(3).getDescription());
		checkBox5.setText(versionList.get(4).getName() + ": " + versionList.get(4).getDescription());
		properties.setCheckBox1Price(new SimpleFloatProperty(versionList.get(0).getPrice()));
		properties.setCheckBox2Price(new SimpleFloatProperty(versionList.get(1).getPrice()));
		properties.setCheckBox3Price(new SimpleFloatProperty(versionList.get(2).getPrice()));
		properties.setCheckBox4Price(new SimpleFloatProperty(versionList.get(3).getPrice()));
		properties.setCheckBox5Price(new SimpleFloatProperty(versionList.get(4).getPrice()));
	}

	private void checkBoxBind() {
		checkBox1.selectedProperty().bindBidirectional(properties.getCheckBox1());
		checkBox2.selectedProperty().bindBidirectional(properties.getCheckBox2());
		checkBox3.selectedProperty().bindBidirectional(properties.getCheckBox3());
		checkBox4.selectedProperty().bindBidirectional(properties.getCheckBox4());
		checkBox5.selectedProperty().bindBidirectional(properties.getCheckBox5());
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

}
