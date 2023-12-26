// Nguyễn Trọng Khánh Duy 20210284
package hust.soict.hedspi.aims.screen;

import java.util.Scanner;

import javax.naming.LimitExceededException;
import javax.swing.SwingUtilities;

public class Aims {
	static Cart cart = new Cart();
	static Store store = new Store();

	public static void showMenu() {
		System.out.println("AIMS");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}

	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media's details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}

	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}

	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}

	public static void main(String[] args) {
		Store store = new Store();
		Cart cart = new Cart();

		// Tạo một số media và thêm vào kho
		// DVD1
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("DVD_The Lion", "Animation", "Roger Allers", 87, 19.95f);
		cart.addMedia(dvd1);
		// DVD2
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("DVD_Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		cart.addMedia(dvd2);
		// CD1
		CompactDisc cd1 = new CompactDisc("CD_Aladin", "Rock", 10.99f, "Batle");
		cd1.addTrack(new Track("Thing", 3));
		cart.addMedia(cd1);
		// CD2
		CompactDisc cd2 = new CompactDisc("CD_The Moon", "Rock", 20.99f, "Floyd");
		cart.addMedia(cd2);
		// Book1
		Book book1 = new Book("Book_The Great Gatsby", "Novel", 10.5f);
		book1.addAuthor("F. Scott Fitzgerald");
		cart.addMedia(book1);
		// Book2
		Book book2 = new Book("Book_The Chronicles of Narnia", "Fantasy", 15.0f);
		book2.addAuthor("C.S. Lewis");
		cart.addMedia(book2);
		// ADD
		store.addMedia(dvd1, dvd2, cd1, cd2, book1, book2);

		new StoreScreen(store, cart);
	}

	public static void consoleUI(Store store, Cart cart) throws LimitExceededException {
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			showMenu(); // Hiển thị menu chính
			choice = sc.nextInt();
			switch (choice) {
			case 1 -> viewStore(store, sc, cart);
			case 2 -> updateStore(store, sc);
			case 3 -> See_current_cart(cart, sc);
			case 0 -> System.out.println("End!");
			default -> System.out.println("Invalid choice!");
			}
		} while (choice != 0);
		sc.close();
	}

	// Case ViewStore
	public static void viewStore(Store store, Scanner sc, Cart cart) {
		store.printStore(); // Hiển thị thông tin của kho
		int choice;
		do {
			storeMenu(); // Hiển thị menu
			choice = sc.nextInt();
			switch (choice) {
			// See a media’s details
			case 1 -> SeeMediaDetail(store, cart, sc);
			// Add a media to cart
			case 2 -> {
				System.out.print("Enter title media  "); // Yêu cầu nhập title của media cần thêm vào giỏ hàng
				sc.nextLine();
				String titleAdd = sc.nextLine();
				Media mediaAdd = store.searchByTitle(titleAdd);
				if (mediaAdd == null) {
					System.out.println("Media not found!");
				} else {
					// Nếu tìm thấy media thì thêm vào giỏ hàng
					cart.addMedia(mediaAdd);
				}
			}
			// Play media
			case 3 -> {
				System.out.print("Enter media title: "); // Yêu cầu nhập title của media cần phát
				sc.nextLine();
				String titlePlay = sc.nextLine();
				Media mediaPlay = store.searchByTitle(titlePlay);
				if (mediaPlay != null) {
					// Nếu tìm thấy media và media có thể phát được thì gọi phương thức play()
					if (mediaPlay instanceof Playable) {
						((Playable) mediaPlay).play();
					} else {
						System.out.println("This media is not playable");
					}
				} else {
					System.out.println("Media not found!");
				}
			}
			// See current cart
			case 4 -> cart.printCart(); // Hiển thị thông tin của giỏ hàng
			case 0 -> {
			}
			default -> System.out.println("Invalid choice!");
			}
		} while (choice != 0);
	}

	// See a media’s details:
	public static void SeeMediaDetail(Store store, Cart cart, Scanner sc) {
		System.out.print("Enter media title: ");
		sc.nextLine();
		String title = sc.nextLine();
		Media media = store.searchByTitle(title);
		if (media != null) {
			System.out.println(media.toString());
			int choice;
			do {
				mediaDetailsMenu(); // Hiển thị menu
				choice = sc.nextInt();
				switch (choice) {
				case 1 -> cart.addMedia(media);
				case 2 -> {
					if (media instanceof Playable) {
						((Playable) media).play();
					} else {
						System.out.println("This media is not playable");
					}
				}
				default -> System.out.println("Invalid choice!");
				}
			} while (choice != 0);
		} else {
			System.out.println("Media not found!");
		}
	}

	// Case 2 Update store
	public static void updateStore(Store store, Scanner sc) {
		int choice;
		do {
			// Hiển thị menu thêm và xoá
			System.out.println("Options: ");
			System.out.println("1. Add media");
			System.out.println("2. Remove media");
			System.out.println("0. Back");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			switch (choice) {
			// Add media
			case 1 -> store.addWithDetails(sc);
			// Remove media
			case 2 -> {
				System.out.print("Enter media title: ");
				sc.nextLine();
				String titleToRemove = sc.nextLine();
				Media mediaToRemove = store.searchByTitle(titleToRemove);
				if (mediaToRemove != null) {
					store.removeMedia(mediaToRemove);
				} else {
					System.out.println("Media not found!");
				}
			}
			case 0 -> {
			}
			default -> System.out.println("Invalid choice!");
			}
		} while (choice != 0);
	}

	// Case 3 See current cart
	public static void See_current_cart(Cart cart, Scanner sc) {
		cart.printCart();
		int choice;
		do {
			cartMenu(); // Hiển thị menu giỏ hàng
			choice = sc.nextInt();
			// Filter medias in cart
			switch (choice) {
			case 1 -> {
				System.out.println("Options: ");
				System.out.println("1. Filter by title");
				System.out.println("2. Filter by id");
				System.out.print("Enter your choice: ");
				int choice1 = sc.nextInt();
				sc.nextLine();
				switch (choice1) {
				case 1 -> {
					System.out.print("Enter the title to filter: ");
					String titleFilter = sc.nextLine();
					for (Media media : cart.getItemsOrdered()) {
						// Kiểm tra xem title của media có chứa title vừa nhập hay không
						if (media.getTitle().toLowerCase().contains(titleFilter.toLowerCase())) {
							System.out.println(media.toString());
						}
					}
				}
				case 2 -> {
					System.out.print("Enter the id to filter: ");
					int idToFilter = sc.nextInt();
					for (Media media : cart.getItemsOrdered()) {
						if (media.getId() == idToFilter) {
							System.out.println(media.toString());
						}
					}
				}
				default -> System.out.println("Invalid choice!");
				}
			}
			// Sort medias in cart
			case 2 -> {
				System.out.println("Options: ");
				System.out.println("1. Sort by cost");
				System.out.println("2. Sort by title");
				System.out.print("Enter your choice: ");
				int choice2 = sc.nextInt();
				sc.nextLine();
				switch (choice2) {
				case 1 -> {
					cart.sortByCostTitle();
					cart.printCart();
				}
				case 2 -> {
					cart.sortByTitleCost();
					cart.printCart();
				}
				default -> System.out.println("Invalid choice!");
				}
			}
			// Remove media from cart
			case 3 -> {
				// Yêu cầu nhập title của media cần xóa
				System.out.print("Enter media title : ");
				sc.nextLine();
				String titleToRemove = sc.nextLine();
				Media mediaToRemove = cart.searchByTitle(titleToRemove);
				if (mediaToRemove != null) {
					cart.removeMedia(mediaToRemove); // Xóa media nếu tìm thấy
				} else {
					System.out.println("Media not found!");
				}
			}
			// Play a media
			case 4 -> {
				System.out.print("Enter media title: ");
				sc.nextLine();
				String titleToPlay = sc.nextLine();
				Media mediaToPlay = cart.searchByTitle(titleToPlay);
				if (mediaToPlay != null) {
					if (mediaToPlay instanceof Playable) {
						((Playable) mediaToPlay).play();
					} else {
						System.out.println("This media is not playable");
					}
				} else {
					System.out.println("Media not found!");
				}
			}
			// Place order
			case 5 -> {
				System.out.println("Total number of items: " + cart.getQtyOrdered());
				System.out.println("Total cost: " + cart.totalCost());
				System.out.print("Are you sure you want to place this order? (Y/N) ");
				sc.nextLine();
				String confirm = sc.nextLine();
				if (confirm.equals("Y")) {
					System.out.println("Order placed! Cart cleared!");
					cart.clearCart();
				} else if (confirm.equals("N")) {
					System.out.println("Order not placed!");
				} else {
					System.out.println("Invalid choice!");
				}
			}
			case 0 -> {
			}
			default -> System.out.println("Invalid choice!");
			}
		} while (choice != 0);
	}

}