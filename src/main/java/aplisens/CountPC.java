package aplisens;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aplisens.view.ConnectorChoiceBox;
import aplisens.view.HousingChoiceBox;
import aplisens.view.Properties;

public class CountPC {

	private Properties properties = Properties.getInstance();
	private final Logger log = LoggerFactory.getLogger(getClass());

	private float rangeExtraPrice() {
		int rangeLow = properties.getRangeLow().get();
		int rangeHigh = properties.getRangeHigh().get();
		if ((rangeHigh-rangeLow)<=10) return 250;
		if (rangeHigh>6000) {
			if (rangeHigh > 20000) {
				return 200;
			} else
				return 100;
		} else
			return 0;
	}

	private float housingTypePrice() {
		String type = properties.getHousingType().get();
		log.debug(type);
		return HousingChoiceBox.valueOf(type).getPrice();
	}

	private float connectorTypePrice() {
		String type = properties.getConnectorType().get();
		log.debug(type);
		return ConnectorChoiceBox.valueOf(type).getPrice();
	}
	
	public float versionExtraPrice() {
		float versionPrice = 0;
		if (properties.getCheckBox1().get()) {
			versionPrice += properties.getCheckBox1Price().get();
		}
		if (properties.getCheckBox2().get()) {
			versionPrice += properties.getCheckBox2Price().get();
		}
		if (properties.getCheckBox3().get()) {
			versionPrice += properties.getCheckBox3Price().get();
		}
		if (properties.getCheckBox4().get()) {
			versionPrice += properties.getCheckBox4Price().get();
		}
		if (properties.getCheckBox5().get()) {
			versionPrice += properties.getCheckBox5Price().get();
		}
		return versionPrice;
	}

	public float countFinalPrice() {
		float itemPrice = 0;
		itemPrice += rangeExtraPrice();
		log.debug("Range: " + rangeExtraPrice());
		itemPrice += housingTypePrice();
		log.debug("Housing: " + housingTypePrice());
		itemPrice += connectorTypePrice();
		log.debug("Connector: " + connectorTypePrice());
		itemPrice += versionExtraPrice();
		log.debug("Version: " + versionExtraPrice());
		itemPrice += properties.getModelPrice().floatValue();
		log.debug("Model: " + properties.getModelPrice().floatValue());
		log.debug("Total: " + itemPrice);
		return itemPrice;
	}
}
