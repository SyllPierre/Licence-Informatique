package fil.coo.Rooms;

/**
 * Class that implements the last Room*
 * @autor desmarest syllebranque
 */
public class EndRoom extends Room{
	
	/**
	 * Creates the last room
	 */
	public EndRoom(){
		super(0,0);
	}
	/**
	 * displays the name of the exit Room
	 */
	public void displayName(){
		System.out.println("You are in the exit room! Congratulations!");
	}
}
