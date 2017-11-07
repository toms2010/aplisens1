package aplisens.logic;

import java.util.ArrayList;
import java.util.List;

public enum HousingChoiceBox {
	M20x1(0), G12(0), NPT12(120), G14(30), CM30x2(130), CG1(210), CG12(180);

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