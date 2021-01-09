package fil.coo.Items;

import fil.coo.Choseable;
import fil.coo.Character.Player;

/**
 * Interface that implements an item
 * @author desmarest syllebranque
 */
public interface Item extends Choseable {

	public int getAmount();
	public String getName();
	public void use(Player p);
}
