package com.linychuo.metrofx.control.dialog;

import com.linychuo.metrofx.control.MetroConfig;
import com.linychuo.metrofx.control.button.MetroButton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by ivan on 14-8-14.
 */
public class AlertDialog implements MetroConfig {

  private Stage stage;

  private AlertDialog(String title, String msg, int width, int height) {
    stage = new Stage();
    stage.initStyle(StageStyle.UNDECORATED);
    stage.initModality(Modality.APPLICATION_MODAL);

    VBox vBox = new VBox();
    vBox.setSpacing(0);
    vBox.setStyle("-fx-background-color:#6badf6");

    AnchorPane caption = new AnchorPane();
    caption.setPrefHeight(CAPTION_HEIGHT);

    Label captionTitle = new Label(title);
    AnchorPane.setTopAnchor(captionTitle, 5.0);
    AnchorPane.setLeftAnchor(captionTitle, MARGIN);
    caption.getChildren().addAll(captionTitle);

    Button closeBtn = new Button("X");
    closeBtn.setPrefSize(48, 24);
    closeBtn.setMinHeight(24);
    closeBtn.setTextFill(Color.WHITE);
    closeBtn.setStyle(";-fx-background-color:#c75050;-fx-background-radius: 0;-fx-cursor:hand");
    AnchorPane.setRightAnchor(closeBtn, MARGIN);
    closeBtn.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        stage.close();
      }
    });
    caption.getChildren().add(closeBtn);

    StackPane content = new StackPane();
    Rectangle bg = new Rectangle(width - MARGIN * 2, height - CAPTION_HEIGHT);
    bg.setFill(Color.web("#fff"));

    AnchorPane msgPane = new AnchorPane();
    Label msgTxt = new Label(msg);
    msgTxt.setStyle("-fx-font-size:20");
    AnchorPane.setLeftAnchor(msgTxt, 20.0);
    AnchorPane.setTopAnchor(msgTxt, 20.0);
    msgPane.getChildren().add(msgTxt);

    MetroButton closeBtnAgain = new MetroButton("确定");
    closeBtnAgain.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        stage.close();
      }
    });
    AnchorPane.setBottomAnchor(closeBtnAgain, 20.0);
    AnchorPane.setRightAnchor(closeBtnAgain, 20.0);
    msgPane.getChildren().add(closeBtnAgain);

    VBox.setMargin(content, new Insets(0, MARGIN, MARGIN, MARGIN));
    content.getChildren().addAll(bg, msgPane);

    vBox.getChildren().addAll(caption, content);
    Scene scene = new Scene(vBox, width, height);

    stage.setScene(scene);
    stage.setTitle(title);
  }

  public void show() {
    stage.centerOnScreen();
    stage.show();
  }


  public static class Builder {

    private String title = "alert";
    private String msg = "alert";
    private int width = 400;
    private int height = 200;

    public Builder setTitle(String title) {
      this.title = title;
      return this;
    }

    public Builder setMsg(String msg) {
      this.msg = msg;
      return this;
    }

    public Builder setWidth(int width) {
      this.width = width;
      return this;
    }

    public Builder setHeight(int height) {
      this.height = height;
      return this;
    }

    public AlertDialog build() {
      AlertDialog dialog = new AlertDialog(title, msg, width, height);
      return dialog;
    }
  }
}
