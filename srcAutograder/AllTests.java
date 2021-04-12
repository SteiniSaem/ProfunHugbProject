import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.AfterClass;

@RunWith(Suite.class)
@SuiteClasses({ QuadrilateralNegativeTest.class, QuadrilateralPositiveTest.class })

public class AllTests {
	/**
	 * Executed after all tests of the test suite have been executed. Student
	 * submission would use a "normal" AllTest.java that would then be replaced by a
	 * version that adds the afterClass() method.
	 */
	@AfterClass
	public static void afterClass() {
		ResultStorageSingleton results = ResultStorageSingleton.getInstance();
		System.out.println("Tested with parameter alpha == 0: " + results.getAlphaZero() + " times");
		System.out.println("Tested with parameter alpha < 0: " + results.getAlphaLowerThanZero() + " times");
		System.out.println("Tested with parameter yielding rectangle: " + results.getRectangle() + " times");
		// TODO: @Helmut: Check that student test suite gives a green bar. (Could be done via, e.g., a TestListener)
	}
}