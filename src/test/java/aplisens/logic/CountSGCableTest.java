package aplisens.logic;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CountSGCableTest {

	CountSG count;
	
	@Before
	public void setUp() {
		count = new CountSG();
	}
	
	
//	Check cable price when type is POLIURETAN and length is 5m
	@Test
	public void CheckCableTypePOLIURETANlength5() {
		int length=5;
		String calbeType="POLIURETAN";
				
		float expectedValue=45;
		float realValue = count.cablePrice(length, calbeType);
		
		assertThat(realValue, equalTo(expectedValue));
	}
	
//	Check cable price when type is Teflon and length is 100m
	@Test
	public void CheckCableTypePOLIURETANlength100() {
		int length=100;
		String calbeType="POLIURETAN";
				
		float expectedValue=900;
		float realValue = count.cablePrice(length, calbeType);
		
		assertThat(realValue, equalTo(expectedValue));
	}
	
//	Check cable price when type is PU_PZH and length is 10m
	@Test
	public void CheckCableTypePU_PZH() {
		int length=10;
		String calbeType="PU_PZH";
				
		float expectedValue=120;
		float realValue = count.cablePrice(length, calbeType);
		
		assertThat(realValue, equalTo(expectedValue));
	}
	
//	Check cable price when type is ETFE and length is 10m
	@Test
	public void CheckCableTypeETFE() {
		int length=10;
		String calbeType="ETFE";
				
		float expectedValue=150;
		float realValue = count.cablePrice(length, calbeType);
		
		assertThat(realValue, equalTo(expectedValue));
	}
	
	
	
//	Check cable price when type is Teflon and length is 10m
	@Test
	public void CheckCableTypeTeflon() {
		int length=10;
		String calbeType="Teflon";
				
		float expectedValue=250;
		float realValue = count.cablePrice(length, calbeType);
		
		assertThat(realValue, equalTo(expectedValue));
	}

}
