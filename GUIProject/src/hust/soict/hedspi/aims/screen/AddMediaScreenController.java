// Nguyễn Trọng Khánh Duy 20210284
package hust.soict.hedspi.aims.screen;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.ArrayList;

public class AddMediaScreenController {
	private Store store;
	private String type;

	@FXML
	private Button btnAddBook;
	@FXML
	private TextField tfBookAuthor;
	@FXML
	private TextField tfBookCate;
	@FXML
	private TextField tfBookCost;
	@FXML
	private TextField tfBookTitle;

	@FXML
	private Button btnAddDVD;
	@FXML
	private TextField tfDVDCate;
	@FXML
	private TextField tfDVDCost;
	@FXML
	private TextField tfDVDDirector;
	@FXML
	private TextField tfDVDLength;
	@FXML
	private TextField tfDVDTitle;

	@FXML
	private Button btnAddCD;
	@FXML
	private Button btnAddTrack;
	@FXML
	private TextField tfCDArtist;
	@FXML
	private TextField tfCDCate;
	@FXML
	private TextField tfCDTitle;
	@FXML
	private TextField tfCDCost;

	public AddMediaScreenController(Store store, String type) {
		this.store = store;
		this.type = type;
	}

	@FXML
	public void initialize() {
		switch (type) {
		case "book" -> {
			btnAddBook.setOnAction(e -> {
				String title = tfBookTitle.getText();
				String category = tfBookCate.getText();
				String author = tfBookAuthor.getText();
				float cost = Float.parseFloat(tfBookCost.getText());
				Book book = new Book(title, category, cost);
				for (String s : author.split(",")) {
					book.addAuthor(s);
				}
				store.addMedia(book);
			});
		}
		case "cd" -> {
			ArrayList<Track> tracks = new ArrayList<>();
			btnAddCD.setOnAction(e -> {
				String title = tfCDTitle.getText();
				String category = tfCDCate.getText();
				String artist = tfCDArtist.getText();
				float cost = Float.parseFloat(tfCDCost.getText());
				CompactDisc cd = new CompactDisc(title, category, cost, artist);
				tracks.forEach(cd::addTrack);
				store.addMedia(cd);
			});
		}
		case "dvd" -> {
			btnAddDVD.setOnAction(e -> {
				String title = tfDVDTitle.getText();
				String category = tfDVDCate.getText();
				String director = tfDVDDirector.getText();
				int length = Integer.parseInt(tfDVDLength.getText());
				float cost = Float.parseFloat(tfDVDCost.getText());
				DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
				store.addMedia(dvd);
			});
		}
		}

	}
}
