package com.electrabel.training.phonenumbers.v5;

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
			if (isStartsWithOtherPhoneFromList(phone, phoneList))
				result = false;
			
			if (result == true && stopOnFirstMatch)
				break;
		}
		
		return result;
	}

	private static boolean isStartsWithOtherPhoneFromList(Phone phone, List<Phone> phoneList) {
		boolean result = false;
		
		// iterate over the phoneList, and check against the given phone
		for (Phone otherPhone : phoneList) {

			// exclude current phone
			if (otherPhone == phone)
				continue;

			if (phone.isStartsWith(otherPhone))
				result = true;
			
			if (result == true && stopOnFirstMatch)
				break;
		}
		
		return result;
	}

	
	/**
	 * TODO try to do this with recursivity.
	 * 
	 * 1 sort list phoneList.sort();
	 * 2 call recursive function phoneList.isConsistent();
	 * 3 check cases:
	 * - empty list = consistent
	 * - list contains 1 phone  > remove element > recursive call
	 * - list contains 2 phones > check prefix > remove element 
	 * - list contains more than 2 phones > recursive?
	 */
	private void recursive_isPrefixOf(Phone phone, Phone otherPhone) {
		recursive_isPrefixOf(phone, otherPhone);
	}
}