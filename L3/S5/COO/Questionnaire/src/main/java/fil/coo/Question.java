
package fil.coo;

import fil.coo.answers.Answer;

/**
 * Class that create a question
 * @author syllebranque desmarest
 */

public class Question {
	private String question;
	private Answer<?> answer;
	private int points;
	
	/**
	 * Create a new question
	 * @param text the question
	 * @param answer the answer of the question
	 * @param nbPoints the points of the question
	 */
	public Question(String text, Answer<?> answer, int nbPoints){
		this.points = nbPoints;
		this.answer = answer;
		this.question = text;
	}
	
	/**
	 * Return the answer of the question
	 * @return the answer of the question
	 */
	public Answer<?> getAnswer(){
		return this.answer;
	}
	
	/**
	 * Return the question
	 * @return the question
	 */
	public String getQuestion() {
		return this.question;
	}
	
	/**
	 * Return the number of points
	 * @return the number of points
	 */
	public int getPoints() {
		return this.points;
	}
}