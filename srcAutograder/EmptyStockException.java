public class EmptyStockException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmptyStockException(String message) {
        super(message);
    }
}