package aplisens.view.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
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
	
	private StringProperty modelTag = new SimpleStringProperty("");
	private StringProperty productTag = new SimpleStringProperty();
	private BooleanProperty buttonProperty = new SimpleBooleanProperty(true);
	
    //-------SG
	private IntegerProperty measurementRange = new SimpleIntegerProperty();
	private IntegerProperty cableLength = new SimpleIntegerProperty();
	private StringProperty cableType = new SimpleStringProperty();
	private FloatProperty modelPrice = new SimpleFloatProperty();
	private FloatProperty finalPrice = new SimpleFloatProperty();
	
	private BooleanProperty checkBox1SG = new SimpleBooleanProperty(false);
	private BooleanProperty checkBox2SG = new SimpleBooleanProperty(false);
	private BooleanProperty checkBox3SG = new SimpleBooleanProperty(false);
	private BooleanProperty checkBox4SG = new SimpleBooleanProperty(false);
	private BooleanProperty checkBox5SG = new SimpleBooleanProperty(false);
	private FloatProperty checkBox1SGPrice = new SimpleFloatProperty();
	private FloatProperty checkBox2SGPrice = new SimpleFloatProperty();
	private FloatProperty checkBox3SGPrice = new SimpleFloatProperty();
	private FloatProperty checkBox4SGPrice = new SimpleFloatProperty();
	private FloatProperty checkBox5SGPrice = new SimpleFloatProperty();
	

	public FloatProperty getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(FloatProperty finalPrice) {
		this.finalPrice = finalPrice;
	}

	public StringProperty getModelTag() {
		return modelTag;
	}

	public void setModelTag(StringProperty modelTag) {
		this.modelTag = modelTag;
	}

	public StringProperty getProductTag() {
		return productTag;
	}

	public void setProductTag(StringProperty productTag) {
		this.productTag = productTag;
	}

	public BooleanProperty getButtonProperty() {
		return buttonProperty;
	}

	public void setButtonProperty(BooleanProperty buttonProperty) {
		this.buttonProperty = buttonProperty;
	}

	public IntegerProperty getMeasurementRange() {
		return measurementRange;
	}

	public void setMeasurementRange(IntegerProperty measurementRange) {
		this.measurementRange = measurementRange;
	}

	public IntegerProperty getCableLength() {
		return cableLength;
	}

	public void setCableLength(IntegerProperty cableLength) {
		this.cableLength = cableLength;
	}

	public BooleanProperty getCheckBox1SG() {
		return checkBox1SG;
	}

	public void setCheckBox1SG(BooleanProperty checkBox1SG) {
		this.checkBox1SG = checkBox1SG;
	}

	public BooleanProperty getCheckBox2SG() {
		return checkBox2SG;
	}

	public void setCheckBox2SG(BooleanProperty checkBox2SG) {
		this.checkBox2SG = checkBox2SG;
	}

	public BooleanProperty getCheckBox3SG() {
		return checkBox3SG;
	}

	public void setCheckBox3SG(BooleanProperty checkBox3SG) {
		this.checkBox3SG = checkBox3SG;
	}

	public BooleanProperty getCheckBox4SG() {
		return checkBox4SG;
	}

	public void setCheckBox4SG(BooleanProperty checkBox4SG) {
		this.checkBox4SG = checkBox4SG;
	}

	public BooleanProperty getCheckBox5SG() {
		return checkBox5SG;
	}

	public void setCheckBox5SG(BooleanProperty checkBox5SG) {
		this.checkBox5SG = checkBox5SG;
	}

	public FloatProperty getCheckBox1SGPrice() {
		return checkBox1SGPrice;
	}

	public void setCheckBox1SGPrice(FloatProperty checkBox1SGPrice) {
		this.checkBox1SGPrice = checkBox1SGPrice;
	}

	public FloatProperty getCheckBox2SGPrice() {
		return checkBox2SGPrice;
	}

	public void setCheckBox2SGPrice(FloatProperty checkBox2SGPrice) {
		this.checkBox2SGPrice = checkBox2SGPrice;
	}

	public FloatProperty getCheckBox3SGPrice() {
		return checkBox3SGPrice;
	}

	public void setCheckBox3SGPrice(FloatProperty checkBox3SGPrice) {
		this.checkBox3SGPrice = checkBox3SGPrice;
	}

	public FloatProperty getCheckBox4SGPrice() {
		return checkBox4SGPrice;
	}

	public void setCheckBox4SGPrice(FloatProperty checkBox4SGPrice) {
		this.checkBox4SGPrice = checkBox4SGPrice;
	}

	public FloatProperty getCheckBox5SGPrice() {
		return checkBox5SGPrice;
	}

	public void setCheckBox5SGPrice(FloatProperty checkBox5SGPrice) {
		this.checkBox5SGPrice = checkBox5SGPrice;
	}

	public StringProperty getCableType() {
		return cableType;
	}

	public void setCableType(StringProperty cableType) {
		this.cableType = cableType;
	}

	public FloatProperty getModelPrice() {
		return modelPrice;
	}

	public void setModelPrice(FloatProperty modelPrice) {
		this.modelPrice = modelPrice;
	}

}
