package com.electrabel.training.stringcalculator;

import org.junit.Assert;
import org.junit.Test;


public class StringCalculatorTest {
	
	@Test
	public void Should_Return_Zero_When_Empty_String() {
		StringCalculator calc = new StringCalculator();
		Assert.assertEquals(0, calc.add(""));
	}
	
	@Test
	public void Should_Return_Value_When_Single_Value() {
		StringCalculator calc = new StringCalculator();
		Assert.assertEquals(1, calc.add("1"));
	}

	@Test
	public void Should_Return_Sum_When_Multiple_Values() {
		StringCalculator calc = new StringCalculator();
		Assert.assertEquals(3, calc.add("1,2"));
	}

	@Test
	public void Should_Return_Sum_When_Multiple_Values_And_New_Line_Separator() {
		StringCalculator calc = new StringCalculator();
		Assert.assertEquals(6, calc.add("1,2\n3"));
	}

}
