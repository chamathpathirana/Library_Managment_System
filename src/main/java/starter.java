import Controllers.Scean.SceneManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class starter extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        SceneManager.setStage(stage);
        SceneManager.switchPage("/view/login_page.fxml");
    }
}
