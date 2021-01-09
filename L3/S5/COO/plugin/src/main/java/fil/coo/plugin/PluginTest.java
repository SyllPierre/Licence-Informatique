package fil.coo.plugin;


public class PluginTest implements Plugin {

	public PluginTest(){
		
	}
	
	/**
	 * Tranform a string
	 * @param s The string to transform
	 * @return the string after the transformation
	 */
	@Override
	public String transform(String s) {
		return "This is a test !";
	}

	/**
	 * Return the label
	 * @return The label
	 */
	@Override
	public String getLabel() {
		return "getLabel";
	}
	
	/**
	 * Return a help message
	 * @return The help message
	 */
	@Override
	public String helpMessage() {
		return "Test if plugin works fine";
	}

}