package Controllers.Books.IssueBook;

import Controllers.Scean.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;



public class issueBookPage {
    IssueBookController issueBookController = new IssueBookController();



    @FXML
    private Button btnExit;

    @FXML
    private Button btnGotBookId;

    @FXML
    private Button btnIssueBooks;

    @FXML
    private Button btnMemberID;

    @FXML
    private TextField txtBookID;

    @FXML
    private TextField txtBookName;

    @FXML
    private DatePicker txtDueDate;

    @FXML
    private DatePicker txtIssueDate;

    @FXML
    private TextField txtMembername;

    @FXML
    private TextField txtMmeberID;

    @FXML
    void btnExitOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/books_page.fxml");

    }

    @FXML
    void btnIssueBooksOnAction(ActionEvent event) {

    }


    public void btnGetBookIdOnAction(ActionEvent actionEvent) {

    }

    public void btnGetMemberIDOnAction(ActionEvent actionEvent) {
    }
}
