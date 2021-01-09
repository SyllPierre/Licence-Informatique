
/**
 * A toy is characterized by its brand
 * 
 * @author jc 
 * @version 1.0
 */
 

public class Toy {
    // constructeurs d'objets de la classe Toy
	
    /** builds a toy with given brand
     * @param brand the toy's brand
     */
    public Toy(String brand) {
        this.brand = brand;
    }
    
    // les attributs de la classe Toy
    /** this toy's brand */
    private String brand;
    
    // les methodes de la classe Toy
    /** displays information on this toy
     */
    public void display() {
        System.out.println(this.toString());
    }
    /** provides a String representing this toy
     * @return a string representation of this toy
     */
    public String toString() {
    	return "I am a toy of brand " + this.brand;
    }
}
