package fil.coo.plugin;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;

/**
 * A Filter for the plugins
 *
 */
public class PluginFilter implements FilenameFilter{

	@Override
	public boolean accept(File dir, String name) {
		//System.out.println(name.substring(0, name.length()-6));
		if(!name.endsWith(".class"))
			return false;
		try {
			Class<?> c = Class.forName("fil.coo.plugin."+name.substring(0, name.length()-6));
			Class<?> plugin = Class.forName("fil.coo.plugin.Plugin");
			//System.out.println(c.toString());
			//System.out.println(plugin.toString());
			if (!plugin.isAssignableFrom(c)) return false;
			Constructor<?> cons = c.getConstructor();
			cons.newInstance();
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
			return false;

		} catch (NoSuchMethodException e) {
			System.out.println("Method not found");
			return false;
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
			return false;
		}
	}
	
}