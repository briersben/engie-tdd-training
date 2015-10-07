package com.electrabel.training.leapyear;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Use a Factory to instantiate objects
 * Do not duplicate common code
 * Single responsibility
 * open/closed principle open for extension closed for modification
 * Decoupling
 * 
 *
 */
public class LeapYearTest {
	
	@Before
	public void init() {
	}
	
	@After
	public void cleanup() {
	}
	
	@Test
	public void shouldReturnTrueWhenYearIsNormalLeapYear() {
		Year year = new Year(1996);
		
		boolean expected = true;
		boolean actual = year.isLeapYear();
		
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnFalseWhenYearIsNormalYear() {
	}

	@Test
	public void shouldReturnFalseWhenYearIsAtypicalCommon() {
	}

	@Test
	public void shouldReturnTrueWhenYearIsNonCommonLeapYear() {
	}


	private boolean isLeapYear(Year year) {
		return year.isLeapYear();
	}
	
}
