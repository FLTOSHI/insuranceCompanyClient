package edu.fltoshi.insurancecompanyclient;

import edu.fltoshi.insurancecompanyclient.controller.LoginController;
import edu.fltoshi.insurancecompanyclient.controller.MainController;
import edu.fltoshi.insurancecompanyclient.entity.UserEntity;
import edu.fltoshi.insurancecompanyclient.service.LoginService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

public class MainApplication extends Application {
    private static MainController mainController = new MainController();
    @Getter
    @Setter
    private static LoginController loginController;

    @Getter
    @Setter
    public static UserEntity tempUser = new UserEntity();

    @Getter
    @Setter
    public static UserEntity userAdmin = new UserEntity();


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 300);
        stage.setTitle("Авторизация");
        stage.setScene(scene);
        stage.show();
    }

    public static void workspace(String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.initModality(Modality.WINDOW_MODAL);
        Scene scene = new Scene(fxmlLoader.load(), 1280, 768);

        stage.setScene(scene);
        mainController = fxmlLoader.getController();
        stage.show();
    }

    public static void showDialog(String nameView, String title) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApplication.class.getResource(nameView));
            AnchorPane page = loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle(title);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}