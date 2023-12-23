// Nguyễn Trọng Khánh Duy - 20210284
package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
	@Override
	public int compare(Media o1, Media o2) {
		if (o1.getTitle() == o2.getTitle()) {
			return (int) (o1.getCost() - o2.getCost());
		}
		return o1.getTitle().compareTo(o2.getTitle());
	}
}
