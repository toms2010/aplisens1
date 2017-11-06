package aplisens.logic;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Properties {

	private static Properties single = null;

	private Properties() {
		rangeWarning.bind(measurementRange.isEqualTo(0));
		lengthWarning.bind(cableLength.isEqualTo(0));
		rangeHighWarning.bind(rangeHigh.isEqualTo(0));
	}

	public static Properties getInstance() {
		if (single == null) {
			single = new Properties();
			return single;
		} else {
			return single;
		}
	}

	public static void resetProperties() {
		single = new Properties();
	}

	private StringProperty title = new SimpleStringProperty();
	private StringProperty modelTag = new SimpleStringProperty();
	private StringProperty typeTag = new SimpleStringProperty();
	private BooleanProperty buttonProperty = new SimpleBooleanProperty(true);
	private FloatProperty modelPrice = new SimpleFloatProperty();
	private FloatProperty finalPrice = new SimpleFloatProperty();

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
	// --------PC
	private StringProperty housingType = new SimpleStringProperty();
	private StringProperty connectorType = new SimpleStringProperty();
	private IntegerProperty rangeLow = new SimpleIntegerProperty();
	private IntegerProperty rangeHigh = new SimpleIntegerProperty();
	private BooleanProperty rangeHighWarning = new SimpleBooleanProperty(true);
	// --------SG
	private IntegerProperty measurementRange = new SimpleIntegerProperty();
	private IntegerProperty cableLength = new SimpleIntegerProperty();
	private StringProperty cableType = new SimpleStringProperty();
	private BooleanProperty rangeWarning = new SimpleBooleanProperty(true);
	private BooleanProperty lengthWarning = new SimpleBooleanProperty(true);

	public StringProperty getTitle() {
		return title;
	}

	public void setTitle(StringProperty title) {
		this.title = title;
	}

	public StringProperty getModelTag() {
		return modelTag;
	}

	public void setModelTag(StringProperty modelTag) {
		this.modelTag = modelTag;
	}

	public StringProperty getTypeTag() {
		return typeTag;
	}

	public void setTypeTag(StringProperty typeTag) {
		this.typeTag = typeTag;
	}

	public BooleanProperty getButtonProperty() {
		return buttonProperty;
	}

	public void setButtonProperty(BooleanProperty buttonProperty) {
		this.buttonProperty = buttonProperty;
	}

	public FloatProperty getModelPrice() {
		return modelPrice;
	}

	public void setModelPrice(FloatProperty modelPrice) {
		this.modelPrice = modelPrice;
	}

	public FloatProperty getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(FloatProperty finalPrice) {
		this.finalPrice = finalPrice;
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

	public BooleanProperty getCheckBox3() {
		return checkBox3;
	}

	public void setCheckBox3(BooleanProperty checkBox3) {
		this.checkBox3 = checkBox3;
	}

	public BooleanProperty getCheckBox4() {
		return checkBox4;
	}

	public void setCheckBox4(BooleanProperty checkBox4) {
		this.checkBox4 = checkBox4;
	}

	public BooleanProperty getCheckBox5() {
		return checkBox5;
	}

	public void setCheckBox5(BooleanProperty checkBox5) {
		this.checkBox5 = checkBox5;
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

	public FloatProperty getCheckBox3Price() {
		return checkBox3Price;
	}

	public void setCheckBox3Price(FloatProperty checkBox3Price) {
		this.checkBox3Price = checkBox3Price;
	}

	public FloatProperty getCheckBox4Price() {
		return checkBox4Price;
	}

	public void setCheckBox4Price(FloatProperty checkBox4Price) {
		this.checkBox4Price = checkBox4Price;
	}

	public FloatProperty getCheckBox5Price() {
		return checkBox5Price;
	}

	public void setCheckBox5Price(FloatProperty checkBox5Price) {
		this.checkBox5Price = checkBox5Price;
	}

	public StringProperty getHousingType() {
		return housingType;
	}

	public void setHousingType(StringProperty housingType) {
		this.housingType = housingType;
	}

	public StringProperty getConnectorType() {
		return connectorType;
	}

	public void setConnectorType(StringProperty connectorType) {
		this.connectorType = connectorType;
	}

	public IntegerProperty getRangeLow() {
		return rangeLow;
	}

	public void setRangeLow(IntegerProperty rangeLow) {
		this.rangeLow = rangeLow;
	}

	public IntegerProperty getRangeHigh() {
		return rangeHigh;
	}

	public void setRangeHigh(IntegerProperty rangeHigh) {
		this.rangeHigh = rangeHigh;
	}

	public BooleanProperty getRangeHighWarning() {
		return rangeHighWarning;
	}

	public void setRangeHighWarning(BooleanProperty rangeHighWarning) {
		this.rangeHighWarning = rangeHighWarning;
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

	public StringProperty getCableType() {
		return cableType;
	}

	public void setCableType(StringProperty cableType) {
		this.cableType = cableType;
	}

	public BooleanProperty getRangeWarning() {
		return rangeWarning;
	}

	public void setRangeWarning(BooleanProperty rangeWarning) {
		this.rangeWarning = rangeWarning;
	}

	public BooleanProperty getLengthWarning() {
		return lengthWarning;
	}

	public void setLengthWarning(BooleanProperty lengthWarning) {
		this.lengthWarning = lengthWarning;
	}

}
