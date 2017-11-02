package aplisens.view.controllers;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Properties {
			
	private static Properties sing = null;
	
	private Properties(){
	}
	
	public static Properties getInstance(){
		if(sing==null){
			sing= new Properties();
			return sing;
		}
		else{
			return sing;
		}
	}
	public static void resetProperties() {
		sing= new Properties();
	}
	private StringProperty modelTag = new SimpleStringProperty();
	private StringProperty productTag = new SimpleStringProperty();
	
	private IntegerProperty range = new SimpleIntegerProperty();
	private IntegerProperty length = new SimpleIntegerProperty();
	
	private BooleanProperty checkBox1 = new SimpleBooleanProperty(false);
	private BooleanProperty checkBox2 = new SimpleBooleanProperty(false);
	private BooleanProperty checkBox3 = new SimpleBooleanProperty(false);
	private BooleanProperty checkBox4 = new SimpleBooleanProperty(false);
	private BooleanProperty checkBox5 = new SimpleBooleanProperty(false);
	private FloatProperty checkBox1Price = new SimpleFloatProperty();
	private FloatProperty checkBox2Price = new SimpleFloatProperty();
	private FloatProperty checkBox3Price = new SimpleFloatProperty();
	private FloatProperty checkBox4Price = new SimpleFloatProperty();
	private FloatProperty checkBox5Price = new SimpleFloatProperty();
	
	private BooleanProperty buttonProperty = new SimpleBooleanProperty(false);
	
	private StringProperty cableType = new SimpleStringProperty();
	
	private FloatProperty price = new SimpleFloatProperty();

	
	public StringProperty getModelTag() {
		return modelTag;
	}


	public StringProperty getProductTag() {
		return productTag;
	}

	public void setProductTag(StringProperty productTag) {
		this.productTag = productTag;
	}

	public void setModelTag(StringProperty modelTag) {
		this.modelTag = modelTag;
	}

	public BooleanProperty getButtonProperty() {
		return buttonProperty;
	}

	public void setButtonProperty(BooleanProperty buttonProperty) {
		this.buttonProperty = buttonProperty;
	}

	public IntegerProperty getRange() {
		return range;
	}

	public void setRange(IntegerProperty range) {
		this.range = range;
	}

	public IntegerProperty getLength() {
		return length;
	}

	public void setLength(IntegerProperty length) {
		this.length = length;
	}

	public StringProperty getCableType() {
		return cableType;
	}

	public void setCableType(StringProperty cableType) {
		this.cableType = cableType;
	}

	public BooleanProperty getCheckBox1() {
		return checkBox1;
	}

	public void setCheckBox1(BooleanProperty checkBox1) {
		this.checkBox1 = checkBox1;
	}

	public BooleanProperty getCheckBox2() {
		return checkBox2;
	}

	public void setCheckBox2(BooleanProperty checkBox2) {
		this.checkBox2 = checkBox2;
	}

	public FloatProperty getCheckBox1Price() {
		return checkBox1Price;
	}

	public void setCheckBox1Price(FloatProperty checkBox1Price) {
		this.checkBox1Price = checkBox1Price;
	}

	public FloatProperty getCheckBox2Price() {
		return checkBox2Price;
	}

	public void setCheckBox2Price(FloatProperty checkBox2Price) {
		this.checkBox2Price = checkBox2Price;
	}

	public FloatProperty getPrice() {
		return price;
	}

	public void setPrice(FloatProperty price) {
		this.price = price;
	}


	
	

}
