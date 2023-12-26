// Nguyễn Trọng Khánh Duy 20210284
package hust.soict.hedspi.aims.screen;

public class Track implements Playable {
	private String title;
	private int length;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}

	// Phương thức play()
	public void play() {
		System.out.println("Playing Track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Track track)) {
			return false;
		}
		return (this.title.equals(track.getTitle()) && this.length == track.getLength());
	}
}
