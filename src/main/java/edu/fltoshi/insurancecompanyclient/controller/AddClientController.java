package edu.fltoshi.insurancecompanyclient.controller;

import edu.fltoshi.insurancecompanyclient.entity.ClientEntity;
import edu.fltoshi.insurancecompanyclient.entity.ContractEntity;
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
    private boolean addFlag;

    @FXML
    private void initialize(){
        service.getAll();
        ClientView.setItems(service.getData());
        ClientLifeCombo.setItems(service.getData());
        ClientMedicalCombo.setItems(service.getData());
        ClientOsagoCombo.setItems(service.getData());
        ClientPropertyCombo.setItems(service.getData());
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
//        ClientOsagoCombo.setItems(temp.getOsago());
//        ClientPropertyCombo.setItems(temp.getProperty());
//        ClientMedicalCombo.setItems(temp.getMedical());
//        ClientLifeCombo.setItems(temp.getLife());
        return temp;
    }

}
