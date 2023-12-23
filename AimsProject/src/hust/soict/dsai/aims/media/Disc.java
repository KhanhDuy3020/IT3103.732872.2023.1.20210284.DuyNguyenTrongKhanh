// Nguyễn Trọng Khánh Duy - 20210284
package hust.soict.dsai.aims.media;

public class Disc extends Media {
	protected float length;
	protected String director;

	public float getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Disc(String title) {
		super(title);
	}

	public Disc(String title, String category, float cost) {
		super(title, category, cost);
	}

	public Disc(String title, String category, int length, float cost) {
		super(title, category, cost);
		this.length = length;
	}

	public Disc(String title, String category, String director, float cost) {
		super(title, category, cost);
		this.director = director;
	}

	public Disc(String title, String category, String director, int length, float cost) {
		super(title, category, cost);
		this.length = length;
		this.director = director;
	}
}
