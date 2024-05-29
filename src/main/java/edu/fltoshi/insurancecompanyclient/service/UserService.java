package edu.fltoshi.insurancecompanyclient.service;

import com.google.gson.reflect.TypeToken;
import edu.fltoshi.insurancecompanyclient.entity.ClientEntity;
import edu.fltoshi.insurancecompanyclient.entity.UserEntity;
import edu.fltoshi.insurancecompanyclient.response.BaseResponse;
import edu.fltoshi.insurancecompanyclient.response.DataResponse;
import edu.fltoshi.insurancecompanyclient.response.ListResponse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;

import java.lang.reflect.Type;

public class UserService {
    @Getter
    private ObservableList<UserEntity> data = FXCollections.observableArrayList();
    private final HTTPService http = new HTTPService();
    JSONService json = new JSONService();
    ClientProperties properties = new ClientProperties();
    private Type dataType = new TypeToken<DataResponse<UserEntity>>(){}.getType();
    private Type listType = new TypeToken<ListResponse<UserEntity>>(){}.getType();

    public void getAll() {
        ListResponse<UserEntity> data = new ListResponse<>();
        data = json.getObject(http.get(properties.getAllClient()), listType);
        if (data.isSuccess()) {
            this.data.addAll(data.getData());
            this.data.forEach(System.out::println);
        } else {
            throw new RuntimeException(data.getMessage());
        }
    }

    public void add(UserEntity data) {
        String temp = http.post(properties.getSaveUser(), json.getJson(data));
        DataResponse<UserEntity> response = json.getObject(temp, dataType);
        if (response.isSuccess()) {
            this.data.add(response.getData());
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }

    public void update(UserEntity after, UserEntity before){
        System.out.println(before);
        System.out.println(after);
        String temp = http.put(properties.getUpdateClient(), json.getJson(after));
        DataResponse<ClientEntity> response = json.getObject(temp, dataType);
        if (response.isSuccess()){
            this.data.remove(before);
            this.data.add(after);
        }else{
            throw new RuntimeException(response.getMessage());
        }
    }

    public void delete(UserEntity data){
        String temp = http.delete(properties.getDeleteClient(), data.getId());
        BaseResponse response = json.getObject(temp,BaseResponse.class);
        if (response.isSuccess()){
            this.data.remove(data);
        }else {
            throw new RuntimeException(response.getMessage());
        }
    }
}
