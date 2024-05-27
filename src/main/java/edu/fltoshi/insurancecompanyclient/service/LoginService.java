package edu.fltoshi.insurancecompanyclient.service;

import com.google.gson.reflect.TypeToken;
import edu.fltoshi.insurancecompanyclient.MainApplication;
import edu.fltoshi.insurancecompanyclient.controller.MainController;
import edu.fltoshi.insurancecompanyclient.entity.UserEntity;
import edu.fltoshi.insurancecompanyclient.response.DataResponse;
import edu.fltoshi.insurancecompanyclient.response.ListResponse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import lombok.Getter;

import java.io.IOException;
import java.lang.reflect.Type;

public class LoginService {

    @Getter
    private ObservableList<UserEntity> data = FXCollections.observableArrayList();
    //        private final ErrorAlertService alertService = new ErrorAlertService();
    private final HTTPService http = new HTTPService();
    JSONService service = new JSONService();
    private FXMLLoader fxmlLoader;
    private static MainController mainController;


    ClientProperties prop = new ClientProperties();
    private Type dataType = new TypeToken<DataResponse<UserEntity>>() {
    }.getType();
    private Type listType = new TypeToken<ListResponse<UserEntity>>() {
    }.getType();

    public void add(UserEntity data) {
        String temp = http.post(prop.getSaveUser(), service.getJson(data));
        DataResponse<UserEntity> response = service.getObject(temp, dataType);
        if (response.isSuccess()) {
            this.data.add(response.getData());
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }

    public void checkUserData(UserEntity data) throws IOException {
        String temp = http.get(prop.getCheckUser() + data.getUsername() + "&password=" + data.getPassword());
        DataResponse<UserEntity> response = service.getObject(temp, dataType);
        if (response.isSuccess()) {
            MainApplication.workspace("Система для автоматизации работы страховой компании 'Белгорстрах'");
        } else {
            System.out.println("ДУРАЧОК ПАРОЛЬ ПРОВЕРЬ!!!!!!!");
        }
    }
}

