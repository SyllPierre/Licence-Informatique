package fil.coo.Items;

import static org.junit.Assert.*;

import org.junit.Test;


public class GoldPurseTest extends ItemTest {
	
	@Test 
	public void testUse(){
		this.item.use(this.player);
		assertEquals(65,this.player.getGold());
	}

	@Override
	public void TestGetName() {
		assertEquals(this.item.getName(),"a gold purse");
		
	}

	@Override
	public void TestGetAmount() {
		assertEquals(new GoldPurse().getAmount(),50);		
	}

	@Override
	public Item createItem() {
		return new GoldPurse();
	}

}
