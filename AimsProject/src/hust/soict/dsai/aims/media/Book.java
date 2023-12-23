// Nguyễn Trọng Khánh Duy 20210284
package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();

	public List<String> getAuthors() {
		return authors;
	}

	public Book(String title) {
		super(title);
	}

	public Book(String title, String category) {
		super(title, category);
	}

	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}

	public void addAuthor(String authorName) {
		if (!authors.contains(authorName)) {
			authors.add(authorName);
			System.out.print("Nguyen Trong Khanh Duy - 20210284: ");
			System.out.println("Added " + authorName + " to the list");
		} else {
			System.out.print("Nguyen Trong Khanh Duy - 20210284: ");
			System.out.println(authorName + " is already in the list.");
		}
	}

	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
			System.out.print("Nguyen Trong Khanh Duy - 20210284: ");
			System.out.println("Removed " + authorName + " to the list");
		} else {
			System.out.print("Nguyen Trong Khanh Duy - 20210284: ");
			System.out.println(authorName + " is not listed.");
		}
	}

	public String toString() {
		return "Book - " + super.getTitle() + " - " + category + " - " + authors + " : " + cost + "$";
	}
}
