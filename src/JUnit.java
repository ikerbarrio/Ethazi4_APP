import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import APP.Metodoak;

public class JUnit {

	@Test
	public void testKenketa() {
		assertEquals(Metodoak.kenketa("20", "10"),"10.0");
	}
	
	@Test
	public void testNanKomprobaketa() {
		assertEquals(Metodoak.nanKomprobaketa("12345678Z"),true);
	}
	
//	@Test
//	public void testPasahitzaKomprobaketa() {
//		assertEquals(Metodoak.pasahitzaKomprobaketa("123"),true);
//	}

	@Test
	public void testNanBalidatu() {
		assertEquals(Metodoak.nanKomprobaketa("12345678Z"),true);
	}


}
