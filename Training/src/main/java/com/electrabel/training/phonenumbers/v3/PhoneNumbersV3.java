package com.electrabel.training.phonenumbers.v3;

import java.util.List;

public class PhoneNumbersV3 {

	public static boolean isConsistent(List<Phone> phoneList) {
		if (phoneList.isEmpty())
			return true;

		// iterate over the phoneList, and check each phone against the others in the list
		for (Phone phone : phoneList) {
			if (isStartsWithPrefixOtherPhoneFromList(phone, phoneList))
				return false;
		}
		
		return true;
	}

	private static boolean isStartsWithPrefixOtherPhoneFromList(Phone phone, List<Phone> phoneList) {
		for (Phone phoneFromList : phoneList) {
			if (phone.isStartsWithPrefix(phoneFromList))
				return true;
		}
		return false;
	}
	
}
