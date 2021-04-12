import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.AfterClass;

@RunWith(Suite.class)
@SuiteClasses({ VendingMachineNegativeTest.class, VendingMachinePositiveTest.class })

public class AllTests {
	/**
	 * Executed after all tests of the test suite have been executed. Student
	 * submission would use a "normal" AllTest.java that would then be replaced by a
	 * version that adds the afterClass() method.
	 */
	@AfterClass
	public static void afterClass() {
		ResultStorageSingleton results = ResultStorageSingleton.getInstance();
		for(int i = 0; i < results.testCases.length; i++) {
			for(int j = 0; j < results.testCases[i].length; j++) {
				System.out.println(results.testCases[i][j]);
			}
			System.out.println();
		}
	}
}