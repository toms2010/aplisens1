package aplisens.logic;

public class CountSG {

	float rangePrice(int range) {
		if (range > 10) {
			if (range > 100) {
				return 200;
			} else
				return 100;
		} else
			return 0;
	}

	float cablePrice(int length, String calbeType) {
		return length * CableChoiceBox.valueOf(calbeType).getPrice();
	}

}
