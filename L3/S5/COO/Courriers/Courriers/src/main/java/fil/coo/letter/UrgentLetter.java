package fil.coo.letter;

import fil.coo.exception.LetterAlreadyInMailboxException;

/**
 * 
 * @author SYLLEBRANQUE DESMAREST
 *
 */
public class UrgentLetter extends LetterDecorator {
	/**
	 * 
	 * @param insideLetter the content inside letter
	 */
	public UrgentLetter(Letter<?> insideLetter) {
		super(insideLetter);
	}
	
	@Override
	public float getCost() {
		float additionalCost = 2f;
		return this.getContent().getCost() * additionalCost;
	}
	
	@Override
	public void toDoWhenReceive() throws LetterAlreadyInMailboxException{
		super.toDoWhenReceive();
		
	}

	@Override
	public String getDescription() {
		return this.getContent().getDescription() + " URGENT";
	}
	
	@Override
	public String getContentDescription() {
		return  this.getContent().getContentDescription();
	}
	
}