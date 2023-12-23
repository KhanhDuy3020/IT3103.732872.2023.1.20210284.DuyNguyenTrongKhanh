// Nguyễn Trọng Khánh Duy 20210284
package hust.soict.dsai.aims;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Aims {
	public static void main(String[] args) {
		List<Media> media = new ArrayList<Media>();
		//Create new dvd objects and add them to the cart

		// 20210284: Create new DVD objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Rogers Allers", 87, 19.95f);
		media.add(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		media.add(dvd2);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 19.99f);
		media.add(dvd3);

		CompactDisc cd1 = new CompactDisc("Happy New Year", "Holiday", 100, 50f, "ABBA");
		media.add(cd1);
		
		Book book = new Book("Ca phe cung Tony","Doi song");
		book.addAuthor("Tony Buoi Sang");
		media.add(book);
		
		Collections.sort(media,Media.COMPARE_BY_TITLE_COST);
		
		for (Media media_item : media) {
			System.out.println(media_item.toString());
		}
	}
}
