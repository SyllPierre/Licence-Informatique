/**
 * Modeling of goods.
 *
 * @author DESMAREST SYLLEBRANQUE
 * @version février 2019
 */
public class Goods {
    private double value;

    private String name;

    /**
     * modeling of goods thanks to its name and its price excluding tax
     * is initialized to 0
     *
     * @param nameToSet name of the goods to be modeled
     */
    public Goods(String nameToSet) {
        this.name = nameToSet;
        this.value = 0;
    }


    /**
     * modeling of goods thanks to its name and its price excluding tax
     *
     * @param nameToSet name of the goods to be modeled
     * @param valueToSet price excluding tax of the goods
     */
    public Goods(String nameToSet, double valueToSet) {
        this.name = nameToSet;
        this.value = valueToSet;
    }


    /**
     * returns the name of the goods
     *
     * @return the name of the goods
     */
    public String getName() {
        return this.name;
    }


    /**
     * returns the price excluding tax of the goods
     *
     * @return the price excluding tax of the goods
     */
    public double getValue() {
        return this.value;
    }


    /**
     * change the price excluding tax of the goods
     *
     * @param val price excluding tax to set to the goods
     */
    public void setValue(double val) {
        this.value = val;
    }


    /**
     * returns a sentence indicating the name and the price excluding
     * tax of the goods
     *
     * @return a sentence indicating the name and the price excluding
     * tax of the goods
     */
    public String toString() {
        return "the good " + this.name + " costs " + this.value;
    }


    /**
     * returns the price including TVA to the goods
     *
     * @return the price including TVA to the goods
     */
    public double getTTC() {
        double ttc = 0.196;
        return this.value * (1 + ttc);
    }
}
