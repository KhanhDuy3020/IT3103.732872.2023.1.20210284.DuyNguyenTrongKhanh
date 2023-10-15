//Exercises: 6.1
package Lab_01;

import javax.swing.JOptionPane;

public class ChoosingOption {
	public static void main(String[] args) {
		int option = JOptionPane.showConfirmDialog(null,
				"Do you want to change to the first class ticket?");
		JOptionPane.showMessageDialog(null, "You 've chosen: "
				+ (option==JOptionPane.YES_OPTION?"YES":"NO"));
		System.exit(0);
	}
}
