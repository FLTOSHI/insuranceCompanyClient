package edu.fltoshi.insurancecompanyclient.controller;

import edu.fltoshi.insurancecompanyclient.entity.InsuranceEntity;
import edu.fltoshi.insurancecompanyclient.service.AlertService;
import edu.fltoshi.insurancecompanyclient.service.InsuranceService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import static edu.fltoshi.insurancecompanyclient.MainApplication.tempUser;
import static edu.fltoshi.insurancecompanyclient.MainApplication.userAdmin;

public class AddInsuranceController {

    InsuranceService insuranceService = new InsuranceService();
    AlertService alerts = new AlertService();
    private boolean addFlag = true;

    @FXML
    private void initialize() {
        // Проверка роли пользователя
        if (userAdmin.equals(tempUser)) {
            InsuranceAddButton.setVisible(true);
            InsuranceDeleteButton.setVisible(true);
        } else {
            InsuranceAddButton.setVisible(false);
            InsuranceDeleteButton.setVisible(false);
        }

        // Получение данных с сервера и расположение их в списке
        insuranceService.getAll();
        InsuranceListView.setItems(insuranceService.getData());
    }


    // Компоненты интерфейса
    @FXML
    private Button InsuranceAddButton;

    @FXML
    public Button InsuranceDeleteButton;

    @FXML
    private Button InsuranceCancelButton;

    @FXML
    private ListView<InsuranceEntity> InsuranceListView;

    @FXML
    private TextField InsuranceNameField;

    @FXML
    private TextField InsuranceCostField;

    // Действия
    @FXML
    void onMouseClickDataList(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            if (event.getClickCount() == 2) {
                addFlag = false;
                InsuranceEntity temp = getSelectionElement();
                InsuranceNameField.setText(temp.getName());
                InsuranceCostField.setText(String.valueOf(temp.getCost()));
                InsuranceAddButton.setText("Изменить");
            }
        }
    }

    private InsuranceEntity getSelectionElement() {
        InsuranceEntity temp = InsuranceListView.getSelectionModel().getSelectedItem();
        return temp;
    }

    @FXML
    void CancelAction(ActionEvent event) {
        addFlag = true;
    }

    @FXML
    void InsuranceDeleteAction(ActionEvent event) {
        try {
            insuranceService.delete(getSelectionElement());
            InsuranceNameField.clear();
            InsuranceCostField.clear();
        } catch (Exception exception) {
            alerts.deleteVoid(exception);
        }
    }

    @FXML
    void addInsuranceAction(ActionEvent event) {
        try {
            InsuranceEntity insurance = new InsuranceEntity();
            insurance.setName(InsuranceNameField.getText());
            insurance.setCost(Integer.valueOf(InsuranceCostField.getText()));
            if (addFlag) {
                insuranceService.add(insurance);
            } else {
                insurance.setId(getSelectionElement().getId());
                insuranceService.update(insurance, getSelectionElement());
            }
            InsuranceNameField.clear();
        } catch (Exception exception) {
            alerts.addVoid(exception);
        }
        Stage stage = (Stage) InsuranceAddButton.getScene().getWindow();
        stage.close();
        InsuranceAddButton.setText("Добавить");
    }
}
