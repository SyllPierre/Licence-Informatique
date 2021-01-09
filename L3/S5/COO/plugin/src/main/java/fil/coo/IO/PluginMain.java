/**
 * 
 */
package fil.coo.IO;

import fil.coo.file.FileChecker;
import fil.coo.file.FileNameFilter;

/**
 *
 */
public class PluginMain {

	public static void main(String[] args) {
		FileChecker pluginChecker = new FileChecker(new FileNameFilter(),"extensions");
		Graphical graphical = new Graphical(pluginChecker);
		MyPluginListener myPluginListener = new MyPluginListener(graphical);
		pluginChecker.addFileListener(myPluginListener);
		graphical.start();
	}

}