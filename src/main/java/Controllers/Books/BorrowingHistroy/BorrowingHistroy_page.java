package Controllers.Books.BorrowingHistroy;

import Controllers.Scean.SceneManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;


public class BorrowingHistroy_page implements Initializable {

    BorrowHistoryController borrowHistoryController = new BorrowHistoryController();

    @FXML
    private Button btnAllBooks;

    @FXML
    private Button btnBooks;

    @FXML
    private Button btnBorrowHist;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnLoginOut;

    @FXML
    private Button btnMembers;

    @FXML
    private Button btnSearchBook;

    @FXML
    private TextField txtSearchBook;

    @FXML
    private TableColumn<Map<String, String>, String> ColBookID;

    @FXML
    private TableColumn<Map<String, String>, String> ColBookName;

    @FXML
    private TableColumn<Map<String, String>, String> ColDue_Date;

    @FXML
    private TableColumn<Map<String, String>, String> ColIssue_Date;

    @FXML
    private TableColumn<Map<String, String>, String> ColMember_name;

    @FXML
    private TableColumn<Map<String, String>, String> ColReturn_Date;

    @FXML
    private TableColumn<Map<String, String>, String> ColStatus;

    @FXML
    private TableColumn<Map<String, String>, String> colMemberID;

    @FXML
    private TableView<Map<String, String>> tblBookHistory;

    private ObservableList<Map<String, String>> masterReturnBorrowHistory = FXCollections.observableArrayList();


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

    public void btnBorrowHistOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/BorrowingHist_Page.fxml");

    }

    public void btnLogoutOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/login_page.fxml");

    }

    public void btnSearchBookOnAction(ActionEvent actionEvent) {

    }

    public void initiableColumns() {
        ColBookID.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("book_id", "")));
        ColBookName.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("book_name", "")));
        colMemberID.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("member_id", "")));
        ColMember_name.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("member_name", "")));
        ColIssue_Date.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("issue_date", "")));
        ColDue_Date.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("due_date", "")));
        ColReturn_Date.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("return_date", "")));
        ColStatus.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("status", "")));

    }

    public void loadTable(){
        ObservableList<Map<String, String>> returnBorrowHistoryFromDb = borrowHistoryController.getBookHistoryBooks();
        masterReturnBorrowHistory.setAll(returnBorrowHistoryFromDb);
        tblBookHistory.setItems(masterReturnBorrowHistory);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initiableColumns();
        loadTable();
    }
}