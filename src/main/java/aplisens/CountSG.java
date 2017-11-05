package aplisens;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aplisens.view.controllers.Properties;

public class CountSG {

	private Properties properties = Properties.getInstance();
	private final Logger log = LoggerFactory.getLogger(getClass());

	private float rangeExtraPrice() {
		int range = properties.getMeasurementRange().get();
		if (range > 10) {
			if (range > 100) {
				return 200;
			} else
				return 100;
		} else
			return 0;
	}

	private float cableExtraPrice() {
		int length = properties.getCableLength().get();
		int typePrice = 0;
		String type = properties.getCableType().get();
		log.debug(type);
		switch (type) {
		case "POLIURETAN":
			typePrice = 9;
			break;
		case "PU PZH":
			typePrice = 12;
			break;
		case "ETFE":
			typePrice = 15;
			break;
		case "Teflon":
			typePrice = 25;
			break;
		}
		return length * typePrice;
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
		itemPrice += cableExtraPrice();
		log.debug("Cable: " + cableExtraPrice());
		itemPrice += rangeExtraPrice();
		log.debug("Range: " + rangeExtraPrice());
		itemPrice += versionExtraPrice();
		log.debug("Version: " + versionExtraPrice());
		itemPrice += properties.getModelPrice().floatValue();
		log.debug("Model: " + properties.getModelPrice().floatValue());
		log.debug("Total: " + itemPrice);
		return itemPrice;
	}
}
