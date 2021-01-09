package fil.coo.scanner;

import java.util.*;
import java.io.*;

/** Provide a class to read integer between 1 and a given value.
By default value are read from System.in but InputStream can be changed.

ScannerInt implements Singleton design pattern

*/
public class ScannerInt {
	
    private Scanner scanner;

    /** to ensure the singleton, default input stream is System.in  */
    private ScannerInt() {
	this.setInToSystemIn();
    }

    /** SINGLETON instance */
    public static final ScannerInt INSTANCE = new ScannerInt();

    /** change the used input stream  
     @param in the new used InputStream
    */
    public void setIn(InputStream in){
	this.scanner = new Scanner(in);
     }
    /** set the used InputStream to System.in*/
    public void setInToSystemIn() {
	this.setIn(System.in);
    }
	
	/**
	 * reads an integer between 1 and n, input is repeated until provided value is correct
	 * 
	 * @param n upper bound
	 * @return input value
	 */
	public int readInt(int n) {
		int input = 0;
		while (input < 1 || input > n) {
			System.out.print("\nYour choice (1-" + n + ") |-> ");
			try {
				input = scanner.nextInt();
				System.out.println("");
			} catch (InputMismatchException	 e){
				// consume the input (that is not an integer)
				scanner.skip(".*");
			}
		} 
		return input;
	}
}