// Nguyễn Trọng Khánh Duy 20210284
package hust.soict.hedspi.aims.screen;

import java.util.List;
import java.util.ArrayList;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	private static int nbBook = 0;

	public Book(String title, String category, float cost) {
		super();
		this.id = ++nbBook;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public void addAuthor(String authorName) {
		if (authors.contains(authorName)) {
			System.out.println("Nguyễn Trọng Khánh Duy - 20210284");
			System.out.println("Author is already in the list");
		} else {
			authors.add(authorName);
		}
	}

	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
		} else {
			System.out.println("Author is not in the list");
		}
	}

	public List<String> getAuthors() {
		return authors;
	}

	// toString() method
	public String toString() {
		String authorsString = String.join(", ", getAuthors());
		return "Book_id: " + getId() + "// - Title: " + getTitle() + " //- Author: " + authorsString + "// - Category: "
				+ getCategory() + " //- Cost: " + getCost() + " $";
	}
}
