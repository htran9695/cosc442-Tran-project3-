package edu.towson.cis.cosc442.project2.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineItemTest {
	VendingMachineItem item;
	VendingMachineItem itemfalse;

	@Before
	public void setUp() throws Exception {
		item = new VendingMachineItem("Candy",2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testVendingMachineItem() {
		assertNotNull(item);
		
	}
	
	@Test (expected = VendingMachineException.class)
	/*Testing for invalid Item*/
	public void testVendingMachineItemFalse() {
		itemfalse = new VendingMachineItem("Bug",-666);
		
	}

	@Test
	public void testGetName() {
		assertEquals("Candy", item.getName());
	}

	@Test
	public void testGetPrice() {
		double x = item.getPrice();
		assertEquals(x, 2,0.001);
	}

}
