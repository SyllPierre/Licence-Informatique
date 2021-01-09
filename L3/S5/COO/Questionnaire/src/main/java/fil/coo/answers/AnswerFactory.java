package fil.coo.answers;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * AnswerFactory is a class that creates the answer when given a string.
 * This class was given by a teacher.
 * We used the first method.
 */
public class AnswerFactory  {
	/**
	 * The answer factory
	 */
	public final static AnswerFactory FACTORY = new AnswerFactory() ;
	
	/**
	 * The constructor of the answer factory
	 */
	private AnswerFactory(){}
	
	/**
	 * Build the answer
	 * @param answer the string we're trying to build an answer from
	 * @return an answer
	 */
	public Answer<?> buildAnswer(String answer) {
		try{
			return new NumericalAnswer(answer) ;		
		} catch (IllegalArgumentException e1) {
		try{
			return new YesNoAnswer(answer) ;		
		} catch (IllegalArgumentException e2) {
		try{
			return new MultiAnswer(answer) ;		
		} catch (IllegalArgumentException e3) {
		try{
			return new MultipleChoiceAnswer(answer) ;		
		} catch (IllegalArgumentException e4) {
			return new TextualAnswer(answer);
		}}}}
	}

	/**
	 * Build the answer
	 * @param className the name of the class
	 * @param answer the string we're trying to build an answer from
	 * @return the answer
	 */
	public Answer<?> buildAnswer2(String className , String answer) {
			Class<?> c ; 
			Constructor<?> r ;
			try {
				c = Class.forName("quiz."+className);
			} catch (ClassNotFoundException e) {
				throw new IllegalArgumentException("Unknown class : " + className) ;
			}
			try {
				r = c.getConstructor(String.class) ;
			} catch (SecurityException e) {
				throw new IllegalArgumentException("Security violation") ;
			} catch (NoSuchMethodException e) {
				throw new IllegalArgumentException("Constructor is missing") ;
			}
			try {
				return (Answer<?>) r.newInstance(answer) ;
			} catch (IllegalAccessException e) {
				throw new IllegalArgumentException("Security violation") ;
			} catch (InvocationTargetException e) {
				throw new IllegalArgumentException("Invocation error") ;
			} catch (InstantiationException e) {
				throw new IllegalArgumentException("Construction error") ;
			}
	}

	

}