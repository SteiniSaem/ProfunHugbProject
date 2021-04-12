/**
 * Various classifications of a quadrilateral. This version of the class
 * contains just some dummies so that the JUnit code has some interface to test
 * against.
 * Correct JUnit test would fail though, because this here is just a dummy implementation.
 */

enum QuadrilateralType {
	/**
	 * (alpha + beta + gamma + delta) == 360
	 */
	irregular,

	/**
	 * (alpha == gamma) && (beta == delta) && (alpha != delta)
	 */
	parallelogram,

	/**
	 * alpha == beta == gamma == delta == 90
	 */
	rectangle
}

/**
 * Everything related to a quadrilateral
 * 
 */

public class Quadrilateral {

	/**
	 * Classifies a quadrilateral based on its internal angels
	 * 
	 * @param alpha first angle
	 * @param beta  second angle
	 * @param gamma third angle
	 * @param delta fourth angle
	 * @return the classification
	 * @throws InvalidParameterException for invalid parameters
	 */

	public QuadrilateralType classify(int alpha, int beta, int gamma, int delta) throws InvalidParameterException {
		// Just some dummy code here

		return QuadrilateralType.irregular;
	}
}
