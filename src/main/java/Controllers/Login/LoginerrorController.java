package Controllers.Login;

import Controllers.Scean.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginerrorController {
    public void btnOkOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/login_page.fxml");
    }
}
