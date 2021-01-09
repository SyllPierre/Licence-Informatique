package condenses_lex;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.Scanner;

import ard.ErrorType;
import ard.ParserException;
import ard.SyntaxException;


public class Exo2 {

	private Yylex tokenizer;
	private Yytoken token;

	public Exo2(Reader in) {
		tokenizer = new Yylex(new BufferedReader(in));
		try {
			token = tokenizer.yylex();
		} catch (Exception e) {
			token = new Unknown("");
		}
	}

	protected void eat(TokenType expected) throws Exception {
		System.out.print(token);
		System.out.print(" =? ");
		System.out.println(expected);
		if (token.getType() != expected)
			//throw new ParserException("expected : " + c + ", found : " + current);
		   throw new Exception();
		token = tokenizer.yylex();
	}


	private void S() throws Exception {
		switch (token.getType()) {
		case LETTRE:
		case OUVRANTE:
			// S -> ERS
			E();
			R();
			S();
			break;
		case FERMANTE:
		case EOD:
			// S -> epsilon
			break;
		default:
			// erreur
//			String myName = Thread.currentThread().getStackTrace()[1].getMethodName();
//			throw new ParserException("No rule for variable "+ myName + " token " + current+ "	.");
			throw new Exception();
		}
	}

	private void E() throws Exception {
		switch (token.getType()) {
		case LETTRE:
			// E -> Lettre
			eat(TokenType.LETTRE);
			break;
		case OUVRANTE:
			// E -> (S)
			eat(TokenType.OUVRANTE);
			S();
			eat(TokenType.FERMANTE);
			break;
		default:
			throw new Exception();
		}
	}

	private void R() throws Exception {
		switch (token.getType()) {
		case LETTRE:
		case OUVRANTE:
		case FERMANTE:
		case EOD:
			// R -> epsilon
			break;
		case ENTIER:
			// R -> Entier
			eat(TokenType.ENTIER);
			break;
		default:
			throw new Exception();
		}
	}

	public void parse() throws Exception{
		// Axiom :
		S();
		// check end of data :
		eat(TokenType.EOD);
	}

}
