package fil.coo.Character;
import java.util.List;

import fil.coo.Actions.*;
import fil.coo.Rooms.Room;
/**
 * Class that creates a player
 * @author desmarest syllebranque
 */
public class Player extends Char {
	/**
	 * create a player
	 * @param s the strength
	 * @param l the number of lives
	 * @param g the number of gold
	 * @param r the room in which the player is
	 */
	public Player(int s, int l, int g, Room r){
		super(s,l,g,r);
	}
	
	/**
	 * Returns the strength changed
	 * @return the strength changed
	 * @param n the number we want to increase
	 */
	public int changeStrength(int n) {
		this.strength+=n;
		return this.strength;
	}
	
	/**
	 * returns the number of lives changed
	 * @return the number of lives changed
	 * @param n the number we want to increase
	 */
	public int changeNbOfLives(int n) {
		this.life+=n;
		return this.life;
	}
	/**
	 * returns the number of gold pieces changed
	 * @return the number of gold pieces changed
	 * @param n the number we want to increase
	 */
	public int changeGold(int n) {
		this.gold += n;
		return this.gold;
	}
	
	/**
	 * Returns the number of gold
	 * @return the number of gold
	 */
	public int getGold(){
		return this.gold;
	}
	
	/**
	 * Returns the room in which the player is
	 * @return the room in which the player is
	 */
	public Room getRoom(){
		return this.room;
	}
	
	/**
	 * Displays informations about the player
	 */
	public void displayInformations(){
		System.out.println("Your player has : "+this.gold+" pieces of gold, "+this.strength+" strength, "+this.life+" number of lives.");
	}
	
	/**
	 * returns the list of possibles actions
	 * @return the list of possibles actions
	 */
	public List<Action> possibleActions(){
		return this.getRoom().getPossibleActions();
		
	}
	
	/**
	 * The player attacks
	 * @param monsterToAttack the monster we want to attack
	 */
	public void attack(Monster monsterToAttack){
		int monsterToAttackLife = monsterToAttack.getLife();
		int playerStrength = this.getStrength();
		int playerGold = this.getGold();
		int monsterToAttackGold = monsterToAttack.getGold();
		monsterToAttack.setLife(monsterToAttackLife-playerStrength);
		if (monsterToAttack.isDead()) {
			System.out.println("You killed the monster, you won "+monsterToAttackGold+" pieces of gold.");
			this.setGold(monsterToAttackGold+playerGold);
			this.getRoom().getListMonster().remove(monsterToAttack);
		}
		else {
			System.out.println("The monster attacks back");
			monsterToAttack.attack(this);
		}
		
	}

}
