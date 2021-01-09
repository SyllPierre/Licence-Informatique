/**
 * 
 */
package fil.coo.file;

/**
 *
 */
public class MyFileListener implements FileListener{
	/**
	 * Prints that a new .class has been detected
	 */
	public void fileAdded(FileEvent e) {
		System.out.println("nouveau . class : "+e.getFileName()+" détecté.");
	}
	
	/**
	 * Prints that a .class has been deleted
	 */
	public void fileRemoved(FileEvent e) {
		System.out.println("fichier "+e.getFileName()+" supprimé.");
	}
}