
import java.util.*;


/**
 * a library collects some books...
 * In order to simplify, in this introductory example, books are stored in an array.
 * 
 * @author JC
 * @version 1.0
 */

public class Library {
	// definition d'une constante pour le nombre max de livres
	private static final int NB_BOOKS_MAX = 10;

	// les attributs de la classe Library
	/** the array of books */
	private Book[] theBooks;
	/** the current number of books in the library */
	private int nbBooks;

	/**
	 * Initially a library has no book
	 */
	public Library() {
		this.theBooks = new Book[NB_BOOKS_MAX];
		this.nbBooks = 0;
	}

	// les methodes de la classe Library

	/**
	 * adds a book to this library if it is not full, else nothing happpens
	 * 
	 * @param book
	 *            the book to add
	 */
	public void addBook(Book book) {
		if (this.nbBooks < this.theBooks.length) {
			this.theBooks[this.nbBooks] = book;
			this.nbBooks = this.nbBooks + 1;
		}
	}

	/**
	 * display the current books in this Library
	 */
	public void displayBooks() {
	    System.out.println("books in the library :");
		int cpt = 0;
		while (cpt < this.nbBooks) {
			this.theBooks[cpt].display();
			cpt = cpt + 1;
		}
	}

	/**
	 * returns the number of books in this library
	 * 
	 * @return the number of books in this library
	 */
	public int getNbBooks() {
		return this.nbBooks;
	}

}
