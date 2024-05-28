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
    private boolean addFlag = true;

    @FXML
    private void initialize() {
        service.getAll();
        ClientView.setItems(service.getData());
    }

    @FXML
    private TextField ClientLastnameField;
    @FXML
    private TextField ClientFirstnameField;

    @FXML
    private TextField ClientSurnameField;

    @FXML
    private CheckBox ClientLifeCheck;

    @FXML
    private CheckBox ClientMedicalCheck;

    @FXML
    private CheckBox ClientOsagoCheck;

    @FXML
    private CheckBox ClientPropertyCheck;

    @FXML
    private ListView<ClientEntity> ClientView;

    @FXML
    private Button DeleteButton;

    @FXML
    private Button CancelButton;

    @FXML
    private Button AddButton;

    @FXML
    void AddAction(ActionEvent event) {
        try {
            ClientEntity client = new ClientEntity();
            client.setLastname(ClientLastnameField.getText());
            client.setName(ClientFirstnameField.getText());
            client.setSurname(ClientSurnameField.getText());
            client.setOsago(ClientOsagoCheck.isSelected());
            client.setProperty(ClientPropertyCheck.isSelected());
            client.setMedical(ClientMedicalCheck.isSelected());
            client.setLife(ClientLifeCheck.isSelected());
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
    void CancelAction(ActionEvent event) {
        addFlag = true;
    }

    @FXML
    void onMouseClickDataList(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            if (event.getClickCount() == 2) {
                addFlag = false;
                ClientEntity temp = getSelectionElement();
                ClientLastnameField.setText(temp.getLastname());
                ClientFirstnameField.setText(temp.getName());
                ClientSurnameField.setText(temp.getSurname());
                ClientMedicalCheck.setSelected(temp.getMedical());
                ClientPropertyCheck.setSelected(temp.getProperty());
                ClientOsagoCheck.setSelected(temp.getOsago());
                ClientLifeCheck.setSelected(temp.getLife());
                AddButton.setText("Изменить");
            }
        }
    }

    private ClientEntity getSelectionElement() {
        ClientEntity temp = ClientView.getSelectionModel().getSelectedItem();
        ClientLastnameField.setText(temp.getLastname());
        ClientFirstnameField.setText(temp.getName());
        ClientSurnameField.setText(temp.getSurname());
        ClientLifeCheck.setSelected(temp.getLife());
        ClientOsagoCheck.setSelected(temp.getOsago());
        ClientMedicalCheck.setSelected(temp.getMedical());
        ClientPropertyCheck.setSelected(temp.getProperty());
        return temp;
    }
}
