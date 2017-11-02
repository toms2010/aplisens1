package aplisens.view.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aplisens.db.DbDirector;
import aplisens.db.listsTypes.ProductModel;
import aplisens.db.listsTypes.ProductType;
import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.converter.NumberStringConverter;


public class TablesController implements ViewControllerInterface {

	protected final Logger log = LoggerFactory.getLogger(getClass());

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
	private Button confirm;

	@FXML
	private void selectedType() {
		property.setProductTag(new SimpleStringProperty(typeTableView.getSelectionModel().getSelectedItem().getTag()));
		log.debug("Wybrano produkt typu: "+ property.getModelTag());
		secondTable();
	}

	@FXML
	private void selectedProduct() {
		property.setModelTag(new SimpleStringProperty(productTableViwe.getSelectionModel().getSelectedItem().getName()));
		log.debug("Wybrano model produktu: "+ property.getModelTag());
	}
	
	
	@FXML
	private void confirmProduct() {
		//Dorobić nieaktywnośc przycisku!!
		if ("SG".equals(property.getProductTag().get())) {
			mainController.setWindow("/fxml/SG.fxml", new SGController());
			log.debug("Wybrano okno SG");	
		}
		else if("PC".equals(property.getProductTag().get())) {
			mainController.setWindow("/fxml/PC.fxml", new PCController());
			log.debug("Wybrano okno PC");	
		}
		else {
			log.error("Nie wybrano produktu!");	
		}
	}

	@FXML
	public void initialize() {
		
		ObservableList<ProductType> data = FXCollections.observableArrayList(dbDirector.odczytType().getDbList());
		typeTagColumn.setCellValueFactory(new PropertyValueFactory<>("tag"));
		typeNameColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
		typeTableView.setItems(data);
		confirm.disableProperty().bind(property.getButtonProperty());
	}

	public void secondTable() {
		productNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		productDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
		productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		productTableViwe.getItems().clear();
		productTableViwe.getItems().addAll(dbDirector.odczytModel().getDbList());
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

}
