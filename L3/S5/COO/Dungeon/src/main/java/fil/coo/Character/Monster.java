package fil.coo.Character;

import fil.coo.Rooms.Room;
import fil.coo.Choseable;
/**
 * Class that implements a Monster
 * @author desmarest syllebranque
 *
 */
public class Monster extends Char implements Choseable {
	
	/**
	 * Create a monster
	  * @param s the strength
	 * @param l the number of lives
	 * @param g the number of gold
	 * @param r the room in which the monster is
	 */
	public Monster(int s, int l, int g, Room r){
		super(s,l,g, r);
	}
	
	/**
	 * Displays the monster
	 */
	public void display(){
		System.out.println("This monster has : "+this.gold+" pieces of gold, "+this.strength+" strength, "+this.life+" number of lives.");
	}
	
	/**
	 * The monster attacks 
	 * @param player the monster attacks the player
	 */
	public void attack(Player player) {
		int playerLife = player.getLife();
		int monsterStrength = this.getStrength();
		player.setLife(playerLife-monsterStrength);
		if (player.isDead()) {
			System.out.println("The monster killed you, you lost.");
			System.exit(0);
		}
		else {
			System.out.println("You lost "+monsterStrength+" number of lives.");
		} 
	}


}
