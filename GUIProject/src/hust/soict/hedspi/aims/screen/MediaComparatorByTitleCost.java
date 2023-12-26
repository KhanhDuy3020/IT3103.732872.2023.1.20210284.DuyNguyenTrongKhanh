// Nguyễn Trọng Khánh Duy 20210284
package hust.soict.hedspi.aims.screen;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
	public int compare(Media m1, Media m2) {
		return Comparator.comparing(Media::getTitle).thenComparing(Media::getCost).compare(m1, m2);
	}
}
