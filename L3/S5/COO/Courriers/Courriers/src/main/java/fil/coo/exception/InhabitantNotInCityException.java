package fil.coo.exception;

@SuppressWarnings("serial")
/**
 * 
 * @author SYLLEBRANQUE
 *
 */
public class InhabitantNotInCityException extends Exception {
	
	/**
	 * Exception when we remove an Inhabitant to a city but this inhabitant does not live in this city.
	 */
	 public void LetterAlreadyInMailBoxException() {
		System.out.println("This Inhabitant is not in the City");
	 }
}
