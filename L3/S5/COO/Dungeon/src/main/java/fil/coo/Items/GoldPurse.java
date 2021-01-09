package fil.coo.Items;

import fil.coo.Character.Player;

/**
 * Class that implements a GoldPurse
 * @author desmarest syllebranque
 */

public class GoldPurse implements Item{
	int amount;
	
	public GoldPurse(){
		this.amount = 50;
	}
	
	/**
	 * returns the amount of the Gold Purse
	 * @return the amount of the Gold Purse
	 */
	public int getAmount(){
		return this.amount;
	}
	
	/**
	 * Returns the name of the item
	 * @return the name of the item
	 */
	public String getName(){
		return "a gold purse";
	}
	
	/**
	 * Use the item (here GoldPurse) with the Player
	 */
	public void use(Player p) {
		p.changeGold(this.getAmount());
		System.out.println("Your gold rise of "+this.getAmount());
		System.out.println("");
	}
	
	/**
	 * displays the item
	 */
	public void display() {
		System.out.println("A gold purse with 50 pieces of gold.");
	}
	
	
}
