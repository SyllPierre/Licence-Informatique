package fil.coo.Character;
import static org.junit.Assert.*;

import org.junit.Test;

import fil.coo.Rooms.Room;


public abstract class CharTest {
	protected Char character;
	protected  Room r;
	protected int s;
	protected int l;
	protected int g;
	
	public abstract Char createChar();
	
	@org.junit.Before
	public void Before() {
		this.character= this.createChar();
	}
	
	@Test
	public void charIsNotNull() {
		assertNotNull(this.character);
	}
	
	@Test
	public void testGetRoom(){
		assertEquals(this.r, this.character.getRoom());
	}
	
	@Test
	public void testGetLife(){
		assertEquals(this.l, this.character.getLife());
	}
	
	@Test
	public void testGetGold(){
		assertEquals(this.g, this.character.getGold());
	}
	
	@Test
	public void testGetStrength(){
		assertEquals(this.s, this.character.getStrength());
	}
	
	@Test
	public void testIsDead() {
		assertFalse(this.character.isDead());
		this.character.setLife(0);
		assertTrue(this.character.isDead());
	}
	
}
