package generics;

public class AlreadyCarryingException extends Exception {
	public AlreadyCarryingException(){
	    super("Already carrying, sorry");

	}
	public AlreadyCarryingException(String msg){
	    super(msg);

	}
}
