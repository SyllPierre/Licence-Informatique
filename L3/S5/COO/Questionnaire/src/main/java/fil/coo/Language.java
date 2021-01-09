package fil.coo;

import java.util.Locale;
import java.util.ResourceBundle;

public class Language{
	private static ResourceBundle INSTANCE = null;
	
	/**
	 * Define the language of the game
	 * @param lang the language of the game
	 */
	
	public Language(String lang) {
		if (INSTANCE == null) {
			if (lang.equals("en")) {
				INSTANCE = ResourceBundle.getBundle("myBundle",Locale.ENGLISH);
			}
			else {
				INSTANCE = ResourceBundle.getBundle("myBundle",Locale.FRANCE);
			}
		}
	}
	
	/**
	 * Return the language of the game
	 * @return the language of the game
	 */
	public static ResourceBundle getInstance() {
		return INSTANCE;
	}
	
}

