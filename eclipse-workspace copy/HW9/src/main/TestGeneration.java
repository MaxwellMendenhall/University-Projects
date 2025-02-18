package main;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class TestGeneration {
	static int numIndepVars = 0;
	static int maxDepth = 4;
	static String direct = "/Users/maxwellmendenhall/eclipse-workspace/HW9/src/main/";

	static Random rand = new Random();

	public static void main(String[] args) throws IOException {
//Get the file name from the user
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the name of the file you want to open:");
//MUST ENTER THE FULL ADDRESS OF THE FILE
		String fileName = direct + input.nextLine();
//Create the DataSet object
		DataSet dSet = new DataSet(fileName);
//The number of independent variables depends on how many x values there are in the data set
		numIndepVars = dSet.getNumIndependentVariables();

//Create generic factories
		Node[] ops = { new Plus(), new Minus(), new Mult(), new Divide() };
		OperatorFactory o = new OperatorFactory(ops);
		TerminalFactory t = new TerminalFactory(numIndepVars);

//Create a generation of 500 GPTrees
		Generation gen = new Generation(500, o, t, maxDepth, rand);
//Evaluate the generation
		gen.evalAll(dSet);
//Print out the best tree and its fitness
		gen.printBestTree();
	}

}
