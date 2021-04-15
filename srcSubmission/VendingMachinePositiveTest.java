import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VendingMachinePositiveTest {
	VendingMachine vm;

	/*@Before
	public void setUp() {
		vm = new VendingMachine();
	}*/
	
	@Test
	public void extraTest() {
		vm = new VendingMachine();
		assertTrue(vm.isEmpty());
	}

	@Test
	public void TC1() {
		vm = new VendingMachine();
		assertTrue(vm.isEmpty());
		vm.refill(vm.getCapacity());
		assertTrue(vm.isFull());
	}
	
	@Test
	public void TC2() {
		vm = new VendingMachine(1);
		vm.refill(9);
		assertTrue(vm.isFull());
	}

	@Test
	public void TC3() {
		vm = new VendingMachine(1);
		assertEquals(1, vm.getStock());
		vm.insertCoin();
		assertTrue(vm.isCoinInserted());
		vm.requestBottle();
		assertTrue(vm.isEmpty());
		assertFalse(vm.isCoinInserted());
	}
	
	@Test
	public void TC4() {
		vm = new VendingMachine(10);
		assertTrue(vm.isFull());
		vm.insertCoin();
		assertTrue(vm.isCoinInserted());
		vm.requestBottle();
		assertEquals(9, vm.getStock());
		assertFalse(vm.isFull());
		assertFalse(vm.isEmpty());
	}
	
}
