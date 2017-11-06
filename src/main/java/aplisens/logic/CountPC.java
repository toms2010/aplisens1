package aplisens.logic;

public class CountPC {
	float rangePrice(int rangeLow,int rangeHigh) {
		if ((Math.abs(rangeHigh-rangeLow))<=10) return 250;
		if (rangeHigh>6000 || rangeLow>6000) {
			if (rangeHigh > 20000|| rangeLow>20000) {
				return 200;
			} else
				return 100;
		} else
			return 0;
		
	}

	float housingTypePrice(String housingType) {
		return HousingChoiceBox.valueOf(housingType).getPrice();
	}

	float connectorTypePrice(String connectorType) {
		return ConnectorChoiceBox.valueOf(connectorType).getPrice();
	}
	
}
