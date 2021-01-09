package fil.coo.Actions;

import java.util.List;

import fil.coo.Game;
import fil.coo.Character.Monster;
import fil.coo.Character.Player;

/**
 * Implements a fight
 * @author desmarest syllebranque
 *
 */
public class Fight implements Action {
	/**
	 * Displays the action
	 */
	public void display(){
		System.out.println("You can fight.");
	}
	/**
	 * Acts in the game
	 */
	public void act(Game game, Player p){
		System.out.println("Which monster do you want to fight ? ");
		List<Monster> list = p.getRoom().getListMonster();
		Monster monsterToAttack = Game.getAnObject(list);
		p.attack(monsterToAttack);
	}
}
