package org.paulg.ispend.model;

import java.util.*;

public class Account {

	private String number;
	private String name;
	private final List<Record> records = new ArrayList<Record>();
	private int covered = 0;

	public Account(final String number, final String name) {
		this.number = number;
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(final String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setCovered(final int covered) {
		this.covered = covered;
	}

	public int getCovered() {
		return covered;
	}

	public int getTotal() {
		return records.size();
	}

	@Override
	public int hashCode() {
		return number.hashCode();
	}

	@Override
	public boolean equals(final Object o) {
		if ((o == null) || !(o instanceof Account) || (number == null) || (name == null)) {
			return false;
		}
		Account a = (Account) o;
		return number.equals(a.getNumber()) && name.equals(a.getName());
	}

	public void printSummary() {
		double maxNegative = Double.MAX_VALUE;
		Record maxNegativeRecord = null;
		double totalNegative = 0;
		double totalPositive = 0;
		int negatives = 0;
		int positives = 0;
		for (final Record r : records) {
			if (r.getValue() < 0) {
				totalNegative += r.getValue();
				negatives++;

				if (r.getValue() < maxNegative) {
					maxNegative = r.getValue();
					maxNegativeRecord = r;
				}

			} else {
				totalPositive += r.getValue();
				positives++;
			}

		}

		System.out.println("For account number " + name + " name : " + name);
		System.out.println("\tTotal records: " + records.size());
		System.out.println("\tTotal negative:" + totalNegative + " avg: " + (totalNegative / negatives));
		System.out.println("\tTotal positive:" + totalPositive + " avg: " + (totalPositive / positives));
		System.out.println("\tMaximum negative record: " + maxNegativeRecord);
		System.out.println("\tFlow: " + (totalPositive + totalNegative));
	}

	public void addRecord(final Record r) {
		records.add(r);
	}

	public Collection<Record> getRecords() {
		return records;
	}
}