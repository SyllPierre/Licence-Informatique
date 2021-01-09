/**
 * 
 */
package fil.coo.plugin;

/**
 * A plugin that transforms a text
 */
public interface Plugin {
	public String transform(String s);
	public String getLabel();
	public String helpMessage();
}