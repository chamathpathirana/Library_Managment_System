package Controllers.Books;

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
    void btnBooksOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/books_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

        Stage errorStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        errorStage.close();


    }

    @FXML
    void btnBorrowOnAction(ActionEvent event) {

    }

    @FXML
    void btnExitOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/login_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

        Stage errorStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        errorStage.close();

    }

    @FXML
    void btnIssueBookOnAction(ActionEvent event) {

    }

    @FXML
    void btnMemberOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/AddMembers_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

        Stage errorStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        errorStage.close();

    }

    @FXML
    void btnReturnBookOnAction(ActionEvent event) {

    }

    @FXML
    void btnHomeOnAction(ActionEvent event) {
        Stage stage = new Stage();

        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/home_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

        Stage errorStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        errorStage.close();

    }

}
