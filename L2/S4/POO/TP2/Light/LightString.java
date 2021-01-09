/**
 * Object representation of garlands
 *
 * @author DESMAREST SYLLEBRANQUE
 * @version février 2019
 */
public class LightString {

    private int nbBulbs;
    private Lightbulb cont[] = new Lightbulb[nbBulbs];
    private boolean state;

    
    /** creates a new lightbulb that is off, the color is white and the consumption of a single bulb is 1W
     * 
     * @param nbBulb the number of lightbulbs composing the lightstring
     * 
     * @return a new lightstring
     */
    public LightString(int nbBulb) {
        this.cont = new Lightbulb[nbBulbs];
        for (int i = 0; i < this.cont.length; i++) {
            this.cont[i] = new Lightbulb(false, 1, "white");
        }
        this.state = false;
    }


    /** returns a lightbulb at a position in parameters
     * 
     * @param i the index of the bulb to be changed
     * 
     * @return the lightbulb at the index i
     */
    public Lightbulb getLightBulb(int i) {
        if (i > 0 && i <= this.cont.length) {
            return this.cont[i - 1];
        } else {
            return null;
        }
    }

    /** gets the power consumption of the whole lightstring
     * 
     * @return pow the power consumption of the lightstring
     */
    public int getConsumedPower() {
        int pow = 0;
        for (int i = 0; i < this.cont.length; i++) {
            pow += this.cont[i].getPower();
        }
        return pow;
    }


    /** replace the n-th lightbulb of the light string by the given lightbulb.
     * Nothing happens if i is not a valid index.
     * 
     * @param n the number of the lightbulb to be changed (first has number 1)
     * 
     * @param theBulb the new lightbulb
     */
    public void changeLightBulb(int i, Lightbulb bulb) {
        if (i > 0 & i <= this.cont.length) {
            this.cont[i - 1] = bulb;
        }
    }

    
}
