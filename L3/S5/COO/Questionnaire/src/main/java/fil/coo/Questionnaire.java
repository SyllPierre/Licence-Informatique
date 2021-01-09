package fil.coo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import fil.coo.answers.Answer;


public class Questionnaire {

	private List<Question> questions;
	private BufferedReader in;
	private PrintStream out;

	/**
	 * Create a questionnaire
	 * @param in where we want to read what the user types
	 * @param out where we want to put the question
	 */
	public Questionnaire(Reader in, PrintStream out) {
		this.questions = new LinkedList<Question>();
		this.in = new BufferedReader(in);
		this.out = out;
	}

	/**
	 * Create a questionnaire
	 */
	public Questionnaire() {
		this(new InputStreamReader(System.in), System.out);
	}

	/**
		* Add a new question
		* @param question the question we want to add
		*/
	public void add (Question question){
		questions.add(question);
	}

	/**
	  * Return the questions
		* @return a list of questions
		*/
	public List<Question> getQuestions(){
		return questions;
	}
	
	/**
	 * Ask one question
	 * @param question the question
	 * @return the number of points
	 */
	private int ask(Question question) {
		ResourceBundle r = Language.getInstance();
		Answer<?> answer = question.getAnswer() ;	
		out.println(question.getQuestion()) ;
		String userAnswer = null;
		do {
			out.print("(" + answer.getGoodType() + ")") ;
			try {
				userAnswer = in.readLine() ;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (! answer.hasGoodType(userAnswer)) ;
		if (answer.isCorrect(userAnswer)) {
			int points = question.getPoints() ;
			out.println(r.getString("correct")+" (" + format(points) + ")") ;
			return points ;
		} else {
			out.println(r.getString("incorrect") + answer.toString()) ;
			return 0 ;
		}
	}
	
	/**
	 * Return points
	 * @param points the number of points 
	 * @return points
	 */
	private static String format(int points) {
		return "" + points + " point" + (points > 1?"s":"") ;
	}
	
	/**
	 * Ask all the questions
	 */
	public void askAll() {
		int result = 0 ;
		ResourceBundle r = Language.getInstance();
		for (Question question : this.questions) {
			result += this.ask(question) ;
		}
		out.println(r.getString("obtenu") + format(result)+" / "+ this.totalPoints()) ;
	}
	
	/**
	 * Return number total of points
	 * @return the number total of points
	 */
	public int totalPoints(){
		int res=0;
		for(Question q : this.questions){
			res+= q.getPoints();
		}
		return res;
	}
}
