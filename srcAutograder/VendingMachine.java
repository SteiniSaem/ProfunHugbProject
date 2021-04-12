
public class VendingMachine {
	private final int capacity = 10;
	private int stock = 0;
	private boolean coinInserted = false;
	
	public VendingMachine() {
		this.stock = 0;
	};
	
	public VendingMachine(int x) throws CapacityExceededException, NegativeOrZeroParameterException { 
		if(x > 10) {
			throw new CapacityExceededException("Stock is more than 10");
		} else if(x <= 0) {
			throw new NegativeOrZeroParameterException("Stock has to be positive integer");
		}
		this.stock = x;
	};
	public void refill(int x) throws CapacityExceededException,CurrentlyCoinInsertedException,NegativeOrZeroParameterException { 
		if(this.stock + x > 10) {
			throw new CapacityExceededException("Stock is more than 10");
		}
		if (x <= 0) {
			throw new NegativeOrZeroParameterException("Stock has to be positive integer");
		}
		if(this.coinInserted) {
			throw new CurrentlyCoinInsertedException("coin is inserted");
		}
		this.stock += x;
	};
	public void insertCoin() throws CurrentlyCoinInsertedException, EmptyStockException { 
		if(this.stock == 0) {
			throw new EmptyStockException("No stock");
		}
		if(this.coinInserted) {
			throw new CurrentlyCoinInsertedException("Coin already inserted");
		}
		this.coinInserted = true;
	};
	
	
	public void requestBottle() throws NoCoinInsertedException {
		if(!coinInserted) {
			throw new NoCoinInsertedException("No coin insterted");
		}
		this.stock--;
		this.coinInserted = false;
	};
}

