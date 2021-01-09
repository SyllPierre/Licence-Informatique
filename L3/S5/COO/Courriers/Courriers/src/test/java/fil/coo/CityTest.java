package fil.coo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fil.coo.content.Money;
import fil.coo.content.Text;
import fil.coo.exception.InhabitantAlreadyInCityException;
import fil.coo.exception.InhabitantNotInCityException;
import fil.coo.exception.LetterAlreadyInMailboxException;
import fil.coo.letter.BillOfExchange;
import fil.coo.letter.SimpleLetter;

public class CityTest {
	private City someCity;
	private SimpleLetter someSimpleLetter;
	private BillOfExchange someBillOfExchange;
	private Inhabitants someInhabitantSender;
	private Inhabitants someInhabitantReceiver;
	
	@Before
	public void setUp() throws Exception {
		someCity = new City("someCity");
		someInhabitantSender = new Inhabitants("someInhabitantSender",someCity);
		someInhabitantReceiver = new Inhabitants("someInhabitantReceiver", someCity);
		Text someText = new Text("SomeText");
		someSimpleLetter = new SimpleLetter(someInhabitantSender, someInhabitantReceiver, someText);
		Money someMoney = new Money(4.4f);
		someBillOfExchange = new BillOfExchange(someInhabitantSender, someInhabitantReceiver, someMoney);
	}

	@Test
	public void addLetterWhenOkTest(){
		int previousNumberOfLetter = someCity.getMailbox().size();
		try {
		someCity.addLetter(someBillOfExchange);
		someCity.addLetter(someSimpleLetter);
		} catch (LetterAlreadyInMailboxException e)
		{	
			e.printStackTrace();
		}
		assertTrue(previousNumberOfLetter + 2 == someCity.getMailbox().size());
		assertTrue(someCity.getMailbox().contains(someSimpleLetter));
		assertTrue(someCity.getMailbox().contains(someBillOfExchange));
	}
	
	@Test(expected = LetterAlreadyInMailboxException.class)
	public void AddLetterWhenNotokTest() throws LetterAlreadyInMailboxException {
		someCity.addLetter(someBillOfExchange);
		someCity.addLetter(someSimpleLetter);
		someCity.addLetter(someBillOfExchange);
		someCity.addLetter(someSimpleLetter);
	}
	
	@Test
	public void addInhabitantsWhenOk() throws InhabitantAlreadyInCityException {
		int previousNumberOfInhabitants = someCity.getInhabitants().size();
		Inhabitants newInhabitant = new Inhabitants("NewInhabitant", someCity);
		assertTrue(previousNumberOfInhabitants + 1 == newInhabitant.getCity().getInhabitants().size());
		assertTrue(newInhabitant.getCity().getInhabitants().contains(newInhabitant));
	}
	
	@Test(expected = InhabitantAlreadyInCityException.class)
	public void addInhabitantWhenNotokTest() throws InhabitantAlreadyInCityException {
		Inhabitants newInhabitant = new Inhabitants("NewInhabitant", someCity);
		someCity.addInhabitants(newInhabitant);
	}
	
	@Test
	public void removeInhabitantsWhenOk() throws InhabitantAlreadyInCityException, InhabitantNotInCityException {
		int previousNumberOfInhabitants = someCity.getInhabitants().size();
		Inhabitants newInhabitant = new Inhabitants("NewInhabitant", someCity);
		someCity.removeInhabitants(newInhabitant);
		assertTrue(previousNumberOfInhabitants == newInhabitant.getCity().getInhabitants().size());
		assertFalse(newInhabitant.getCity().getInhabitants().contains(newInhabitant));
	}
	
	@Test(expected = InhabitantNotInCityException.class)
	public void removeInhabitantWhenNotokTest() throws InhabitantAlreadyInCityException, InhabitantNotInCityException {
		Inhabitants newInhabitant = new Inhabitants("NewInhabitant", someCity);
		City anotherCity = new City("another City");
		anotherCity.removeInhabitants(newInhabitant);
	}
}
