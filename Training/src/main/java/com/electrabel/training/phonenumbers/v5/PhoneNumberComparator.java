package com.electrabel.training.phonenumbers.v5;

import java.util.Comparator;

public class PhoneNumberComparator implements Comparator<Phone> {

	@Override
	public int compare(Phone o1, Phone o2) {
		return o1.getPhoneNumberWithoutWhitespaces().compareTo(o2.getPhoneNumberWithoutWhitespaces());
	}

}
