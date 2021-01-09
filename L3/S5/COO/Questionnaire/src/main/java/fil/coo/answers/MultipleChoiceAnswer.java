/**
 * 
 */
package fil.coo.answers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fil.coo.Language;

/**
 * An answer where we have the choice but only one is correct
 */
public class MultipleChoiceAnswer extends Answer<String> {
	
	/**
	 * The list of answers
	 */
	private List<String> answers;
	
	/**
	 * Constructor for MultipleChoiceAnswer 
	 * @param answer the string we want to make a multiple choice answer of.
	 */
	public MultipleChoiceAnswer(String answer) {
		super(answer);
		this.answers = new ArrayList<String>();
		String [] allAnswers = answer.split(" \\| ");
		boolean firstime = true;
		for (String mot : allAnswers){
			if (firstime){
				this.goodAnswer = mot;
				firstime = false;
			}
			this.answers.add(mot);	
		}
		if (this.answers.size()==1) {
			throw new IllegalArgumentException();
		}
		Collections.shuffle(this.answers);
	}
	
	/**
	 * Return the good type
	 * @return the string that indicates the good type
	 */
	@Override
	public String getGoodType(){
		String res = new String();
		for (String mot : this.answers){
			res += mot+" - ";
		}
		res = res.substring(0, res.length()-3);
		res += " : "+Language.getInstance().getString("choose");
		return res;
	}
	
	/**
	 * Returns true if the string is correct
	 * @param s the string
	 * @return true if the string is correct
	 */
	@Override
	public boolean isCorrect(String s){
		return s.toUpperCase().equals(this.goodAnswer.toUpperCase());
	}

	/**
	 * Returns true if the string has the good type
	 * @param s the string
	 * @return true if the string has the good type
	 */
	@Override
	public boolean hasGoodType(String s) {
		for (String a : this.answers){
			if (a.toUpperCase().equals(s.toUpperCase())){
				return true;
			}
		}
		return false;
		
	}

	/**
	 * Returns the string that indicates the type (for the graphical view)
	 * @return the string that indicates the type (for the graphical view)
	 */
	@Override
	public String getType() {
		return "MultipleChoice";
	}

	/**
	 * Returns the list of the answers
	 * @return the list of the answers
	 */
	public List<String> getAnswers() {
		return answers;
	}

	

}