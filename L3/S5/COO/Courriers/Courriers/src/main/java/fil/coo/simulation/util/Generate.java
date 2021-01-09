package fil.coo.simulation.util;

import java.util.Random;

import fil.coo.City;
import fil.coo.Inhabitants;
import fil.coo.content.Money;
import fil.coo.content.Text;
import fil.coo.exception.InhabitantAlreadyInCityException;
import fil.coo.letter.BillOfExchange;
import fil.coo.letter.Letter;
import fil.coo.letter.RegistredLetter;
import fil.coo.letter.SimpleLetter;
import fil.coo.letter.UrgentLetter;

/**
 * 
 * @author SYLLEBRANQUE
 *
 */
public class Generate {
	
	static private Random RAND = new Random();
	static private int PROBABILITY_OF_BECOMING_REGISTRED = 20;
	static private int PROBABILITY_OF_BECOMING_URGENT = 15;
	static private String[] FIRST_NAME = {"Jean", "Marie", "Pierre", "Jeanne", "Michel", "Francoise", "André", "Monique", "Phillipe", "Catherine","René", "Nathalie", "Louis", "Isabelle", "Alain", "Jacqueline", "Jacques", "Anne", "Bernard", "Sylvie"};
	static private String[] NAME = {"Dupont", "Roux", "Lambert", "Petit", "Leroy", "Morel", "Durand", "Dubois", "Moreau", "Fontaine"};
	
	/**
	 * Generate city with defined numbers of inhabitants and maximum amount of money for inhabitants.
	 * @param numbersOfInhabitants numbers of inhabitants
	 * @param maximumInitialAmountOfMoneyForInhabitants maximum initial amount of money for inhabitants
	 * @throws InhabitantAlreadyInCityException an exception
	 */
	public static City generateCityWithDefinedNumbersOfInhabitantsAndMaximumInitialAmoutOfMmoneyForInhabitants(int numbersOfInhabitants, int  maximumInitialAmountOfMoneyForInhabitants) throws InhabitantAlreadyInCityException
	{
		City gotham = new City("Gotham");
		int cpt = 0;
		while (cpt < numbersOfInhabitants) {
			for (String fn : FIRST_NAME) {
				for (String n : NAME) {
					String inhabitantCompleteName = fn + " " + n;
					Inhabitants newInhabitant = new Inhabitants(inhabitantCompleteName, gotham);
					newInhabitant.setAccount(RAND.nextInt(maximumInitialAmountOfMoneyForInhabitants));
					cpt += 1;
				}
			}
		}
		return gotham;
	}
	
	/**
	 * Generate random type of Letter.
	 * @param sender the sender
	 * @param receiver the receiver
	 * @return letter the letter 
	 */
	public static Letter<?> generateRandomLetter(Inhabitants sender, Inhabitants receiver) {
		int choiceTypeOfLetter = RAND.nextInt(2);
		Letter<?> letter;
		switch (choiceTypeOfLetter) {
		case 0:
			Money value;
			if (sender.getAccount() > 0) {
				 value = new Money(RAND.nextInt((int)sender.getAccount()) / 2);
			}
			else {
				 value = new Money(RAND.nextInt(10));
			}
			letter = new BillOfExchange(sender, receiver, value);
			break;
		case 1:
			Text text = new Text("Bla bla bla");
			letter = new SimpleLetter(sender, receiver, text);
			break;
		default:
			return null;
		}
		letter = probabilityOfBecomingRegistred(letter);
		letter = probabilityOfBecomingUrgent(letter);
		return letter;
	}
	/**
	 * Change a letter to Registred letter with defined probability.
	 * @param letter the letter
	 */
	public static Letter<?> probabilityOfBecomingRegistred( Letter<?> letter) {
		int probability = RAND.nextInt(100);
		if (probability < PROBABILITY_OF_BECOMING_REGISTRED) {
			letter = new RegistredLetter(letter);
		}
		return letter;
	}
	
	/**
	 * Change a letter to Urgent letter with defined probability.
	 * @param letter the letter
	 */
	public static Letter<?> probabilityOfBecomingUrgent( Letter<?> letter) {
		int probability = RAND.nextInt(100);
		if (probability < PROBABILITY_OF_BECOMING_URGENT) {
			letter = new UrgentLetter(letter);
		}
		return letter;
	}
	
}