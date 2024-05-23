package edu.fltoshi.insurancecompanyclient.controller;

import edu.fltoshi.insurancecompanyclient.entity.ClientEntity;
import edu.fltoshi.insurancecompanyclient.service.ClientService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddClientController {
    private final ClientService service = new ClientService();

    @FXML
    private void initialize(){
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
    private ComboBox<ClientEntity> ClientLifeCombo;

    @FXML
    private ComboBox<ClientEntity> ClientMedicalCombo;

    @FXML
    private ComboBox<ClientEntity> ClientOsagoCombo;

    @FXML
    private ComboBox<ClientEntity> ClientPropertyCombo;

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
        ClientEntity client = new ClientEntity();
        client.setLastname(ClientLastnameField.getText());
        client.setName(ClientFirstnameField.getText());
        client.setSurname(ClientSurnameField.getText());
        client.setOsago(ClientOsagoCombo.getSelectionModel().getSelectedItem().getOsago());
        client.setProperty(ClientPropertyCombo.getSelectionModel().getSelectedItem().getProperty());
        client.setMedical(ClientMedicalCombo.getSelectionModel().getSelectedItem().getMedical());
        client.setLife(ClientLifeCombo.getSelectionModel().getSelectedItem().getLife());
        service.add(client);
    }

    @FXML
    void DeleteAction(ActionEvent event) {
    }

    @FXML
    void EditAction(ActionEvent event) {
    }
}
