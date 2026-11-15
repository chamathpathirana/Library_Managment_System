package Controllers.Books.AddBook;

import Controllers.Alert.Alertutill;
import Controllers.Scean.SceneManager;
import Controllers.model.BookDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddBookPageController implements Initializable {

    AddBookController addBookController = new AddBookController();

    @FXML
    public TextField txtQuantity;

    @FXML
    private Button btnAddBook;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnMembers;


    @FXML
    private Button btnAllBooks;

    @FXML
    private Button btnBooks;

    @FXML
    private Button btnBorrowHis;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBookID;

    @FXML
    private TextField txtBookTitle;


    @FXML
    private ComboBox<String> txtCategory;

    @FXML
    private TextField txtPublishedYear;

    @FXML
    void btnAddBookOnAction(ActionEvent event) {
        BookDTO bookDTO = new BookDTO();


        bookDTO.setBookId(txtBookID.getText());
        bookDTO.setBookTitle(txtBookTitle.getText());
        bookDTO.setBookAuthor(txtAuthor.getText());
        bookDTO.setCategory(txtCategory.getValue().toString());
        bookDTO.setQuantity(txtQuantity.getText());
        bookDTO.setPublishedYear(txtPublishedYear.getText());

        if (bookDTO.getBookId() == null || bookDTO.getBookId().trim().isEmpty() ||
                bookDTO.getBookTitle() == null || bookDTO.getBookTitle().trim().isEmpty() ||
                bookDTO.getBookAuthor() == null || bookDTO.getBookAuthor().trim().isEmpty() ||
                bookDTO.getQuantity() == null || bookDTO.getQuantity().trim().isEmpty() ||
                bookDTO.getCategory() == null || bookDTO.getCategory().trim().isEmpty() ||
                bookDTO.getPublishedYear() == null

        ) {
            Alertutill.showAlert(Alert.AlertType.WARNING,
                    "WARNING",
                    "Fill All Requid Fields");
            return;
        }

        boolean bookAdded = addBookController.addBooks(bookDTO);

        if (bookAdded) {
            Alertutill.showAlert(Alert.AlertType.INFORMATION,
                    "SUCESS",
                    "Sucessfully Add Book!  Your Book Id : " + bookDTO.getBookId());
        } else {
            Alertutill.showAlert(Alert.AlertType.ERROR,
                    "ERROR",
                    "Faild To Add Book");
        }
        txtBookID.setText(addBookController.genarateBookId());
        txtBookID.setEditable(false);

    }
    @FXML
    void btnExitOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/books_page.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtBookID.setText(addBookController.genarateBookId());
        txtBookID.setEditable(false);

        ObservableList<String> cmbList = FXCollections.observableArrayList();
        cmbList.add("Love Story");
        cmbList.add("Adventure");
        cmbList.add("Fantasy");
        cmbList.add("Childern");
        cmbList.add("18 Plus");
        cmbList.add("Computer Scienece");
        cmbList.add("Programming");

        txtCategory.setItems(cmbList);
    }


    public void btnHomeOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/home_page.fxml");
    }

    public void btnMemberOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/ViewMembers_page.fxml");
    }

    public void btnBooksOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/books_page.fxml");
    }

    public void btnAllBooksOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/AllBooks_page.fxml");
    }

    public void btnBorrowHisOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/BorrowingHist_Page.fxml");
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/login_page.fxml");
    }
}
