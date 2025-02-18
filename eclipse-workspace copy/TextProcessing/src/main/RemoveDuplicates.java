package main;

import java.util.Scanner;

/*
 * Remove duplicate letters in a string.
 * Givin a string S of lowercase letters, a duplicate removal 
 * consists of choosing two adjacent and equal letters, and removing them.
 * We repeatedly make duplicate removals on S until we no longer can.
 * Return the final string after all such duplicate removals have been made.
 * Example 1
 * input: "2"
 * output: "zx"
 * Exaplanation: In "xyyxzx", the first round removeal is "yy".
 * After "yy" has been removed, the string is "xxzx". Then, in the next round,
 * "xx" will be removed. "zx" is the final result.
 * Please name your java file as RemoveDuplicates.java
 */

public class RemoveDuplicates {
  
  public static void main(String[] args) {
	  Scanner s = new Scanner(System.in);
		System.out.print("Enter Duplicate String: ");
	  	String duplicates = s.next();
	  	System.out.println(duplicates(duplicates));
  }

  private static String duplicates(String s) {
	  
	  char[] stack = new char[s.length()];
	  int i = 0;
	  
	  for(int j = 0; j < s.length(); j++) {
		  char curr = s.charAt(j);
		  
		  if(i >0 && stack[i - 1] == curr) {
			  i--;
		  }else {
			  stack[i] = curr;
			  i += 1;
		  }
	  }
	  return new String(stack, 0, i);
	  /*
	  StringBuilder sb = new StringBuilder();
	  for(int i = 0; i < s.length(); i++) {
		  char c = s.charAt(i);
		  int idx = s.indexOf(c, i+1);
		  if(idx == -1) {
			  sb.append(c);
		  }
	  }
	  return sb;
	  */
	  
	 
  }
  
}