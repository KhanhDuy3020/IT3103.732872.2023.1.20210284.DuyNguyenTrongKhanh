// Nguyễn Trọng Khánh Duy 20210284
package lab03;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private static int nbDigitalVideoDiscs = 0;
	private int id;

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public String getDirector() {
		return director;
	}

	public int getLength() {
		return length;
	}

	public float getCost() {
		return cost;
	}

	public int getId() {
		return id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public DigitalVideoDisc(String title) {
		this.title = title;
	}

//	 Nguyễn Trọng Khánh Duy 20210284
	public DigitalVideoDisc(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = ++nbDigitalVideoDiscs;
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		this.id = ++nbDigitalVideoDiscs;
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		this.id = ++nbDigitalVideoDiscs;
	}
	
//	 Nguyễn Trọng Khánh Duy 20210284
	public boolean isMatch(String title) {
		return getTitle().equals(title);
	}

//	 Nguyễn Trọng Khánh Duy 20210284
	@Override
	public String toString() {
		return this.id + ".DVD - " + this.title + " - " + this.category + " - " + this.director + " - " + this.length
				+ " : " + this.cost + "$";
	}

}
