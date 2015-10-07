package com.electrabel.training.stringcalculator;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;


public class StringCalculator {

	private static final String COMMA_SEPARATOR = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	
	// delimiters separated by | char
	private static final String DELIMITERS_REGEXP = ",|\n";

	public int add(String numbers) {
		String[] numberArray = toNumberArray(numbers);
		int sum = addNumbers(numberArray);
		System.out.println("Add '" + numbers + "' = " + sum);
		return sum;
	}

	private String[] toNumberArray(String numbers) {
		return numbers.split(DELIMITERS_REGEXP);
	}

	private int addNumbers(String[] listNumbers) {
		int add = 0;
		for (int i = 0 ; i < listNumbers.length ; i++) {
			String currentValue = listNumbers[i];
			if(StringUtils.isNotEmpty(currentValue)){
				add += Integer.parseInt(currentValue);
			}
		}
		return add;
	}

	
	
	// -- where we left off during training sessin
	
//	public int add_JONATHAN(String numbers) {
//		System.out.println("Add: " + numbers);
//		int add = 0;
//		String[] numberArray = numbers.split(",");
//		for(int i = 0 ; i < numberArray.length ; i++) {
//			String currentValue = numberArray[i];
////			System.out.println(listNumbers[i]);
//			if(StringUtils.isNotEmpty(currentValue)){
//				add += Integer.parseInt(currentValue);
//			}
//		}
//		System.out.println("Result: " + add);
//		return add;
//	}

	// --- alternative creating delimiter regexp based on list of delimiters
	
//	private String[] toNumberArray(String numbers, String... delimiters) {
//		String delimiterExpr = evaluateDelimiterExpression(delimiters);
//		
//		return numbers.split(delimiterExpr.toString());
//	}
//
//	private String evaluateDelimiterExpression(String... delimiters) {
//		StringBuilder delimiterExpr = new StringBuilder();
//		for (String delimiter : delimiters) {
//			if (delimiterExpr.length() > 0)
//				delimiterExpr.append("|");
//			delimiterExpr.append(delimiter);
//		}
//		return delimiterExpr.toString();
//	}
	

	// --- own implementation using index
	
//	private void getNextNumber(String numbers, int currentIndex) {
//		
//		int nextCommaIndex = numbers.indexOf(COMMA_SEPARATOR, currentIndex);
//		int nextNewLineIndex = numbers.indexOf(NEW_LINE_SEPARATOR, currentIndex);
//		
//		
//		
//		if (numbers.indexOf(COMMA_SEPARATOR, currentIndex) > 0) {
//			numbers.sub
//		}
//			
//	}

	
	// --- using StringTokenizer
	
//	public String[] toNumberArray_usingStringTokenizer(String numbers) {
//		List<String> numberList = new ArrayList<String>();
//		String delimiters = ",\n";
//		StringTokenizer tokenizer = new StringTokenizer(numbers, delimiters);
//		while (tokenizer.hasMoreTokens()) {
//			String token = tokenizer.nextToken();
//			numberList.add(token);
//		}
//		return numberList.toArray(new String [0]);
//	}
	
}
