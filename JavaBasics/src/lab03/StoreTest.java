// Nguyễn Trọng Khánh Duy 20210284
package lab03;

public class StoreTest {

	public static void main(String[] args) {
		Store store = new Store();

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		store.addDVD(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		store.addDVD(dvd2);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Nguyen Trong Khanh Duy", 23, 18.99f);
		store.addDVD(dvd3);
		
		store.viewStore();

		store.removeDVD(dvd1);
		
		store.viewStore();
	}
}
