package fil.coo;
import java.util.List;
import scanner.*;
import fil.coo.Actions.Action;
import fil.coo.Character.*;
import fil.coo.Rooms.*;

/**
 * Create a Game
 * @author desmarest syllebranque
 */
public class Game {
	private Player player;
	/**
	 * create a game
	 */
	public Game(){
		BeginningRoom beginningRoom = new BeginningRoom();
		Room room1 = new Room(2,1);
		room1.addDirection(Direction.NORTH, beginningRoom);
		Room room2 = new Room (1,3);
		room2.addDirection(Direction.EAST, room1);
		room2.addDirection(Direction.SOUTH, beginningRoom);
		Room endRoom = new EndRoom();
		endRoom.addDirection(Direction.WEST, room2);
		player = new Player(10,20,50,beginningRoom);
	}
	/**
	 * returns the player
	 * @return the player
	 */
	public Player getPlayer(){
		return this.player;
	}
	/**
	 * Play a game
	 * @param args Param for the main
	 */
	public static void main(String[] args){
		Game game = new Game();
		Player p = game.getPlayer();
		System.out.println("Welcome !");
		while (!(p.getRoom() instanceof EndRoom)){
			Room room = p.getRoom();
			room.displayName();
			p.displayInformations();
			List<Action> actions = room.getPossibleActions();
			Action object = getAnObject(actions);
			if (object != null) object.act(game, p);
		}
		System.out.println("End of the game. You made it out of the dungeon. You won ! ");
		
	}
	/**
	 * Get an object in the list
	 * @param list the list we want to get an object from
	 * @param <T> an object we can choose
	 * @return an objct from the list
	 */
	public static <T extends Choseable> T getAnObject(List<T> list) {
		int cpt = 1;
		int res = 0;
		T object = null;
		
		for (Choseable item : list) {
			System.out.print("Choice n°" + cpt + " : " );
			item.display();
			cpt++;
		}
		System.out.println("type 0 to quit");

		res = choiceOfPlayerOnKeyboard(0, list.size());
		if (res > 0) {
			object = list.get(res - 1);
		}
		if (res == 0){
			System.out.println("You have chosen to quit\nEnd of the game");
			System.exit(0);
		}
		return object;
	}
	/**
	 * Asks the player which object he wants to get
	 * @param deb beginning of the list
	 * @param size the size of the list
	 * @return an int of the choice of the player
	 */
	private static int choiceOfPlayerOnKeyboard(int deb, int size) {
		int res = 0;
		System.out.println("Your choice : " + deb + " - " + size);
		res = ScannerInt.readInt(size+1);
		return res;
	}

}
