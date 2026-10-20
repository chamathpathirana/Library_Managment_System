package Controllers.Books;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AddBookPageController {

    @FXML
    private Button btnAddBook;

    @FXML
    private Button btnExit;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBookID;

    @FXML
    private TextField txtBookTitle;


    @FXML
    private ComboBox<?> txtCategory;

    @FXML
    private DatePicker txtPublishedYear;

    @FXML
    void btnAddBookOnAction(ActionEvent event) {

    }

    @FXML
    void btnExitOnAction(ActionEvent event) {

    }

}
