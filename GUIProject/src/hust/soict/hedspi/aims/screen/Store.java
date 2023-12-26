// Nguyễn Trọng Khánh Duy 20210284
package hust.soict.hedspi.aims.screen;

import java.util.*;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();

	public void addMedia(Media media) {
		if (itemsInStore.contains(media)) {
			System.out.println("Media is already in the store");
		} else {
			itemsInStore.add(media);
			System.out.println("Added media title: '" + media.getTitle() + "' to store.");
		}
	}

	public void removeMedia(Media media) {
		if (itemsInStore.contains(media)) {
			itemsInStore.remove(media);
			System.out.println("Removed media title '" + media.getTitle() + "' from store.");
		} else {
			System.out.println("Media is not in the store");
		}
	}

	public void addMedia(Media... media) {
		for (Media m : media) {
			addMedia(m);
		}
	}

	public void printStore() {
		System.out.println("***********************STORE***********************");
		System.out.println("Items in store:");
		for (int i = 0; i < itemsInStore.size(); i++) {
			System.out.println(i + 1 + ". " + itemsInStore.get(i).toString());
		}
		System.out.println("***************************************************");
	}

	public Media searchByTitle(String title) {
		for (Media media : itemsInStore) {
			if (media.isMatch(title)) {
				return media;
			}
		}
		return null;
	}

	public void addWithDetails(Scanner scanner) {
		// Nhập vào loại media muốn thêm vào kho
		System.out.print("Enter the type of media you want to add (1-Book; 2-CD; 3-DVD)(enter 1-2-3): ");
		int mediaType = scanner.nextInt();
		scanner.nextLine();

		// Nhập các thông tin chung
		System.out.print("Enter the title: ");
		String title = scanner.nextLine();

		System.out.print("Enter the category: ");
		String category = scanner.nextLine();

		System.out.print("Enter the cost: ");
		float cost = scanner.nextFloat();
		scanner.nextLine();

		switch (mediaType) {
		case 1 -> {
			Book book = new Book(title, category, cost);
			String input = scanner.nextLine();
			addMedia(book); // Thêm book vào kho
		}
		case 2 -> {
			System.out.print("Enter the artist: ");
			String artist = scanner.nextLine();
			CompactDisc cd = new CompactDisc(title, category, cost, artist);
			System.out.print("Enter the number of tracks: ");
			int numOfTracks = scanner.nextInt();
			scanner.nextLine();
			for (int i = 0; i < numOfTracks; i++) {
				System.out.print("Enter the title of track " + (i + 1) + ": ");
				String trackTitle = scanner.nextLine();
				System.out.print("Enter the length of track " + (i + 1) + ": ");
				int trackLength = scanner.nextInt();
				scanner.nextLine();
				Track track = new Track(trackTitle, trackLength);
				cd.addTrack(track);
			}
			addMedia(cd); // Thêm cd vào kho
		}
		case 3 -> {
			// Yêu cầu người dùng nhập vào director và length của dvd
			System.out.print("Enter the director: ");
			String director = scanner.nextLine();
			System.out.print("Enter the length: ");
			int length = scanner.nextInt();
			scanner.nextLine();
			DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
			addMedia(dvd); // Thêm dvd vào kho
		}
		default -> System.out.println("Invalid media type.");
		}
	}

	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}
}
