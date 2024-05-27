package edu.fltoshi.insurancecompanyclient.controller;

import edu.fltoshi.insurancecompanyclient.entity.InsuranceEntity;
import edu.fltoshi.insurancecompanyclient.entity.UserEntity;
import edu.fltoshi.insurancecompanyclient.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddUserController {

        UserService service = new UserService();

        @FXML
        private Button cancelButton;

        @FXML
        private TextField passwordField;

        @FXML
        private Button saveUser;

        @FXML
        private TextField userNameField;

        @FXML
        void addAction(ActionEvent event) {
                try {
                UserEntity user = new UserEntity();
                user.setUsername(userNameField.getText());
                user.setPassword(passwordField.getText());

                service.add(user);
                userNameField.clear();
                passwordField.clear();
        } catch (Exception e) {
        }
        Stage stage = (Stage) saveUser.getScene().getWindow();
        stage.close();
        saveUser.setText("Добавить");
        }

        @FXML
        void cancelAction(ActionEvent event) {

        }

    }

