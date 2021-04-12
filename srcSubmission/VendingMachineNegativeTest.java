import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VendingMachineNegativeTest {
	VendingMachine vm;


	@Test(expected = CapacityExceededException.class)
	public void testCapacity() throws Exception {
		vm = new VendingMachine(11);
	}

	@Test(expected = CurrentlyCoinInsertedException.class)
	public void testCoinInserted() throws Exception {
		vm = new VendingMachine(10);
		vm.insertCoin();
		vm.insertCoin();
	}

	
	@Test(expected = EmptyStockException.class)
	public void testEmptyStock() throws Exception {
		vm = new VendingMachine();
		vm.insertCoin();
	}
	
	@Test(expected = NegativeOrZeroParameterException.class)
	public void testNegativeOrZero() throws Exception {
		vm = new VendingMachine(-1);
	}
	
	@Test(expected = NoCoinInsertedException.class)
	public void testNoCoinInserted() throws Exception {
		vm = new VendingMachine(10);
		vm.requestBottle();
	}

}
