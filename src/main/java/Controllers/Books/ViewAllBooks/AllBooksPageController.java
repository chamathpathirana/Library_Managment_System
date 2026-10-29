package Controllers.Books.ViewAllBooks;

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

public class AllBooksPageController implements Initializable {

    AllBooksController allBooksController = new AllBooksController();

    @FXML
    private TableColumn<Map<String, String>, String> ColAuthor;

    @FXML
    private TableColumn<Map<String, String>, String> ColBookID;

    @FXML
    private TableColumn<Map<String, String>, String> ColBookName;

    @FXML
    private TableColumn<Map<String, String>, String> ColCategory;

    @FXML
    private TableColumn<Map<String, String>, String> ColPublishedYear;

    @FXML
    private TableColumn<Map<String, String>, String> ColQuantity;

    @FXML
    private Button btnAddBook;

    @FXML
    private Button btnAllBooks;

    @FXML
    private Button btnBooks;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnLoginOut;

    @FXML
    private Button btnMembers;

    @FXML
    private Button btnSearchBook;

    @FXML
    private TableView<Map<String, String>> tblAllBooks;

    @FXML
    private TextField txtSearchBook;

    private ObservableList<Map<String, String>> masterBookList = FXCollections.observableArrayList();

    @FXML
    void btnAddBookOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/AddBook_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

        Stage errorStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        errorStage.close();


    }

    @FXML
    void btnAllBooksOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/AllBooks_page.fxml"))));
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
    void btnLogoutOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/login_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

        Stage errorStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        errorStage.close();

    }

    @FXML
    void btnMemberOnAction(ActionEvent event) {
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
    void btnSearchBookOnAction(ActionEvent event) {

    }

    public  void initiableColumns(){
        ColBookID.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("book_id","")));
        ColBookName.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("Book_name", "")));
        ColAuthor.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("author", "")));
        ColCategory.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("category","")));
        ColQuantity.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("quantity", "")));
        ColPublishedYear.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrDefault("published_year", "")));

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initiableColumns();
        loadBooks();
    }

    private void loadBooks() {
        ObservableList<Map<String, String>> bookFromDB = AllBooksController.getAllBooks();
        masterBookList.setAll(bookFromDB);
        tblAllBooks.setItems(masterBookList);
    }
}

