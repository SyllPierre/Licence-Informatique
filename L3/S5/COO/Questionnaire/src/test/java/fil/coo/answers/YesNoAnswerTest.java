package fil.coo.answers;

import static org.junit.Assert.*;
import org.junit.Test;

import fil.coo.Language;

public class YesNoAnswerTest {
	@SuppressWarnings("unused")
	private Language l = new Language("fr");
	
	@Test
	public void isCorrectTest() {
		YesNoAnswer a = new YesNoAnswer("oui");
		assertTrue(a.isCorrect("oui"));
	}
	
	@Test
	public void isNotCorrectTest() {
		YesNoAnswer a = new YesNoAnswer("oui");
		assertFalse(a.isCorrect("non"));
	}	
	
	@Test
	public void testHasGoodTypeTrue() {
		YesNoAnswer a = new YesNoAnswer("oui");
		assertTrue(a.hasGoodType("non"));
	}
	
	@Test
	public void testHasGoodTypeFalse() {
		YesNoAnswer a = new YesNoAnswer("oui");
		assertFalse(a.hasGoodType("lala"));
	}

	
	@Test (expected=IllegalArgumentException.class)
	public void YesNoAAnswerThrowsIllegalArgumentException() {
		new YesNoAnswer("jjcaba");
	}
}