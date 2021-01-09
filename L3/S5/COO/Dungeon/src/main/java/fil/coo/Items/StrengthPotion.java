package fil.coo.Items;

import fil.coo.Character.Player;

/**
 * Implements a Strength Potion
 * @autor desmarest syllebranque
 */
public class StrengthPotion implements Item {
	int amount;
	/**
	 * Creates a Strength Potion
	 */
	public StrengthPotion(){
		this.amount = 7;
	}
	/**
	 * returns the amount of the StrengthPotion
	 * @return the amount of the StrengthPotion
	 */
	public int getAmount(){
		return this.amount;
	}
	
	
	/**
	 * Use the item (here StrengthPotion) with the Player
	 */
	public void use(Player p) {
		p.changeStrength(this.getAmount());
		System.out.println("Your strength rise of "+this.getAmount());
		System.out.println("");
	}
	
	/**
	 * Returns the name of the item
	 * @return the name of the item
	 */
	public String getName(){
		return "a strength potion";
	}
	/**
	 * displays the item
	 */
	public void display() {
		System.out.println("A strength potion whose value is 7.");
		
	}
}
