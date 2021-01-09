package fil.coo.simulation;

import fil.coo.City;
import fil.coo.Inhabitants;
import fil.coo.exception.InhabitantAlreadyInCityException;
import fil.coo.exception.LetterAlreadyInMailboxException;
import fil.coo.letter.Letter;
import fil.coo.simulation.util.Generate;

/**
 * 
 * @author SYLLEBRANQUE DESMAREST
 *
 */
public class RegularMailSendingSimulation {
	
	/**
	 * Simulation for Regular mail sending.
	 * @param numbersOfInhabitants numbers of inhabitants
	 * @param numberOfDay number of day
	 * @param numberOfMailSendEachDays number of mail send each days
	 * @param maximumInitialAmountOfMoneyForInhabitants maximum initial amount of money for inhabitants
	 * @throws InhabitantAlreadyInCityException an exception
	 * @throws LetterAlreadyInMailboxException an exception
	 */
	public static void startSimulation(int numbersOfInhabitants, int numberOfDay, int numberOfMailSendEachDays, int maximumInitialAmountOfMoneyForInhabitants) throws InhabitantAlreadyInCityException, LetterAlreadyInMailboxException {	
		City gotham = Generate.generateCityWithDefinedNumbersOfInhabitantsAndMaximumInitialAmoutOfMmoneyForInhabitants(numbersOfInhabitants, maximumInitialAmountOfMoneyForInhabitants);
		int day = 1;
		boolean simulationNumberOfDayDone = false;
		while(day < numberOfDay + 1 | gotham.getMailbox().size() > 0) {
			System.out.println("---------------------------------------DAY " + day + "---------------------------------------");
			gotham.distributeLetters();
			if (!simulationNumberOfDayDone) {
				for(int n = 0; n < numberOfMailSendEachDays; n++) {
					Inhabitants sender = gotham.getRandomInhabitant();
					Inhabitants receiver = gotham.getRandomInhabitant();
					while (sender.equals(receiver)) {;
						receiver = gotham.getRandomInhabitant();
					}
					Letter<?> letter = Generate.generateRandomLetter(sender, receiver);
					sender.sendLetter(letter);
				}
			}
			day += 1;
			if (day == numberOfDay + 1) {
				simulationNumberOfDayDone = true;
			}
		}
	}
}