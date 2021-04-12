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

	private int constructorCalls;

	private boolean exceptionThrown;

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
	}

	/**
	 * Return how often the classify method was called with parameter alpha < 0
	 */
	public boolean getExceptionThrown() {
		return exceptionThrown;
	};


	/**
	 * Increment how often the classify method was called with parameter alpha < 0
	 */
	public void setExcetionThrown() {
		exceptionThrown = true;
	}
}
