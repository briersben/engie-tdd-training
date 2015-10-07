package com.electrabel.training.fizzbuzz;

import org.junit.Assert;
import org.junit.Test;

public class FizzBuzzTest {

	@Test
	public void should_return_fizz_when_number_divisible_by_three() {
		assertExpectedValue(FizzBuzz.FIZZ, 3);
	}

	@Test
	public void should_return_buzz_when_number_divisible_by_five() {
		assertExpectedValue(FizzBuzz.BUZZ, 5);
	}

	@Test
	public void should_return_fizz_buzz_when_number_divisible_by_three_and_five() {
		assertExpectedValue(FizzBuzz.FIZZ + FizzBuzz.BUZZ, 15);
	}

	@Test
	public void should_return_number_when_number_not_divisible_by_three_or_five() {
		assertExpectedValue("4", 4);
	}

	private void assertExpectedValue(String expected, int number) {
		Assert.assertEquals(expected, FizzBuzz.getOutput(number));
	}
	
	@Test
	public void test_range_of_numbers() {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<100; i++) {
			sb.append(FizzBuzz.getOutput(i));
			sb.append(", ");
		}
		System.out.println(sb.toString());
	}
}
