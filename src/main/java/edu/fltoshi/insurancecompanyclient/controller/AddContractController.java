package edu.fltoshi.insurancecompanyclient.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AddContractController {

    @FXML
    private ComboBox<?> ClientBox;

    @FXML
    private Button ContractAddButton;

    @FXML
    private Button ContractDeleteButton;

    @FXML
    private Button ContractEditButton;

    @FXML
    private ListView<?> ContractListView;

    @FXML
    private TextField ContractTimelapseField;

    @FXML
    private ComboBox<?> InsuranceTypeBox;

}
