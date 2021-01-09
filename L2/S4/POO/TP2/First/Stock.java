/**
 * Décrivez votre classe Stock ici.
 *
 * @author DESMAREST SYLLEBRANQUE
 * @version janvier 2019
 */
public class Stock{
    /**
     * quantity of this stock
     */
    private int quantity;

    /**
     * create Stock object with its quantity initialized to 0
     */
    public Stock() {
        this.quantity = 0;
    }

    /**
     * create Stock object with its quantity initialized to n
     *
     * @param n the quantity at which the stock will be initialized
     */
    public Stock(int n){
        this.quantity=n;
    }

    /**
     * return the quantity in a stock
     *
     * @return the quantity in a stock
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * increase the current stock of n elements
     *
     * @param n the number of elements to add
     */
    public void add(int n) {
        this.quantity = this.quantity + n;
    }

    /**
     * decrease the current stock of m elements
     *
     * @param m m elements of stock to remove
     */
    public int remove(int m){
        if (m > this.quantity) {
            m = this.quantity ;
        }
        this.quantity = this.quantity - m ;
        return m ;
    }
    }

    /**
     * provide a string representation for this Stock object
     */
    public String  toString(){
        String result = "The stock's quantity is";
        result = result + this.quantity;
        return result;
    }
}
