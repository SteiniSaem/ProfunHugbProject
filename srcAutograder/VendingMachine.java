
public class VendingMachine {
	private final int capacity = 10;
	private int stock = 0;
	private boolean coinInserted = false;
	private ResultStorageSingleton storage;
	
	public VendingMachine() {
		storage = ResultStorageSingleton.getInstance();
		storage.incrConstructorCalls();
		stock = 0;
	};
	
	public VendingMachine(int x) throws CapacityExceededException, NegativeOrZeroParameterException { 
		storage = ResultStorageSingleton.getInstance();
		storage.incrConstructorCalls();
		if(x > 10) {
			throw new CapacityExceededException("Stock is more than 10");
		} else if(x <= 0) {
			throw new NegativeOrZeroParameterException("Stock has to be positive integer");
		}
		stock = x;
	};
	public void refill(int x) throws CapacityExceededException,CurrentlyCoinInsertedException,NegativeOrZeroParameterException { 
		storage.addToTestCase("refill(" + x + ")");
		if(stock + x > 10) {
			throw new CapacityExceededException("Stock is more than 10");
		}
		if (x <= 0) {
			throw new NegativeOrZeroParameterException("Stock has to be positive integer");
		}
		if(coinInserted) {
			throw new CurrentlyCoinInsertedException("coin is inserted");
		}
		stock += x;
	};
	public void insertCoin() throws CurrentlyCoinInsertedException, EmptyStockException { 
		storage.addToTestCase("insertCoin");
		if(this.stock == 0) {
			throw new EmptyStockException("No stock");
		}
		if(coinInserted) {
			throw new CurrentlyCoinInsertedException("Coin already inserted");
		}
		coinInserted = true;
	};
	
	
	public void requestBottle() throws NoCoinInsertedException {
		storage.addToTestCase("requestBottle");
		if(!coinInserted) {
			throw new NoCoinInsertedException("No coin insterted");
		}
		stock--;
		coinInserted = false;
	};
	
	public int getCapacity() {
		return capacity;
	}
	
	public int getStock() {
		return stock;
	}
	
	public boolean isCoinInserted() {
		return coinInserted;
	}
	
	public boolean isFull() {
		return stock == capacity;
	}
	
	public boolean isEmpty() {
		return stock == 0;
	}
}

