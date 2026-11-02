package Controllers.Books.BorrowingHistroy;

import Controllers.Scean.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class BorrowingHistroy_page {

    @FXML
    private Button btnBack;

    @FXML
    void btnBackOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/books_page.fxml");

    }

}