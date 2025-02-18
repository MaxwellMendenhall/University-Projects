package main;

import java.util.Scanner;

public class UserInput {
	
	public static void main(String[] args) throws Exception {	
		
		//Scanner s = new Scanner(System.in);
		//System.out.print("Enter forever loop");
		//String fileName = s.nextLine();
		
		Incrementing x = new Incrementing();
		
		int r = x.Increment();
		
		System.out.println(r);
		
		int t = x.Increment();
		
		System.out.println(t);
		
		/*
		while(true) {
			if (fileName.equals("stop")) {
				System.out.println("Stopping");
				break;
			}
		*/	
			
			
		
		
	}

}
