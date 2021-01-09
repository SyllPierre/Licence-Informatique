/**
 * 
 */
package fil.coo.IO;

import fil.coo.file.FileEvent;
import fil.coo.file.FileListener;

/**
 * Listener for the plugins
 */
public class MyPluginListener implements FileListener {

	private View view;
	
	/**
	 * Constructor of the listener
	 * @param view The view we want to have
	 */
	public MyPluginListener(View view){
		this.view = view;
	}
	
	/**
	 * Throws the event corresponding to the view when a new file has been detected
	 */
	@Override
	public void fileAdded(FileEvent event) {
		this.view.actionWhenAdded(event);
		
	}

	/**
	 * Throw the event corresponding to the view when a file has been removed
	 */
	@Override
	public void fileRemoved(FileEvent event) {
		this.view.actionWhenRemoved(event);
		
	}
	

}