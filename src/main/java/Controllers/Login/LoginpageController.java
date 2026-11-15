package Controllers.Login;

import Controllers.Scean.SceneManager;
import Controllers.model.LoginDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginpageController {

   LoginController loginController = new LoginController();

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnReset;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    void btnLoginOnAction(ActionEvent event) {
        LoginDTO loginDTO = new LoginDTO();

        loginDTO.setUsername(txtUserName.getText());
        loginDTO.setPassword(txtPassword.getText());

        if (loginController.checkUserNameandPassword(loginDTO))
        {
            SceneManager.switchPage("/view/home_page.fxml");
        }else {
            SceneManager.switchPage("/view/Loginerror_page.fxml");
        }

    }

    @FXML
    void btnRestOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/login_page.fxml");


    }

}

