/**
 * 
 */
package fil.coo.graphical;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import fil.coo.*;
import fil.coo.answers.Answer;

/**
 *
 */
public class GraphicalQuestionnaire {
	private static int result;
	private static Questionnaire Questionnaire;
	private static JPanel panel1;
	private List<Boolean> correctAnswers = new ArrayList<Boolean>();
	
	
	public static void main(String[] args) throws IOException{
		createQuestionnaire(args[0]);
	}
	
	public static void createQuestionnaire(String fileName) throws IOException {
		QuestionnaireFactory qF = new QuestionnaireFactory();
		Questionnaire = qF.QuestionnairecreateQuestionnaire(fileName);
		createGraphicalQuestionnaire(Questionnaire);
	}

	private static void createGraphicalQuestionnaire(Questionnaire Questionnaire) {
		result = 0 ;
		experiment();
	}
	
	

	public static void experiment() {
		JButton finalButton;
		int nbQuestion = Questionnaire.getQuestions().size();
		Answer<?> answer;
		JFrame f = new JFrame("Questionnaire");
		f.setLocation(100, 300);
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(nbQuestion,2));
		
		// Ici, nous affichons les questions
		for (Question question : Questionnaire.getQuestions()){
			panel1.add(new JLabel(question.getQuestion()));
			answer = question.getAnswer();
			JPanel jp = createGraphicalAnswer(answer);
			panel1.add(jp);
		}
		f.add(panel1, BorderLayout.CENTER);
		
		finalButton = new JButton("Finish");


		// abonnement d'un listener :
		finalButton.addActionListener(new GraphicalQuestionnaire().new AfficheResultatListener());
		

		f.add(finalButton,BorderLayout.SOUTH);
		


		f.pack();
		f.setVisible(true);
	}
	
	private static JPanel createGraphicalAnswer(Answer<?> answer) {
		JPanel panelRes = new JPanel();
		if (answer.getType().equals("Textual") || answer.getType().equals("Multi")){
			JTextField j = new JTextField();
			j.setPreferredSize( new Dimension( 200, 30 ) );
			panelRes.add(j);
		}
		if (answer.getType().equals("YesNo")){
			ResourceBundle r = Language.getInstance();
			JRadioButton yesButton = new JRadioButton(r.getString("oui"));
			JRadioButton noButton = new JRadioButton(r.getString("non"));
			ButtonGroup group = new ButtonGroup();
			group.add(yesButton);
			group.add(noButton);
			panelRes.add(yesButton);
			panelRes.add(noButton);

		}
		if (answer.getType().equals("MultipleChoice")){
			ButtonGroup group = new ButtonGroup();
			for (String a : answer.getAnswers()){
				JRadioButton tmp = new JRadioButton(a);
				group.add(tmp);
				panelRes.add(tmp);
			}
		}
		if (answer.getType().equals("Numerical")){
			JSpinner spinner = new JSpinner();
			spinner.setPreferredSize(new Dimension( 100, 30 ));
			panelRes.add(spinner);
		}
		return panelRes;
	}

	public class AfficheResultatListener implements ActionListener {		
		
		public void actionPerformed(ActionEvent e) {
			ResourceBundle r = Language.getInstance();
			result = 0;
			int i;
			int size = Questionnaire.getQuestions().size();
			for (i = 0; i< size*2;i+=2){
				
				Question q = Questionnaire.getQuestions().get(i/2);
				String answer = traiteReponse((JPanel)panel1.getComponent(i+1));
				if(q.getAnswer().isCorrect(answer)){
					correctAnswers.add(true);
					result += q.getPoints();
				}
				else{
					correctAnswers.add(false);
				}
				
			}
			String endMessage = "";
			for(i=0; i<size;i++){
				endMessage += Questionnaire.getQuestions().get(i).getQuestion();
				if(correctAnswers.get(i)==false){
					endMessage += " --> "+r.getString("incorrect");
					endMessage += Questionnaire.getQuestions().get(i).getAnswer().toString()+"\n";
				}
				else {
					endMessage += r.getString("correct")+", "+r.getString("points")+" : "+Questionnaire.getQuestions().get(i).getPoints()+"\n";
				}
			}
			endMessage += "\n"+r.getString("result")+" : "+result+" / "+Questionnaire.totalPoints();
			JOptionPane.showMessageDialog(null, endMessage );
		}

		private String traiteReponse(JPanel component) {
			Class<? extends Component> c = component.getComponent(0).getClass();
			if (c.isAssignableFrom(JTextField.class)){
				JTextField c1 = (JTextField) component.getComponent(0);
				return c1.getText();
			}
			else if (c.isAssignableFrom(JRadioButton.class)){
				for (int i=0; i<component.getComponentCount(); i++){
					JRadioButton r1 = (JRadioButton) component.getComponent(i);
					if (r1.isSelected()){
						return r1.getText();
					}
				}
			}
			if (c.isAssignableFrom(JSpinner.class)){
				JSpinner c1 = (JSpinner) component.getComponent(0);
				return c1.getValue().toString();
			}
		return "";
		}
		
	}
	
	



	
}