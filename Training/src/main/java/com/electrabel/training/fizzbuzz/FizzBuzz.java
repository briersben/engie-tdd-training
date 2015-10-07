package com.electrabel.training.fizzbuzz;

public class FizzBuzz {

	public static final int THREE = 3;
	public static final int FIVE = 5;
	
	public static final String FIZZ = "fizz";
	public static final String BUZZ = "buzz";
	
	public static String getOutput(int number) {
		StringBuilder sb = new StringBuilder();
		if (isDivisableByThree(number))
			sb.append(FIZZ);
		if (isDivisableByFive(number))
			sb.append(BUZZ);

		return (sb.length() == 0 ? String.valueOf(number) : sb.toString());
	}
	
	private static boolean isDivisableByThree(int number) {
		return isDivisibleBy(number, THREE);
	}

	private static boolean isDivisableByFive(int number) {
		return isDivisibleBy(number, FIVE);
	}
	
	private static boolean isDivisableByThreeAndFive(int number) {
		return isDivisibleBy(number, THREE) && isDivisibleBy(number, FIVE);
	}
	
	private static boolean isDivisibleBy(int number, int otherNumber) {
		if (number % otherNumber == 0)
			return true;
		return false;
	}
}
