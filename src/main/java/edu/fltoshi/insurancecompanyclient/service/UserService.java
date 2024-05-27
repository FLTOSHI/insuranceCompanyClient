package edu.fltoshi.insurancecompanyclient.service;

import com.google.gson.reflect.TypeToken;
import edu.fltoshi.insurancecompanyclient.entity.ClientEntity;
import edu.fltoshi.insurancecompanyclient.entity.UserEntity;
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

    public void add(UserEntity data) {
        String temp = http.post(properties.getSaveUser(), json.getJson(data));
        DataResponse<UserEntity> response = json.getObject(temp, dataType);
        if (response.isSuccess()) {
            this.data.add(response.getData());
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }
}
