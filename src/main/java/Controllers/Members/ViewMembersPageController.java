package Controllers.Members;

import Controllers.Scean.SceneManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class ViewMembersPageController implements Initializable {

    ViewMemberController viewMemberController = new ViewMemberController();

    @FXML
    private TableColumn<Map<String, String>, String> colMemberAddress;

    @FXML
    private TableColumn<Map<String, String>, String> colMemberEmail;

    @FXML
    private TableColumn<Map<String, String>, String> colMemberID;

    @FXML
    private TableColumn<Map<String, String>, String> colMemberName;

    @FXML
    private TableColumn<Map<String, String>, String> colMemberPhNumber;

    @FXML
    private TableView<Map<String, String>> tblMembers;

    @FXML
    private Button btnAddMember;

    @FXML
    private Button btnBooks;

    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnMembers;

    @FXML
    private Button btnMemberSearch;

    @FXML
    private TextField txtSearchMember;

    @FXML
    private Button btnAllBooks;

    @FXML
    private Button btnBorrowHist;

    private ObservableList<Map<String, String>> masterMemberList = FXCollections.observableArrayList();

    @FXML
    void btnAddMemberOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/AddMembers_page.fxml");

    }

    @FXML
    void btnBooksOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/books_page.fxml");

    }



    @FXML
    void btnHomeOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/home_page.fxml");


    }

    @FXML
    void btnMembersOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/ViewMembers_page.fxml");

    }



    public void initializeColumns(){
        colMemberID.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("member_id", "" )));
        colMemberName.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("member_name", "")));
        colMemberEmail.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("email","")));
        colMemberPhNumber.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("phone_number","")));
        colMemberAddress.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("address", "")));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeColumns();
        loadMember();
        
    }

    private void loadMember() {
        ObservableList<Map<String, String>> MemberFromDb = viewMemberController.getAllMembers();
        masterMemberList.setAll(MemberFromDb);
        tblMembers.setItems(masterMemberList);
    }

    public void btnMemberSearchOnAction(ActionEvent actionEvent) {

    }

    public void btnBorrowHistOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/BorrowingHist_Page.fxml");
    }

    public void btnAllBooksOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/AllBooks_page.fxml");

    }

    public void btnLogOutOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/login_page.fxml");

    }
}
