package Controllers.Books.AddBook;

import Controllers.Scean.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddBookPageController implements Initializable {

    AddBookController addBookController = new AddBookController();

    @FXML
    public TextField txtQuantity;

    @FXML
    private Button btnAddBook;

    @FXML
    private Button btnExit;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBookID;

    @FXML
    private TextField txtBookTitle;


    @FXML
    private ComboBox<String> txtCategory;

    @FXML
    private TextField txtPublishedYear;

    @FXML
    void btnAddBookOnAction(ActionEvent event) {
        addBookController.addBooks(
                txtBookID.getText(),
                txtBookTitle.getText(),
                txtAuthor.getText(),
                txtCategory.getValue().toString(),
                Integer.parseInt(txtQuantity.getText()),
                txtPublishedYear.getText()

        );
        txtBookID.setText(addBookController.genarateBookId());
        txtBookID.setEditable(false);


    }
    @FXML
    void btnExitOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/books_page.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtBookID.setText(addBookController.genarateBookId());
        txtBookID.setEditable(false);

        ObservableList<String> cmbList = FXCollections.observableArrayList();
        cmbList.add("Love Story");
        cmbList.add("Adventure");
        cmbList.add("Fantasy");
        cmbList.add("Childern");
        cmbList.add("18 Plus");
        cmbList.add("Computer Scienece");
        cmbList.add("Programming");

        txtCategory.setItems(cmbList);
    }

    public void btnHomeOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/home_page.fxml");
    }

    public void btnMemberOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/AddMembers_page.fxml");

    }

    public void btnBooksOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/books_page.fxml");
    }

    public void btnAllBooksOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/AllBooks_page.fxml");
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/login_page.fxml");
    }
}
