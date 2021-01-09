
/**
 * Boxes defined by their weight.
 * 
 * @author jc 
 * @version 1.0
 */

public class Box {   

    /** A box is defined by its weight
     * @param weight this box weight
     */
    public Box(int weight) {
        this.weight = weight;
    }
    
    // les attributs de la classe Caisse
    /** this box's weight */
    private int weight;
    
    // les methodes de la classe Caisse     
    /**returns this box's weight
     * @return this box's weight
     */
    public int getWeight() {
        return this.weight;
    }
    /**
     * @return a string representation for this box
     */
    public String toString() {
        return "a box of weight "+this.weight;
    }
}
