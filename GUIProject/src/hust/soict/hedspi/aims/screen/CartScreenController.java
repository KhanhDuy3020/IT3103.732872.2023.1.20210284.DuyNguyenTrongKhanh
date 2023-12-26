// Nguyễn Trọng Khánh Duy - 20210284
package hust.soict.hedspi.aims.screen;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class CartScreenController {
	private Cart cart;
	@FXML
	private TableView<Media> tblMedia;
	@FXML
	private TableColumn<Media, String> colMediaTitle;
	@FXML
	private TableColumn<Media, String> colMediacategory;
	@FXML
	private TableColumn<Media, Float> colMediaCost;
	@FXML 
	private Button btnPlay;
	@FXML 
	private Button btnRemove;
	@FXML
	private Button btnPlaceOrder;
	@FXML
    public Menu menuOption;
    @FXML
    public Label lbCost;
    @FXML
    private MenuItem addBookMenuItem, addCDMenuItem, 
    				addDVDMenuItem, viewStoreMenuItem, viewCartMenuItem;

	public CartScreenController(Cart cart) {
		this.cart = cart;
	}
	
	@FXML
	private void initialize() {
			colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
			colMediacategory.setCellValueFactory( new PropertyValueFactory<Media, String>("category")); 
			colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost")); 
			tblMedia.setItems(cart.getItemsOrdered());
			
			btnPlay.setVisible(false);
			btnRemove.setVisible(false);
			
			lbCost.setText(cart.totalCost() + "$");
			
			tblMedia.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Media>() {
				@Override
				public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
					if(newValue != null) {
						updateButtonBar(newValue);
					}
				}
			});
	}
	
	@FXML
	void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if(media instanceof Playable) {
			btnPlay.setVisible(true);
		}else {
			btnPlay.setVisible(false);
		}
	}
	
	
	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
		tblMedia.setItems(cart.getItemsOrdered());
        lbCost.setText(cart.totalCost() + "$");
	}
	
	@FXML
	void btnPlaceOrderPressed(ActionEvent event){
		  Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	         alert.setTitle("Place order");
	         alert.setHeaderText("Are you sure you want to place this order?");
	         alert.setContentText("Total items: " + cart.getQtyOrdered() + "\nTotal cost: " + cart.totalCost() + "$");
	         alert.showAndWait().ifPresent(response -> {
	             if (response == ButtonType.OK) {
	                 cart.clearCart();
	                 tblMedia.setItems(cart.getItemsOrdered());
	                 lbCost.setText(cart.totalCost() + "$");
	             }
	         });
	  }
        
}
