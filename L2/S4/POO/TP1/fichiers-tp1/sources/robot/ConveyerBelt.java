
/**
 * (Documentation should be in english...)
 * ConveyerBelt on which it is possible to put boxes whose weight is not heavier than a maximal weight. 
 * A conveyer belt can accept only a limited number of boxes. 
 * @author jc 
 * @version 1.0
 */

// parce que l'on utilise des listes (sera vu plus tard)
import java.util.*;

public class ConveyerBelt {

    private static final int capacity = 2;

    // les attributs de la classe ConveyerBelt
    /** the maximal accepted total weight  */
    private int maxWeight;
    /** the belt, ie. the list of carried boxes */
    private ArrayList<Box> boxesOnBelt; // on utilise une liste de caisses pour gerer le tapis

    /**
     * a ConveyrBelt is defined by a maximal authorized  weight
     * @param maxWeight maximal authorized  weight
     */
    public ConveyerBelt(int maxWeight) {
        this.maxWeight = maxWeight;
        this.boxesOnBelt = new ArrayList<Box>();
    }

    // les methodes de la classe TapisRoulant
    /**
     * returns the maximal authorized weight
     * 
     * @return the maximal authorized weight
     */
    public int getMaxWeight() {
        return this.maxWeight;
    }

    /**
     * a box is put on this belt, an exception is thrown if this belt is full or added box is too heavy
     * 
     * @param box
     *            the bow put on the belt
     * @exception IllegalArgumentException  if box is too heavy 
     * @exception IllegalStateException  if this belt is full
     */
    public void receive(Box box) {
        if (this.accept(box)) {
            if (!this.isFull()) {
                this.boxesOnBelt.add(box);
            } else { 
                throw new IllegalStateException("belt is full");
            }
        }
        else {
            throw new IllegalArgumentException("box too heavy");
        }
    }

    /**
     * tells if belt is full
     * 
     * @return <code>true</code> iff this belt is full
     */
    public boolean isFull() {
        return this.boxesOnBelt.size() == ConveyerBelt.capacity;
    }

    /**
     * checks if this belt can accept the given box : it is not too heavy
     * 
     * @param box the box
     * @return <code>true</code> if box is not too heavy else <t>false</t> 
     */
    public boolean accept(Box box) {
        return box.getWeight() <= this.maxWeight;
    }

    /**
     * displays boxes carried by this belt
     */
    public void display() {
        System.out.println("the conveyer belt carries" + this.boxesOnBelt.size() + " box(es)");
        for (Box box : this.boxesOnBelt) {
            System.out.println(box.toString());
        }
    }

    /**
     * empty this belt : removes all boxes
     */
    public void emptyBelt() {
        // ce code sera explique plus tard dans le cours
        Iterator<Box> boxes_it = this.boxesOnBelt.iterator();
        while (boxes_it.hasNext()) {
            boxes_it.next();
            boxes_it.remove();
        }
    }
}
