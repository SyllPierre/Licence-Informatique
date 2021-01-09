package fil.coo;

import java.util.ArrayList;
import java.util.Random;

import fil.coo.exception.InhabitantAlreadyInCityException;
import fil.coo.exception.InhabitantNotInCityException;
import fil.coo.exception.LetterAlreadyInMailboxException;
import fil.coo.letter.Letter;

/**
 * 
 * @author SYLLEBRANQUE DESMAREST
 *
 */
public class City {

	
	private String name;
	protected final ArrayList<Inhabitants> inhabitants;
	protected final ArrayList<Letter<?>> mailBox;
	
	/**
	 * Create a city with a defined Name.
	 * @param name Name of the city.
	 */
	public City(String name) {
		this.inhabitants = new ArrayList<Inhabitants>();
		this.mailBox = new ArrayList<Letter<?>>();
	}
	
	/**
	 * Return the name of this city.
	 * @return name of this city.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * set a new name to this City.
	 * @param name the name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Return The list of all inhabitants wich live in this city.
	 * @return this inhabitants list.
	 */
	public ArrayList<Inhabitants> getInhabitants() {
		return inhabitants;
	}
	

	/**
	 * Return the list of all letter contains in this city mailbox.
	 * @return the mailbox.
	 */
	public ArrayList<Letter<?>> getMailbox() {
		return mailBox;
	}

	
	/**
	 * Add a letter to this city mail box.
	 * @param letter the letter to add.
	 * @throws LetterAlreadyInMailboxException an exception
	 */
	public void addLetter(Letter<?> letter) throws LetterAlreadyInMailboxException {
		if (this.mailBox.contains(letter)) {
			throw new LetterAlreadyInMailboxException();
		}
		else {
			this.mailBox.add(letter);
		}
	}
	
	/**
	 * Add inhabitant in this city.
	 * @param inhabitantToAdd inhabitant to add.
	 * @throws InhabitantAlreadyInCityException an exception
	 */
	public void addInhabitants(Inhabitants inhabitantToAdd) throws InhabitantAlreadyInCityException {
		if (this.inhabitants.contains(inhabitantToAdd)) {
			throw new InhabitantAlreadyInCityException();
		}
		else {
			this.inhabitants.add(inhabitantToAdd);
		}
	}
	
	/**
	 * Remove inhabitant in this City.
	 * @param inhabitantToRemove the inhabitant to remove.
	 * @throws InhabitantNotInCityException an exception
	 */
	public void removeInhabitants(Inhabitants inhabitantToRemove) throws InhabitantNotInCityException {
		if (!this.inhabitants.contains(inhabitantToRemove)) {
			throw new InhabitantNotInCityException();
		}
		else {
			this.inhabitants.remove(inhabitantToRemove);
		}
	}	
	
	/**
	 * Distribute all letters contains in this city mailbox.
	 * @throws LetterAlreadyInMailboxException an exception
	 */
	public void distributeLetters() throws LetterAlreadyInMailboxException {		
		ArrayList<Letter<?>> mailBag = new ArrayList<Letter<?>>(mailBox);
		for (Letter<?> letter : mailBag) {
			letter.getReceiver().receiveLetter(letter);
			mailBox.remove(letter);
		}
	}
	
	/**
	 * Return a random inhabitant of this city.
	 * @return inhabitant choose randomly.
	 */
	public Inhabitants getRandomInhabitant() {
		Random rand = new Random();
		return this.getInhabitants().get(rand.nextInt(this.getInhabitants().size()));
	}
	
	@Override
	public String toString() {
		return "City [name=" + name + ", inhabitants=" + inhabitants + ", mailbox=" + mailBox + "]";
	}
	
	
}
