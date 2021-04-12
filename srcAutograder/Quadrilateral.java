/**
 * Various classifications of a quadrilateral. This version of the class
 * contains all the code needed to assess JUnit code testing it. To this aim,
 * the singleton class ResultStorageSingleton is used to store there, whether
 * this class is called, e.g. with valid and invalid parameters, no defect
 * masking occurs, etc.
 * 
 * Students submitting such an assignment would however get a version that does
 * not does these checks, but returns always, e.g., QuadrilateralType.irregular
 * (So, students submitting cannot simply have a look at the source code and see
 * which checks are done.) A Gradescope shell script then would take care to
 * replace the dummy for the students with this class here. 
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
	private ResultStorageSingleton resultStorage;

	public Quadrilateral() {
		resultStorage = ResultStorageSingleton.getInstance();
	}

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
		if (alpha == 0) {
			resultStorage.incrAlphaZero();
			throw new InvalidParameterException("Parameter alpha == 0");
		}
		if (alpha < 0) {
			resultStorage.incrAlphaLowerThanZero();
			throw new InvalidParameterException("Parameter alpha < 0");
		}

		if (beta <= 0) {
			throw new InvalidParameterException("Parameter beta is <= 0");
		}

		if ((alpha == 90) && (beta == 90) && (gamma == 90) && (delta == 90)) {
			resultStorage.incrRectangle();
			return QuadrilateralType.rectangle;
		}

		return QuadrilateralType.irregular;
	}
}
