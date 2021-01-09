
/**
 * Write a description of class Switch here.
 *
 * @author SYLLEBRANQUE DESMAREST
 * @version février 2019
 */
public class Switch{
    private String name;
    
    private Lightbulb light;
    
    /**
     * "Turn off" (false) or "turn on" (true) the light
     * 
     * @param lightbulb initialized bulb
     */
    public Switch(Lightbulb lightbulb){
        this.light = lightbulb;
    }
    
    /**
     * change the state of the Lightbuld according to its current state
     * @param lightbulb 
     */
    
    public void push(){
        if(this.light.getState()){
            this.light.setState(false);
        } else {
            this.light.setState(true);
        }
            
    }    
}
