package main;

import java.util.ArrayList;

public class DataSetTester2 {
    public static void main(String[] args) {
        String fileName = "/Users/maxwellmendenhall/eclipse-workspace/HW9/src/main/winequality-red.csv";
        DataSet ds = new DataSet(fileName);
        boolean matchesSoFar = true;
        if (11 != ds.getNumIndependentVariables()) {
            matchesSoFar = false;
            System.out.println("num independent variables doesn't match: " +
                    11 + " != " + ds.getNumIndependentVariables());
        }
        ArrayList<DataRow> rows = ds.getRows();
        if (rows != null) {
            if (rows.size() != 1599) {
                matchesSoFar = false;
                System.out.println("number of rows don't match array size: " +
                        1599 + " != " + rows.size());

            }
            DataRow eight = rows.get(7);
            double y = eight.getDependentVariable();
            if (y != 7.0) {
                matchesSoFar = false; 
                System.out.println("eighth row dependent variable should be: " + 7.0 +
                " but it is " + y);
            }
            double[] x = eight.getIndependentVariables();
            if(x != null) {
                if (x[0] != 7.3) {
                    matchesSoFar = false; 
                    System.out.println("eighth row first independent variable should be: " + 7.3 +
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
            System.out.println("Data Set Test 2: Passes");
        } else {
            System.out.println("Data Set Test 2: Fails, see above for what went wrong");
        }
    }
}
