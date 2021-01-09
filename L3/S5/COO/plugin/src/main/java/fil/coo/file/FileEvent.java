package fil.coo.file;

import java.util.EventObject;

/**
 *  This class represents an event that happens when a file is added.
 **/
public class FileEvent extends EventObject{
		private static final long serialVersionUID = 1L;
		
		private String fileName;
	
		/**
		 * @return the fileName
		 */
		public String getFileName() {
			return fileName;
		}
		
		/**
		 * Constructor of FileEvent
		 * @param source the source of the event
		 * @param fileName the name of the file
		 */
		public FileEvent(Object source, String fileName){
			super(source);
			this.fileName = fileName;
		}
}