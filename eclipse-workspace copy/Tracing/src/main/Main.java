package main;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Answer: " + mystery(4));
		System.out.println("Answer 1: " + mystery1(12345));
		int[][] tisk = new int[5][5];
		System.out.println("Answer 1: " + mystery2(tisk, 500000000));
		mystery3("BELLE");
		
	}
	public static int mystery1(int x) {
		if (x / 10 < 10) {
			return x;
		} else {
			return x % 10 + mystery1(x / 10);
		}
	}
	public static int mystery(int num) {
		if(num == 1) {
			return num;
		}else {
			return (num/2) * mystery(num-1);
		}
	}

	public static int mystery2(int[][] numbers, int val) {
		int idx = -1;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[i].length; j++) {
				if (numbers[i][j] > val) {
					idx = j;
				}
			}
		}
		return idx;
	}

	public static void mystery3(String str) {
		  if (str.length() < 4) {
		    System.out.println("D");
		  }
		  else {
			  System.out.print(str.substring(0, 1));
		    mystery3(str.substring(1));
		    System.out.print(str.substring(0, 1));
		}
	}

}
