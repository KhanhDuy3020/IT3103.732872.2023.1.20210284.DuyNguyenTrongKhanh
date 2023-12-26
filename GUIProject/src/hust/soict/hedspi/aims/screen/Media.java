// Nguyễn Trọng Khánh Duy 20210284
package hust.soict.hedspi.aims.screen;

import java.util.*;

public abstract class Media {
	protected int id;
	protected String title;
	protected String category;
	protected float cost;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public boolean isMatch(String title) {
		return this.title.equals(title);
	}

	// equals() method
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Media media))
			return false;
		return this.isMatch(media.getTitle());
	}
}
