/**
 * 
 */
package fil.coo.letter;

import java.util.ArrayList;
import java.util.Random;

import fil.coo.Inhabitants;
import fil.coo.content.ChainOfInhabitant;
import fil.coo.content.Money;
import fil.coo.exception.LetterAlreadyInMailboxException;

/**
 * 
 * @author SYLLEBRANQUE DESMAREST
 *
 */
public class FoolLetter extends Letter<ChainOfInhabitant>{

	static private int PROBABILTY_OF_ANSWERING = 15;
	static private Random RAND = new Random();

	/**
	 * Create a FoolLetter with defined sender, receiver and ChainOfInhabitant content
	 * @param sender the sender
	 * @param receiver the receiver
	 * @param content the content
	 */
	public FoolLetter(Inhabitants sender, Inhabitants receiver, ChainOfInhabitant content) {
		super(sender, receiver, content);
		}

	@Override
	public void toDoWhenReceive() throws LetterAlreadyInMailboxException {
		if(RAND.nextInt(100) < PROBABILTY_OF_ANSWERING & this.getReceiver().getAccount() > 0) {
			//Envoie de 5€ aux habitants de la liste
			for (Inhabitants inhabitants : this.getContent().getListOfInhabitants()) {
				this.getReceiver().debit(5);
				BillOfExchange billOfExchangeToSend = new BillOfExchange(this.getReceiver(), inhabitants, new Money(5f));
				this.getReceiver().sendLetter(billOfExchangeToSend);
			}
			//Creation de la  nouvelle chaine	
			ArrayList<Inhabitants> newListOfInhabitant = new ArrayList<Inhabitants>();
			for (int i = 1; i < this.getContent().getListOfInhabitants().size(); i++) {
				newListOfInhabitant.add(this.getContent().getListOfInhabitants().get(i));
			}
			newListOfInhabitant.add(this.getReceiver());
			ChainOfInhabitant newChainOfInhabitant = new ChainOfInhabitant(newListOfInhabitant);
			//Envoie a 10 habitants aléatoire 
			ArrayList<Inhabitants> newListOfReceiver = new ArrayList<Inhabitants>();
			while (newListOfReceiver.size() < 10) {
				Inhabitants newReceiver = this.getReceiver().getCity().getRandomInhabitant();
				while (newListOfReceiver.contains(newReceiver)) {
					newReceiver = this.getReceiver().getCity().getRandomInhabitant();
				}
				if (! newListOfReceiver.contains(newReceiver)) {
					FoolLetter newFoolLetter = new FoolLetter(this.getReceiver(), newReceiver, newChainOfInhabitant);
					this.getReceiver().sendLetter(newFoolLetter);
					newListOfReceiver.add(newReceiver);
				}
			}
		}
	}

	@Override
	public float getCost() {
		return 0.5f ;
	}
 
	@Override
	public String getDescription() {
		return "Fool Letter";
	}

}