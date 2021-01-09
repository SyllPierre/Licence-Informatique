package fil.coo;

import java.io.IOException;

public class TextualQuestionnaire {
	
	public static void main(String[] args) throws IOException{
		createQuiz(args[0]);
	}
	
	public static void createQuiz(String fileName) throws IOException {
		QuestionnaireFactory qF = new QuestionnaireFactory();
		Questionnaire quiz = qF.QuestionnairecreateQuestionnaire(fileName);
		quiz.askAll();
	}
}