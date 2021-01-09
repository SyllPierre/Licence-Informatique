/**
 * 
 */
package fil.coo.answers;

import java.util.ResourceBundle;

import fil.coo.Language;

/**
 *
 */
public class YesNoAnswer extends Answer<String> {
	
	/**
	 * Create a yes no answer
	 * @param answer the string we want to create a YesNoAnwser with
	 */
	public YesNoAnswer(String answer) {
		super(answer);
		if (!(answer.equals("oui") || answer.equals("non"))) {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Return the good answer
	 * @return the good answer
	 */
	@Override
	public String getGoodType() {
		ResourceBundle r = Language.getInstance();
		return r.getString("oui")+" / "+r.getString("non");
	}

	
	/**
	 * Returns true if the string has the good type
	 * @param s the string
	 * @return true if the string has the good type
	 */
	@Override
	public boolean hasGoodType(String s) {
		ResourceBundle r = Language.getInstance();
		return s.toLowerCase().equals(r.getString("oui").toLowerCase()) || s.equals(r.getString("non").toLowerCase()) ;
	}
	
	/**
	 * Returns true if the string is correct
	 * @param s the string
	 * @return true if the string is correct
	 */
	@Override
	public boolean isCorrect(String s){
		ResourceBundle r = Language.getInstance();
		String goodAnswer =  r.getString(this.goodAnswer.toString().toLowerCase()).toLowerCase();
		return goodAnswer.equals(s.toLowerCase());
	}


	/**
	 * Returns the string that indicates the type (for the graphical view)
	 * @return the string that indicates the type (for the graphical view)
	 */
	@Override
	public String getType() {
		return "YesNo";
	}

}