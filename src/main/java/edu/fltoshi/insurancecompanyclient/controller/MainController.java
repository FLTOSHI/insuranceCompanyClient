package edu.fltoshi.insurancecompanyclient.controller;

import edu.fltoshi.insurancecompanyclient.MainApplication;
import edu.fltoshi.insurancecompanyclient.entity.ClientEntity;
import edu.fltoshi.insurancecompanyclient.service.ClientService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {
    ClientService service = new ClientService();

    @FXML
    private void initialize() {
        //получаем все книги с сервера
        service.getAll();
        //связываем поля таблицы со столбцами
        ClientLastnameColumn.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        ClientNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ClientSurnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        ClientOSAGOColumn.setCellValueFactory(new PropertyValueFactory<>("osago"));
        ClientPropertyColumn.setCellValueFactory(new PropertyValueFactory<>("property"));
        ClientMedicalColumn.setCellValueFactory(new PropertyValueFactory<>("medical"));
        ClientLifeColumn.setCellValueFactory(new PropertyValueFactory<>("life"));

        ClientTable.setItems(service.getData());
    }

    @FXML
    private TableColumn<ClientEntity, String> ClientLastnameColumn;

    @FXML
    private TableColumn<ClientEntity, String> ClientLifeColumn;

    @FXML
    private TableColumn<ClientEntity, String> ClientMedicalColumn;

    @FXML
    private TableColumn<ClientEntity, String> ClientNameColumn;

    @FXML
    private TableColumn<ClientEntity, String> ClientOSAGOColumn;

    @FXML
    private TableColumn<ClientEntity, String> ClientPropertyColumn;

    @FXML
    private TableColumn<ClientEntity, String> ClientSurnameColumn;

    @FXML
    private TableView<ClientEntity> ClientTable;

    @FXML
    private MenuItem ContractWork;

    @FXML
    private MenuItem InsuranceWork;

    @FXML
    private Button AddButton;

    @FXML
    void AddNewClientAction(ActionEvent event) {
        MainApplication.showClientDialog();
    }

        @FXML
    private Button EditButton;

    @FXML
    private Button DeleteButton;


    @FXML
    void insuranceOpen(ActionEvent event) {
        MainApplication.showDialog("add-insurance-view.fxml", "Работа с видами страхования");

    }
    @FXML
    void contractOpen(ActionEvent event) {
        MainApplication.showDialog("add-contract-view.fxml", "Работа с договорами");

    }
}


