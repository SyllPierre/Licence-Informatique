package fil.coo.Items;

import static org.junit.Assert.*;

import org.junit.Test;



public class OneArmedBanditTest extends ItemTest {
	
	@Test 
	public void testUseWhenPlayerDoesntHaveEnoughMoney(){
		this.item.use(this.player);
		assertEquals(15,this.player.getGold());
	}
	
	
	@Override
	public void TestGetName() {
		assertEquals(this.item.getName(),"an one armed bandit");
		
	}

	@Override
	public void TestGetAmount() {
		assertEquals(this.item.getAmount(),25);		
	}

	@Override
	public Item createItem() {
		return new OneArmedBandit();
	}

}
