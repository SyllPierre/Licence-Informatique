/**
 * 
 */
package fil.coo.plugin;

/**
 *
 */
public class ToUpperCase implements Plugin {

	/**
	 * Tranform a string
	 * @param s The string to transform
	 * @return the string after the transformation
	 */
	@Override
	public String transform(String s) {
		return s.toUpperCase();
	}

	/**
	 * Return the label
	 * @return The label
	 */
	@Override
	public String getLabel() {
		return "ToUpperCase";
	}

	/**
	 * Return a help message
	 * @return The help message
	 */
	@Override
	public String helpMessage() {
		return "Plugin that puts every letter in upper case";
	}

}