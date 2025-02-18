package main;

import java.util.ArrayList;

public class DataSetTester {
    public static void main(String[] args) {
        String fileName = "/Users/maxwellmendenhall/eclipse-workspace/HW9/src/main/simpleTest.csv";
        DataSet ds = new DataSet(fileName);
        boolean matchesSoFar = true;
        if (1 != ds.getNumIndependentVariables()) {
            matchesSoFar = false;
            System.out.println("num independent variables doesn't match: " +
                    1 + " != " + ds.getNumIndependentVariables());
        }
        ArrayList<DataRow> rows = ds.getRows();
        if (rows != null) {
            if (rows.size() != 31) {
                matchesSoFar = false;
                System.out.println("number of rows don't match array size: " +
                        31 + " != " + rows.size());

            }
            DataRow eight = rows.get(7);
            double y = eight.getDependentVariable();
            if (y != 0.91) {
                matchesSoFar = false; 
                System.out.println("eighth row dependent variable should be: " + 0.91 +
                " but it is " + y);
            }
            double[] x = eight.getIndependentVariables();
            if(x != null) {
                if (x[0] != 0.7) {
                    matchesSoFar = false; 
                    System.out.println("eighth row independent variable should be: " + 0.7 +
                    " but it is " + x[0]);
                }
            } else {
                matchesSoFar = false; 
                System.out.println("independent variables variable is null");
            }
        } else {
            matchesSoFar = false; 
            System.out.println("data rows returned is null");
        }
        if (matchesSoFar) {
            System.out.println("Data Set Test 1: Passes");
        } else {
            System.out.println("Data Set Test 1: Fails, see above for what went wrong");
        }
    }
}
