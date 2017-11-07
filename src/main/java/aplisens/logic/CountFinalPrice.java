package aplisens.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CountFinalPrice {
	
	private Properties properties = Properties.getInstance();
	private final Logger log = LoggerFactory.getLogger(getClass());
	private CountPC countPC;
	private CountSG countSG;
	private float itemPrice;
	private float totalPrice;
	private float versionPrice;
	
	public CountFinalPrice() {
		countPC = new CountPC();
		countSG = new CountSG();
	}

	public float countFinalPricePC() {
		totalPrice=0;
		itemPrice = countPC.rangePrice(properties.getRangeLow().get(),properties.getRangeHigh().get());
		totalPrice += itemPrice;
		log.debug("Range: " + itemPrice);
		
		itemPrice = countPC.housingTypePrice(properties.getHousingType().get());
		totalPrice += itemPrice;
		log.debug("Housing: " + itemPrice);
		
		itemPrice = countPC.connectorTypePrice(properties.getConnectorType().get());
		totalPrice += itemPrice;
		log.debug("Connector: " + itemPrice);
		
		totalPrice += versionPrice();
		log.debug("Version: " + versionPrice());
		
		totalPrice += properties.getModelPrice().floatValue();
		log.debug("Model: " + properties.getModelPrice().floatValue());
		log.debug("Total: " + totalPrice);
		return totalPrice;
	}

	public float countFinalPriceSG() {
		totalPrice=0;
		itemPrice = countSG.rangePrice(properties.getMeasurementRange().get());
		totalPrice += itemPrice;
		log.debug("Range: " + itemPrice);
		
		itemPrice = countSG.cablePrice(properties.getCableLength().get(),properties.getCableType().get());
		totalPrice += itemPrice;
		log.debug("Cable: " + itemPrice);
		
		totalPrice += versionPrice();
		log.debug("Version: " + versionPrice());
		
		totalPrice += properties.getModelPrice().floatValue();
		log.debug("Model: " + properties.getModelPrice().floatValue());
		log.debug("Total: " + totalPrice);
		return totalPrice;
	}
	
	private float versionPrice() {
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
}
