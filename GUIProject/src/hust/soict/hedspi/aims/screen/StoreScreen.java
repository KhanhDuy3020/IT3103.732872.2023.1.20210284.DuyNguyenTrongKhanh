// Nguyễn Trọng Khánh Duy 20210284
package hust.soict.hedspi.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import javax.swing.*;

public class StoreScreen extends JFrame {
	private Store store;
	private Cart cart;
	private Container cp;

	public StoreScreen(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
		cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
	}

	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}

	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem smAddBook = new JMenuItem("Add Book");
		smAddBook.addActionListener(e -> {
			new AddMediaScreen(store, "book", this);
		});
		smUpdateStore.add(smAddBook);
		JMenuItem smAddCD = new JMenuItem("Add CD");
		smAddCD.addActionListener(e -> {
			new AddMediaScreen(store, "cd", this);
		});
		smUpdateStore.add(smAddCD);

		JMenuItem smAddDVD = new JMenuItem("Add DVD");
		smAddDVD.addActionListener(e -> {
			new AddMediaScreen(store, "dvd", this);
		});
		smUpdateStore.add(smAddDVD);
		menu.add(smUpdateStore);

		JMenuItem smViewStore = new JMenuItem("View Store");
		smViewStore.addActionListener(e -> {

		});
		menu.add(smViewStore);

		JMenuItem smViewCart = new JMenuItem("View Cart");
		smViewCart.addActionListener(e -> {
			new CartScreen(cart);
		});
		menu.add(smViewCart);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout((LayoutManager) new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		return menuBar;
	}

	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		JLabel title = new JLabel("AIMS-DuyNTK-210284");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);

		JButton cart = new JButton("View cart");
		cart.setPreferredSize(new Dimension(100, 50));
		cart.setMaximumSize(new Dimension(100, 50));

		cart.addActionListener(e -> {
			new CartScreen(this.cart);
		});

		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		return header;
	}

	JPanel createCenter() {
		Cart cart = new Cart();
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (Media media : mediaInStore) {
			MediaStore cell = new MediaStore(media, cart);
			center.add(cell);
		}
		return center;
	}

	public void updateScreen() {
		cp.removeAll();
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		cp.revalidate();
		cp.repaint();
	}
}
