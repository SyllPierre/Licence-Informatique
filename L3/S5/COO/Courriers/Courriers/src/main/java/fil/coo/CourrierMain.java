package fil.coo;

import fil.coo.exception.InhabitantAlreadyInCityException;
import fil.coo.exception.InhabitantNotInCityException;
import fil.coo.exception.LetterAlreadyInMailboxException;
import fil.coo.scanner.ScannerInt;
import fil.coo.simulation.FoolLetterSimulation;
import fil.coo.simulation.RegularMailSendingSimulation;

/**
 * 
 * @author SYLLEBRANQUE DESMAREST
 *
 */
public class CourrierMain 
{	
	/**
	 * Main to be execute
	 * @param args the args
	 * @throws InhabitantAlreadyInCityException an exception
	 * @throws LetterAlreadyInMailboxException an exception
	 * @throws InhabitantNotInCityException an exception
	 */
    public static void main( String[] args ) throws InhabitantAlreadyInCityException, LetterAlreadyInMailboxException, InhabitantNotInCityException
    {
    	int choice;
    	int numbersOfInhabitants;
    	int maximumInitialAmountOfMoneyForInhabitants;
    	int numberOfDay;
    	int numberOfMailSendEachDays;
    	System.out.println("--------------------WELCOME TO MAIL SIMULTATION !--------------------\n"
    			+ "Which simulation do you want to perform ?\n"
    			+ " - (1) Regular mail sending simulation\n"
    			+ " - (2) Fool letter simulation");
    	choice = ScannerInt.INSTANCE.readInt(2);
    	System.out.println("With how many inhabitants do you want to start simulation ?");
    	numbersOfInhabitants = ScannerInt.INSTANCE.readInt(1000);
    	System.out.println("What is the maximum amount that residents can have at the beginning of the simulation?");
    	maximumInitialAmountOfMoneyForInhabitants = ScannerInt.INSTANCE.readInt(1000);
    	switch (choice) {
    	case 1 :
    		System.out.println("How many days do you want to make the simulation last?");
    		numberOfDay = ScannerInt.INSTANCE.readInt(1000);
    		System.out.println("How many mails should be sent each day?");
    		numberOfMailSendEachDays = ScannerInt.INSTANCE.readInt(1000);
    		System.out.println("--------------------START OF THE REGULAR MAIL SENDING SIMULATION-------------------");
    		RegularMailSendingSimulation.startSimulation(numbersOfInhabitants, numberOfDay, numberOfMailSendEachDays, maximumInitialAmountOfMoneyForInhabitants);
    		break;
    	case 2 : 
    		System.out.println("--------------------START OF FOOL LETTER SIMULATION--------------------");
    		FoolLetterSimulation.startSimulation(numbersOfInhabitants, maximumInitialAmountOfMoneyForInhabitants);
    	}
    }
}