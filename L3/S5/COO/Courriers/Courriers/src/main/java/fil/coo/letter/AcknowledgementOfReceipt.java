package fil.coo.letter;

import fil.coo.Inhabitants;
import fil.coo.content.Text;

/**
 * 
 * @author SYLLEBRANQUE DESMAREST
 *
 */
public class AcknowledgementOfReceipt extends SimpleLetter {
	
	/**
	 * Create a defined AcknowledgmentOfReceipt with defined sender, receiver and content.
	 * @param sender the sender
	 * @param receiver the receiver
	 * @param content the content
	 */
	public AcknowledgementOfReceipt(Inhabitants sender, Inhabitants receiver, Text content) {
		super(sender, receiver, content);
	}
	
	@Override
	public String getDescription() {
		return "acknowledgement of receipt" ;
	}
}