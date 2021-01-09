package fil.coo.Character;
import fil.coo.Rooms.Room;

import org.junit.Test;


public class PlayerTest extends CharTest {

	public Char createChar() {
		this.s = 105;
		this.l = 10;
		this.g = 140;
		this.r = new Room(2,0);
		return new Player(this.s,this.l,this.g, this.r);
	}
	
	

}
