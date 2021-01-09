package fil.coo.Rooms;

/**
 * Class that implements the first Room
 * @author desmarest syllebranque
 */
public class BeginningRoom extends Room{
	
	/**
	 * Creates the first room
	 */
	public BeginningRoom(){
		super(0,0);
	}
	
	@Override
	public void displayName(){
		System.out.println("You are in the first room.");
	}
}
