package toms.aplisens1;

import aplisens.db.read.ProductModels;

public class Logic {
	
	ProductModels mode=  new ProductModels();
	float z;
	
	void funkcja (){
		String tab[][]=mode.getProductsModels();
			z= Float.parseFloat(tab[1][2]);
			System.out.println(z);
	}
	

}
