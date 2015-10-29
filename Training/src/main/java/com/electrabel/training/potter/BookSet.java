package com.electrabel.training.potter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BookSet {
	private List<String> books = new ArrayList<String>();
	
	private static final float UNIT_PRICE = 8;
	
	private static final int DISCOUNT_SET_OF_1 = 0;
	private static final int DISCOUNT_SET_OF_2 = 5;
	private static final int DISCOUNT_SET_OF_3 = 10;
	private static final int DISCOUNT_SET_OF_4 = 20;
	private static final int DISCOUNT_SET_OF_5 = 25;
	
	public void add(String book) {
		books.add(book);
	}
	
	public boolean contains(String book) {
		return books.contains(book);
	}
	
	public BigDecimal calculateDiscountedPrice() {
		return calculateDiscountedPrice(books.size());
	}

	public BigDecimal calculateDisountedPriceWithNewBook() {
		return calculateDiscountedPrice(books.size() + 1);
	}

	private BigDecimal calculateDiscountedPrice(int numberOfBooks) {
		BigDecimal totalPrice = BigDecimal.valueOf(numberOfBooks * UNIT_PRICE);
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
			discount = DISCOUNT_SET_OF_5;
			break;
		case 4:
			discount = DISCOUNT_SET_OF_4;
			break;
		case 3:
			discount = DISCOUNT_SET_OF_3;
			break;
		case 2:
			discount = DISCOUNT_SET_OF_2;
			break;
		default:
			break;
		}
		return discount;
	}

	private boolean isSetOf2BetterThanSetOf1() {
		return DISCOUNT_SET_OF_2 > DISCOUNT_SET_OF_1; 
	}
	
	private boolean isSetOf3BetterThanSetOf2() {
		return DISCOUNT_SET_OF_3 > DISCOUNT_SET_OF_2; 
	}

	private boolean isSetOf4BetterThanSetOf3() {
		return DISCOUNT_SET_OF_3 > DISCOUNT_SET_OF_2; 
	}

	private boolean isSetOf5BetterThanSetOf4() {
		return DISCOUNT_SET_OF_3 > DISCOUNT_SET_OF_2; 
	}
}
