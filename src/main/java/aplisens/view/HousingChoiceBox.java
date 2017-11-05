package aplisens.view;

import java.util.ArrayList;
import java.util.List;

public enum HousingChoiceBox {
	
	PD(0), PZ(220), PK(90), PM12(170), SG(250);

	private float price;
	static List<String> housingTypeList = new ArrayList<>();

	private HousingChoiceBox(float price) {
		this.price = price;
	}

	public static List<String> getHousingTypeList() {
		HousingChoiceBox[] list = HousingChoiceBox.values();
		for (HousingChoiceBox x : list) {
			housingTypeList.add(x.toString());
		}
		return housingTypeList;
	}

	public float getPrice() {
		return price;
	}
	
}