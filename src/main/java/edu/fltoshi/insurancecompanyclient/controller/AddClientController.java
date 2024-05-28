package edu.fltoshi.insurancecompanyclient.controller;

import edu.fltoshi.insurancecompanyclient.entity.ClientEntity;
import edu.fltoshi.insurancecompanyclient.entity.ContractEntity;
import edu.fltoshi.insurancecompanyclient.service.AlertService;
import edu.fltoshi.insurancecompanyclient.service.ClientService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class AddClientController {
    private final ClientService service = new ClientService();

    private AlertService alerts = new AlertService();

    private boolean booleanVariable = true;
    private boolean addFlag = false;

    @FXML
    private void initialize(){
        service.getAll();
        ClientView.setItems(service.getData());
        ClientLifeCombo.getItems().addAll("Есть", "Нет");
        ClientLifeCombo.setValue("Нет");
        ClientLifeCombo.valueProperty().addListener((observable, oldValue, newValue) -> {
            if ("Есть".equals(newValue)) {
                booleanVariable = true;
            } else if ("Нет".equals(newValue)) {
                booleanVariable = false;
            }
        });

        ClientMedicalCombo.getItems().addAll("Есть", "Нет");
        ClientMedicalCombo.setValue("Нет");
        ClientMedicalCombo.valueProperty().addListener((observable, oldValue, newValue) -> {
            if ("Есть".equals(newValue)) {
                booleanVariable = true;
            } else if ("Нет".equals(newValue)) {
                booleanVariable = false;
            }
        });

        ClientOsagoCombo.getItems().addAll("Есть", "Нет");
        ClientOsagoCombo.setValue("Нет");
        ClientOsagoCombo.valueProperty().addListener((observable, oldValue, newValue) -> {
            if ("Есть".equals(newValue)) {
                booleanVariable = true;
            } else if ("Нет".equals(newValue)) {
                booleanVariable = false;
            }
        });

        ClientPropertyCombo.getItems().addAll("Есть", "Нет");
        ClientPropertyCombo.setValue("Нет");
        ClientPropertyCombo.valueProperty().addListener((observable, oldValue, newValue) -> {
            if ("Есть".equals(newValue)) {
                booleanVariable = true;
            } else if ("Нет".equals(newValue)) {
                booleanVariable = false;
            }
        });
    }

    @FXML
    private TextField ClientLastnameField;
    @FXML
    private TextField ClientFirstnameField;

    @FXML
    private TextField ClientSurnameField;

    @FXML
    private ComboBox<String> ClientLifeCombo;

    @FXML
    private ComboBox<String> ClientMedicalCombo;

    @FXML
    private ComboBox<String> ClientOsagoCombo;

    @FXML
    private ComboBox<String> ClientPropertyCombo;

    @FXML
    private ListView<ClientEntity> ClientView;

    @FXML
    private Button DeleteButton;

    @FXML
    private Button EditButton;

    @FXML
    private Button AddButton;

    @FXML
    void AddAction(ActionEvent event) {
        try {
            ClientEntity client = new ClientEntity();
            client.setLastname(ClientLastnameField.getText());
            client.setName(ClientFirstnameField.getText());
            client.setSurname(ClientSurnameField.getText());
            client.setOsago(Boolean.valueOf(ClientOsagoCombo.getValue()));
            client.setMedical(Boolean.valueOf(ClientOsagoCombo.getValue()));
            client.setProperty(Boolean.valueOf(ClientOsagoCombo.getValue()));
            client.setLife(Boolean.valueOf(ClientOsagoCombo.getValue()));

            service.add(client);
        } catch (Exception e) {
            alerts.addVoid(e);
        }
    }

    @FXML
    void DeleteAction(ActionEvent event) {
        try {
            service.delete(getSelectionElement());
            ClientView.editableProperty().setValue(false);
        } catch (Exception e) {
            alerts.deleteVoid(e);
        }
    }

    @FXML
    void EditAction(ActionEvent event) {
    }

    @FXML
    void onMouseClickDataList(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)){
            if (event.getClickCount() == 2){
                addFlag = false;
                ClientEntity temp = getSelectionElement();
            }
        }
    }

    private ClientEntity getSelectionElement(){
        ClientEntity temp = ClientView.getSelectionModel().getSelectedItem();
        ClientLastnameField.setText(temp.getLastname());
        ClientFirstnameField.setText(temp.getName());
        ClientSurnameField.setText(temp.getSurname());
//        ClientOsagoCombo.(Boolean.valueOf(ClientOsagoCombo.getValue()));
//        .setMedical(Boolean.valueOf(ClientOsagoCombo.getValue()));
//        client.setProperty(Boolean.valueOf(ClientOsagoCombo.getValue()));
//        client.setLife(Boolean.valueOf(ClientOsagoCombo.getValue()));
        return temp;
    }
}
