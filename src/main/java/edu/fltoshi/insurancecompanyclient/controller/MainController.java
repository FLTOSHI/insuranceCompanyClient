package edu.fltoshi.insurancecompanyclient.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MainController {

    @FXML
    private TableColumn<?, ?> ClientLastnameColumn;

    @FXML
    private TableColumn<?, ?> ClientLifeColumn;

    @FXML
    private TableColumn<?, ?> ClientMedicalColumn;

    @FXML
    private TableColumn<?, ?> ClientNameColumn;

    @FXML
    private TableColumn<?, ?> ClientOSAGOColumn;

    @FXML
    private TableColumn<?, ?> ClientPropertyColumn;

    @FXML
    private TableColumn<?, ?> ClientSurnameColumn;

    @FXML
    private TableView<?> ClientTable;

    @FXML
    private Button AddButton;

    @FXML
    private Button EditButton;

    @FXML
    private Button DeleteButton;


}
