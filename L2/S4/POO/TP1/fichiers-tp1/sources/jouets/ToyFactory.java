 
/**
 * a toy factory can create Toy objects, it is characterized by a
 * brand
 * 
 * @author jc 
 * @version 1.0
 */ 
 

public class ToyFactory {
    // constructeurs de la classe ToyFactory
    /**
     * builds a Toyfactory of "generic" brand
     */
    public ToyFactory() {
    	this.brand = "generic";     // ou : this("generic");
    }
    /**
     * builds a Toyfactory of give brand
     * @param brand brand of this factory
     */
    public ToyFactory(String brand) {
        this.brand = brand;
    }
    
    // les attributs de la classe ToyFactory    
    /** la marque des jouets de l'usine
     * par defaut  la marque est "generique"
     */ 
    private String brand;
    
    // les methodes de la classe ToyFactory
    /** builds a new toy with this factory's brand 
     * @return the new built toy
     */
    public Toy produce() {
        // creates a new object
        Toy toy = new Toy(this.brand);
        // since we have the reference we can send message to the object
        toy.display();
        // the return value can be an object, returned through the reference
        return toy;
    }
}
