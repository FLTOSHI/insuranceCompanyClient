package edu.fltoshi.insurancecompanyclient.controller;

import edu.fltoshi.insurancecompanyclient.MainApplication;
import edu.fltoshi.insurancecompanyclient.service.AlertService;
import edu.fltoshi.insurancecompanyclient.service.LoginService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static edu.fltoshi.insurancecompanyclient.MainApplication.*;

public class LoginController {

    LoginService service = new LoginService();
    AlertService alerts = new AlertService();
    @FXML
    private Button enterButton;

    @FXML
    private Button registrationButton;

    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    void enterAction(ActionEvent event) throws IOException {
        try {
            userAdmin.setUsername("superadmin");
            userAdmin.setPassword("megapasswordishe");
            tempUser.setUsername(loginField.getText());
            tempUser.setPassword(passwordField.getText());
            service.checkUserData(tempUser);
        }catch (Exception e){
            alerts.wrongInput(e);
            MainApplication.showDialog("login-view.fxml", "Авторизация в систему");
        }
        Stage stage = (Stage) enterButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void registrationAction(ActionEvent event) {
        try {
            MainApplication.showDialog("add-registration-user-view.fxml", "Регистрация нового пользователя");
        } catch (Exception e) {
            alerts.InvalidInput(e);
        }
    }
}