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

	private int alphaZero;

	private int alphaLowerThanZero;

	private int rectangle;

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
	public int getAlphaZero() {
		return alphaZero;
	}

	/**
	 * Increment how often the classify method was called with parameter alpha == 0
	 */
	public void incrAlphaZero() {
		alphaZero++;
	}

	/**
	 * Return how often the classify method was called with parameter alpha < 0
	 */
	public int getAlphaLowerThanZero() {
		return alphaLowerThanZero;
	};


	/**
	 * Increment how often the classify method was called with parameter alpha < 0
	 */
	public void incrAlphaLowerThanZero() {
		alphaLowerThanZero++;
	}


	/**
	 * Return how often the classify method was called with parameter yielding a rectangle
	 */
	public int getRectangle() {
		return rectangle;
	}

	/**
	 * Increment how often the classify method was called with parameter yielding a rectangle
	 */
	public void incrRectangle() {
		rectangle++;
		
	}
}
