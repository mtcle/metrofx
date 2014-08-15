import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by ivan on 14-8-15.
 */
public class TestStage extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {

    VBox vBox = new VBox();
    vBox.setSpacing(0);
    vBox.setStyle("-fx-background-color:#6badf6");

    Scene scene = new Scene(vBox, 300, 200);
    primaryStage.setScene(scene);
    primaryStage.centerOnScreen();
    primaryStage.show();
  }
}
