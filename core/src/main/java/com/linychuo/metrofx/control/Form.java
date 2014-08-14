package com.linychuo.metrofx.control;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * Created by ivan on 14-8-14.
 */
public abstract class Form {

  public abstract Pane build();

  public void validate(TextField txtField) {
    txtField.textProperty().addListener(new ChangeListener<String>() {
      @Override
      public void changed(ObservableValue<? extends String> observable, String oldValue,
                          String newValue) {
        if (newValue.trim().equals("")) {
          txtField.setStyle("-fx-border-color:red;");
        } else {
          txtField.setStyle("-fx-border-color:#d9d9d9");
        }
      }
    });
  }
}
