import control.MetroButton;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 * Created by ivan on 14-8-14.
 */
public class Test extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    TilePane tilePane = new TilePane();
    tilePane.setHgap(10);
    tilePane.setVgap(10);
    tilePane.setPadding(new Insets(10));
    tilePane.setPrefColumns(2);

    MetroButton
        button1 =
        new MetroButton.Builder().text("登录").size(100, 40).bgColor("#16499a")
            .build();
    button1.setOnClick(e -> {
      System.out.println("ddd");
    });

    tilePane.getChildren().addAll(button1);

    Scene scene = new Scene(tilePane);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
