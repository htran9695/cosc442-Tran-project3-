package edu.towson.cis.cosc442.project2.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {
	VendingMachineItem item;
	VendingMachine theMachine;
	@Before
	public void setUp() throws Exception {
		item = new VendingMachineItem("Candy",2);
		theMachine= new VendingMachine();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	/*Test with correct values adding in*/
	public void testAddItemCorrectA() {
		assertTrue(theMachine.addItem(item, "A"));
	}
	
	@Test
	/*Test with correct values adding in*/
	public void testAddItemCorrectB() {
		assertTrue(theMachine.addItem(item, "B"));
	}
	
	@Test
	/*Test with correct values adding in*/
	public void testAddItemCorrectC() {
		assertTrue(theMachine.addItem(item, "C"));
	}
	
	@Test
	/*Test with correct values adding in*/
	public void testAddItemCorrectD() {
		assertTrue(theMachine.addItem(item, "D"));
	}
	
	@Test (expected = VendingMachineException.class)
	/*Test with incorrect values adding in*/
	public void testAddItemCorrectE() {
		theMachine.addItem(item, "E");
	}
	
	@Test (expected = VendingMachineException.class)
	/*Test with incorrect values adding in*/
	public void testAddItemFalse() {
		theMachine.addItem(item, "A");
		theMachine.addItem(item, "A");
		}

	@Test
	/*Test with actual item to remove */
	public void testRemoveItem() {
		theMachine.addItem(item, "A");
		theMachine.removeItem("A");
		assertNull(theMachine.getItem("A"));
	}

	@Test (expected = VendingMachineException.class)
	/*Test without item to remove */
	public void testRemoveItemNone(){
		theMachine.removeItem("A");
	}
	
	@Test (expected = VendingMachineException.class)
	/*Test with invalid amount to remove */
	public void testInsertMoneyNone() {
		theMachine.insertMoney(-200);
	}
	
	@Test 
	public void testInsertMoney() {
		theMachine.insertMoney(200);
		assertEquals(theMachine.getBalance(),200,0.00001);
	}

	@Test
	public void testGetBalance() {
		assertEquals(theMachine.getBalance(),0,0.0000001);
	}

	@Test
	public void testMakePurchaseSuccess() {
		theMachine.insertMoney(200);
		theMachine.addItem(item,"A");
		assertTrue(theMachine.makePurchase("A"));
	}
	
	@Test
	public void testMakePurchaseFail1() {
		theMachine.insertMoney(1);
		theMachine.addItem(item,"A");
		assertFalse(theMachine.makePurchase("A"));
	}
	
	@Test
	public void testMakePurchaseFail2() {
		theMachine.insertMoney(1);
		assertFalse(theMachine.makePurchase("A"));
	}

	@Test
	public void testReturnChange1() {
		theMachine.insertMoney(200);
		theMachine.addItem(item,"A");
		theMachine.makePurchase("A");
		assertEquals(198, theMachine.returnChange(),0.0001);
		
	}
	
	@Test
	public void testReturnChange2() {
		theMachine.insertMoney(200);
		theMachine.addItem(item,"A");
		theMachine.makePurchase("A");
		theMachine.returnChange();
		assertEquals(0, theMachine.getBalance(),0.0001);
		
	}

}
