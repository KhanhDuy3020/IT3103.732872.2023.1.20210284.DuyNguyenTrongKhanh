// Nguyễn Trọng Khánh Duy 20210284
package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

public class Store {
	public static final int MAX_NUMBERS_ITEM = 10000;
	private ArrayList<Media> itemInStore = new ArrayList<Media>();

	public void addMedia(Media newMedia) {
		if (itemInStore.size() == MAX_NUMBERS_ITEM) {
			System.out.print("Nguyen Trong Khanh Duy - 20210284: ");
			System.out.println("The Store is almost full");
		} else {
			if (itemInStore.contains(newMedia)) {
				System.out.print("Nguyen Trong Khanh Duy - 20210284: ");
				System.out.println("The disc has been added");
			} else {
				itemInStore.add(newMedia);
				System.out.print("Nguyen Trong Khanh Duy - 20210284: ");
				System.out.println("Store add successful");
			}
		}
	}

	public void addMedia(Media[] mediaList) {
		for (Media media : mediaList) {
			addMedia(media);
			if (itemInStore.size() == MAX_NUMBERS_ITEM)
				break;
		}
	}

	public void removeMedia(Media aMedia) {
		if (itemInStore.contains(aMedia)) {
			itemInStore.remove(aMedia);
			System.out.print("Nguyen Trong Khanh Duy - 20210284: ");
			System.out.println("Remove successfull");
		} else {
			System.out.print("Nguyen Trong Khanh Duy - 20210284: ");
			System.out.println("The disc has not been added");
		}
	}

	public void print() {
		System.out.println("----------STORE----------");
		for (Media order : itemInStore) {
			System.out.println(order.toString());
		}
		System.out.println("-------------------------");
	}
}
