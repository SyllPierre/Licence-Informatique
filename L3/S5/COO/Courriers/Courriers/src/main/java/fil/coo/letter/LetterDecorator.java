/**
 * 
 */
package fil.coo.letter;

import fil.coo.Inhabitants;
import fil.coo.exception.LetterAlreadyInMailboxException;

/**
 * @author SYLLEBRANQUE
 *
 */

public abstract class LetterDecorator extends Letter<Letter<?>> {
	
	/**
	 * Create a Decorator with defined Insideletter
	 * @param insideLetter the content inside the letter
	 */
	public LetterDecorator(Letter<?> insideLetter) {
		super(insideLetter.getSender(), insideLetter.getReceiver(), insideLetter);
	}

	/**
	 * @throws LetterAlreadyInMailboxException an Exception
	 * 
	 */
	public void toDoWhenReceive() throws LetterAlreadyInMailboxException {
		this.getContent().toDoWhenReceive();
	}

	/**
	 * 
	 */
	public float getCost() {
		return this.getContent().getCost();
	}
	
	/**
	 * 
	 */
	public Inhabitants getSender() {
		return this.getContent().getSender();
	}
	
	/**
	 * 
	 */
	public Inhabitants getReceiver( ) {
		return this.getContent().getReceiver();
	}
	
	/**
	 * 
	 */
	public String getDescription( ) {
		return this.getContent().getDescription();
	}
}
