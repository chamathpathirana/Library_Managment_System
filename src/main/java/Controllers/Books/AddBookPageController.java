package Controllers.Books;

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

        txtCategory.setItems(cmbList);
    }
}
