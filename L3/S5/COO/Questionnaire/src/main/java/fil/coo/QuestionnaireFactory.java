/**
 * 
 */
package fil.coo;

import java.io.*;


import fil.coo.answers.AnswerFactory;

/**
 *
 */
public class QuestionnaireFactory {
	
	/**
	 * Create a new question
	 * @param text the question
	 * @param answer the answer
	 * @param points the number of points
	 * @return a new question
	 * @throws IOException if the question hasn't a good format
	 */
	public Question createQuestion(String text , String answer, String points) throws IOException{
		try{
			int nbPoints = Integer.parseInt(points);
			return  new Question(text , AnswerFactory.FACTORY.buildAnswer(answer), nbPoints);
		}
		catch (NumberFormatException e){
			throw  new	IOException("bad format");
		}
	}
	
	
	/**
	 * Create a Questionnaire
	 * @param fileName source of the Questionnaire
	 * @return a new Questionnaire
	 * @throws IOException if file has a bad format
	 */
	public Questionnaire QuestionnairecreateQuestionnaire(String fileName) throws IOException {
		Questionnaire questionnaire = new Questionnaire ();
		File source = new File(fileName);
		BufferedReader in = null;
		try {
			in = new BufferedReader(new	FileReader(source ));
			String text ;
			// read block of 3 lines : text , answer and number of points
			while ((text = in.readLine())!= null) {
				String answer = in.readLine ();
				String nbPoints = in.readLine ();
				if (answer == null || nbPoints == null){
						throw  new IOException(	"bad format");
				}
				questionnaire.add(this.createQuestion(text , answer, nbPoints));
			}
		}
		catch (FileNotFoundException e){
			throw  new 	IOException(e);
		}
		finally {
			in.close();
		}
		return questionnaire ;
	}
}