package edu.fltoshi.insurancecompanyclient.service;

import com.google.gson.reflect.TypeToken;
import edu.fltoshi.insurancecompanyclient.entity.InsuranceEntity;
import edu.fltoshi.insurancecompanyclient.response.BaseResponse;
import edu.fltoshi.insurancecompanyclient.response.DataResponse;
import edu.fltoshi.insurancecompanyclient.response.ListResponse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;

import java.lang.reflect.Type;

public class InsuranceService {
    @Getter
    private ObservableList<InsuranceEntity> data = FXCollections.observableArrayList();
    private final HTTPService http = new HTTPService();
    JSONService service = new JSONService();
    ClientProperties properties = new ClientProperties();
    private Type dataType = new TypeToken<DataResponse<InsuranceEntity>>(){}.getType();
    private Type listType = new TypeToken<ListResponse<InsuranceEntity>>(){}.getType();

    public void getAll() {
        ListResponse<InsuranceEntity> data = new ListResponse<>();
        data = service.getObject(http.get(properties.getAllInsurance()), listType);
        if (data.isSuccess()) {
            this.data.addAll(data.getData());
            this.data.forEach(System.out::println);
        } else {
            throw new RuntimeException(data.getMessage());
        }
    }

    public void add(InsuranceEntity data){
        String temp = http.post(properties.getSaveInsurance(), service.getJson(data));
        DataResponse<InsuranceEntity> response = service.getObject(temp, dataType);
        if (response.isSuccess()){
            this.data.add(response.getData());

        }else{
            throw new RuntimeException(response.getMessage());
        }
    }

    public void update(InsuranceEntity after, InsuranceEntity before){
        System.out.println(before);
        System.out.println(after);
        String temp = http.put(properties.getUpdateInsurance(), service.getJson(after));
        DataResponse<InsuranceEntity> response = service.getObject(temp, dataType);
        if (response.isSuccess()){
            this.data.remove(before);
            this.data.add(after);
        }else{
            throw new RuntimeException(response.getMessage());
        }
    }

    public void delete(InsuranceEntity data){
        String temp = http.delete(properties.getDeleteClient(), data.getId());
        BaseResponse response = service.getObject(temp,BaseResponse.class);
        if (response.isSuccess()){
            this.data.remove(data);
        }else {
            throw new RuntimeException(response.getMessage());
        }
    }
}
