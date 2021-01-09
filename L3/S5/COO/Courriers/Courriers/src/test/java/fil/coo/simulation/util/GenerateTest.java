package fil.coo.simulation.util;

import static org.junit.Assert.*;

import org.junit.Test;

import fil.coo.City;
import fil.coo.Inhabitants;
import fil.coo.exception.InhabitantAlreadyInCityException;

public class GenerateTest {

	@Test
	public void testGenerateCity() throws InhabitantAlreadyInCityException {
		int numberOfInhabitants = 200;
		int maximumAmountOfMoney = 1000;
		City someCity = Generate.generateCityWithDefinedNumbersOfInhabitantsAndMaximumInitialAmoutOfMmoneyForInhabitants(numberOfInhabitants, maximumAmountOfMoney);
		assertTrue(someCity.getInhabitants().size() == numberOfInhabitants);
		for (Inhabitants inhabitant : someCity.getInhabitants()) {
			assertTrue(inhabitant.getAccount() <= maximumAmountOfMoney );
		}
	}

}
