package fil.coo.Actions;

import fil.coo.Game;
import fil.coo.Character.Player;
import fil.coo.Rooms.Room;

/**
 * Implements an action where the player is looking
 * @author desmarest syllebranque
 */
public class Look implements Action {
	/**
	 * Creates an action where the player is looking
	 */
	public Look(){}
	
	/**
	 * The action Look is always possible.
	 * @return a boolean true.
	 * @param p the player 
	 */
	public boolean isPossible(Player p){
		return true;
	}
	/**
	 * Displays the action
	 */
	public void display(){
		System.out.println("You can look.");
	}
	/**
	 * Acts in the game
	 * @param game the gale
	 * @param p the player
	 */
	public void act(Game game, Player p){
		System.out.println("You chose to look what's in the room.");
		Room r = p.getRoom();
		r.displayInformations();
	}
}
