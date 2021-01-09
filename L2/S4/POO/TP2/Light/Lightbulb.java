
/**
 * Write a description of class Lightbulb here.
 *
 * @author DESMAREST SYLLEBRANQUE
 * @version février 2019
 */
public class Lightbulb
{
    private boolean state;
    private int power;
    private String color;
    
    /**
     * Creation of object bulb with for initialization a power of 100 Watt 
     * extinguished and of white color
     */
    public Lightbulb(){
        this.state = false;
        this.power = 100;
        this.color = "white";
    }
    
    /**
     * creation of the initialized bulb object with the 
     * entered parameters
     * 
     * @param state the state of the bulb
     * @param power the power of the bulb
     * @param color the color of the bulb
     */
    public Lightbulb(boolean state, int power, String color){
        this.state = state;
        this.power = power;
        this.color = color;
    }
    
    /**
     * returns the power of the bulb
     * 
     * @returns the power of the bulb
     */
    public int getPower(){
        return this.power;
    }
    
    /**
     * returns the color of the bulb
     * 
     * @return the color of the bulb
     */
    public String getColor(){
        return this.color;
    }
    
    /**
     * returns the state of the bulb
     * 
     * @return the state of the bulb
     */
    public boolean getState(){
        return this.state;   
    }
    
    /**
     * change the state of the bulb
     * 
     * @param stateToSet the state to change
     */
    public void setState(boolean stateToSet){
           this.state = stateToSet;    
    }
    
    /**
     * returns a sentence describing the buld
     *
     * @return a sentence describing the buld
     */

    public String toString(){
        String e = "éteinte";
        if (this.state) {
            e = "allumée";
        }
        return "l'ampoule " + e + " elle consomme " + this.power 
            + " watt et est de couleur " + this.color;

    }
}
