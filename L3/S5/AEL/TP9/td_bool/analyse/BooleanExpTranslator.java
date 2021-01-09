package analyse;

import java.io.IOException;
import java.io.Reader;

import lexical.Constant;
import lexical.Ident;
import lexical.LexicalException;
import lexical.TokenType;

public class BooleanExpTranslator extends AbstractParser<String> {

	public BooleanExpTranslator(Reader in) throws IOException, LexicalException {
		super(in);
	}

	@Override
	protected String axiom() throws SyntaxException, ParserException, IOException, LexicalException {
		return E();
	}

	private String E() throws SyntaxException, ParserException, IOException, LexicalException {
		switch (current.getType()) {
		case CONSTANT:
		case IDENT:
		case OPEN_BRACKET:
		case NOT:
			String s1 = T();
			String s2 = Ep();
			return s1 + s2;
		default:
			throw new SyntaxException(ErrorType.NO_RULE, current);
		}
	}

	private String Ep() throws ParserException, IOException, LexicalException, SyntaxException {
		switch (current.getType()) {
		case OR:
			next();
			String s1 = T();
			String s2 = Ep();
			return " or "+ s1 + s2;
		case CLOSE_BRACKET:
		case EOD:
			return "";
		default:
			throw new SyntaxException(ErrorType.NO_RULE, current);
		}
	}

	private String T() throws SyntaxException, ParserException, IOException, LexicalException {
		switch (current.getType()) {
		case CONSTANT:
		case IDENT:
		case OPEN_BRACKET:
		case NOT:
			String s1 = F();
			String s2 = Tp();
			return s1 + s2;
		default:
			throw new SyntaxException(ErrorType.NO_RULE, current);
		}
	}

	private String Tp() throws ParserException, IOException, LexicalException, SyntaxException {
		switch (current.getType()) {
		case AND:
			next();
			String s1 = F();
			String s2 = Tp();
			return " and "+ s1 + s2;
		case OR:
		case CLOSE_BRACKET:
		case EOD:
			return "";
		default:
			throw new SyntaxException(ErrorType.NO_RULE, current);
		}
	}

	private String F() throws SyntaxException, ParserException, IOException, LexicalException {
		switch (current.getType()) {
		case CONSTANT: {
			Constant c = (Constant) current;
			next();
			return Boolean.toString(c.getValue());
		}
		case IDENT: {
			Ident i = (Ident) current;
			next();
			return i.image();
		}
		case OPEN_BRACKET: {
			next();
			String e = E();
			eat(TokenType.CLOSE_BRACKET);
			return "(" + e + ")";
		}
		case NOT: {
			next();
			String s1 = F();
			return " not "+ s1;
		}
		default:
		throw new SyntaxException(ErrorType.NO_RULE, current);
		}
	}

}
