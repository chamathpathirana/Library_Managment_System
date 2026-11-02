package Controllers.Books.ReturnBook;

import Controllers.Scean.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class RetrunBookPageController {

    @FXML
    private Button btnExit;

    @FXML
    private Button btnRetrunBook;

    @FXML
    void btnExitOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/books_page.fxml");

    }

    @FXML
    void btnRetrunBookOnAction(ActionEvent event) {

    }

}
