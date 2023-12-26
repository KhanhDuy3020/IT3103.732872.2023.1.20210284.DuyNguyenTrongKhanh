// Nguyễn Trọng Khánh Duy 20210284
package hust.soict.hedspi.aims.screen;

import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	private int qtyOrdered;

	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public int getQtyOrdered() {
		return qtyOrdered;
	}

	public void addMedia(Media media) {
		if (itemsOrdered.contains(media)) {
			System.out.println("Media is already in the cart");
		} else {
			itemsOrdered.add(media);
			System.out.println("Added media title: '" + media.getTitle() + "' to cart.");
			qtyOrdered++;
			updateTotalCost();
		}
	}

	public void removeMedia(Media media) {
		if (itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println("Removed media title '" + media.getTitle() + "' from cart.");
			qtyOrdered--;
			updateTotalCost();
		} else {
			System.out.println("Media is not in cart.");
		}
	}

	public void printCart() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("***************************************************");
	}

	// Tìm theo ID
	public void searchByID(int id) {
		boolean found = false;
		for (Media media : itemsOrdered) {
			if (media.getId() == id) {
				System.out.println("Found media: " + media.toString());
				found = true;
				break; // No need to continue searching once found
			}
		}
		if (!found) {
			System.out.println("No media found with ID: " + id);
		}
	}

	// Tìm theo title
	public Media searchByTitle(String title) {
		for (Media media : itemsOrdered) {
			if (media.isMatch(title)) {
				return media;
			}
		}
		return null;
	}

	public float totalCost() {
		float total = 0;
		for (Media media : itemsOrdered) {
			total += media.getCost();
		}
		return total;
	}

	public void clearCart() {
		itemsOrdered.clear();
	}

	public void updateTotalCost() {
		float total = totalCost();
		System.out.println("Updated Total Cost: " + total);
	}

	public static final java.util.Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final java.util.Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

	public void sortByCostTitle() {
		Collections.sort(itemsOrdered, COMPARE_BY_COST_TITLE);
	}

	public void sortByTitleCost() {
		Collections.sort(itemsOrdered, COMPARE_BY_TITLE_COST);
	}

}
