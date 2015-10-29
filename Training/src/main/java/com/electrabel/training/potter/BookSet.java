package com.electrabel.training.potter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BookSet {
	private List<String> books = new ArrayList<String>();
	
	private static final float UNIT_PRICE = 8;
	
	public void add(String book) {
		books.add(book);
	}
	
	public boolean contains(String book) {
		return books.contains(book);
	}
	
	public BigDecimal calculateDiscountedPrice() {
		BigDecimal totalPrice = BigDecimal.valueOf(books.size() * UNIT_PRICE);
		return totalPrice.subtract(getDiscount(totalPrice));
	}
	
	private BigDecimal getDiscount(BigDecimal totalPrice) {
		int discountPercentage = getDiscountPercentage(books.size());
		return totalPrice.multiply(new BigDecimal(discountPercentage)).divide(new BigDecimal(100));
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
