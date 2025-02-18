package main;

/**
 * Author:
 * Date:
 * Purpose:
 */


public class DataRow {

    // add fields here
    double y;
    double[] x;

    /**
     * @param y the dependent variable
     * @param x the array of independent variables
     */
    public DataRow(double y, double[] x)
    {
        // initialize fields here
        this.x = x;
        this.y = y;
    }

    /**
     * @return the dependent variable
     */
    public double getDependentVariable() {
        // FIXME: return the right thing here
        return y;
    }

    /**
     * @return the array of independent variables
     */
    public double[] getIndependentVariables() {
        // FIXME: return the right thing here
        return x;
    }
}
