/**
 * 
 */
package fil.coo.answers;

import java.util.ResourceBundle;

import fil.coo.Language;

/**
 * Class for an answer that has multiple good answers
 */
public class MultiAnswer extends Answer<String[]> {
	
	/**
	 * Create a multianswer
	 * @param answer the string we want to create a multianswer with
	 */
	public MultiAnswer(String answer) {
		super(answer.split(" ; "));
		if (answer.split(" ; ").length==1) {
			throw new IllegalArgumentException();
		}
	}
	/**
	 * Returns true if the string is correct
	 * @param s the string
	 * @return true if the string is correct
	 */
	@Override
	public boolean isCorrect(String s){
		s = s.toUpperCase();
		for (String mot : this.goodAnswer){
			if(mot.toUpperCase().equals(s)){
				return true;
			}
		}
		return false;
	}

	/**
	 * Return the good type
	 * @return the string that indicates the good type
	 */
	@Override
	public String getGoodType() {
		ResourceBundle r = Language.getInstance();
		return r.getString("type") + " ("+ r.getString("typeText")+")";
	}
	
	/**
	 * Returns the string of the good answer
	 * @return the string of the good answer
	 */
	@Override
	public String toString(){
		String res = new String();
		ResourceBundle r = Language.getInstance();
		for (String mot : this.goodAnswer){
			res += mot+" "+r.getString("or")+" ";
		}
		return res.substring(0,res.length()-3);
	}
	
	/**
	 * Returns the string that indicates the type (for the graphical view)
	 * @return the string that indicates the type (for the graphical view)
	 */
	@Override
	public String getType() {
		return "Multi";
	}

}