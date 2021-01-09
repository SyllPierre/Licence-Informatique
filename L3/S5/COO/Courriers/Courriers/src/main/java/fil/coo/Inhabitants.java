/**
 * 
 */
package fil.coo;

import fil.coo.exception.InhabitantAlreadyInCityException;
import fil.coo.exception.LetterAlreadyInMailboxException;
import fil.coo.letter.Letter;

/**
 * 
 * @author SYLLEBRANQUE DESMAREST
 *
 */
public class Inhabitants {
	private String name;
	private City city;
	private float account;
	
	/**
	 * Create an Inhabitant with defined name and city.
	 * @param name name of this inhabitant
	 * @param city city of this inhabitant
	 * @throws InhabitantAlreadyInCityException an exception
	 */
	public Inhabitants(String name, City city) throws InhabitantAlreadyInCityException {
		this.name = name;
		this.city = city;
		city.addInhabitants(this);
		this.account = 100;
	}
	
	/**
	 * Return the name of this inhabitant
	 * @return name the name of the inhabitant
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set a new name to this inhabitant
	 * @param name a name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Return the city of this inhabitant
	 * @return city
	 */
	public City getCity() {
		return city;
	}
	
	/**
	 * Set a new city to this inhabitant
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}
	
	/**
	 * Return the account of this inhabitant
	 * @return account
	 */
	public float getAccount() {
		return account;
	}
	
	/**
	 * Set a new account to this inhabitant
	 * @param account the account of the inhabitant
	 */
	public void setAccount(float account) {
		this.account = account;
	}
	
	/**
	 *  Credit this inhabitant account
	 * @param sum sum to add on the account of the inhabitant
	 */
	public void credit (float sum) {
		this.account += sum;
	}
	
	/**
	 * Debit this inhabitant account
	 * @param sum sum to debit on the account of the inhabitant
	 */
	public void debit (float sum) {
		this.account -= sum;
	}
	
	/**
	 * Action to do when this inhabitant receiver a letter
	 * @param letter the letter to receive
	 * @throws LetterAlreadyInMailboxException an exception
	 */
	public void receiveLetter(Letter<?> letter) throws LetterAlreadyInMailboxException {
		System.out.println(letter + " " + letter.getContentDescription() + " send by " + letter.getSender().getName() + " received by " + letter.getReceiver().getName());
		letter.toDoWhenReceive();
	}
	
	/**
	 * Action to do when this inhabitant send a letter
	 * @param letter the letter to send
	 * @throws LetterAlreadyInMailboxException an exception
	 */
	public void sendLetter(Letter<?> letter) throws LetterAlreadyInMailboxException {
		this.getCity().addLetter(letter);
		this.debit(letter.getCost());
		System.out.println(">>> " + letter.getSender().getName()  + " send " + letter + " count (" + letter.getCost() + ")" + " to " + letter.getReceiver().getName() );
	}

}
