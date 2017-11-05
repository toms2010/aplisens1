package aplisens.view.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aplisens.db.DbDirector;
import aplisens.db.listsTypes.ProductModel;
import aplisens.db.listsTypes.ProductType;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TablesController implements ViewControllersInterface {

	private static final String PC_FXML = "/fxml/PC.fxml";
	private static final String SG_FXML = "/fxml/SG.fxml";
	private final Logger log = LoggerFactory.getLogger(getClass());
	private MainController mainController;
	private DbDirector dbDirector = new DbDirector();
	private Properties property = Properties.getInstance();

	@FXML
	private TableView<ProductType> typeTableView;
	@FXML
	private TableColumn<ProductType, String> typeTagColumn;
	@FXML
	private TableColumn<ProductType, String> typeNameColumn;

	@FXML
	private TableView<ProductModel> productTableViwe;
	@FXML
	private TableColumn<ProductModel, String> productNameColumn;
	@FXML
	private TableColumn<ProductModel, String> productDescriptionColumn;
	@FXML
	private TableColumn<ProductModel, Float> productPriceColumn;

	@FXML
	private Button confirmButton;

	@FXML
	public void initialize() {
		ObservableList<ProductType> data = FXCollections.observableArrayList(dbDirector.readType().getDbList());
		typeTagColumn.setCellValueFactory(new PropertyValueFactory<>("tag"));
		typeNameColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
		typeTableView.setItems(data);
		confirmButton.setDisable(true);
	}

	@FXML
	private void selectedType() {
		property.setTypeTag(new SimpleStringProperty(typeTableView.getSelectionModel().getSelectedItem().getTag()));
		log.debug("Wybrano produkt typu: " + property.getTypeTag());
		secondTable();
	}

	@FXML
	private void selectedProduct() {
		property.setModelTag(
				new SimpleStringProperty(productTableViwe.getSelectionModel().getSelectedItem().getName()));
		log.debug("Wybrano model produktu: " + property.getModelTag());
		property.setModelPrice(
				new SimpleFloatProperty(productTableViwe.getSelectionModel().getSelectedItem().getPrice()));
		log.debug("Cena produktu: " + property.getModelPrice());
		confirmButton.setDisable(false);
		property.setTitle(
				new SimpleStringProperty(productTableViwe.getSelectionModel().getSelectedItem().getDescription()));
	}

	@FXML
	private void confirmProduct() {
		if ("SG".equals(property.getTypeTag().get())) {
			mainController.setWindow(SG_FXML, new SGController());
			log.info("Wybrano okno SG");
		} else if ("PC".equals(property.getTypeTag().get())) {
			mainController.setWindow(PC_FXML, new PCController());
			log.info("Wybrano okno PC");
		} else {
			log.error("Nie wybrano produktu!");
		}
	}

	private void secondTable() {
		productNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		productDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
		productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		productTableViwe.getItems().clear();
		productTableViwe.getItems().addAll(dbDirector.readModel().getDbList());
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

}
