package aplisens.db;

import aplisens.db.read.ReadProductModel;
import aplisens.db.read.ReadProductVersionsPC;
import aplisens.db.read.ReadProductVersionsSG;
import aplisens.db.read.ReadProductParametersPC;
import aplisens.db.read.ReadProductParametersSG;
import aplisens.db.read.ReadProductType;

public class DbDirector {

	private ReadProductType readProductType = new ReadProductType();
	private ReadProductModel readProductModel = new ReadProductModel();
	private ReadProductVersionsPC readProductVersionsPC = new ReadProductVersionsPC();
	private ReadProductVersionsSG readProductVersionsSG = new ReadProductVersionsSG();
	private ReadProductParametersPC readProductParametersPC = new ReadProductParametersPC();
	private ReadProductParametersSG readProductParametersSG = new ReadProductParametersSG();

	public ReadProductType readType() {
		readProductType.read();
		return readProductType;
	}

	public ReadProductModel readModel() {
		readProductModel.read();
		return readProductModel;
	}

	public ReadProductParametersPC readParametersPC() {
		readProductParametersPC.read();
		return readProductParametersPC;
	}
	
	public ReadProductParametersSG readParametersSG() {
		readProductParametersSG.read();
		return readProductParametersSG;
	}

	public ReadProductVersionsPC readVersionPC() {
		readProductVersionsPC.read();
		return readProductVersionsPC;
	}
	
	public ReadProductVersionsSG readVersionSG() {
		readProductVersionsSG.read();
		return readProductVersionsSG;
	}
}
