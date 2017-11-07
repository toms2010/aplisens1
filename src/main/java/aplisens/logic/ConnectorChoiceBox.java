package aplisens.logic;

import java.util.ArrayList;
import java.util.List;

public enum ConnectorChoiceBox {
	
	PD(0), PZ(220), PK(90), PM12(170), SG(250);

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