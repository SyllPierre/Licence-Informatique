package fil.coo.Actions;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fil.coo.Game;
import fil.coo.Character.Player;
import fil.coo.Rooms.Direction;
import fil.coo.Rooms.Room;

/**
 * Implements a move
 * @author desmarest syllebranque
 */
public class Move implements Action {
	/**
	 * Displays the action
	 */
	public void display(){
		System.out.println("You can move.");
	}
	
	/**
	 * Acts in the game
	 */
	public void act(Game game, Player p){
		System.out.println("You chose to move.");
		System.out.println("");
		Room room = p.getRoom();
		Map<Direction,Room> map = room.getMap();
		List<Room> list = new ArrayList<Room>();
		for (Map.Entry<Direction,Room> entry : map.entrySet()){
			list.add(entry.getValue());
		}
		Room roomToSet = Game.getAnObject(list);
		p.setRoom(roomToSet);
		}
}
