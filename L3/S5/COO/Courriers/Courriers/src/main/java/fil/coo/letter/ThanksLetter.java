package fil.coo.letter;

import fil.coo.Inhabitants;
import fil.coo.content.Text;
import fil.coo.exception.LetterAlreadyInMailboxException;

/**
 * 
 * @author SYLLEBRANQUE DESMAREST
 *
 */
public class ThanksLetter extends SimpleLetter {
	
	/**
	 * 
	 * @param sender the sender
	 * @param receiver the receiver
	 * @param content the content
	 */
	public ThanksLetter(Inhabitants sender, Inhabitants receiver, Text content) {
		super(sender, receiver, content);
	}

	@Override
	public void toDoWhenReceive() throws LetterAlreadyInMailboxException {
		super.toDoWhenReceive();
	}

	@Override
	public float getCost() {
		return 0.5f ;
	}

	@Override
	public String getDescription() {
		return "thanks letter";
	}

}