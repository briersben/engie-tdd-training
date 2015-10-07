package com.electrabel.training.phonenumbers.v2;

import java.util.List;

public class PhoneNumbersV2 {

	public static boolean isConsistent(List<String> phoneList) {
		if (phoneList.isEmpty())
			return true;

		// iterate over the phoneList, and check each phone against the others in the list
		for (String phone : phoneList) {
			boolean startsWithPrefixOtherPhoneFromList = isStartsWithPrefixOtherPhoneFromList(phone, phoneList);
			if (startsWithPrefixOtherPhoneFromList)
				return false;
		}
		
		return true;
	}

	private static boolean isStartsWithPrefixOtherPhoneFromList(String phone, List<String> phoneList) {
		for (String phoneFromList : phoneList) {
			if (isStartsWithPrefixOtherPhone(phone, phoneFromList))
				return true;
		}
		return false;
	}

	private static boolean isStartsWithPrefixOtherPhone(String phone, String phoneFromList) {
		// exclude current phone
		if (!phoneFromList.equals(phone)) {
			String phoneWithoutWhitespaces = removeWhitespaces(phone);
			String prefix = getPrefix(phoneFromList);
			if (phoneWithoutWhitespaces.startsWith(prefix)) {
				System.out.println("phone '" + phone + "' starts with prefix '" + prefix + "' of phone '" + phoneFromList + "'");
				return true;
			}
		}

		return false;
	}
	
	
	private static String removeWhitespaces(String phone) {
		return phone.replaceAll("\\s","");
	}

	private static String getPrefix(String phone) {
		int indexFirstWhitespace = phone.indexOf(" ");
		if (indexFirstWhitespace == -1)
			return phone;
		else
			return phone.substring(0, indexFirstWhitespace);
	}
	
}
