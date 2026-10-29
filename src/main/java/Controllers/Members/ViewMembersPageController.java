package Controllers.Members;

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
    private Button btnExit;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnMembers;

    @FXML
    private Button btnSearch;

    @FXML
    private TextField txtSearchMember;

    private ObservableList<Map<String, String>> masterMemberList = FXCollections.observableArrayList();

    @FXML
    void btnAddMemberOnAction(ActionEvent event) {
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
    void btnExitOnAction(ActionEvent event) {
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

    @FXML
    void btnMembersOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/ViewMembers_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

        Stage errorStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        errorStage.close();


    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

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
        ObservableList<Map<String, String>> MemberFromDb = ViewMemberController.getAllMembers();
        masterMemberList.setAll(MemberFromDb);
        tblMembers.setItems(masterMemberList);
    }
}
