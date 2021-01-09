package fil.coo.exception;

@SuppressWarnings("serial")
/**
 * 
 * @author SYLLEBRANQUE
 *
 */
public class InhabitantAlreadyInCityException extends Exception {
	
	/**
	 * Exception when we add Inhabitant in a City but the inhabitant is already in this city.
	 */
	 public void LetterAlreadyInMailBoxException() {
		System.out.println("This Inhabitant is already in the City");
	 }
}
