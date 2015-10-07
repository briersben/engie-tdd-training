package com.electrabel.training.leapyear;

import java.util.Calendar;

public class Year {
	private int year;

	public Year(int year) {
		this.year = year;
	}

	public boolean isLeapYear() {
		return isLeapYear(year);
	}

	public static boolean isLeapYear(int year) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
	}

	public static boolean isLeapYearReinvented(int year) {
		if (year % 4 != 0) {
			return false;
		} else if (year % 400 == 0) {
			return true;
		} else if (year % 100 == 0) {
			return false;
		} else {
			return true;
		}
	}
}
