package aplisens.view.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aplisens.db.DbDirector;
import aplisens.db.listsTypes.ProductModel;
import aplisens.db.listsTypes.ProductType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import toms.aplisens1.Tag;

public class TablesController implements ViewControllerInterface {

	protected final Logger log = LoggerFactory.getLogger(getClass());

	private MainController mainController;
	private DbDirector dbDirector = new DbDirector();

	
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
	private TableColumn<ProductModel, String> productPriceColumn;

	@FXML
	private void selectedType() {
		ProductType selectedTag = typeTableView.getSelectionModel().getSelectedItem();
		Tag.productTypeTag = (selectedTag.getTag());
		secondTable();
	}

	@FXML
	private void selectedProduct() {
		log.info("selectedProduct");
	}

	@FXML
	private void confirmProduct() {
		mainController.setWindow("/fxml/Product.fxml", new ProductController());
		log.info("Wybrano okno Product - confirmProduct");
	}

	@FXML
	public void initialize() {
		ObservableList<ProductType> data = FXCollections.observableArrayList(dbDirector.odczytType().getDbList());
		typeTagColumn.setCellValueFactory(new PropertyValueFactory<>("tag"));
		typeNameColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
		typeTableView.setItems(data);
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
