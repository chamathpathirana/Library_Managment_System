package Controllers.Home;

import Controllers.Scean.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class homepageController {

    @FXML
    private Button btnBooks;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnMembers;

    @FXML
    private Button btnAllBooks;

    //=================btnBooks eka create================

    @FXML
    void btnBooksOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/books_page.fxml");

    }

    //================Homebutton eka create===================
    @FXML
    void btnHomeOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/home_page.fxml");


    }

//=====================LogOut button eka create ========================
    @FXML
    void btnLogOutOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/login_page.fxml");
    }

//=====================Member button eka create========================
    @FXML
    void btnMemberOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/ViewMembers_page.fxml");

    }

    public void btnBorrowHisOnAction(ActionEvent actionEvent) {
    }



    public void btnAllBooksOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/AllBooks_page.fxml");

    }
}
