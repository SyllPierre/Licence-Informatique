package fil.coo.file;

import java.io.File;
import java.io.FilenameFilter;
/**
 * A class that checks if the file ends with ".class"
 */
public class FileNameFilter implements FilenameFilter{
	
		public boolean accept(File dir, String name){
			return name.endsWith(".class");
		}
}