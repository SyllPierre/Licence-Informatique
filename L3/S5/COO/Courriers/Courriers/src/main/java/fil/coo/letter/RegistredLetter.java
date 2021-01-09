package fil.coo.letter;

import fil.coo.content.Text;
import fil.coo.exception.LetterAlreadyInMailboxException;

/**
 * 
 * @author SYLLEBRANQUE DESMAREST
 *
 */
public class RegistredLetter extends LetterDecorator {
	
	/**
	 * Create RegistredLetter with defined insideLetter
	 * @param insideLetter the content inside letter
	 */
	public RegistredLetter(Letter<?> insideLetter) {
		super(insideLetter);
	}
	
	@Override
	public float getCost() {
		float additionalCost = 1.15f;
		return this.getContent().getCost() * additionalCost;
	}
	
	@Override
	public void toDoWhenReceive() throws LetterAlreadyInMailboxException{
		super.toDoWhenReceive();
		this.getContent().getReceiver().sendLetter(new AcknowledgementOfReceipt(this.getContent().getReceiver(), this.getContent().getReceiver(), new Text(this.getContent().toString())));
		
	}

	@Override
	public String getDescription() {
		return  this.getContent().getDescription() + " registred" ;
	}
	
	@Override
	public String getContentDescription() {
		return  this.getContent().getContentDescription();
	}
	
}