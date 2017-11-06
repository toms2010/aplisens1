package aplisens.logic;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import aplisens.logic.CountPC;

public class CountPCRangeTest {

	CountPC count;
	
	@Before
	public void setUp() {
		count = new CountPC();
	}
	
//	Check the measuring range is lower then 10kPa and low range is equal to 0kPa
	@Test
	public void CheckRangeLowerThen10WhenLowRangeIs0() {
		int rangeLow=0;
		int rangeHigh=5;
		
		float expectedValue=250;
		float realValue = count.rangePrice(rangeLow, rangeHigh);
		
		assertThat(realValue, equalTo(expectedValue));
	}
	
//	Check the measuring range is lower then 10kPa and low range is bigger then 0kPa
	@Test
	public void CheckRangeLowerThen10WhenLowRangeIsNot0() {
		int rangeLow=100;
		int rangeHigh=105;
		
		float expectedValue=250;
		float realValue = count.rangePrice(rangeLow, rangeHigh);
		
		assertThat(realValue, equalTo(expectedValue));
	}
	
//	Check the measuring range is lower then 10kPa and low range is bigger then high range 
	@Test
	public void CheckRangeLowerThen10WhenLowRangeIsBigger() {
		int rangeLow=50;
		int rangeHigh=42;
		
		float expectedValue=250;
		float realValue = count.rangePrice(rangeLow, rangeHigh);
		
		assertThat(realValue, equalTo(expectedValue));
	}
	
//	Check the measuring range is equal to 10kPa
	@Test
	public void CheckRangeEqualTo10() {
		int rangeLow=20;
		int rangeHigh=30;
		
		float expectedValue=250;
		float realValue = count.rangePrice(rangeLow, rangeHigh);
		
		assertThat(realValue, equalTo(expectedValue));
	}
	
//	Check the measuring range is higher then 10kPa and lower then 6000kPa
	@Test
	public void CheckRangeAbove10() {
		int rangeLow=0;
		int rangeHigh=90;
		
		float expectedValue=0;
		float realValue = count.rangePrice(rangeLow, rangeHigh);
		
		assertThat(realValue, equalTo(expectedValue));
	}
	
//	Check the measuring range is higher then 10kPa and low range is bigger then 0kPa
	@Test
	public void CheckHRangeAbove10WhenLowRangeIsNot0() {
		int rangeLow=2000;
		int rangeHigh=5000;
		
		float expectedValue=0;
		float realValue = count.rangePrice(rangeLow, rangeHigh);
		
		assertThat(realValue, equalTo(expectedValue));
	}
	
//	Check the measuring high range is equal to 6000kPA	
	@Test
	public void CheckHRangeEqualTo6000() {
		int rangeLow=2000;
		int rangeHigh=6000;
		
		float expectedValue=0;
		float realValue = count.rangePrice(rangeLow, rangeHigh);
		
		assertThat(realValue, equalTo(expectedValue));
	}
	
//	Check the measuring high range is higher then 6000kPA	
	@Test
	public void CheckHRangeHigherThen6000() {
		int rangeLow=2000;
		int rangeHigh=7000;
		
		float expectedValue=100;
		float realValue = count.rangePrice(rangeLow, rangeHigh);
		
		assertThat(realValue, equalTo(expectedValue));
	}
	
//	Check the measuring low range is higher then 6000kPA when high range is lower then 6000kPa
	@Test
	public void CheckLRangeHigherThen6000() {
		int rangeLow=7000;
		int rangeHigh=2000;
		
		float expectedValue=100;
		float realValue = count.rangePrice(rangeLow, rangeHigh);
		
		assertThat(realValue, equalTo(expectedValue));
	}
	
//	Check the measuring high range is equal to 20000kPa
	@Test
	public void CheckHRangeEqualTo20000() {
		int rangeLow=0;
		int rangeHigh=20000;
		
		float expectedValue=100;
		float realValue = count.rangePrice(rangeLow, rangeHigh);
		
		assertThat(realValue, equalTo(expectedValue));
	}
	
//	Check the measuring low range is equal to 20000kPa
	@Test
	public void CheckLRangeEqualTo20000() {
		int rangeLow=20000;
		int rangeHigh=5000;
		
		float expectedValue=100;
		float realValue = count.rangePrice(rangeLow, rangeHigh);
		
		assertThat(realValue, equalTo(expectedValue));
	}
	
//	Check the measuring high range is higher then 20000kPa
	@Test
	public void CheckHRangeHigherThen20000() {
		int rangeLow=20000;
		int rangeHigh=25000;
		
		float expectedValue=200;
		float realValue = count.rangePrice(rangeLow, rangeHigh);
		
		assertThat(realValue, equalTo(expectedValue));
	}
	
//	Check the measuring low range is higher then 20000kPa
	@Test
	public void CheckLRangeHigherThen20000() {
		int rangeLow=21000;
		int rangeHigh=0;
		
		float expectedValue=200;
		float realValue = count.rangePrice(rangeLow, rangeHigh);
		
		assertThat(realValue, equalTo(expectedValue));
	}
}
