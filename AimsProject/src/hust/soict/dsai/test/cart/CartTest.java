// Nguyễn Trọng Khánh Duy 20210284
package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {
	public static void main(String[] args) {
		Cart cart = new Cart();

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		cart.addDigitalVideoDisc(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		cart.addDigitalVideoDisc(dvd2);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		cart.addDigitalVideoDisc(dvd3);

		// Test the print method
		cart.print();

		// Test searchDVDsById method
		cart.searchDVDsById(1);

		cart.searchDVDsById(20210284);

		// Test searchDVDsByTitle;
		cart.searchDVDsByTitle("Star Wars");

		cart.searchDVDsByTitle("Nguyễn Trọng Khánh Duy");

	}
}
