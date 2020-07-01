package adubolazov.quiz.inn;

import static adubolazov.quiz.inn.InnUtils.parseInn;
import static org.junit.Assert.*;

import org.junit.Test;

public class InnUtilsTest {


	private static final String INN1 = "    _  _     _  _  _  _  _ \n" + 
									   "  | _| _||_||_ |_   ||_||_|\n" +
									   "  ||_  _|  | _||_|  ||_| _|\n";

	private static final String INN2 = " _  _  _     _  _  _  _    \n" + 
									   "| | _||_||_||_ | |  ||_|  |\n" +
									   "|_||_  _|  | _||_|  ||_|  |\n";

	private static final String INN3 = " _  _  _     _  _  _  _    \n" + 
									   "| || ||_||_||_ | |  ||_|  |\n" +
									   "|_||_| _|  | _||_|  ||_|  |\n";

	private static final String INN4 = " _  _  _     _  _  _  _    \n" + 
									   "| | _|| ||_||_ | |  ||_|  |\n" +
									   "|_||_  _|  | _||_|  ||_|  |\n";

	@Test
	public void testParsing() {
		assertEquals("123456789", parseInn(INN1));
		assertEquals("29450781", parseInn(INN2));
		assertEquals("9450781", parseInn(INN3));
		try {
			parseInn(INN4);
			fail("Exception expected");
		} catch (RuntimeException e) {
			assertTrue(e.getMessage().startsWith("Invalid value:"));
		}
	}
}
