package com.electrabel.training.phonenumbers.v1;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.electrabel.training.phonenumbers.v2.PhoneNumbersV2;

/**
 * https://github.com/emilybache/phone-numbers-kata
 * https://cucumber.io/  (BDD)
 * http://infinitest.github.io/
 */
public class PhoneNumbersV1Test {
	// Bob       91 12 54 26
	// Alice     97 625 992
	// Emergency 911
	static final List<String> EMPTY_LIST;
	static final List<String> INCONSISTENT_LIST;
	static final List<String> CONSISTENT_LIST;
	
	static {
		EMPTY_LIST = new ArrayList<String>();
		
		CONSISTENT_LIST = new ArrayList<String>();
		CONSISTENT_LIST.add("91 12 54 26");
		CONSISTENT_LIST.add("97 625 992");
		
		INCONSISTENT_LIST = new ArrayList<String>();
		INCONSISTENT_LIST.add("91 12 54 26");
		INCONSISTENT_LIST.add("97 625 992");
		INCONSISTENT_LIST.add("911");
	}
	
	@Test
	public void empty_list_is_consistent_list() {
		Assert.assertTrue(PhoneNumbersV2.isConsistent(EMPTY_LIST));
	}

	@Test
	public void consistent_list_contains_no_duplicate_prefixes() {
		Assert.assertTrue(PhoneNumbersV2.isConsistent(CONSISTENT_LIST));
	}

	@Test
	public void inconsistent_list_contains_duplicate_prefixes() {
		Assert.assertFalse(PhoneNumbersV2.isConsistent(INCONSISTENT_LIST));
	}

}
