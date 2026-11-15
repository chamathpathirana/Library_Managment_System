package Controllers.Books;

import Controllers.Scean.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class BooksPageController {


    @FXML
    private Button btnBooks;

    @FXML
    private Button btnBorrow;


    @FXML
    private Button btnAddBook;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnIssueBook;

    @FXML
    private Button btnMembers;

    @FXML
    private Button btnReturnBook;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnAllBooks;



    @FXML
    void btnBooksOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/books_page.fxml");


    }

    @FXML
    void btnBorrowOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/BorrowingHist_Page.fxml");

    }

    @FXML
    void btnExitOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/home_page.fxml");

    }

    @FXML
    void btnIssueBookOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/issueBook_page.fxml");

    }

    @FXML
    void btnMemberOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/ViewMembers_page.fxml");

    }

    @FXML
    void btnReturnBookOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/RetrunBook_Page.fxml");

    }

    @FXML
    void btnHomeOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/home_page.fxml");
    }





    public void btnAddBookOnAction(ActionEvent actionEvent) {
       SceneManager.switchPage("/view/AddBook_page.fxml");
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/login_page.fxml");


    }

    public void btnAllBooksOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/AllBooks_page.fxml");

    }
}
