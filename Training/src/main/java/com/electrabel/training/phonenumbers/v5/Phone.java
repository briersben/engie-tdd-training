package com.electrabel.training.phonenumbers.v5;

import org.apache.log4j.Logger;

public class Phone {
    private static final Logger LOG = Logger.getLogger(Phone.class);

	private String name;
	private String phone;
	
	public Phone(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getPrefix() {
		int indexFirstWhitespace = phone.indexOf(" ");
		if (indexFirstWhitespace != -1)
			return phone.substring(0, indexFirstWhitespace);
		return phone;
	}

	public boolean isStartsWith(Phone otherPhone) {
		String phoneWithoutWhitespaces = removeWhitespaces(getPhone());
		String otherPhoneWithoutWhitespaces = removeWhitespaces(otherPhone.getPhone());
		if (phoneWithoutWhitespaces.startsWith(otherPhoneWithoutWhitespaces)) {
			System.out.println(this.toString() + " starts with prefix " + otherPhone.toString());
			return true;
		}
		
		return false;
	}
	
	private static String removeWhitespaces(String phone) {
		return phone.replaceAll("\\s","");
	}

	@Override
	public String toString() {
		return "Phone [name=" + name + ", phone=" + phone + "]";
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
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}

}
