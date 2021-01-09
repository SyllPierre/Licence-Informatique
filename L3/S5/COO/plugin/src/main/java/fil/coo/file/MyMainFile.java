package fil.coo.file;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class MyMainFile {
	public static void main(String[] args) throws IOException{
		String current = new java.io.File( "." ).getCanonicalPath();
		String fileName = current+"/src/main/java/fil/coo/file";
		File myFile = new File(fileName);
		
		FilenameFilter filter = new FilenameFilter(){
			public boolean accept(File dir, String name){
				return name.endsWith(".class");
			}
		};
		
		String[] files = myFile.list( filter );
		for (String file : files){
			System.out.println(file);
		}
	}
}
