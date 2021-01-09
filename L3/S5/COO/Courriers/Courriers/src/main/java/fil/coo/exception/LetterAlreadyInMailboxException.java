package fil.coo.exception;

@SuppressWarnings("serial")
/**
 * 
 * @author SYLLEBRANQUE
 *
 */
public class LetterAlreadyInMailboxException extends Exception {
	
	/**
	 * Exception when we add a letter to a city's mailbox but the letter is already in.
	 */
	 public void LetterAlreadyInMailBoxException() {
		System.out.println("This letter is already in the mailbox");
	 }
}
