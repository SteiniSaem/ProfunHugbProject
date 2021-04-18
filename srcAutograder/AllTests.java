import org.junit.runner.RunWith;

import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import java.util.Arrays;

import org.junit.AfterClass;


@RunWith(Suite.class)
@SuiteClasses({VendingMachinePositiveTest.class, VendingMachineNegativeTest.class})

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
		String[][] correctAnswers = {{"new VendingMachine()", "refill(10)"}, {"new VendingMachine(1)", "refill(9)",}, {"new VendingMachine(1)", "insertCoin()", "requestBottle()"}, {"new VendingMachine(10)", "insertCoin()", "requestBottle()"}};
		System.out.println("Test cases submitted:\n");
		for(int i = 0; i < testCases.length; i++) {
			for(int j = 0; j < testCases[i].length; j++) {
				System.out.println(testCases[i][j]);
			}
			System.out.println();
		}
			
		String[][] missingAnswers = new String[5][4];

		int numOfMissingAnswers = 0;
		for(int i = 0; i < correctAnswers.length; i++) {
			boolean isIncluded = false;
			for(int j = 0; j < testCases.length; j++) {
				if(Arrays.equals(correctAnswers[i], testCases[j])) {
					isIncluded = true;
					break;
				}
			}
			if(!isIncluded) {
				missingAnswers[numOfMissingAnswers] = correctAnswers[i];
				numOfMissingAnswers++;
			}
		}
		
		if(results.getExceptionThrows() == 0) {
			numOfMissingAnswers++;
		}
		
		System.out.println("Num of missing answers: " + numOfMissingAnswers);
		int additional = testCases.length - 5 + numOfMissingAnswers;
		System.out.println("Num of additional answers: " + additional);
		System.out.println("Num of exception throws: " + results.getExceptionThrows());
		System.out.println("Missing Answers:\n");
		if (results.getExceptionThrows() == 0) {
			System.out.println("A concrete negative test case is missing!");
			System.out.println();
		}
		for(int i = 0; i < missingAnswers.length; i++) {
			for(int j = 0; j < missingAnswers[i].length; j++) {
				if(missingAnswers[i][j] != null) {
					System.out.println(missingAnswers[i][j]);
				}
			}
			System.out.println();
		}
		
	}
}