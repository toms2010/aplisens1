package aplisens.logic;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CountPCHousingTest {

	CountPC count;
	
	@Before
	public void setUp() {
		count = new CountPC();
	}
	

	@Test
	public void housingTypeIsPD() {
		String housingType= "PD";
				
		float expectedValue=0;
		float realValue = count.housingTypePrice(housingType);

		assertThat(realValue, equalTo(expectedValue));
	}
	
	@Test
	public void housingTypeIsPZ() {
		String housingType= "PZ";
				
		float expectedValue=220;
		float realValue = count.housingTypePrice(housingType);

		assertThat(realValue, equalTo(expectedValue));
	}
	
	@Test
	public void housingTypeIsPK() {
		String housingType= "PK";
				
		float expectedValue=90;
		float realValue = count.housingTypePrice(housingType);

		assertThat(realValue, equalTo(expectedValue));
	}
	
	@Test
	public void housingTypeIsPM12() {
		String housingType= "PM12";
				
		float expectedValue=170;
		float realValue = count.housingTypePrice(housingType);

		assertThat(realValue, equalTo(expectedValue));
	}
	
	@Test
	public void housingTypeIsSG() {
		String housingType= "SG";
				
		float expectedValue=250;
		float realValue = count.housingTypePrice(housingType);

		assertThat(realValue, equalTo(expectedValue));
	}
}
