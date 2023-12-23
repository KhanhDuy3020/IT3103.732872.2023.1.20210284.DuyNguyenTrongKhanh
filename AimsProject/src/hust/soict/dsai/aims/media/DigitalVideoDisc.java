// Nguyễn Trọng Khánh Duy 20210284
package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	protected static int nb;

	public DigitalVideoDisc(String title) {
		super(title);
		nb += 1;
		this.id = nb;
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
		nb += 1;
		this.id = nb;
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
		nb += 1;
		this.id = nb;
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
		nb += 1;
		this.id = nb;
	}

	@Override // override toString method to print info of disc
	public String toString() {
		return "DVD - " + super.getTitle() + " - " + category + " - " + director + " - " + length + " : " + cost + "$";
	}
	public boolean isMatch(String title) {
		if (this.title.equalsIgnoreCase(title))
			return true;
		else
			return false;
	}
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
}
