package fil.coo;

import java.io.IOException;

import fil.coo.graphical.GraphicalQuestionnaire;

/**
 * 
 */
public class TextualOrGraphicalQuestionnaire {
		
	/**
	 * @param args the first argument is the fileName and the second is "textual" or "graphical"
	 * @throws IOException the exception
	 */
	public static void main(String[] args) throws IOException{
		new Language(args[2]);
		if(args[1].equals("textual")) {
			TextualQuestionnaire.createQuiz(args[0]);
		}
		else if (args[1].equals("graphical")){
			GraphicalQuestionnaire.createQuestionnaire(args[0]);
		}
	}
}