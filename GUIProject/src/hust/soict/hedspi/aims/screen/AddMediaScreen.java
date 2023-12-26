// Nguyễn Trọng Khánh Duy 20210284
package hust.soict.hedspi.aims.screen;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import hust.soict.hedspi.aims.*;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class AddMediaScreen extends JFrame { // Nguyễn Trọng Khánh Duy - 20210284
	private Store store;

	public AddMediaScreen(Store store, String type, StoreScreen storeScreen) {
		this.store = store;

		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);

		this.setTitle("Add Media");
		this.setVisible(true);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader fxmlLoader = switch (type) {
					case "cd" -> new FXMLLoader(getClass().getResource("addCD.fxml"));
					case "dvd" -> new FXMLLoader(getClass().getResource("addDVD.fxml"));
					default -> new FXMLLoader(getClass().getResource("addBook.fxml"));
					};
					AddMediaScreenController controller = new AddMediaScreenController(store, type);
					fxmlLoader.setController(controller);
					Parent root = fxmlLoader.load();
					fxPanel.setScene(new Scene(root, 400, 200));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		// Add a window listener
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				storeScreen.updateScreen();
			}
		});
	}
}
