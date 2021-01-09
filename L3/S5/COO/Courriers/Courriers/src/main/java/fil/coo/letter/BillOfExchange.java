/**
 * 
 */
package fil.coo.letter;

import fil.coo.Inhabitants;
import fil.coo.content.Money;
import fil.coo.content.Text;
import fil.coo.exception.LetterAlreadyInMailboxException;

/**
 * 
 * @author SYLLEBRANQUE DESMAREST
 *
 */
public class BillOfExchange extends Letter<Money> {
	
	/**
	 * Create a BillOfExchange with a deinfed sender, receiver and Money Content
	 * @param sender the sender
	 * @param receiver the receiver
	 * @param content the content
	 */
	public BillOfExchange(Inhabitants sender, Inhabitants receiver, Money content) {
		super(sender, receiver, content);
	}

	@Override
	public void toDoWhenReceive() throws LetterAlreadyInMailboxException {
		this.getSender().debit(this.getContent().getAmount());
		this.getReceiver().credit(this.getContent().getAmount());
		Text contentThanksLetter = new Text("Thanks for " + this);
		ThanksLetter thanksLetter = new ThanksLetter(this.getReceiver(), this.getSender(), contentThanksLetter);
		this.getReceiver().sendLetter(thanksLetter);
	}

	@Override
	public float getCost() {
		return (float) (1 + (this.getContent().getAmount() * 0.01));
	}

	@Override
	public String getDescription() {
		return "bill of exchange";
	}

}
