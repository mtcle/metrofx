package com.linychuo.metrofx.control.button;


import javafx.scene.Node;
import javafx.scene.control.Button;

/**
 * Created by ivan on 14-8-14.
 */
public class MetroButton extends Button {

  private String color;

  public MetroButton(String text) {
    super(text);
    this.color = "#16499a";
    initStyle();
  }

  public MetroButton(String text, String color) {
    super(text);
    this.color = color;
    initStyle();
  }

  public MetroButton(String text, String color, Node graphic) {
    super(text, graphic);
    this.color = color;
    initStyle();
  }

  private void initStyle() {
    getStylesheets().add(getClass().getResource("button.css").toExternalForm());
    styleProperty().set("-fx-background-color:" + color);
  }

}
