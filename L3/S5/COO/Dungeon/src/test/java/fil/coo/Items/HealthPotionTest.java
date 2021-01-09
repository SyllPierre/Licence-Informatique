package fil.coo.Items;

import static org.junit.Assert.*;

import org.junit.Test;


public class HealthPotionTest extends ItemTest {

	
	@Test 
	public void testUse(){
		this.item.use(this.player);
		assertEquals(45,this.player.getLife());
	}

	@Override
	public void TestGetName() {
		assertEquals(this.item.getName(),"a health potion");
		
	}

	@Override
	public void TestGetAmount() {
		assertEquals(this.item.getAmount(),30);		
	}

	@Override
	public Item createItem() {
		return new HealthPotion();
	}

}
