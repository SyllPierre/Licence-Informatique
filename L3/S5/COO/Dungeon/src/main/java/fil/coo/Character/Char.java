package fil.coo.Character;
import fil.coo.Rooms.Room;

/**
 * Abstract class that implements a character
 * @author desmarest syllebranque
 */

public abstract class Char {
	
	protected int strength;
	protected int life;
	protected int gold;
	protected Room room;
	
	/**
	 * Create a character
	 * @param s the strength
	 * @param l the number of lives
	 * @param g the number of gold
	 * @param r the room in which the character is
	 */
	public Char(int s, int l, int g, Room r){
		this.strength = s;
		this.life = l;
		this.gold = g;
		this.room = r;
	}
	
	/**
	 * Returns the strength
	 * @return the strength
	 */
	public int getStrength() {
		return strength;
	}
	
	/**
	 * Set the strength
	 * @param strength the strength
	 */
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	/**
	 * Return the number of lives
	 * @return the number of lives
	 */
	public int getLife() {
		return life;
	}
	
	/**
	 * Set the number of lives 
	 * @param life Set the number of lives to life
	 */
	public void setLife(int life) {
		this.life = life;
	}
	
	/**
	 * Return the number of gold
	 * @return the number of gold
	 */
	public int getGold() {
		return gold;
	}
	
	/**
	 * Set the number of gold
	 * @param gold the number of gold
	 */
	public void setGold(int gold) {
		this.gold = gold;
	}
	
	/**
	 * Setting a player to a new room
	 * @param room the room we want to set the char to
	 */
	public void setRoom(Room room) {
		this.room = room;
	}

	/**
	 * Return the room where the character is
	 * @return the room where the character is
	 */
	public Room getRoom(){
		return this.room;
	}
	
	/**
	 * return true if the character is dead
	 * @return true if the character is dead.
	 */
	public boolean isDead() {
		return this.getLife()<=0;
	}
}

