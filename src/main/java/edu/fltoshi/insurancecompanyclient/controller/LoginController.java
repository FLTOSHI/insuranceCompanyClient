package edu.fltoshi.insurancecompanyclient.controller;

import edu.fltoshi.insurancecompanyclient.MainApplication;
import edu.fltoshi.insurancecompanyclient.entity.UserEntity;
import edu.fltoshi.insurancecompanyclient.service.LoginService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    LoginService service = new LoginService();
    @FXML
    private Button enterButton;

    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    void enterAction(ActionEvent event) throws IOException {
        try {
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(loginField.getText());
            userEntity.setPassword(passwordField.getText());
            service.checkUserData(userEntity);
            MainApplication.workspace("Что-то важное.");

        }catch (Exception e){
        }
        Stage stage = (Stage) enterButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void registrationAction(ActionEvent event) {
        try {
            MainApplication.showDialog("add-user-view.fxml", "Регистрация нового пользователя");
        }catch (Exception e){
        }
    }
}
