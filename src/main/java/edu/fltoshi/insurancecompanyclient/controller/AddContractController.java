package edu.fltoshi.insurancecompanyclient.controller;

import edu.fltoshi.insurancecompanyclient.entity.ClientEntity;
import edu.fltoshi.insurancecompanyclient.entity.ContractEntity;
import edu.fltoshi.insurancecompanyclient.entity.InsuranceEntity;
import edu.fltoshi.insurancecompanyclient.service.ClientService;
import edu.fltoshi.insurancecompanyclient.service.ContractService;
import edu.fltoshi.insurancecompanyclient.service.InsuranceService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddContractController {

    InsuranceService insuranceService = new InsuranceService();
    ClientService clientService = new ClientService();
    ContractService contractService = new ContractService();

    private boolean addFlag = true;


    @FXML
    private void initialize(){
        insuranceService.getAll();
        clientService.getAll();
        contractService.getAll();
        ContractListView.setItems(contractService.getData());
        ClientBox.setItems(clientService.getData());
        InsuranceTypeBox.setItems(insuranceService.getData());
    }

    @FXML
    private ComboBox<ClientEntity> ClientBox;

    @FXML
    private Button ContractAddButton;

    @FXML
    private Button ContractDeleteButton;

    @FXML
    private Button ContractEditButton;

    @FXML
    private ListView<ContractEntity> ContractListView;

    @FXML
    private TextField ContractTimelapseField;

    @FXML
    private ComboBox<InsuranceEntity> InsuranceTypeBox;

    @FXML
    void onMouseClickDataList(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)){
            if (event.getClickCount() == 2){
                addFlag = false;
                ContractEntity temp = getSelectionElement();
//                ClientBox.setItems();
                ContractTimelapseField.setText(ContractTimelapseField.getText());
                ContractAddButton.setText("Изменить");
            }
        }
    }

    private ContractEntity getSelectionElement(){
        ContractEntity temp = ContractListView.getSelectionModel().getSelectedItem();
        ContractTimelapseField.setText(temp.getTimelapse());
//        InsuranceTypeBox.setItems((temp.getInsurance()));
//        ClientBox.setItems((ObservableList<ClientEntity>) temp.getClient());
        return temp;
    }


    public void ContractAddAction(javafx.event.ActionEvent actionEvent) {
        try {
            ContractEntity contract = new ContractEntity();
            contract.setClient(ClientBox.getValue());
            contract.setInsurance(InsuranceTypeBox.getValue());
            contract.setTimelapse(ContractTimelapseField.getText());
            if (addFlag) {
                contractService.add(contract);
            } else {
                contract.setId(getSelectionElement().getId());
//                ContractService.update(contract, getSelectionElement());
            }

        }catch (Exception e){
//            alertService.addVoid(e);
        }
        Stage stage = (Stage) ContractAddButton.getScene().getWindow();
        stage.close();
        ContractAddButton.setText("Добавить");
    }

    public void ContractDeleteAction(ActionEvent actionEvent) {
    }

    public void CancelAction(ActionEvent actionEvent) {
    }
}
