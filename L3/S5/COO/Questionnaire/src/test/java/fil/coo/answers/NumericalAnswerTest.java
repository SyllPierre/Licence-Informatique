package fil.coo.answers;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumericalAnswerTest {

	@Test
	public void isCorrectTest() {
		NumericalAnswer a = new NumericalAnswer("69");
		assertTrue(a.isCorrect("69"));
	}
	
	@Test
	public void isNotCorrectTest() {
		NumericalAnswer a = new NumericalAnswer("69");
		assertFalse(a.isCorrect("59"));
	}	
	
	@Test
	public void testHasGoodTypeTrue() {
		NumericalAnswer a = new NumericalAnswer("3");
		assertTrue(a.hasGoodType("2"));
	}
	
	@Test
	public void testHasGoodTypeFalse() {
		NumericalAnswer a = new NumericalAnswer("69");
		assertFalse(a.hasGoodType("jjcaba"));
	}

	@Test (expected=IllegalArgumentException.class)
	public void NumericalAnswerThrowsIllegalArgumentException() {
		new NumericalAnswer("jjcaba");
	}
}