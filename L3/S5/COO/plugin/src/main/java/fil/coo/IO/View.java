package fil.coo.IO;

import fil.coo.file.FileEvent;

/**
 * A View
 *
 */
public interface View {

	void actionWhenAdded(FileEvent event);
	void actionWhenRemoved(FileEvent event);
	
}