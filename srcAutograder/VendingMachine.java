
public class VendingMachine {
	private final int capacity = 10;
	private int stock = 0;
	private boolean coinInserted = false;
	private ResultStorageSingleton storage;
	
	public VendingMachine() {
		storage = ResultStorageSingleton.getInstance();
		storage.incrConstructorCalls();
		storage.addToTestCase("new VendingMachine()");
		stock = 0;
	};
	
	public VendingMachine(int x) throws CapacityExceededException, NegativeOrZeroParameterException { 
		storage = ResultStorageSingleton.getInstance();
		if(x > 10) {
			storage.incrExceptionThrows();
			throw new CapacityExceededException("Stock is more than 10");
		} else if(x <= 0) {
			storage.incrExceptionThrows();
			throw new NegativeOrZeroParameterException("Stock has to be positive integer");
		}
		storage.incrConstructorCalls();
		storage.addToTestCase("new VendingMachine(" + x + ")");
		stock = x;
	};
	public void refill(int x) throws CapacityExceededException,CurrentlyCoinInsertedException,NegativeOrZeroParameterException { 
		if(stock + x > 10) {
			storage.incrExceptionThrows();
			throw new CapacityExceededException("Stock is more than 10");
		}
		if (x <= 0) {
			storage.incrExceptionThrows();
			throw new NegativeOrZeroParameterException("Stock has to be positive integer");
		}
		if(coinInserted) {
			storage.incrExceptionThrows();
			throw new CurrentlyCoinInsertedException("coin is inserted");
		}
		storage.addToTestCase("refill(" + x + ")");
		stock += x;
	};
	public void insertCoin() throws CurrentlyCoinInsertedException, EmptyStockException { 
		if(this.stock == 0) {
			storage.incrExceptionThrows();
			throw new EmptyStockException("No stock");
		}
		if(coinInserted) {
			storage.incrExceptionThrows();
			throw new CurrentlyCoinInsertedException("Coin already inserted");
		}
		storage.addToTestCase("insertCoin()");
		coinInserted = true;
	};
	
	
	public void requestBottle() throws NoCoinInsertedException {
		if(!coinInserted) {
			storage.incrExceptionThrows();
			throw new NoCoinInsertedException("No coin insterted");
		}
		stock--;
		storage.addToTestCase("requestBottle()");
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

