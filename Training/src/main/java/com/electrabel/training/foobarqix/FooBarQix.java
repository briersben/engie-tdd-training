package com.electrabel.training.foobarqix;

public class FooBarQix {

	public static final String FOO = "Foo";
	public static final String BAR = "Bar";
	public static final String QIX = "Qix";
	
	public String getOutput(Integer number) {
		StringBuilder sb = new StringBuilder();

		sb.append(getDivisableByInfo(number));
		sb.append(getNumbersInString(number));
		
		if (sb.length() == 0)
			sb.append(String.valueOf(number));
		
		return sb.toString();
	}

	private String getDivisableByInfo(Integer number) {
		StringBuilder sb = new StringBuilder();
		if (isDivisableBy(number, 3))
			sb.append(FOO);
		if (isDivisableBy(number, 5))
			sb.append(BAR);
		if (isDivisableBy(number, 7))
			sb.append(QIX);
		return sb.toString();
	}
	
	private boolean isDivisableBy(Integer number, int divider) {
		return number % divider == 0;
	}

	private String getNumbersInString(Integer number) {
		StringBuilder sb = new StringBuilder();
		for (char charInNumber : String.valueOf(number).toCharArray()) {
			if (charInNumber == '3')
				sb.append(FOO);
			if (charInNumber == '5')
				sb.append(BAR);
			if (charInNumber == '7')
				sb.append(QIX);
		}
		return sb.toString();
	}

}
