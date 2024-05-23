package edu.fltoshi.insurancecompanyclient.service;

import com.google.gson.reflect.TypeToken;
import edu.fltoshi.insurancecompanyclient.entity.ClientEntity;
import edu.fltoshi.insurancecompanyclient.response.BaseResponse;
import edu.fltoshi.insurancecompanyclient.response.DataResponse;
import edu.fltoshi.insurancecompanyclient.response.ListResponse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;

import java.lang.reflect.Type;

public class ClientService {
    @Getter
    private ObservableList<ClientEntity> data = FXCollections.observableArrayList();
    private final HTTPService http = new HTTPService();
    JSONService service = new JSONService();
    ClientProperties properties = new ClientProperties();
    private Type dataType = new TypeToken<DataResponse<ClientEntity>>(){}.getType();
    private Type listType = new TypeToken<ListResponse<ClientEntity>>(){}.getType();

    public void getAll() {
        ListResponse<ClientEntity> data = new ListResponse<>();
        data = service.getObject(http.get(properties.getAllClient()), listType);
        if (data.isSuccess()) {
            this.data.addAll(data.getData());
            this.data.forEach(System.out::println);
        } else {
            throw new RuntimeException(data.getMessage());
        }
    }

    public void add(ClientEntity data){
        String temp = http.post(properties.getSaveClient(), service.getJson(data));
        DataResponse<ClientEntity> response = service.getObject(temp, dataType);
        if (response.isSuccess()){
            this.data.add(response.getData());

        }else{
            throw new RuntimeException(response.getMessage());
        }
    }

    public void update(ClientEntity after, ClientEntity before){
        System.out.println(before);
        System.out.println(after);
        String temp = http.put(properties.getUpdateClient(), service.getJson(after));
        DataResponse<ClientEntity> response = service.getObject(temp, dataType);
        if (response.isSuccess()){
            this.data.remove(before);
            this.data.add(after);
        }else{
            throw new RuntimeException(response.getMessage());
        }
    }

    public void delete(ClientEntity data){
        String temp = http.delete(properties.getDeleteClient(), data.getId());
        BaseResponse response = service.getObject(temp,BaseResponse.class);
        if (response.isSuccess()){
            this.data.remove(data);
        }else {
            throw new RuntimeException(response.getMessage());
        }
    }


    public void findById(ClientEntity data){
        String temp = http.get(properties.getFindByIdClient() + data.getId());
        DataResponse<ClientEntity> response = service.getObject(temp, dataType);
        if (response.isSuccess()){
            this.data.add(response.getData());

        }else{
            throw new RuntimeException(response.getMessage());
        }
    }
}
