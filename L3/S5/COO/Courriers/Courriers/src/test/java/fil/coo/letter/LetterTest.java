package fil.coo.letter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fil.coo.City;
import fil.coo.Inhabitants;
import fil.coo.content.Text;
import fil.coo.exception.LetterAlreadyInMailboxException;

public class LetterTest {
	private City someCity;
	private Inhabitants someInhabitantSender;
	private Inhabitants someInhabitantReceiver;
	
	@Before
	public void setUp() throws Exception {
		 someCity = new City("someCity");
		 someInhabitantSender = new Inhabitants("someInhabitantSender",someCity);
		 someInhabitantReceiver = new Inhabitants("someInhabitantReceiver", someCity);
	
	}
	
	@Test
	public void doActionOnLetterReception( ) throws LetterAlreadyInMailboxException {
		MockLetter letter = new MockLetter(someInhabitantSender, someInhabitantReceiver);
		assertEquals(0, letter.doActions);
		someInhabitantReceiver.receiveLetter(letter);
		assertEquals(1, letter.doActions);
	}
	
	class MockLetter extends Letter<Text> {
		
		public MockLetter(Inhabitants sender, Inhabitants receiver) {
			super(sender, receiver, new Text("MockLetter"));
		}

		private static final int COST = 1;
		protected int doActions = 0;
		
		@Override
		public void toDoWhenReceive() throws LetterAlreadyInMailboxException {
			doActions++;
		}

		@Override
		public float getCost() {
			return COST;
		}

		@Override
		public String getDescription() {
			return "MockLetter";
		}
		
	}
}
