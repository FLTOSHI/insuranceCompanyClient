package edu.fltoshi.insurancecompanyclient.controller;

import edu.fltoshi.insurancecompanyclient.entity.UserEntity;
import edu.fltoshi.insurancecompanyclient.service.AlertService;
import edu.fltoshi.insurancecompanyclient.service.LoginService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddUserController {
    @FXML
    private Button cancelButton;
    @FXML
    private Button saveUser;
    @FXML
    private TextField passwordField;

    @FXML
    private TextField userNameField;

    private final AlertService alerts = new AlertService();
    LoginService service = new LoginService();

    @FXML
    void addAction(ActionEvent event) {
        try {
            UserEntity users = new UserEntity();
            users.setUsername(userNameField.getText());
            users.setPassword(passwordField.getText());
            service.add(users);
        } catch (Exception e) {
            alerts.InvalidInput(e);
        }
        Stage stage = (Stage) saveUser.getScene().getWindow();
        stage.close();
    }

    @FXML
    void cancelAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}