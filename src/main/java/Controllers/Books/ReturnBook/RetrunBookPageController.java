package Controllers.Books.ReturnBook;

import Controllers.Scean.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.Map;
import java.util.ResourceBundle;

public class RetrunBookPageController implements Initializable {

    ReturnBookController returnBookController = new ReturnBookController();

    @FXML
    private Button btnExit;


    @FXML
    private Button btnSearchMemName;

    @FXML
    private Button btnReturnBook;

    @FXML
    private DatePicker txtReturnDate;

    @FXML
    private TextField txtmemberID;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtBookName;

    @FXML
    private DatePicker txtDueDate;

    @FXML
    private TextField txtIssueBookID;

    @FXML
    private DatePicker txtIssueDate;

    @FXML
    private TextField txtMemberName;

    @FXML
    void btnExitOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/books_page.fxml");

    }

    @FXML
    void btnReturnBookOnAction(ActionEvent event) {
        returnBookController.returnBooks(

                txtBookId.getText(),
                txtmemberID.getText(),
                txtIssueDate.getValue(),
                txtDueDate.getValue(),
                txtReturnDate.getValue()

        );

    }

    public void btnSearchMemNameOnAction(ActionEvent actionEvent) {
        Map<String, String> data = returnBookController.get(txtMemberName.getText());

        if (data != null) {
            txtIssueBookID.setText(data.get("issue_id"));
            txtmemberID.setText(data.get("member_id"));
            txtBookId.setText(data.get("Book_id"));
            txtBookName.setText(data.get("Book_name"));
            txtIssueDate.setValue(LocalDate.parse(data.get("issuedate")));
            txtDueDate.setValue(LocalDate.parse(data.get("duedate")));
        } else {
            System.out.println("return book id not found");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtmemberID.setEditable(false);
        txtBookId.setEditable(false);
        txtBookName.setEditable(false);
        txtIssueDate.setEditable(false);
        txtDueDate.setEditable(false);
    }
}
