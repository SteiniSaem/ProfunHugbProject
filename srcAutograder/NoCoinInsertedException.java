public class NoCoinInsertedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoCoinInsertedException(String message) {
        super(message);
    }
}