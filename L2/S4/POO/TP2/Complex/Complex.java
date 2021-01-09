/**
 * Representation of complex numbers
 *
 * @author DESMAREST SYLLEBRANQUE
 * @version 1.0
 */
public class Complex {
    private double re;
    private double im;
    
    /**
     * creat Complex object 
     * 
     * @param re the real part of the complex number
     * @param im the imaginary part of the complex number
     */
    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    
    /**
     * returns the real part of the complex number
     * 
     * @return the real part of the complex number
     */
    public double getRe(){
        return this.re;
    }

    
    /**
     * returns the imaninary part of the complex number
     * 
     * @return the imaninary part of the complex number
     */
    public double getIm() {
        return this.im;
    }

    
    /**
     * returns the modulus of the complex number
     * 
     * @return the modulus of the complex number
     */
    public double modulus() {
        return Math.sqrt(this.re * this.re + this.im * this.im);
    }

    
    /**
     * returns the conjugate of the complex number
     * 
     * @return the conjugate of the complex number
     */
    public Complex conjugate() {
        return new Complex(this.re, -this.im);
    }

    
    /**
     * returns the sum of the complex number and the other complex number c
     * 
     * @param c the complex number to add to the complex number
     * 
     * @return the sum of the complex number and the other complex number c
     */
    public Complex add(Complex c) {
        return new Complex(this.re + c.getRe(), this.im + c.getIm());
    }

    
    /**
     * returns the multiplication of the complex number with complex c
     * 
     * @param the complex number to multiply to the complex number
     * 
     * @return the multiplication of the complex number with complex c
     */
    public Complex mult(Complex c) {
        return new Complex(this.re * c.getRe() - this.im * c.getIm(), this.re * c.getIm() + this.im * c.getRe());
    }

    
    /**
     * returns the complex display
     * 
     * @return the complex display
     */
    public String toString() {
        return this.re + " + i" + this.im;
    }

    /**
     * returns a Boolean value that indicates whether the complex is 
     * equal to the O complex or not
     *
     * @param O the complex we are comparing
     * 
     * @return a Boolean value that indicates whether the complex is 
     * equal to the O complex or not
     */
    public boolean equals(Object O) {
        if (O instanceof Complex) {
            Complex theOther = (Complex) O;
            return (this.re == theOther.getRe() 
            && this.im == theOther.getIm());
        }
        else {
            return false;
        }
    }
}
