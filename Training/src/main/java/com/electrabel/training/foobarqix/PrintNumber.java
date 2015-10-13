package com.electrabel.training.foobarqix;

public class PrintNumber {

	public static final String FOO = "Foo";
	public static final String BAR = "Bar";
	public static final String QIX = "Qix";
	
	private int number;
	
	public PrintNumber(int number) {
		this.number = number;
	}

	public String print() {
		StringBuilder sb = new StringBuilder();
		if (isDivisableBy(3))
			sb.append(FOO);
		if (isDivisableBy(5))
			sb.append(BAR);
		if (isDivisableBy(7))
			sb.append(QIX);
		
		sb.append(getNumbersInString());
		
		if (sb.length() == 0)
			sb.append(String.valueOf(number));
		
		return sb.toString();
	}

	private boolean isDivisableBy(int divider) {
		return number % divider == 0;
	}

	private String getNumbersInString() {
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
