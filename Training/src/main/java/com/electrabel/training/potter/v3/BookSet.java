package com.electrabel.training.potter.v3;

import java.util.ArrayList;
import java.util.List;

public class BookSet {
	private List<String> books = new ArrayList<String>();
	
	private static final int UNIT_PRICE = 8;
	
	public void add(String book) {
		books.add(book);
	}
	
	public boolean contains(String book) {
		return books.contains(book);
	}
	
	public float calculateDiscountedPrice() {
		float totalPrice = books.size() * UNIT_PRICE;
		int discount = getDiscountPercentage(books.size());
		return totalPrice * (100 - discount) / 100;
	}

	private int getDiscountPercentage(int numberOfBooksInSet) {
		int discount = 0;
		switch (numberOfBooksInSet) {
		case 5:
			discount = 25;
			break;
		case 4:
			discount = 20;
			break;
		case 3:
			discount = 10;
			break;
		case 2:
			discount = 5;
			break;
		default:
			break;
		}
		return discount;
	}

}
