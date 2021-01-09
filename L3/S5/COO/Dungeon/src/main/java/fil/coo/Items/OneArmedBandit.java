package fil.coo.Items;

import java.util.Random;

import fil.coo.Character.Player;

/**
 * Implements an one armed bandit
 * @author desmarest syllebranque
 */
public class OneArmedBandit implements Item{
	int price;
	/**
	 * Create an one armed bandit
	 */
	public OneArmedBandit(){
		this.price = 25;
	}
	
	/**
	 * returns the amount of the gold used by the one armed bandit
	 * @return the amount of the gold used by the one armed bandit
	 */
	public int getAmount(){
		return this.price;
	}
	/**
	 * Use of the one armed Bandit
	 */
	public void use(Player p) {
		Item res;
		if (p.getGold()>=this.getAmount()){
			p.changeGold(-this.getAmount());
			res = choseItemRandomly();
			System.out.print("The one armed bandit gave you : ");
			res.display();
			res.use(p);
		}
		else {
			System.out.println("You don't have enough gold, the bandit dissappears.");
		}
}
	/**
	 * Returns a random item
	 * @return a random item
	 */
	public Item choseItemRandomly(){
		Random random = new Random();
		int c = random.nextInt(2);
		Item item ;
		item = null;
		switch (c){
		case 0:
			item = new GoldPurse();
			break;
		case 1:
			item = new HealthPotion();
			break;
		case 2:
			item = new StrengthPotion();
			break;
					}
		return item;
	}
	/**
	 * Returns the name of the item
	 * @return the name of the item
	 */
	public String getName(){
		return "an one armed bandit";
	}
	/**
	 * displays the item
	 */
	public void display() {
		System.out.println("An one armed bandit that will cost you 25 pieces of gold.");
	}
}
