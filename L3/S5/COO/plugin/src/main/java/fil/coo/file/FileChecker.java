package fil.coo.file;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;

/**
 *  Class that fires the events 
 **/
public class FileChecker {
	private List<String> listFiles = new ArrayList<String>();
	private List<FileListener> listeners = new ArrayList<FileListener>();
	private Timer timer;
	private FilenameFilter fileNameFilter;
	private File dir;
	
	/**
	 * Constructor of the FileChecker 
	 * @param f a FilenameFilter
	 * @param dir a directory
	 */
	public FileChecker(FilenameFilter f, String dir){
		this.fileNameFilter = f;	
		this.dir = new File(dir);
	}
	
	/**
	 * Throws checkFiles when is called
	 *
	 */
	public class FileCheckerEvent implements ActionListener{
		public void actionPerformed(ActionEvent event){
				checkFiles();
		}
	}
	
	
	/**
	 * Throws the event
	 */
	public void start(){
		this.timer = new Timer(2500,new FileCheckerEvent());
		this.timer.start();
		while(true);
	}
	
	/**
	 * Check if a new file has been added or removed
	 */
	public void checkFiles(){
		String[] list = this.dir.list(this.fileNameFilter); /* dans list, on recupere tout ce qui correspond au filtre qui est dans dir */
		List<String> copie = new ArrayList<String>(listFiles);
		for (String str : list){
			if (!copie.contains(str)){ /* si il y a un fichier qui n'est pas encore enregistré */
				fireFileAdded(str); 
				listFiles.add(str);
			}
			else {
				copie.remove(str);
			}
		}
		for (String str : copie ){
			fireFileRemoved(str);
			listFiles.remove(str);
		}
		
	}
	
	/**
	 * Add a new fileListener
	 * @param fileListener a FileListener
	 */
	public synchronized void addFileListener(FileListener fileListener) {
		if (!listeners.contains(fileListener)) {
			listeners.add(fileListener);
		}
	}
	
	/**
	 * Remove a fileListener
	 * @param fileListener a FileListener
	 */
	public synchronized void removeFileListener(FileListener fileListener) {
		listeners.remove(fileListener);
	}
	
	/**
	 * If a new file has been detected, fireFileAdded will notify the listeners
	 * @param fileString the name of the file
	 */
	private void fireFileAdded(String fileString){
		FileEvent fileEvent = new FileEvent(this,fileString);
		for(FileListener fl : listeners){
			fl.fileAdded(fileEvent);
		}
	}
	
	/**
	 * If a file has been removed, fireFileAdded will notify the listeners
	 * @param fileString the name of the file
	 */
	private void fireFileRemoved(String fileString){
		FileEvent fileEvent = new FileEvent(this,fileString);
		for(FileListener fl : listeners){
			fl.fileRemoved(fileEvent);
		}
	}
	

}