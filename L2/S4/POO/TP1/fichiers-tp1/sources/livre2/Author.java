
/**
 * Defines author for Book objet
 * 
 * @see Book
 * 
 * @author JC
 * @version 1.0
 */

public class Author {
	/**
	 * an Author is defined by its nanme, firstanme, birth and death year
	 * @param name author's name
	 * @param firstname author's firstname
	 * @param birhtyear author's birth year
	 */
	public Author(String name, String firstname, int birthYear) {
		this.name = name;
		this.firstname = firstname;
		this.birthYear = birthYear;
	}

	// les attributs de la classe Author
	private String name;
	private String firstname;
	private int birthYear;
	private int deathYear;

	// les methodes de la classe Author

	/**
	 * display author's information
	 */
	public void display() {
		System.out.println(this.firstname + " " + this.name + " born in " + this.birthYear);
	}

	/**
	 * update this author death of year
	 *
	 * @param deathYear
	 *            the death of year for this author
	 */
	public void setDeathYear(int deathYear) {
		this.deathYear = deathYear;
	}
}
