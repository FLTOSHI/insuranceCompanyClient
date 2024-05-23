package edu.fltoshi.insurancecompanyclient.controller;

import edu.fltoshi.insurancecompanyclient.entity.ClientEntity;
import edu.fltoshi.insurancecompanyclient.service.HTTPService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AddClientController {


    @FXML
    private TextField ClientLastnameField;
    @FXML
    private TextField ClientFirstnameField;

    @FXML
    private TextField ClientSurnameField;

    @FXML
    private ChoiceBox<?> ClientOsagoInsuranceCombo;

    @FXML
    private ChoiceBox<?> ClientPropertyInsuranceCombo;

    @FXML
    private ChoiceBox<?> ClientMedicalInsuranceCombo;

    @FXML
    private ChoiceBox<?> ClientLifeInsuranceCombo;

    @FXML
    private ListView<ClientEntity> ClientView;

    @FXML
    private Button DeleteButton;

    @FXML
    private Button EditButton;

    @FXML
    private Button AddButton;

}
