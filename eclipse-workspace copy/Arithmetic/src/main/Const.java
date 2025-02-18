package main;

public class Const extends Node {
	/** the constant value 
	 * This class will pick a random number between 1-20 for the program
	 */
    private double value;
    /**
     * @param d the value to set the constant to.
     */
    public Const(double d) {
        value = d;
    }
    /**
     * @return the value of the constant.
     */
    public double eval() {
        return value;
    }
    public String toString() {
    	return "" + value;
    }
}
