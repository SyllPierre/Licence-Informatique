package fil.coo.Character;

import fil.coo.Rooms.Room;

public class MockCharacterTest extends CharTest{

	@Override
	public Char createChar() {
		this.r = new Room(2,0);
		this.s = 20;
		this.l = 120;
		this.g = 5;
		return new MockChar(this.s,this.l,this.g,this.r);
	}
	
	private class MockChar extends Char {

		public MockChar(int s, int l, int g, Room r) {
			super(s, l, g, r);
		}

			
	
	}

	
}
