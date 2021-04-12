
public class VendingMachine {
	private final int capacity = 10;
	private int stock = 0;
	private boolean coinInserted = false;
	
	public VendingMachine() { };
	
	public VendingMachine(int x) throws CapacityExceededException, NegativeOrZeroParameterException { 
		this.stock = x;
		if(x > 10) {
			throw new CapacityExceededException("stock is more than 10");
		}
	};
	public void refill(int x) throws CapacityExceededException,CurrentlyCoinInsertedException,NegativeOrZeroParameterException { 
		this.stock += x;
	};
	public void insertCoin() throws MoreThanOneCoinInsertedException, EmptyStockException { };
	
	Bottle requestBottle() throws NoCoinInsertedException { };
}

