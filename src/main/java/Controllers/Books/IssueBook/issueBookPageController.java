package Controllers.Books.IssueBook;

import Controllers.Scean.SceneManager;
import Controllers.model.IssueBookDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;


import java.net.URL;
import java.util.ResourceBundle;


public class issueBookPageController implements Initializable {

    IssueBookController issueBookController = new IssueBookController();

    @FXML
    public TextField txtissueId;

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
    private Button btnAllBooks;

    @FXML
    private Button btnBooks;

    @FXML
    private Button btnBorrowHis;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnMembers;



    @FXML
    void btnExitOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/books_page.fxml");

    }

    @FXML
    void btnIssueBooksOnAction(ActionEvent event) {
        IssueBookDTO issueBookDTO = new IssueBookDTO();


                issueBookDTO.setIssueID(issueBookController.genarateIssueBookId());
                issueBookDTO.setMemberID(issueBookController.genarateIssueBookId());
                issueBookDTO.setBookID(txtBookID.getText());
                issueBookDTO.setIssuedate(txtIssueDate.getValue());
                issueBookDTO.setDuedate(txtDueDate.getValue());

                issueBookController.issueBooks(issueBookDTO);



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

        txtissueId.setText("YOUR ID IS : " + issueBookController.genarateIssueBookId());
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/login_page.fxml");
    }

    public void btnBorrowHisOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/BorrowingHist_Page.fxml");
    }

    public void btnAllBooksOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/AllBooks_page.fxml");
    }

    public void btnBooksOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/books_page.fxml");
    }

    public void btnMemberOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/ViewMembers_page.fxml");
    }

    public void btnHomeOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/home_page.fxml");
    }
}
