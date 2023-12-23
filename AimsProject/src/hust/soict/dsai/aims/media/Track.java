// Nguyễn Trọng Khánh Duy - 20210284
package hust.soict.dsai.aims.media;

public class Track implements Playable {
	private String title;
	private int length;

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	public Track(String title) {
		super();
		this.title = title;
	}

	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}

	public boolean equals(Track track) {
		return (this.title == track.title && this.length == track.length);
	}

	@Override
	public void play() { // Nguyễn Trọng Khánh Duy - 20210284
		System.out.println("Play DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
}
