package fil.coo.content;

/**
 * @author SYLLEBRANQUE
 *
 */
public class Text implements Content {
	private String text;

	/**
	 * Create a text content
	 * @param text the text
	 */
	public Text(String text) {
		this.text = text;
	}

	/**
	 * Return the text of this content
	 * @return text the text
	 */
	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return "[" + text + "]";
	}	
	
	
}