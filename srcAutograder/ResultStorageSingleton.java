/**
 * Class for storing results from the class that gets tested be the submitted
 * JUnit tests.
 * 
 * This class uses the singleton design pattern, so that it can be used by all
 * instance of the class that gets tested. => Instantiate via getInstance()
 * 
 *
 */
public class ResultStorageSingleton {
	private static ResultStorageSingleton theInstance = null;

	private int constructorCalls = 0;
	private int methodCalls = 0;

	private int exceptionThrows;
	
	public String[][] testCases = new String[5][4];

	public static ResultStorageSingleton getInstance() {
		if (theInstance == null) { // Lazy instantiation
			theInstance = new ResultStorageSingleton();
		}
		return theInstance;
	}

	protected ResultStorageSingleton() { // Class may not be instantiated by others
	};

	/**
	 * Return how often the classify method was called with parameter alpha == 0
	 */
	public int numOfConstuctorCalls() {
		return constructorCalls;
	}

	/**
	 * Increment how often the classify method was called with parameter alpha == 0
	 */
	public void incrConstructorCalls() {
		constructorCalls++;
		methodCalls = 0;
	}
	public void incrMethodCalls() {
		methodCalls++;
	}
	
	public int getMethodCalls() {
		return methodCalls;
	}
	
	/**
	 * Return how often the classify method was called with parameter alpha < 0
	 */
	public int getExceptionThrows() {
		return exceptionThrows;
	};


	/**
	 * Increment how often the classify method was called with parameter alpha < 0
	 */
	public void incrExceptionThrows() {
		exceptionThrows++;
	}
	
	public String[][] getTestCases() {
		for(int i = 0; i < testCases.length; i++) {
			testCases[i] = removeNulls(testCases[i]);
		}
		return testCases;
	}
	
	public void addToTestCase(String s) {
		testCases[constructorCalls-1][methodCalls] = s;
		incrMethodCalls();
	}
	
	public static String[] removeNulls(String[] array) {
		int nullCount = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] == null) {
				nullCount++;
			}
		}
		String[] copy = new String[array.length - nullCount];
		for(int i = 0, j = 0; i < array.length; i++) {
			if(array[i] != null) {
				copy[j++] = array[i];
			}
		}
		return copy;
	}
}
