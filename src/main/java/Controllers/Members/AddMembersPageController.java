package Controllers.Members;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddMembersPageController {
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


    public void btnMemberRegisterOnAction(ActionEvent actionEvent) {
        addMemberController.addMembers(
                txtMemberId.getText(),
                txtFullName.getText(),
                txtEmail.getText(),
                Integer.valueOf(txtPhoneNum.getText()),
                txtAddress.getText()
        );




    }
}
