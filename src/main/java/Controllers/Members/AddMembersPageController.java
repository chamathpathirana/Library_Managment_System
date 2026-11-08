package Controllers.Members;

import Controllers.Scean.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddMembersPageController implements Initializable {
    AddMemberController addMemberController = new AddMemberController();

    @FXML
    private Button btnClear;

    @FXML
    private Button btnRegister;


    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFullName;

    @FXML
    private TextField txtMemberId;

    @FXML
    private TextField txtPhoneNum;

    @FXML
    void btnClearOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/AddMembers_page.fxml");

    }


    public void btnMemberRegisterOnAction(ActionEvent actionEvent) {
        addMemberController.addMembers(
                txtMemberId.getText(),
                txtFullName.getText(),
                txtEmail.getText(),
                Integer.valueOf(txtPhoneNum.getText()),
                txtAddress.getText()
        );

        txtMemberId.setText(addMemberController.genarateMemberID());
        txtMemberId.setEditable(false);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtMemberId.setText(addMemberController.genarateMemberID());
        txtMemberId.setEditable(false);
    }
}
