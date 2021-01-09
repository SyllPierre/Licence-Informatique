package fil.coo.simulation;

import java.util.ArrayList;

import fil.coo.City;
import fil.coo.Inhabitants;
import fil.coo.content.ChainOfInhabitant;
import fil.coo.exception.InhabitantAlreadyInCityException;
import fil.coo.exception.InhabitantNotInCityException;
import fil.coo.exception.LetterAlreadyInMailboxException;
import fil.coo.letter.FoolLetter;
import fil.coo.simulation.util.Generate;

/**
 * 
 * @author SYLLEBRANQUE DESMAREST
 *
 */
public class FoolLetterSimulation {

	
	/**
	 * Simulation for Fool Letter
	 * @param numbersOfInhabitants numbers of inhabitants
	 * @param maximumInitialAmountOfMoneyForInhabitants maximum initial amount of money for inhabitants
	 * @throws InhabitantAlreadyInCityException an exception
	 * @throws LetterAlreadyInMailboxException an exception
	 * @throws InhabitantNotInCityException an exception
	 */
	public static void startSimulation (int numbersOfInhabitants, int maximumInitialAmountOfMoneyForInhabitants) throws InhabitantAlreadyInCityException, LetterAlreadyInMailboxException, InhabitantNotInCityException {	
		City gotham = Generate.generateCityWithDefinedNumbersOfInhabitantsAndMaximumInitialAmoutOfMmoneyForInhabitants(numbersOfInhabitants, maximumInitialAmountOfMoneyForInhabitants);
		ArrayList<Inhabitants> listOfInihabitantsForinitialChainOfInhabitants = new ArrayList<Inhabitants>();
		for (int i = 0; i < 4; i++) {
			Inhabitants inhabitantToAdd = gotham.getRandomInhabitant();
			while(listOfInihabitantsForinitialChainOfInhabitants.contains(inhabitantToAdd)) {
				inhabitantToAdd = gotham.getRandomInhabitant();
			}
			listOfInihabitantsForinitialChainOfInhabitants.add(inhabitantToAdd);
		}
		Inhabitants initialSender = new Inhabitants("John Doe", gotham);
		FoolLetter initialFoolLetter = new FoolLetter(initialSender, gotham.getRandomInhabitant(), new ChainOfInhabitant(listOfInihabitantsForinitialChainOfInhabitants));
		initialSender.sendLetter(initialFoolLetter);
		gotham.removeInhabitants(initialSender);
		while(gotham.getMailbox().size() > 0) {
			gotham.distributeLetters();
		}
		Inhabitants jeffBezos = gotham.getRandomInhabitant();
		float mostFilledAccount = 0;
		for (Inhabitants inhabitantToTest : gotham.getInhabitants()) {
			if (inhabitantToTest.getAccount() > mostFilledAccount) {
				jeffBezos = inhabitantToTest;
				mostFilledAccount = jeffBezos.getAccount();
			}
		}
		System.out.println("TADAM ! After this simulation the richest inhabitant is : " + jeffBezos.getName() + " with " + jeffBezos.getAccount() + " Euros.");
	}
}