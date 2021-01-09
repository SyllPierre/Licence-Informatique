package fil.coo.Items;

import fil.coo.Character.Player;

/**
 * Class that implements a HealthPotion
 * @author desmarest syllebranque
 */

public class HealthPotion implements Item {
	int amount;
	/**
	 * Create a health Potion
	 */
	public HealthPotion(){
		this.amount = 30;
	}
	
	/**
	 * Returns the name of the item
	 * @return the name of the item
	 */
	public String getName(){
		return "a health potion";
	}
	
	/**
	 * returns the amount of the HealthPotion
	 * @return the amount of the HeatlthPotion
	 */
	public int getAmount(){
		return this.amount;
	}
	
	/**
	 * Use the item (here HealthPotion) with the Player p
	 */
	public void use(Player p) {
		p.changeNbOfLives(this.getAmount());
		System.out.println("Your health rise of "+this.getAmount());
		System.out.println("");
	
	}
	
	/**
	 * displays the item
	 */
	public void display() {
		System.out.println("A heath potion whose value is 30");
		
	}
}
