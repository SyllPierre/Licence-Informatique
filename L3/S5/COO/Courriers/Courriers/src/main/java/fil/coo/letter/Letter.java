package fil.coo.letter;

import fil.coo.Inhabitants;
import fil.coo.content.Content;
import fil.coo.exception.LetterAlreadyInMailboxException;

/**
 * 
 * @author SYLLEBRANQUE DESMAREST
 *
 */
public abstract class Letter<T extends Content> implements Content {
	
	private Inhabitants sender;
	private Inhabitants receiver;
	private T content;
	private String name;
	protected static int label = 0;
	
	/**
	 * @param sender the sender
	 * @param receiver the receiver
	 * @param content the content
	 */
	public Letter(Inhabitants sender, Inhabitants receiver, T content) {
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
		label++;
		setName("Mail n° " + label);
	}
	
	/**
	 * @return the sender
	 */
	public Inhabitants getSender() {
		return sender;
	}
	
	/**
	 * @param sender the sender to set
	 */
	public void setSender(Inhabitants sender) {
		this.sender = sender;
	}
	
	/**
	 * @return the receiver
	 */
	public Inhabitants getReceiver() {
		return receiver;
	}
	
	/**
	 * @param receiver the receiver to set
	 */
	public void setReceiver(Inhabitants receiver) {
		this.receiver = receiver;
	}
	
	/**
	 * @return the content
	 */
	public T getContent() {
		return content;
	}
	
	/**
	 * @param content the content to set
	 */
	public void setContent(T content) {
		this.content = content;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public abstract void toDoWhenReceive() throws LetterAlreadyInMailboxException;
	
	public abstract float getCost();
	
	public abstract String getDescription();

	@Override
	public String toString() {
		return this.name + " " + this.getDescription();
	}

	public  String getContentDescription() {
		return this.getContent().toString();
	}
	
	
}