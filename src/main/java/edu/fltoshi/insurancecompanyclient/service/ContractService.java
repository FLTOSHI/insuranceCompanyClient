package edu.fltoshi.insurancecompanyclient.service;

import com.google.gson.reflect.TypeToken;
import edu.fltoshi.insurancecompanyclient.entity.ContractEntity;
import edu.fltoshi.insurancecompanyclient.response.BaseResponse;
import edu.fltoshi.insurancecompanyclient.response.DataResponse;
import edu.fltoshi.insurancecompanyclient.response.ListResponse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;

import java.lang.reflect.Type;

public class ContractService {
    @Getter
    private ObservableList<ContractEntity> data = FXCollections.observableArrayList();
    private final HTTPService http = new HTTPService();
    JSONService service = new JSONService();
    ClientProperties properties = new ClientProperties();
    private Type dataType = new TypeToken<DataResponse<ContractEntity>>(){}.getType();
    private Type listType = new TypeToken<DataResponse<ContractEntity>>(){}.getType();

    public void getAll() {
        ListResponse<ContractEntity> data = new ListResponse<>();
        data = service.getObject(http.get(properties.getAllContract()), listType);
        if (data.isSuccess()) {
            this.data.addAll(data.getData());
            this.data.forEach(System.out::println);
        } else {
            throw new RuntimeException(data.getMessage());
        }
    }

    public void add(ContractEntity data){
        String temp = http.post(properties.getSaveContract(), service.getJson(data));
        DataResponse<ContractEntity> response = service.getObject(temp, dataType);
        if (response.isSuccess()){
            this.data.add(response.getData());

        }else{
            throw new RuntimeException(response.getMessage());
        }
    }

    public void update(ContractEntity after, ContractEntity before){
        System.out.println(before);
        System.out.println(after);
        String temp = http.put(properties.getUpdateContract(), service.getJson(after));
        DataResponse<ContractEntity> response = service.getObject(temp, dataType);
        if (response.isSuccess()){
            this.data.remove(before);
            this.data.add(after);
        }else{
            throw new RuntimeException(response.getMessage());
        }
    }

    public void delete(ContractEntity data){
        String temp = http.delete(properties.getDeleteClient(), data.getId());
        BaseResponse response = service.getObject(temp,BaseResponse.class);
        if (response.isSuccess()){
            this.data.remove(data);
        }else {
            throw new RuntimeException(response.getMessage());
        }
    }


    public void findById(ContractEntity data){
        String temp = http.get(properties.getFindContractById() + data.getId());
        DataResponse<ContractEntity> response = service.getObject(temp, dataType);
        if (response.isSuccess()){
            this.data.add(response.getData());

        }else{
            throw new RuntimeException(response.getMessage());
        }
    }
}
