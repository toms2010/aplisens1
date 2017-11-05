package aplisens;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aplisens.view.controllers.Properties;

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
		float price = 0;
		String type = properties.getHousingType().get();
		switch (type) {
		case "PD":
			price= 0;
			break;
		case "PZ":
			price= 220;
			break;
		case "PK":
			price= 90;
			break;
		case "PM12":
			price= 170;
			break;
		case "SG":
			price= 250;
			break;
		}
		log.debug(type);
		return price;
	}

	private float connectorTypePrice() {
		float price = 0;
		String type = properties.getConnectorType().get();
		switch (type) {
		case "M20x1,5":
			price= 0;
			break;
		case "G1/2":
			price= 0;
			break;
		case "1/2NPT":
			price= 120;
			break;
		case "G1/4":
			price= 30;
			break;
		case "CM30x2":
			price= 130;
			break;
		case "CG1":
			price= 210;
			break;
		case "CG1/2":
			price= 180;
			break;
		}
		log.debug(type);
		return price;
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
