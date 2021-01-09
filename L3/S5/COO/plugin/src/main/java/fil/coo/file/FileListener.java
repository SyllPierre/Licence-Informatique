package fil.coo.file;

import java.util.EventListener;
/**
 * Interface of the listeners
 **/
public interface FileListener extends EventListener {
	
	public void fileAdded(FileEvent event);
	public void fileRemoved(FileEvent event);
}