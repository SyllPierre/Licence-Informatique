package fil.coo.Items;

import static org.junit.Assert.*;

import org.junit.Test;



public class StrengthPotionTest extends ItemTest {

	@Test 
	public void testUse(){
		this.item.use(this.player);
		assertEquals(22,this.player.getStrength());
	}

	@Override
	public void TestGetName() {
		assertEquals(this.item.getName(),"a strength potion");

	}

	@Override
	public void TestGetAmount() {
		assertEquals(this.item.getAmount(),7);		
	}

	@Override
	public Item createItem() {
		return new StrengthPotion();
	}

}
