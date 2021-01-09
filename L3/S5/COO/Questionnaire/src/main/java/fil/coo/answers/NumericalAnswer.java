/**
*
*/
package fil.coo.answers;

import java.util.ResourceBundle;

import fil.coo.Language;

/**
 * A class for a numerical answer
 */
public class NumericalAnswer extends Answer<String>{
	/**
	 * The correct answer
	 */
	protected int goodAnswer;
	
	/**
	 * Constructor for a numerical answer
	 * @param s the string we want to make a numerical answer of
	 */
	public NumericalAnswer(String s) {
		super(s);
		this.goodAnswer = Integer.parseInt(s);
	}
	
	/**
	 * Return the good type
	 * @return the string that indicates the good type
	 */
	@Override
	public String getGoodType() {
		ResourceBundle r = Language.getInstance();
		return r.getString("type") + " ("+ r.getString("int") + ")";
	}
	
	/**
	 * Returns true if the string has the good typer
	 * @param s the string
	 * @return true if the string has the good type
	 */
	@Override
	public boolean hasGoodType(String s) {
		try {
			Integer.parseInt(s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Returns the string that indicates the type (for the graphical view)
	 * @return the string that indicates the type (for the graphical view)
	 */
	@Override
	public String getType() {
		return "Numerical";
	}
	
}
