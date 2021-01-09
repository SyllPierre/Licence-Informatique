/**
 * 
 */
package fil.coo.Items;

import static org.junit.Assert.*;
import org.junit.Test;

import fil.coo.Character.Player;


/**
 * @author
 *
 */
public class MockItemTest extends ItemTest{
	
	
	public Item createItem() {
		return new MockItem();
	}
	
	@Test
	public void TestGetName() {
		assertEquals(this.item.getName(),"an item");
	}
	
	@Test
	public void TestGetAmount(){
		assertEquals(this.item.getAmount(),0);
	}
	
	

	private class MockItem implements Item {

		private int amount = 0;

		@Override
		public int getAmount() {
			return this.amount;
		}

		@Override
		public String getName() {
			return "an item";
		}

		@Override
		public void display() {}

		@Override
		public void use(Player p) {}
			
	
	}

	
}