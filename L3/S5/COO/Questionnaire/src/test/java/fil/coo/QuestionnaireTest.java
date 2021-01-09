package fil.coo;
import static org.junit.Assert.*;
import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;

import fil.coo.answers.Answer;


public class QuestionnaireTest {
	
	private class MockAnswer extends Answer<Character> {
		
		protected int hasGoodTypeCalls ;
		
		public MockAnswer() {
			super('b') ; 
			this.hasGoodTypeCalls = 0 ;
		}

		@Override
		public String getGoodType() {
			return "any char but 'a'" ;
		}

		@Override
		public boolean hasGoodType(String answer) {
			hasGoodTypeCalls++ ;
			return ! "a".equals(answer) ;
		}

		@Override
		public String getType() {
			return null;
		}
	}
	
	@Test
	public void waitUntilAnAcceptableAnswer() throws IOException {
		new Language("fr");
		MockAnswer answer = new MockAnswer() ;
		Questionnaire Questionnaire = new Questionnaire( new StringReader("a\na\na\nb\n") , System.out) ;
		Questionnaire.add(new Question("input 'b'" , answer , 1)) ;
		Questionnaire.askAll() ;
		assertEquals(answer.hasGoodTypeCalls , 4) ;
	}
	

}