package fil.coo.Actions;

import fil.coo.Choseable;
import fil.coo.Game;
import fil.coo.Character.Player;

/**
 * Implements an action
 * @author desmarest syllebranque
 */
public interface Action extends Choseable {
	
	public void act(Game game, Player p);
}
