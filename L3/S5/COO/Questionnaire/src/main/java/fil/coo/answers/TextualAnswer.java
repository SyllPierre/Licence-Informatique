/**
 * 
 */
package fil.coo.answers;

import java.util.ResourceBundle;

import fil.coo.Language;

/**
 *
 */
public class TextualAnswer extends Answer<String> {
	
	/**
	 * Create a textual answer
	 * @param answer the string we want to create a textualanswer with
	 */
	public TextualAnswer(String answer) {
		super(answer);
	}

	/**
	 * Return the good type
	 * @return the string that indicates the good type
	 */
	@Override
	public String getGoodType() {
		ResourceBundle r = Language.getInstance();
		return r.getString("type")+" ("+r.getString("typeText")+")";
	}
	
	/**
	 * Returns the string that indicates the type (for the graphical view)
	 * @return the string that indicates the type (for the graphical view)
	 */
	@Override
	public String getType() {
		return "Textual";
	}
}