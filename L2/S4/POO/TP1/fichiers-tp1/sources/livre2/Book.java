
/**
 * Second book version for simple object manipulations
 * 
 * @author jc
 * @version 1.0
 */

public class Book {
    /**
     * book is defined by its author , its title, its
     * publication year and full text
     * 
     * @param author the author of this book
     * @param title the title of this book
     * @param year the publicatiojn year of this book
     * @param text the text of this book
     */
	public Book(Author author, String title, int publicationYear, String text) {
		this.author = author;
		this.title = title;
		this.publicationYear = publicationYear;
		this.text = text;
	}

	// les attributs de la classe Book

	private Author author;
	private String title;
	private int publicationYear;
	private String text;

	// les methodes de la classe Book


    /**
     * display information on this book
     */
	public void display() {
		System.out.println(this.title);
		System.out.println(" by ");
		this.author.display();
		System.out.println(" published in " + publicationYear);
	}

    /**
     * reads this book (actually displays text)
     */
	public void read() {
		System.out.println(this.text);
	}

    /**
     * returns this book's author
     * 
     * @return this book's author
     */
	public Author getAuthor() {
		return this.author;
	}
}
