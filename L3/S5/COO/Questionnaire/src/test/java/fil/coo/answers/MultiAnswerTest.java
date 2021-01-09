package fil.coo.answers;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultiAnswerTest {

	@Test
	public void isCorrectTest() {
		MultiAnswer a = new MultiAnswer("Pierre ; Mathilde ; Valentine");
		assertTrue(a.isCorrect("Pierre"));
	}
	
	@Test
	public void isCorrectTestWithFalse() {
		MultiAnswer a = new MultiAnswer("Pierre ; Mathilde ; Valentine");
		assertFalse(a.isCorrect("Axel"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void MultiAnswerShouldThrowIllegalArgumentException() {
		new MultiAnswer("jjcaba");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void MultiAnswerShouldThrowIllegalArgumentException2() {
		new MultiAnswer("jjcaba | jjcaba");
	}

}