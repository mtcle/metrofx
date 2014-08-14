package com.linychuo.metrofx.control.button;


import javafx.scene.Node;

/**
 * Created by ivan on 14-8-14.
 */
public class Button extends javafx.scene.control.Button {

  private String color;

  public Button(String text) {
    super(text);
    this.color = "#16499a";
    initStyle();
  }

  public Button(String text, String color) {
    super(text);
    this.color = color;
    initStyle();
  }

  public Button(String text, String color, Node graphic) {
    super(text, graphic);
    this.color = color;
    initStyle();
  }

  private void initStyle() {
    getStylesheets().add(getClass().getResource("button.css").toExternalForm());
    setStyle("-fx-background-color:" + color);
  }
}
