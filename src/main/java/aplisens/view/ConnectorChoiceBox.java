package aplisens.view;

import java.util.ArrayList;
import java.util.List;

public enum ConnectorChoiceBox {
	M20x1(0), G12(0), NPT12(120), G14(30), CM30x2(130), CG1(210), CG12(180);

	private float price;
	static List<String> connectorTypeList = new ArrayList<>();

	private ConnectorChoiceBox(float price) {
		this.price = price;
	}

	public static List<String> getConnectorTypeList() {
		ConnectorChoiceBox[] list = ConnectorChoiceBox.values();
		for (ConnectorChoiceBox x : list) {
			connectorTypeList.add(x.toString());
		}
		return connectorTypeList;
	}

	public float getPrice() {
		return price;
	}

}