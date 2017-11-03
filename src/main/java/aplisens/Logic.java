package aplisens;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aplisens.view.controllers.Properties;

public class Logic {
	
	private Properties properties = Properties.getInstance();
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	
	private float rangeExtraPrice() {
		int range=properties.getMeasurementRange().get();
		if(range>10) {
			if(range>100) {
				return 200;
			}
			else return 100;
		}
		else return 0;
	}

	
	
	private float cableExtraPrice() {
		int length=properties.getCableLength().get();
		int typePrice=0;
		String type = properties.getCableType().get();
		log.debug(type);
		switch(type){
		  case "PCV":
			typePrice=9;
		    break;
		  case "Teflon":
			typePrice=15;
		    break;
		}
		return length*typePrice;
	}

	
	
	public float versionExtraPrice() {
		float versionPrice=0;
		if(properties.getCheckBox1SG().get()) {
			versionPrice+=properties.getCheckBox1SGPrice().get();
		}
		if(properties.getCheckBox2SG().get()) {
			versionPrice+=properties.getCheckBox2SGPrice().get();
		}
//		if(properties.getCheckBox3SG().get()) {
//			versionPrice+=properties.getCheckBox3SGPrice().get();
//		}
//		if(properties.getCheckBox4SG().get()) {
//			versionPrice+=properties.getCheckBox4SGPrice().get();
//		}
//		if(properties.getCheckBox5SG().get()) {
//			versionPrice+=properties.getCheckBox5SGPrice().get();
//		}
		return versionPrice;
	}
	
	
//		properties.setModelPrice(new SimpleFloatProperty(g+h+z));

	
	public float finalPrice() {
		float itemPrice=0;
		itemPrice+=cableExtraPrice();
		log.debug("Cable: "+cableExtraPrice());
		itemPrice+=rangeExtraPrice();
		log.debug("Range: "+rangeExtraPrice());
		itemPrice+=versionExtraPrice();
		log.debug("Version: "+versionExtraPrice());
		itemPrice+=properties.getModelPrice().floatValue();
		log.debug("Model: "+properties.getModelPrice().floatValue());
		log.debug("Total: "+itemPrice);
		return itemPrice;
	}
	
	
}
