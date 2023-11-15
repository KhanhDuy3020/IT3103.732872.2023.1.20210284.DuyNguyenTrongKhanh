// Nguyễn Trọng Khánh Duy 20210284
package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0; // 20210284: The quantity of ordered DVDs in the Cart.

	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) { // 20210284: Not almost full
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.print("Nguyen Trong Khanh Duy - 20210284: ");
			System.out.println("Add successful");
		} else {
			System.out.print("Nguyen Trong Khanh Duy - 20210284: ");
			System.out.println("The cast is almost full");
		}
	}

//	 Nguyễn Trọng Khánh Duy 20210284
//	 Function add listDVD
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		int listLength = dvdList.length;
		if (qtyOrdered + listLength - 1 < MAX_NUMBERS_ORDERED) { // 20210284: Not almost full
			for (DigitalVideoDisc disc : dvdList) {
				itemsOrdered[qtyOrdered] = disc;
				qtyOrdered++;
				System.out.print("Nguyen Trong Khanh Duy - 20210284: ");
				System.out.println("Add successful");
			}
		} else {
			System.out.print("Nguyen Trong Khanh Duy - 20210284: ");
			System.out.println("The cast is almost full");
		}
	}

	// Nguyễn Trọng Khánh Duy 20210284
	// Function add 2 DVD
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (qtyOrdered + 2 <= MAX_NUMBERS_ORDERED) { // 20210284: Not almost full
			itemsOrdered[qtyOrdered] = dvd1;
			qtyOrdered++;
			itemsOrdered[qtyOrdered] = dvd2;
			qtyOrdered++;
			System.out.print("Nguyen Trong Khanh Duy - 20210284: ");
			System.out.println("Add successful");
		} else {
			System.out.print("Nguyen Trong Khanh Duy - 20210284: ");
			System.out.println("The cast is almost full");
		}
	}

	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		boolean found = false;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].equals(disc)) {
				for (int j = i; j < qtyOrdered - 1; j++) {
					itemsOrdered[j] = itemsOrdered[j + 1];
				}
				qtyOrdered--;
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

	public float totalCost() {
		float cost = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			cost += itemsOrdered[i].getCost();
		}
		return cost;
	}

	public void viewCart() {
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println("DVD " + i + itemsOrdered[i].toString());
		}
	}

//	 Nguyễn Trọng Khánh Duy 20210284
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");

		double totalCost = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			totalCost += itemsOrdered[i].getCost();
			System.out.println(itemsOrdered[i].toString());
		}

		System.out.println("Total cost: " + totalCost);
	}
//	 Nguyễn Trọng Khánh Duy 20210284
	public void searchDVDsById(int id) {
		boolean check = false;	// Kiểm tra có tồn tại DVD cần tìm không
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].getId() == id) {
				check = true;	// Có tồn tại => in ra và thoát khỏi vòng lặp
				System.out.println(itemsOrdered[i].toString());
				break;
			}
		}
		if (!check) {
			System.out.println("Not DVDs match for id = " + id);
		}
	}

	public void searchDVDsByTitle(String title) {
		boolean check = false;	// Kiểm tra có tồn tại DVD cần tìm không
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].isMatch(title)) {
				check = true;	// Có tồn tại => in ra và thoát khỏi vòng lặp
				System.out.println(itemsOrdered[i].toString());
				break;
			}
		}
		if (!check) {
			System.out.println("Not DVDs match! for title = " + title);
		}
	}
}
