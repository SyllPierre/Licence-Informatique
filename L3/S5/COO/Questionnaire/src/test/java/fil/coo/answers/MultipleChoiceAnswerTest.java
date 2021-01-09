package fil.coo.answers;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultipleChoiceAnswerTest {

	@Test
	public void isCorrectTest() {
		MultipleChoiceAnswer a = new MultipleChoiceAnswer("Pierre | Mathilde | Valentine");
		assertTrue(a.isCorrect("Pierre"));
	}
	
	@Test
	public void isNotCorrectTest() {
		MultipleChoiceAnswer a = new MultipleChoiceAnswer("Pierre | Mathilde | Valentine");
		assertFalse(a.isCorrect("Mathilde"));
		assertFalse(a.isCorrect("Axel"));
	}
	
	@Test 
	public void testHasGoodTypeTrue() {
		MultipleChoiceAnswer a = new MultipleChoiceAnswer("bleu | pastel | rose");
		assertTrue(a.hasGoodType("pastel"));
	}
	
	@Test
	public void testHasGoodTypeFalse() {
		MultipleChoiceAnswer a = new MultipleChoiceAnswer("bleu | pastel | rose");
		assertFalse(a.hasGoodType("licorne"));
	}
	
	
	@Test (expected = IllegalArgumentException.class)
	public void MultipleChoiceAnswerShouldThrowIllegalArgumentException() {
		new MultipleChoiceAnswer("jjcaba");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void MultiChoiceAnswerShouldThrowIllegalArgumentException2() {
		new MultipleChoiceAnswer("jjcaba ; jjcaba");
	}

}