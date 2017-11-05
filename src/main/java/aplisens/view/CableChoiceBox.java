package aplisens.view;

import java.util.ArrayList;
import java.util.List;

public enum CableChoiceBox {

	POLIURETAN(9), PU_PZH(12), ETFE(15), Teflon(25);

	private float price;
	static List<String> cableTypeList = new ArrayList<>();

	private CableChoiceBox(float price) {
		this.price = price;
	}

	public static List<String> getCableTypeList() {
		CableChoiceBox[] list = CableChoiceBox.values();
		for (CableChoiceBox x : list) {
			cableTypeList.add(x.toString());
		}
		return cableTypeList;
	}

	public float getPrice() {
		return price;
	}
	
}