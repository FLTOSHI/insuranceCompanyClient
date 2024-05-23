package edu.fltoshi.insurancecompanyclient.controller;

import edu.fltoshi.insurancecompanyclient.entity.ClientEntity;
import edu.fltoshi.insurancecompanyclient.service.ClientService;
import edu.fltoshi.insurancecompanyclient.service.HTTPService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {
    ClientService service = new ClientService();

    @FXML
    private void initialize(){
        //получаем все книги с сервера
        service.getAll();
        //связываем поля таблицы со столбцами
        ClientLastnameColumn.setCellValueFactory(new PropertyValueFactory<ClientEntity, String>("lastname"));
        ClientNameColumn.setCellValueFactory(new PropertyValueFactory<ClientEntity, String>("name"));
        ClientSurnameColumn.setCellValueFactory(new PropertyValueFactory<ClientEntity, String>("surname"));
        ClientOSAGOColumn.setCellValueFactory(new PropertyValueFactory<ClientEntity, String>("osago"));
        ClientPropertyColumn.setCellValueFactory(new PropertyValueFactory<ClientEntity, String>("property"));
        ClientMedicalColumn.setCellValueFactory(new PropertyValueFactory<ClientEntity, String>("medical"));
        ClientLifeColumn.setCellValueFactory(new PropertyValueFactory<ClientEntity, String>("life"));

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
    private Button AddButton;

    @FXML
    private Button EditButton;

    @FXML
    private Button DeleteButton;
}
