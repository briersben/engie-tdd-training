package com.electrabel.training.phonenumbers.v4;

import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.opencsv.CSVReader;

public class PhoneNumbersV4 {
    private static final Logger LOG = Logger.getLogger(PhoneNumbersV4.class);

	public static boolean isConsistent(PhoneList phoneList) {
		return phoneList.isConsistent();
	}

	public static PhoneList loadPhoneNumbers() throws IOException {
		PhoneList phoneList = new PhoneList();

		CSVReader reader = new CSVReader(new FileReader("src/main/resources/phone_data.csv"));
		String[] nextLine;
		while ((nextLine = reader.readNext()) != null) {
			if (nextLine.length == 2) {
				Phone phone = new Phone(nextLine[0], nextLine[1]);
				phoneList.add(phone);
			} else {
				System.out.println("skipping invalid phone record: " + nextLine.toString());
			}
		}
		reader.close();
		
		return phoneList;
	}
}
