import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QuadrilateralNegativeTest {
	Quadrilateral quadrilateral;

	@Before
	public void setUp()  {
		quadrilateral = new Quadrilateral();
	}

	@Test(expected = InvalidParameterException.class)
	public void testNegativeAlpha() throws Exception {
		quadrilateral.classify(-10, 40, 30, 300);
	}

	@Test(expected = InvalidParameterException.class)
	public void testZeroAlpha() throws Exception {
		quadrilateral.classify(0, 50, 30, 300);
	}

	
	@Test(expected = InvalidParameterException.class)
	public void testWronglyIgnoringDefectMasking() throws Exception {
		quadrilateral.classify(-10, -40, -30, -300);
	}

}
