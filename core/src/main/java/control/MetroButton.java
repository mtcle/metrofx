package control;


import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import util.MetroColor;

/**
 * Created by ivan on 14-8-13.
 */
public class MetroButton extends StackPane {

  private static final String
      FONT_FAMILY =
      "'Segoe UI Light_', 'Open Sans Light', Verdana, Arial, Helvetica, sans-serif";


  private MetroButton(String showText, double fontSize, Image image, int width, int height,
                      String webColorVal) {

    setPadding(new Insets(2));
    setStyle("-fx-background-color:" + webColorVal);
    setPrefSize(width, height);
    setMaxHeight(height);
    setMaxWidth(width);
    setAlignment(Pos.CENTER);

    Rectangle bg = new Rectangle(width - 2, height - 2);
    bg.setFill(Color.web(webColorVal));
    getChildren().add(bg);

    if (showText != null) {
      Label label = new Label(showText);
      label.setPadding(new Insets(2));
      label.setWrapText(true);
      label.setTextFill(Color.WHITE);
      label.setFont(Font.font(FONT_FAMILY, fontSize));
      getChildren().add(label);
      if (image != null) {
        setAlignment(label, Pos.BOTTOM_LEFT);
        setMargin(label, new Insets(0, 0, 5, 5));
      }
    }

    if (image != null) {
      ImageView imgView = new ImageView(image);
      getChildren().add(imgView);
    }

    setOnMouseEntered(e -> {
      setStyle("-fx-background-color:#CCC;");
      setCursor(Cursor.HAND);
    });
    setOnMouseExited(e -> {
      setStyle("-fx-background-color:" + webColorVal);
    });

  }

  public void setOnClick(EventHandler<? super MouseEvent> value) {
    onMousePressedProperty().set(value);
  }

  public static class Builder {

    private String showText;
    private Image image;
    private int width = 71;
    private int height = 26;
    private String webColorVal;
    private double fontSize = 14;

    public MetroButton build() {
      if (webColorVal == null) {
        webColorVal = MetroColor.color();
      }
      return new MetroButton(showText, fontSize, image, width, height, webColorVal);
    }

    public Builder text(String showText) {
      this.showText = showText;
      return this;
    }

    public Builder image(Image image) {
      this.image = image;
      return this;
    }

    public Builder size(int width, int height) {
      this.width = width;
      this.height = height;
      return this;
    }

    public Builder large() {
      this.fontSize = 17.5;
      return size(86, 40);
    }

    public Builder small() {
      this.fontSize = 11.9;
      return size(53, 22);
    }

    public Builder mini() {
      this.fontSize = 10.5;
      return size(33, 18);
    }

    public Builder fontSize(double fontSize) {
      this.fontSize = fontSize;
      return this;
    }

    public Builder bgColor(String webColorVal) {
      this.webColorVal = webColorVal;
      return this;
    }

  }
}
