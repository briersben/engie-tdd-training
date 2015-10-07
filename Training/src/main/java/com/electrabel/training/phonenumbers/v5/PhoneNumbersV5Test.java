package com.electrabel.training.phonenumbers.v5;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

/**
 * 03 Kata Phone Numbers
 * Given a list of phone numbers, determine if it is consistent. In a consistent phone list no number is a prefix of another. For example:
 * Bob: 91 12 54 26
 * Alice: 97 625 992
 * Emergency: 911
 * 
 * In this case, it is not possible to call Bob because the phone exchange would direct your call to the emergency line as soon as you as dialed the first three digits of Bob’s phone number.
 * 
 * Note there are some sample phonebook datasets available on github (https://github.com/emilybache/phone-numbers-kata)
 * 
 * https://cucumber.io/  (BDD)
 * http://infinitest.github.io/
 * 
 * Action points:
 * Only do safe refactorings (using the integrated IDE refactoring options)
 * Learn to use the IDE shortcuts (try to only use keyboard)
 * Refactoring tips: Martin Fowler
 */
public class PhoneNumbersV5Test {
	static final Phone BOB = new Phone("Bob", "91 12 54 26");
	static final Phone ALICE = new Phone("Alice", "97 625 992");
	static final Phone EMERGENCY = new Phone("Emergency", "911");
	static final Phone JACK = new Phone("Jack", "91 12 12 34");
	
	@Test
	public void empty_list_is_consistent_list() {
		PhoneList phoneList = new PhoneList();
		Assert.assertTrue(phoneList.isConsistent_recursive());
	}

	@Test
	public void consistent_list_contains_no_duplicate_prefixes() {
		PhoneList phoneList = new PhoneList();
		phoneList.add(BOB);
		phoneList.add(ALICE);
		Assert.assertTrue(phoneList.isConsistent_recursive());
	}

	@Test
	public void inconsistent_list_contains_duplicate_prefixes() {
		PhoneList phoneList = new PhoneList();
		phoneList.add(BOB);
		phoneList.add(ALICE);
		phoneList.add(EMERGENCY);
		Assert.assertFalse(phoneList.isConsistent_recursive());
	}

	@Test
	public void inconsistent_list() {
		PhoneList phoneList = new PhoneList();
		phoneList.add(new Phone("111"));
		phoneList.add(new Phone("222"));
		phoneList.add(new Phone("222 222"));
		Assert.assertFalse(phoneList.isConsistent_recursive());
	}

	//@Test
	public void test_load_phone_numbers() throws IOException {
		PhoneList phoneList = PhoneNumbersV5.loadPhoneNumbers();
		Assert.assertTrue(phoneList.isConsistent_recursive());
	}
}
