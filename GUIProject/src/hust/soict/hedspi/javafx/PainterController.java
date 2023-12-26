package hust.soict.hedspi.javafx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
public class PainterController {
    @FXML
    private Pane drawingAreaPane;
    @FXML
    private RadioButton eraserRadioButton;
    @FXML
    private RadioButton penRadioButton;
    private boolean eraserMode = false;
    @FXML
    void initialize() {
        // Thiết lập sự kiện khi chọn RadioButton "Eraser"
        penRadioButton.setOnAction(e -> setPenMode());
        eraserRadioButton.setOnAction(e -> setEraserMode());
    }
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        if (eraserMode) {
            // Nếu đang ở chế độ tẩy, sử dụng hình tròn màu nền trắng
            Circle eraserCircle = new Circle(event.getX(), event.getY(), 4, Color.WHITE);
            drawingAreaPane.getChildren().add(eraserCircle);
        } else {
            // Sử dụng hình tròn màu đen để vẽ
            Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
            drawingAreaPane.getChildren().add(newCircle);
        }
    }
    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();}
    private void setPenMode() {
        // Khi chọn RadioButton "Pen", chuyển sang chế độ bút
        eraserMode = false;
        drawingAreaPane.setCursor(Cursor.DEFAULT);}
    private void setEraserMode() {
        // Khi chọn RadioButton "Eraser", chuyển sang chế độ tẩy
        eraserMode = eraserRadioButton.isSelected();
        // Thay đổi con trỏ chuột để hiển thị chế độ đang được chọn
        if (eraserMode) {
            drawingAreaPane.setCursor(Cursor.CROSSHAIR);
        } else {
            drawingAreaPane.setCursor(Cursor.DEFAULT);
        }
    }
}
