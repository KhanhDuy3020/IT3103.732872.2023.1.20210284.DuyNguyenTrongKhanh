// Nguyễn Trọng Khánh Duy 20210284
package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.dsai.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

	public ArrayList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public int getQtyOrder() {
		return itemsOrdered.size();
	}

	public void addMedia(Media newMedia) { // add media to cart
		if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) // check if the cart is full
		{
			System.out.print("Nguyen Trong Khanh Duy - 20210284: ");
			System.out.println("The cart is almost full");
		} else {
			if (itemsOrdered.contains(newMedia)) // to check if the media has been added
			{
				System.out.print("Nguyen Trong Khanh Duy - 20210284: ");
				System.out.println("The disc has been added"); // notify
			} else { // If not
				itemsOrdered.add(newMedia); // add new media to arraylist
				System.out.println("Add successful"); // notify success
			}
		}
	}

	public void removeMedia(Media aMedia) { // remove media
		if (itemsOrdered.contains(aMedia)) { // to check if the media has been added
			itemsOrdered.remove(aMedia); // remove the media
			System.out.print("Nguyen Trong Khanh Duy - 20210284: ");
			System.out.println("Remove successful");
		} // notify success
		else // If not
			System.out.print("Nguyen Trong Khanh Duy - 20210284: ");
		System.out.println("The disc has not been added"); // notify
	}

	public float totalCost() { // calculate the cost of cart
		float cost = 0.0f;
		for (Media order : itemsOrdered)
			cost += order.getCost();
		return cost;
	}

	public void print() { // print information of every media in the cart
		System.out.println("******************CART********************");
		for (Media order : itemsOrdered) {
			System.out.println(order.toString());
		}

		System.out.println("Total cost: " + totalCost());
		System.out.println("******************************************");
	}

	// method to find the media with id
	public void searchById(int id) {
		boolean check = false; // to check can find id or not
		for (Media order : itemsOrdered)
			if (order.getId() == id) { // if itemOrdered has media with same id
				System.out.println("The disc requested: ");
				System.out.println(order.toString()); // print out disc info
				check = true;
			}
		if (!check)
			System.out.println("Can not find the ID requested"); // if not notify
	}

	// method to find the media with title
	public void searchByTitle(String title) {
		boolean check = false;
		for (Media order : itemsOrdered)
			if (order.getTitle().equals(title)) { // if itemOrdered has media with same title
				System.out.println("The disc requested: ");
				System.out.println(order.toString()); // print out media info
				check = true;
			}
		if (!check)
			System.out.println("Can not find the ID requested"); // if not notify
	}
	
    public void sortByTitleCost(){
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }
    public void sortByCostTitle(){
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }
}
