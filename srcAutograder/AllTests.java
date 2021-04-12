import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import java.util.Arrays;

import org.junit.AfterClass;

@RunWith(Suite.class)
@SuiteClasses({ VendingMachinePositiveTest.class })

public class AllTests {
	/**
	 * Executed after all tests of the test suite have been executed. Student
	 * submission would use a "normal" AllTest.java that would then be replaced by a
	 * version that adds the afterClass() method.
	 */
	@AfterClass
	public static void afterClass() {
		ResultStorageSingleton results = ResultStorageSingleton.getInstance();
		String[][] testCases = results.getTestCases();
		for(int i = 0; i < testCases.length; i++) {
			for(int j = 0; j < testCases[i].length; j++) {
				System.out.println(testCases[i][j]);
			}
			System.out.println();
		}
		System.out.println("HHAAAALLLOOOOOO");
			
		String[][] correctAnswers = {{"new VendingMachine()", "refill(10)"}, {"new VendingMachine(1)", "coinInserted()", "requestBottle()"}, {"new VendingMachine(10)", "coinInserted()", "requestBottle()"}, {"new VendingMachine(1)", "refill(9)"}};
		String[][] missingAnswers = new String[0][4];
		String[][] temp;
		for(int i = 0; i < correctAnswers.length; i++) {
			boolean isIncluded = false;
			for(int j = 0; j < testCases.length; j++) {
				if(Arrays.equals(correctAnswers[i], testCases[j])) {
					isIncluded = true;
					break;
				}
			}
			if(!isIncluded) {
				temp = new String[missingAnswers.length+1][4];
				for(int j = 0; j < missingAnswers.length; j++) {
					temp[i] = missingAnswers[i];
				}
				temp[missingAnswers.length] = correctAnswers[i];
				missingAnswers = temp;
			}
		}
		System.out.println("Num of missing answers: " + missingAnswers.length);
		int additional = testCases.length - 4 + missingAnswers.length;
		System.out.println("Num of additional answers: " + additional);
		for(int i = 0; i < missingAnswers.length; i++) {
			for(int j = 0; j < missingAnswers[i].length; j++) {
				System.out.println(missingAnswers[i][j]);
			}
			System.out.println();
		}
	}
}