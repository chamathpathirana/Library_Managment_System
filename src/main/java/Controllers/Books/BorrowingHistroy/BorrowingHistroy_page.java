package Controllers.Books.BorrowingHistroy;

import Controllers.Scean.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class BorrowingHistroy_page {


    @FXML
    private Button btnAllBooks;

    @FXML
    private Button btnBooks;

    @FXML
    private Button btnBorrowHist;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnLoginOut;

    @FXML
    private Button btnMembers;

    @FXML
    private Button btnSearchBook;

    @FXML
    private TextField txtSearchBook;

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

    public void btnBorrowHistOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/BorrowingHist_Page.fxml");

    }

    public void btnLogoutOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/login_page.fxml");

    }

    public void btnSearchBookOnAction(ActionEvent actionEvent) {


    }
}