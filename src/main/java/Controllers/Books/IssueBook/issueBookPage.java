package Controllers.Books.IssueBook;

import Controllers.Scean.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;


public class issueBookPage implements Initializable {

    IssueBookController issueBookController = new IssueBookController();

    @FXML
    public Text txtissueID;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnGetBookId;

    @FXML
    private Button btnGetMemberID;

    @FXML
    private Button btnIssueBooks;

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
        issueBookController.issueBooks(
                issueBookController.genarateIssueBookId(),
                txtMmeberID.getText(),
                txtBookID.getText(),
                txtIssueDate.getValue(),
                txtDueDate.getValue()
        );


    }


    public void btnGetBookIdOnAction(ActionEvent actionEvent) {
        String bookId = issueBookController.getBookIDFromDB(txtBookName.getText());

        if (bookId != null){
            txtBookID.setText(bookId);

        }else {
            System.out.println("Vradiy ykoo");
        }

    }

    public void btnGetMemberIDOnAction(ActionEvent actionEvent) {
        String memberId = issueBookController.getMemberIDFromDB(txtMembername.getText());

        if (memberId != null){
            txtMmeberID.setText(memberId);
        }else {
            System.out.println("wadada huuto");
            txtMmeberID.clear();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtBookID.setEditable(false);
        txtMmeberID.setEditable(false);

        txtissueID.setText("your id is : " + issueBookController.genarateIssueBookId());
    }
}
