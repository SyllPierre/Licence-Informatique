package fil.coo.answers;

import static org.junit.Assert.*;

import org.junit.Test;

public class TextualAnswerTest {

	@Test
	public void isCorrectTest() {
		TextualAnswer a = new TextualAnswer("Pepito");
		assertTrue(a.isCorrect("Pepito"));
	}
	
	@Test
	public void isNotCorrectTest() {
		TextualAnswer a = new TextualAnswer("Pepito");
		assertFalse(a.isCorrect("Pierre"));
	}
	
}