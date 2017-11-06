package aplisens.logic;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CountSGRangeTest {

	CountSG count;
	
	@Before
	public void setUp() {
		count = new CountSG();
	}
	
//	Check the measuring range is lower then 10m 
	@Test
	public void CheckRangeLowerThen10() {
		int range=5;
		
		float expectedValue=0;
		float realValue = count.rangePrice(range);
		
		assertThat(realValue, equalTo(expectedValue));
	}
	
//	Check the measuring range is equal 10m
	@Test
	public void CheckRangeEqual10() {
		int range=10;
		
		float expectedValue=0;
		float realValue = count.rangePrice(range);
		
		assertThat(realValue, equalTo(expectedValue));
	}
//	Check the measuring range is lower then 100m and higher then 10
	@Test
	public void CheckRangeBetween0And100() {
		int range=80;
	
		float expectedValue=100;
		float realValue = count.rangePrice(range);
		
		assertThat(realValue, equalTo(expectedValue));
	}
//	Check the measuring range is equal 100m
	@Test
	public void CheckRangeEqual100() {
		int range=100;
		
		float expectedValue=100;
		float realValue = count.rangePrice(range);
		
		assertThat(realValue, equalTo(expectedValue));
	}
	
//	Check the measuring range is higher then 100m
	@Test
	public void CheckRangeHigherThen100() {
		int range=120;
		
		float expectedValue=200;
		float realValue = count.rangePrice(range);
		
		assertThat(realValue, equalTo(expectedValue));
	}
}
