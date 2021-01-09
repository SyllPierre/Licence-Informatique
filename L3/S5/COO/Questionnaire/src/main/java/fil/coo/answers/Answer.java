package fil.coo.answers;

import java.util.List;

/**
	* Class abstract for the answers
	*/

public abstract class Answer<T>{

	/**
	 * The good Answer
	 */
	protected T goodAnswer;

	/**
	 * Create an answer
	 * @param answer the answer
	 */

	public Answer(T answer) {
		this.goodAnswer = answer;
	}

	/**
	 * Return the good type
	 * @return the string that indicates the good type
	 */
	public abstract String getGoodType();


	/**
	 * Return true if the string has the good type
	 * @param s the string
	 * @return true if the string has the good type
	 */

	public boolean hasGoodType(String s) {
		return true;
	}

	/**
	 * Returns true if the string is correct
	 * @param s the string
	 * @return true if the string is correct
	 */
	public boolean isCorrect(String s){
		return this.goodAnswer.toString().toUpperCase().equals(s.toUpperCase());
	}

	/**
	 * Return the good answer
	 * @return the good answer
	 */
	protected T getGoodAnswer(){
		return this.goodAnswer;
	}

	/**
	 * Returns the string of the good answer
	 * @return the string of the good answer
	 */
	public String toString(){
		return this.getGoodAnswer().toString();
	}

	/**
	 * Returns the string that indicates the type (for the graphical view)
	 * @return the string that indicates the type (for the graphical view)
	 */
	public abstract String getType();

	/**
	 * Returns a list of the answers
	 * @return the answers
	 */
	public List<String> getAnswers() {
		return null;
	}


}
