// Nguyễn Trọng Khánh Duy 20210284
package hust.soict.hedspi.aims.screen;

import javax.swing.JOptionPane;

public class DigitalVideoDisc extends Disc implements Playable {
	private static int nbDigitalVideoDiscs = 0; // Class attribute
	// Constructor overloading

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		this.id = ++nbDigitalVideoDiscs;// gán id
	}

	// Constructor
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		this.id = ++nbDigitalVideoDiscs;
	}

	// Constructor overloading
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = ++nbDigitalVideoDiscs;
	}

	// Constructor overloading
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		this.id = ++nbDigitalVideoDiscs;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public static int getNbDigitalVideoDiscs() {
		return nbDigitalVideoDiscs;
	}

	// Phương thức play()
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
		JOptionPane.showMessageDialog(null, "Playing DVD : " + this.getTitle() + "\nDVD length: " + this.getLength(),
				"", JOptionPane.INFORMATION_MESSAGE);
	}

	// toString() method
	public String toString() {
		return "DVD_id: " + id + " //- Title:  " + title + " //- Category:  " + category + " //- Director:  " + director
				+ " //- Length:  " + length + " //- Cost:  " + cost + " $";
	}
}
