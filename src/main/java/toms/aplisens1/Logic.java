package toms.aplisens1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aplisens.view.controllers.Properties;
import javafx.beans.property.SimpleFloatProperty;

public class Logic {
	
	private int typePrice;
	private Properties properties = Properties.getInstance();
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	public float rangeExtraPrice() {
		int range=properties.getRange().get();
		if(range>10) {
			if(range>100) {
				return 200;
			}
			else return 100;
		}
		else return 0;
	}

	public float cableExtraPrice() {
		int length=properties.getLength().get();
		String type = properties.getCableType().get();
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
		log.debug(String.valueOf(properties.getCheckBox1().get()));
		if(properties.getCheckBox1().get()) {
			versionPrice+=properties.getCheckBox1Price().get();
			log.debug("Extra versiona price: "+versionPrice);
		}
		log.debug(String.valueOf(properties.getCheckBox2().get()));
		if(properties.getCheckBox2().get()) {
			versionPrice+=properties.getCheckBox2Price().get();
			log.debug("Extra versiona price 2 : "+versionPrice);
		}
		return versionPrice;
	}
	
	public void wyswietl() {
		int x=properties.getLength().get();
		int y=properties.getRange().get();
		System.out.println(x+"  "+y);
		log.error("Leight: "+x+ "Range: "+y);
		float g=cableExtraPrice();
		float h=rangeExtraPrice();
		log.error("Cable: "+g+"Range: "+h);
		versionExtraPrice();
		float z=versionExtraPrice();
		log.error("Extra versiona price: "+z);
		log.error("cała cena: "+z+g+h);
		properties.setPrice(new SimpleFloatProperty(g+h+z));
	}
	
	
}
