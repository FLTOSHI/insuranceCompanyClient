package edu.fltoshi.insurancecompanyclient.service;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.PrintWriter;
import java.io.StringWriter;

public class AlertService extends Application {

    @Override
    public void start(Stage stage) {
        Button button1 = new Button("Показать ошибку");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            }
        });
        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(10);

        root.getChildren().addAll(button1);

        Scene scene = new Scene(root, 450, 250);
        stage.setTitle("JavaFX Error Alert (o7planning.org)");
        stage.setScene(scene);

        stage.show();
    }


    private void showAlertWithHeaderTextError(String whatMistakeStr) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        alert.setX(bounds.getMaxX() - 800);
        alert.setY(bounds.getMaxY() - 650);
        alert.setTitle("Поиск");
        alert.setHeaderText("Результаты поиска: ");
        alert.setContentText(whatMistakeStr);

        alert.showAndWait();
    }

    public void showError(Exception e, String whatMistakeStr) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка!");
        alert.setHeaderText(whatMistakeStr);

        VBox dialogPaneContent = new VBox();

        Label label = new Label("Ошибки:");

        String stackTrace = this.getStackTrace(e);
        TextArea textArea = new TextArea();
        textArea.setText(stackTrace);

        dialogPaneContent.getChildren().addAll(label, textArea);

        alert.getDialogPane().setContent(dialogPaneContent);

        alert.showAndWait();
    }

    public void deleteVoid(Exception e) {
        String whatMistakeStr = "Вы пытаетесь удалить по логике ничего, либо сервер отключен. Выберите объект для удаления, либо проверьте сервер на работоспособность.";
        showError(e, whatMistakeStr);
    }

    public void addVoid(Exception e) {
        String whatMistakeStr = "Ошибка добавления - тип данных пуст или же некоректно ввели данные! Проверьте корректность и повторите снова.";
        showError(e, whatMistakeStr);
    }

    public void serverOffline(Exception e) {
        String whatMistakeStr = "Проблема с серверной частью. Вероятнее всего, сервер попросту не включён.";
        showError(e, whatMistakeStr);
    }

    public void wrongInput(Exception e) {
        String whatMistakeStr = "Ошибка в правильности введённых данных. Проверьте корреткность пароля и имени пользователя.";
        showError(e, whatMistakeStr);
    }

    public void InvalidInput(Exception e) {
        String whatMistakeStr = "Тип введённых данных некоректен. Пожалуйста, проверьте их правильность и повторите снова.";
        showError(e, whatMistakeStr);
    }

    public void wrongUser() {
        String whatMistakeStr = "Пользователя с такими данными нет в базе данных. Проверьте верность ввода и повторите снова.";
        showAlertWithHeaderTextError(whatMistakeStr);
    }

    public String getStackTrace(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        String s = sw.toString();
        return s;
    }


}