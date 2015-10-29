package com.electrabel.training.potter.v3;

import java.util.ArrayList;
import java.util.List;

public class BookSets {
	private List<BookSet> bookSets = new ArrayList<BookSet>();

	public List<BookSet> getBookSets() {
		return bookSets;
	}
	
	public void add(String book) {
		boolean bookAdded = false;
		for (BookSet bookSet : bookSets) {
			if (!bookSet.contains(book)) {
				bookSet.add(book);
				bookAdded = true;
				break;
			}
		}
		if (!bookAdded) {
			BookSet bookSet = new BookSet();
			bookSet.add(book);
			bookSets.add(bookSet);
		}
	}
	
	public int calculateDiscountedPrice() {
		int price = 0;
		for (BookSet bookSet : bookSets) {
			price += bookSet.calculateDiscountedPrice();
		}
		return price;
	}

}
