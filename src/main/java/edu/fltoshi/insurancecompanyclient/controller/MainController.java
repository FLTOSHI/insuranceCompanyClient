package edu.fltoshi.insurancecompanyclient.controller;

import static edu.fltoshi.insurancecompanyclient.MainApplication.*;
import edu.fltoshi.insurancecompanyclient.MainApplication;
import edu.fltoshi.insurancecompanyclient.entity.ClientEntity;
import edu.fltoshi.insurancecompanyclient.entity.InsuranceEntity;
import edu.fltoshi.insurancecompanyclient.service.ClientService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    ClientService service = new ClientService();
    private boolean addFlag = false;

    // Инициалазция окна
    @FXML
    private void initialize() {
        if (userAdmin.equals(tempUser)) {
            UserWork.setVisible(true);
        } else {
            UserWork.setVisible(false);
        }

        // Получение данных с сервера и установка их по местам в таблице
        service.getAll();
        ClientLastnameColumn.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        ClientNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ClientSurnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        ClientOSAGOColumn.setCellValueFactory(new PropertyValueFactory<>("osago"));
        ClientPropertyColumn.setCellValueFactory(new PropertyValueFactory<>("property"));
        ClientMedicalColumn.setCellValueFactory(new PropertyValueFactory<>("medical"));
        ClientLifeColumn.setCellValueFactory(new PropertyValueFactory<>("life"));

        ClientTable.setItems(service.getData());
    }

    // Компоненты FXML
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
    private MenuItem UserWork;

    @FXML
    private MenuItem exitMenu;

    @FXML
    private MenuItem helpMenu;

    @FXML
    private Button AddButton;

    @FXML
    private Button EditButton;

    @FXML
    private Button DeleteButton;

    // Действия
    @FXML
    void onMouseClickDataList(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            if (event.getClickCount() == 2) {
                addFlag = false;
                ClientEntity temp = getSelectionElement();
            }
        }
    }

    private ClientEntity getSelectionElement() {
        ClientEntity temp = ClientTable.getSelectionModel().getSelectedItem();
        return temp;
    }
    @FXML
    void addNewClientAction(ActionEvent event) {
        MainApplication.showDialog("add-client-view.fxml", "Работа с клиентами");
    }

    @FXML
    void deleteAction(ActionEvent event) {
        service.delete(getSelectionElement());
    }

    @FXML
    void insuranceOpen(ActionEvent event) {
        MainApplication.showDialog("add-insurance-view.fxml", "Работа с видами страхования");
    }

    @FXML
    void contractOpen(ActionEvent event) {
        MainApplication.showDialog("add-contract-view.fxml", "Работа с договорами");
    }

    @FXML
    void userOpen(ActionEvent event) {
        MainApplication.showDialog("add-user-view.fxml", "Работа с пользователями");
    }

    @FXML
    void exitAction(ActionEvent event) {
        Stage stage = (Stage) DeleteButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void helpAction(ActionEvent event) throws IOException {
        Runtime.getRuntime().exec("hh.exe C:\\Users\\User\\Desktop\\primeMOY\\help.chm");
    }
}