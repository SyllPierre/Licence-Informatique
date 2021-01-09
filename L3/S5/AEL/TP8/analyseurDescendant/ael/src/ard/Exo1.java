package ard;

import java.io.Reader;

public class Exo1 extends Ard {

	public Exo1(Reader in) {
		super(in);
	}

	private void S() throws SyntaxException, ParserException {
		switch (current) {
		case 'a':
		case 'b':
		case 'c':
		case '(':
			// S -> ERS
			E();
			R();
			S();
			break;
		case ')':
		case END_MARKER:
			// S -> epsilon
			break;
		default:
			// erreur
//			String myName = Thread.currentThread().getStackTrace()[1].getMethodName();
//			throw new ParserException("No rule for variable "+ myName + " token " + current+ "	.");
			throw new SyntaxException(ErrorType.NO_RULE,current);
		}
	}

	private void E() throws SyntaxException, ParserException {
		switch (current) {
		case 'a':
		case 'b':
		case 'c':
			// E -> L
			L();
			break;
		case '(':
			// E -> (S)
			eat('(');
			S();
			eat(')');
			break;
		default:
			throw new SyntaxException(ErrorType.NO_RULE,current);
		}
	}

	private void R() throws SyntaxException, ParserException {
		switch (current) {
		case 'a':
		case 'b':
		case 'c':
		case '(':
		case ')':
		case END_MARKER:
			// R -> epsilon
			break;
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			// R -> C
			C();
			break;
		default:
			throw new SyntaxException(ErrorType.NO_RULE,current);
		}
	}

	private void L() throws SyntaxException, ParserException {
		switch (current) {
		case 'a':
		case 'b':
		case 'c':
			// L -> a|b|c
			eat(current);
			break;
		default:
			throw new SyntaxException(ErrorType.NO_RULE,current);
		}
	}

	private void C() throws SyntaxException, ParserException {
		switch (current) {
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			// C -> 0|1|...|9
			eat(current);
			break;
		default:
			throw new SyntaxException(ErrorType.NO_RULE,current);
		}
	}

	@Override
	protected void axiom() throws SyntaxException, ParserException {
	  S();
	}


}
