package main;

/**
 * Author:
 * Date:
 * Purpose:
 */

/**
 * Author:
 * Date:
 * Purpose:
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSet {

    // add fields here
    @SuppressWarnings("unused")
	private String filename;
    private String[] split;
    ArrayList<DataRow> data = new ArrayList<DataRow>();
    /**
     * @param filename the name of the file to read the data set from
     */
    public DataSet(String filename)
    {
         // initialize fields here
         this.filename = filename;
         File fn = new File(filename);

         //scans each row in the file and makes cols to how many variables there are
         try {
        	 
 			Scanner s = new Scanner(fn);
 			
 			//reads and skips the first line
 			s.nextLine();
 			
 			//goes through the file untile there is no more lines
            while(s.hasNext()){
            	
                 String stringData = s.next();
                 split = stringData.split(",");

                 //System.out.println();
                 
                 /*
                  * y variable to be passed into DataRow()
                  * converts first index split[0] to a double variable
                  */
                 double y = Double.parseDouble(split[0]);
                 
                 /*
                  * xVals to be passed into DataRow()
                  * takes split[] and converts it into double[] with first index[0]
                  * not being copied over 
                  */
                 int skipFirstIndex = 1;
                 double[] xVals = new double[split.length];
                 for (int i = 0; i < xVals.length; i++) {
                     xVals[i] = Double.parseDouble(split[skipFirstIndex]);
                 }
                 skipFirstIndex++;
                 
                 /*
                  * adds y, xVals to DataRow() 
                  * then adds it to ArrayList<DataRow>
                  */
                 DataRow getRows = new DataRow(y, xVals);
                 data.add(getRows);
             }
            s.close();
         } catch (FileNotFoundException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
    }

    /**
     * @return the list of rows
     */
    public ArrayList<DataRow> getRows() {
        // FIXME: return the right thing here;
    	return data;
    }

    /**
     * @return the number of independent variables in each row of the data set
     */
    public int getNumIndependentVariables() {
        // FIXME: return the right thing here
        return split.length-1;
    }
}