/**
 * 
 */
package fil.coo.file;

import java.io.FilenameFilter;



/**
 *
 */
public class MainExercice3 {

	public static void main(String[] args) {
	
		FilenameFilter filter = new FileNameFilter();
		FileChecker fileChecker = new FileChecker(filter,".");
		MyFileListener myFileListener = new MyFileListener();
		fileChecker.addFileListener(myFileListener);
		fileChecker.start();
	}
}