package com.electrabel.training.phonenumbers.v5;

import java.util.ArrayList;
import java.util.Collections;
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
	
	/**
	 * --- First solution iterating over the complete collection
	 */
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
	 * --- Second solution using a recursive method.
	 */
	public boolean isConsistent_recursive() {
		// first, make a copy the original phone list
		List<Phone> copyOfPhoneList = new ArrayList<Phone>(this.phoneList);
		// next, sort the list lexicographically (alphabetically and shortest first)
		Collections.sort(copyOfPhoneList, new PhoneNumberComparator());
		// finally call the recursive method
		return isConsistent_recursive(new ArrayList<Phone>(copyOfPhoneList));
	}

	public boolean isConsistent_recursive(List<Phone> phoneList) {
		// case 1: an empty list is consistent
		// case 2: a list containing only 1 element is consistent
		if (phoneList.size() < 2)
			return true;
		
		// case 3: a list contains more than 1 element > compare
		Phone phone = phoneList.get(0);
		Phone otherPhone = phoneList.get(1);

		LOG.debug("check if otherPhone " + otherPhone + " starts with " + phone);
		if (otherPhone.isStartsWith(phone))
			return false;
		
		phoneList.remove(0);
		return isConsistent_recursive(phoneList);
	}
	
}
