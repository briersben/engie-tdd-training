package com.electrabel.training.phonenumbers.v3;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class PhoneList {
    private static final Logger LOG = Logger.getLogger(PhoneList.class);

	private static final boolean stopOnFirstMatch = false;

	private List<Phone> phoneList;
	
	public PhoneList() {
		phoneList = new ArrayList<Phone>();
	}
	
	public void add(Phone phone) {
		phoneList.add(phone);
	}
	
	public boolean isConsistent() {
		if (phoneList.isEmpty())
			return true;

		boolean result = true;
		
		// iterate over the phoneList, and check each phone against the others in the list
		for (Phone phone : phoneList) {
			if (isStartsWithPrefixOtherPhoneFromList(phone, phoneList))
				result = false;
			
			if (result == true && stopOnFirstMatch)
				break;
		}
		
		return result;
	}
	
	private static boolean isStartsWithPrefixOtherPhoneFromList(Phone phone, List<Phone> phoneList) {
		boolean result = false;
		
		// iterate over the phoneList, and check against the given phone
		for (Phone otherPhone : phoneList) {

			// exclude current phone
			if (otherPhone == phone)
				continue;

			if (phone.isStartsWithPrefix(otherPhone))
				result = true;
			
			if (result == true && stopOnFirstMatch)
				break;
		}
		
		return result;
	}

}
