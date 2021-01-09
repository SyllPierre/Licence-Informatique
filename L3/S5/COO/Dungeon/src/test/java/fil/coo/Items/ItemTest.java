
package fil.coo.Items;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import fil.coo.Character.Player;
import fil.coo.Rooms.Room;

public abstract class ItemTest {
	
	protected Item item;
	protected Player player;

	@Before
	public void before() {
		this.item = this.createItem();
		this.player = new Player(15,15,15,new Room(0,0));
	}
	
	@Test
	public abstract void TestGetName();
	
	@Test
	public abstract void TestGetAmount();
	
	@Test
	public void TestNotNull() {
		assertNotNull(this.item);
	}
	
	public abstract Item createItem();
}

