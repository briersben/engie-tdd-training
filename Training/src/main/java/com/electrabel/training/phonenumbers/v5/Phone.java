package com.electrabel.training.phonenumbers.v5;

import org.apache.log4j.Logger;

import com.electrabel.training.util.Utils;

public class Phone {
    private static final Logger LOG = Logger.getLogger(Phone.class);

	private String name;
	private String phoneNumber;
	
	public Phone(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Phone(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumberWithoutWhitespaces() {
		return Utils.removeWhitespaces(phoneNumber);
	}

	public boolean isStartsWith(Phone otherPhone) {
		if (getPhoneNumberWithoutWhitespaces().startsWith(otherPhone.getPhoneNumberWithoutWhitespaces())) {
			System.out.println("> " + this.toString() + " starts with " + otherPhone.toString());
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Phone [name=" + name + ", phone=" + phoneNumber + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phone other = (Phone) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}

}
