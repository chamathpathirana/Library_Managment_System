package Controllers.Members;

import Controllers.Scean.SceneManager;
import Controllers.model.MemberDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddMembersPageController implements Initializable {
    AddMemberController addMemberController = new AddMemberController();

    @FXML
    private Button btnClear;

    @FXML
    private Button btnRegister;

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


        MemberDTO memberDTO = new MemberDTO();

                memberDTO.setAddress(txtMemberId.getText());
                memberDTO.setFullname(txtFullName.getText());
                memberDTO.setEmail(txtEmail.getText());
                memberDTO.setPhoneNumber(Integer.parseInt(txtPhoneNum.getText()));
                memberDTO.setAddress(txtAddress.getText());
                memberDTO.setMemberID(addMemberController.genarateMemberID());


                txtMemberId.setText(memberDTO.getMemberID());

                addMemberController.addMembers(memberDTO);

        txtMemberId.setEditable(false);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtMemberId.setText(addMemberController.genarateMemberID());
        txtMemberId.setEditable(false);
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
