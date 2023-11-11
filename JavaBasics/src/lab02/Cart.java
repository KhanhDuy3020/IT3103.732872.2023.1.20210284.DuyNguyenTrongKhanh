// Nguyễn Trọng Khánh Duy 20210284
package lab02;

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
		for (int i = 0 ; i < qtyOrdered; i++) {
			System.out.println("DVD " + i + itemsOrdered[i].toString());
		}
	}
}
