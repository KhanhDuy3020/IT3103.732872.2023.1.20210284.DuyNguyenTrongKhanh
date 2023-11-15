// Nguyễn Trọng Khánh Duy 20210284
package hust.soict.dsai.lab02;

public class Aims {
	public static void main(String[] args) {
		// 20210284: Create a new Cast
		Cart anOrder = new Cart();

		// 20210284: Create new DVD objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Rogers Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);

		// 20210284: Print total cost of the item in the cart
		System.out.print("Total cost is: ");
		System.out.println(anOrder.totalCost());
		
		
		// 20210284: Remove DVD1 and DVD3 out of cart
		anOrder.removeDigitalVideoDisc(dvd1);
		anOrder.removeDigitalVideoDisc(dvd3);
		anOrder.viewCart();
	}
}
