/**
 * 
 */
package fil.coo.plugin;

/**
 * @author Pierre
 *
 */
public class PluginVacances implements Plugin {

	/**
	 * Tranform a string
	 * @param s The string to transform
	 * @return the string after the transformation
	 */
	@Override
	public String transform(String s) {
		return "Bonnes vacances !!";
	}

	/**
	 * Return the label
	 * @return The label
	 */
	@Override
	public String getLabel() {
		return "PluginLicorne";
	}

	/**
	 * Return a help message
	 * @return The help message
	 */
	@Override
	public String helpMessage() {
		return "print a nice message";
	}

}