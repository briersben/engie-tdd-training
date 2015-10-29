package com.electrabel.training.potter.v3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {
	private Map<String,Integer> bookList = new HashMap<String,Integer>();

	public void add(String book, int quantity) {
		bookList.put(book, quantity);
	}


	public float getTotalPrice() {
		// create book sets
		List<BookSet> bookSets = createBookSets();
		
		// calculate total price
		return calculateDiscountedPrice(bookSets);
	}

	private List<BookSet> createBookSets() {
		List<BookSet> bookSets = new ArrayList<BookSet>();
		for (String book : bookList.keySet()) {
			int quantity = bookList.get(book);
			for (int i = 0; i < quantity; i++) {
				addBookToSet(bookSets, book);
			}
		}
		return bookSets;
	}

	private void addBookToSet(List<BookSet> bookSets, String book) {
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

	public float calculateDiscountedPrice(List<BookSet> bookSets) {
		float price = 0;
		for (BookSet bookSet : bookSets) {
			price += bookSet.calculateDiscountedPrice();
		}
		return price;
	}

}
