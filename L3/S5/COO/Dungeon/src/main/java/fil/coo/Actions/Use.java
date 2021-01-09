package fil.coo.Actions;

import java.util.List;

import fil.coo.Game;
import fil.coo.Character.Player;
import fil.coo.Items.Item;

/**
 * Implements the use of an object
 * @author desmarest syllebranque
 */
public class Use implements Action {

	/**
	 * Displays the action
	 */
	public void display(){
		System.out.println("You can use an item.");
	}
	
	/**
	 * Acts in the game
	 */
	public void act(Game game, Player p){
		System.out.println("Which item do you want to use ? ");
		List<Item> list = p.getRoom().getItems();
		Item itemToUse = Game.getAnObject(list);
		itemToUse.use(p);
		p.getRoom().getItems().remove(itemToUse);
	}
	
}
