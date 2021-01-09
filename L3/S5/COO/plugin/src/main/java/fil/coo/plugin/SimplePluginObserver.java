package fil.coo.plugin;

import java.io.FilenameFilter;

import fil.coo.file.FileChecker;
import fil.coo.file.MyFileListener;

public class SimplePluginObserver {

	public static void main(String[] args) {
		
		FilenameFilter filter = new PluginFilter();
		FileChecker fileChecker = new FileChecker(filter,"extensions");
		MyFileListener myFileListener = new MyFileListener();
		fileChecker.addFileListener(myFileListener);
		fileChecker.start();
		
	}
}