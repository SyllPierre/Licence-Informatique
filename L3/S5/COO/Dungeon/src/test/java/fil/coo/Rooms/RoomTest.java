package fil.coo.Rooms;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoomTest {

	public Room createRoom() {
		return new MockRoom(10,10);
	}
	@Test
	public void testRoomIsNotNull() {
		assertNotNull(this.createRoom());
	}
	
	@Test
	public void testAddDirection() {
		Room room = this.createRoom();
		Room room2 = new Room(0,0);
		room.addDirection(Direction.EAST, room2);
		assertEquals(room.getMap().size(),1);
	}
	
	private class MockRoom extends Room {

		public MockRoom(int nbMonsters, int nbItems) {
			super(nbMonsters, nbItems);
		}
		
		
	}

}
