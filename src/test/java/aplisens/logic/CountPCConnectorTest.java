package aplisens.logic;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CountPCConnectorTest {

	CountPC count;
	
	@Before
	public void setUp() {
		count = new CountPC();
	}
	

	@Test
	public void connectorTypeIsM20x1() {
		String connectorType= "M20x1";
				
		float expectedValue=0;
		float realValue = count.connectorTypePrice(connectorType);

		assertThat(realValue, equalTo(expectedValue));
	}
	
	@Test
	public void connectorTypeIsG12() {
		String connectorType= "G12";
				
		float expectedValue=0;
		float realValue = count.connectorTypePrice(connectorType);

		assertThat(realValue, equalTo(expectedValue));
	}
	
	@Test
	public void connectorTypeIsNPT12() {
		String connectorType= "NPT12";
				
		float expectedValue=120;
		float realValue = count.connectorTypePrice(connectorType);

		assertThat(realValue, equalTo(expectedValue));
	}
	
	@Test
	public void connectorTypeIsG14() {
		String connectorType= "G14";
				
		float expectedValue=30;
		float realValue = count.connectorTypePrice(connectorType);

		assertThat(realValue, equalTo(expectedValue));
	}
	
	@Test
	public void connectorTypeIsCM30x2() {
		String connectorType= "CM30x2";
				
		float expectedValue=130;
		float realValue = count.connectorTypePrice(connectorType);

		assertThat(realValue, equalTo(expectedValue));
	}
	
	@Test
	public void connectorTypeIsCG1() {
		String connectorType= "CG1";
				
		float expectedValue=210;
		float realValue = count.connectorTypePrice(connectorType);

		assertThat(realValue, equalTo(expectedValue));
	}
	
	@Test
	public void connectorTypeIsCG12() {
		String connectorType= "CG12";
				
		float expectedValue=180;
		float realValue = count.connectorTypePrice(connectorType);

		assertThat(realValue, equalTo(expectedValue));
	}

}
