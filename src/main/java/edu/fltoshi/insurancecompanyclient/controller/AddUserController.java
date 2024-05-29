package edu.fltoshi.insurancecompanyclient.controller;

import edu.fltoshi.insurancecompanyclient.entity.ClientEntity;
import edu.fltoshi.insurancecompanyclient.entity.ContractEntity;
import edu.fltoshi.insurancecompanyclient.entity.UserEntity;
import edu.fltoshi.insurancecompanyclient.service.AlertService;
import edu.fltoshi.insurancecompanyclient.service.UserService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddUserController {

    private UserService service = new UserService();
    private AlertService alerts = new AlertService();
    private boolean addFlag = true;

    // Получение данных с сервера и их расположение в таблице
    @FXML
    public void initialize() {
        service.getAll();
        userListView.setItems(service.getData());
    }

    // Компоненты интерфейса
    @FXML
    private Button addButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField passwordField;

    @FXML
    private ListView<UserEntity> userListView;

    @FXML
    private TextField usernameField;

    // Действия
    @FXML
    void onMouseClickDataList(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            if (event.getClickCount() == 2) {
                addFlag = false;
                UserEntity temp = getSelectionElement();
                usernameField.setText(temp.getUsername());
                passwordField.setText(temp.getPassword());
                addButton.setText("Изменить");
            }
        }
    }

    private UserEntity getSelectionElement() {
        UserEntity temp = userListView.getSelectionModel().getSelectedItem();
        usernameField.setText(temp.getUsername());
        passwordField.setText(temp.getPassword());
        return temp;
    }

    @FXML
    void AddAction(ActionEvent event) {
        try {
            UserEntity user = new UserEntity();
            user.setUsername(usernameField.getText());
            user.setPassword(passwordField.getText());
            service.add(user);
        } catch (Exception exception) {
            alerts.InvalidInput(exception);
        }
    }

    @FXML
    void CancelAction(ActionEvent event) {
        addFlag = true;
    }

    @FXML
    void DeleteAction(ActionEvent event) {
        try {
            service.delete(getSelectionElement());
            userListView.editableProperty().setValue(false);
        } catch (Exception e) {
            alerts.deleteVoid(e);
        }
    }

}
