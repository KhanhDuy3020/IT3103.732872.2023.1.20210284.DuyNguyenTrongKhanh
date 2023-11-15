// Nguyễn Trọng Khánh Duy 20210284
package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	public static final int MAX_NUMBERS_OF = 10000;
	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBERS_OF];
	private int itemCount;

	public Store() {
		this.itemCount = 0;
	}

	public void addDVD(DigitalVideoDisc dvd) {
		if (itemCount <= MAX_NUMBERS_OF) {
			itemsInStore[itemCount] = dvd;
			itemCount++;
			System.out.print("Nguyen Trong Khanh Duy - 20210284: ");
			System.out.println("Add successful");
		} else {
			System.out.print("Nguyen Trong Khanh Duy - 20210284: ");
			System.out.println("The store is almost full");
		}
	}

	// remove any dvd from itemsOrdered.
	public void removeDVD(DigitalVideoDisc dvd) {
		boolean found = false;
		for (int i = 0; i < itemCount; i++) {
			if (itemsInStore[i].equals(dvd)) {
				for (int j = i; j < itemCount - 1; j++) {
					itemsInStore[j] = itemsInStore[j + 1];
				}
				itemCount--;
				found = true;
				break; // Stop the loop when the DVD is found and removed
			}
		}
		if (found) {
			System.out.print("Nguyen Trong Khanh Duy - 20210284: ");
			System.out.println("Remove successful");
		} else {
			System.out.print("Nguyen Trong Khanh Duy - 20210284: ");
			System.out.println("The disc has not been added");
		}
	}

	public void viewStore() {
		for (int i = 0; i < itemCount; i++) {
			System.out.println(itemsInStore[i].toString());
		}
	}
}
