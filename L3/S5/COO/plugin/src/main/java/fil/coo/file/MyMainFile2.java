package fil.coo.file;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class MyMainFile2 {
	public static void main(String[] args) throws IOException{
		String current = new java.io.File( "." ).getCanonicalPath();
		String fileName = current+"/src/main/java/fil/coo/file";
		File myFile = new File(fileName);
		String[] files = myFile.list(new FilenameFilter(){
			public boolean accept(File dir, String name){
				return name.startsWith("C");
			}
		});
		for (String file : files){
			System.out.println(file);
		}
	}
}