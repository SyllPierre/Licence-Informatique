package generics;
import java.util.*;

/** define collectors able to collect (and carry) one specific type T of objects
 * only one T object can be carried at a time
 */

public class Collector<T> {
	/**
	 * Construct a collector
	 * @param name the name of the collector
	 */
	public Collector(String name) {
	this.name = name;
	this.carriedObject = null;
    }

    private String name;
    private T carriedObject;
	
    /**
     * Returns the name of the collector
     * @return the name of the collector
     */
    public String toString() {
	return this.name;
    }
    
    /**
     * returns the description of the collector
     * @return the description of the collector
     */
    public String description() {
	return this.name + " carries " + this.carriedObject;
    }
    
    /**
     * Returns the carried object
     * @return the carried object
     */
    public T getCarriedObject(){
    	if (this.carriedObject != null){
    		return this.carriedObject;
    	}
    	else {
    		return null;
    	}
    }
    
    /**
     * The collector takes an object 
     * @param obj The object that will be taken
     * @throws AlreadyCarryingException if the collector is already carrying an object
     */
    public void take(T obj) throws AlreadyCarryingException {
    	if (this.getCarriedObject() == null){
    		this.carriedObject = obj;}
    	else {
    		throw new AlreadyCarryingException("Already carrying, sorry");

    	}
    }
    
    /**
     * Give to another collector the object
     * @param otherCollector the collector we want to give the object to
     * @throws AlreadyCarryingException if the collector already has an object
     */
    public void giveTo(Collector<? super T> otherCollector) throws AlreadyCarryingException{
    	T obj = this.getCarriedObject();
    	if (otherCollector.getCarriedObject() == null){
    		otherCollector.take(obj);
    		this.carriedObject = null;
    	}
    	else  {
    		throw new AlreadyCarryingException();
    	}
    }
    
    /**
     * Makes the collector drops the object
     * @return the object the collector dropped or null if the collector didn't have any object.
     */
    public T drop(){
    	if (this.getCarriedObject()!= null){
    		T obj = this.getCarriedObject();
    		this.carriedObject = null;
    		return obj;
    	}
    	else {
    		return null;
    	}
    }
    
    public static void main(String[] args) throws AlreadyCarryingException {
	
		Carrot c1 = new Carrot(1);
		Carrot c2 = new Carrot(2);
		Carrot c3 = new Carrot(3);
		Apple p1 = new Apple(1);
		Apple p2 = new Apple(2);

		Collector<Carrot> carrotCollector1 = new Collector<Carrot>("carrot-collector-1");
		Collector<Carrot> carrotCollector2 = new Collector<Carrot>("carrot-collector-2");
		Collector<Apple> appleCollector1 = new Collector<Apple>("apple-collector-1");
		
		// attention ici le type d'objets ramasses est Legume :
		Collector<Vegetable> vegetableCollector = new Collector<Vegetable>("vegetable-collector");

		carrotCollector1.take(c3);
		System.out.println(carrotCollector1.description());
		// NE COMPILE PAS
		// carrotCollector2.take(p1);

		// NE COMPILE PAS
		// carrotCollector1.giveTo(appleCollector1);

		// COMPILE :
		carrotCollector1.giveTo(vegetableCollector);

		// NE COMPILE PAS
		// vegetableCollector.giveTo(carrotCollector1);
		// NE COMPILE PAS
		// appleCollector1.giveTo(vegetableCollector);

		carrotCollector1.take(c1);
		carrotCollector1.giveTo(carrotCollector2);
		System.out.println(carrotCollector1.description());
		System.out.println(carrotCollector2.description());
		carrotCollector1.take(c2);
		
		
		try {
			carrotCollector1.giveTo(carrotCollector2);
		} catch (AlreadyCarryingException e) {
			//System.out.println("*** exception : " + carrotCollector2 + " porte deja qque chose");
			System.out.println(" * " + e.getMessage());
		}

		appleCollector1.take(p2);
		System.out.println(appleCollector1.description());
		try {
			appleCollector1.take(p1);
		} catch (AlreadyCarryingException e) {
			//System.out.println("*** exception : " + appleCollector1 + " porte deja qque chose");
			System.out.println(" * " + e.getMessage());
		}
		appleCollector1.drop();
		System.out.println(appleCollector1.description());
		appleCollector1.take(p1);
	
     }
}
