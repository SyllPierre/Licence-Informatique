package fil.coo.Actions;

import fil.coo.Game;
import fil.coo.Character.Player;

/**
 * Implements a suicide
 * @author desmarest syllebranque
 *
 */
public class Suicide implements Action {
	/**
	 * Displays the action
	 */
	public void display(){
		System.out.println("You can end the game.");
	}
	/**
	 * Acts in the game
	 */
	public void act(Game game, Player p){
		System.out.println("You chose to end the game.");
		System.exit(0);
	}
}
