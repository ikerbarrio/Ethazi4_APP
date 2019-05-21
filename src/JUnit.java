import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import APP.Metodoak;

public class JUnit {
	Metodoak m = new Metodoak();

	@Test
	public void testKenketa() {
		assertEquals(Metodoak.kenketa("20", "10"),"10.0");
	}
	
	@Test
	public void testNanBalidatu() {
		assertEquals(Metodoak.NANbalidatu("12345678Z"),true);
	}
	
	@Test
	public void testDatenKenketa() {
		assertEquals(m.datenKenketa("12/02/99", "14/02/99"),2);
	}
	
	@Test
	public void testPrezioKalk() {
		assertEquals(m.prezioKalk(2, "Banakakoa"),40);
	}
	
	@Test
	public void testKalkulatuDenboraldia() {
		assertEquals(m.kalkulatuDenboraldia("20/08/19", "22/08/19"),"alta");
	}


}
