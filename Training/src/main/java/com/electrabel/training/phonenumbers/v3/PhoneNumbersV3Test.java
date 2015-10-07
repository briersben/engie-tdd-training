package com.electrabel.training.phonenumbers.v3;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://github.com/emilybache/phone-numbers-kata
 * https://cucumber.io/  (BDD)
 * http://infinitest.github.io/
 * 
 * Action points:
 * Only do safe refactorings (using the integrated IDE refactoring options)
 * Learn to use the IDE shortcuts (try to only use keyboard)
 * Refactoring tips: Martin Fowler
 */
public class PhoneNumbersV3Test {
	static final List<Phone> EMPTY_LIST;
	static final List<Phone> CONSISTENT_LIST;
	static final List<Phone> INCONSISTENT_LIST;
	static final List<Phone> INCONSISTENT_LIST_REVERSE;
	
	static {
		EMPTY_LIST = new ArrayList<Phone>();
		
		CONSISTENT_LIST = new ArrayList<Phone>();
		CONSISTENT_LIST.add(new Phone("Bob", "91 12 54 26"));
		CONSISTENT_LIST.add(new Phone("Alice", "97 625 992"));
		
		INCONSISTENT_LIST = new ArrayList<Phone>();
		INCONSISTENT_LIST.add(new Phone("Bob", "91 12 54 26"));
		INCONSISTENT_LIST.add(new Phone("Alice", "97 625 992"));
		INCONSISTENT_LIST.add(new Phone("Emergency", "911"));

		INCONSISTENT_LIST_REVERSE = new ArrayList<Phone>();
		INCONSISTENT_LIST_REVERSE.add(new Phone("Emergency", "911"));
		INCONSISTENT_LIST_REVERSE.add(new Phone("Alice", "97 625 992"));
		INCONSISTENT_LIST_REVERSE.add(new Phone("Bob", "91 12 54 26"));
	}
	
	@Test
	public void empty_list_is_consistent_list() {
		Assert.assertTrue(PhoneNumbersV3.isConsistent(EMPTY_LIST));
	}

	@Test
	public void consistent_list_contains_no_duplicate_prefixes() {
		Assert.assertTrue(PhoneNumbersV3.isConsistent(CONSISTENT_LIST));
	}

	@Test
	public void inconsistent_list_contains_duplicate_prefixes() {
		Assert.assertFalse(PhoneNumbersV3.isConsistent(INCONSISTENT_LIST));
	}

	@Test
	public void inconsistent_list_contains_duplicate_prefixes_reverse() {
		Assert.assertFalse(PhoneNumbersV3.isConsistent(INCONSISTENT_LIST_REVERSE));
	}

}
