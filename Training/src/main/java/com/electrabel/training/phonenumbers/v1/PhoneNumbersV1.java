package com.electrabel.training.phonenumbers.v1;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumbersV1 {

	public static boolean isConsistent(List<String> phoneList) {
		phoneList = removeWhitespaces(phoneList);
		
		if (phoneList.isEmpty())
			return true;

		// iterate over the phoneList, and check each phone against the others in the list
		for (String phone : phoneList) {
			boolean duplicatePrefixUsed = isDuplicatePrefixUsed(phoneList, phone);
			if (duplicatePrefixUsed)
				return false;
		}
		
		return true;
	}

//	private static boolean isDuplicatePrefixUsed(List<String> phoneList, String phone) {
//		int startIndex = 0;
//		int endIndex = startIndex + 3;
//		String prefix = phone.substring(startIndex, endIndex);
//		return isDuplicatePrefixUsed(phoneList, phone, prefix);
//	}

	private static boolean isDuplicatePrefixUsed(List<String> phoneList, String phone) {
		int beginIndex = 0;
		for (int endIndex = beginIndex+1; endIndex < phone.length(); endIndex++) {
			String prefix = phone.substring(beginIndex, endIndex);
			if (isDuplicatePrefixUsed(phoneList, phone, prefix))
				return true;
		}
		return false;
	}

	private static boolean isDuplicatePrefixUsed(List<String> phoneList, String phone, String prefix) {
		System.out.println("phone = " + phone + " (check prefix='" + prefix + "')");
		System.out.println("iterate over phoneList");
		for (String phoneFromList : phoneList) {
			// exclude current phone
			if (phoneFromList.equals(phone))
				continue;
			System.out.println("- phoneFromList = " + phoneFromList);
			if (phoneFromList.startsWith(prefix)) {
				System.out.println("duplicate prefix '" + prefix + "' found in phone " + phoneFromList);
				return true;
			}
		}
		return false;
	}

	private static List<String> removeWhitespaces(List<String> phoneList) {
		List<String> phoneListWithoutSpaces = new ArrayList<String>();
		for (String phone : phoneList) {
			phoneListWithoutSpaces.add(removeWhitespaces(phone));
		}
		return phoneListWithoutSpaces;
	}
	
	private static String removeWhitespaces(String phone) {
		return phone.replaceAll("\\s","");
	}

	
	
	
	// --- NEW SOLUTION
	private String getPrefix(String phone) {
		int indexFirstWhitespace = phone.indexOf(" ");
		if (indexFirstWhitespace == -1)
			return phone;
		else
			return phone.substring(0, indexFirstWhitespace);
	}
	
}
