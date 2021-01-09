/**
 * 
 */
package fil.coo.letter;

import fil.coo.Inhabitants;
import fil.coo.content.Text;
import fil.coo.exception.LetterAlreadyInMailboxException;

/**
 * @author SYLLEBRANQUE
 */
public class SimpleLetter extends Letter<Text>{

	/**
	 * @param sender the sender
	 * @param receiver the receiver
	 * @param content the content
	 */
	public SimpleLetter(Inhabitants sender, Inhabitants receiver, Text content) {
		super(sender, receiver, content);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void toDoWhenReceive() throws LetterAlreadyInMailboxException {
	}

	@Override
	public float getCost() {
		return 1f ;
	}

	@Override
	public String getDescription() {
		return "simple letter" ;
	}

}