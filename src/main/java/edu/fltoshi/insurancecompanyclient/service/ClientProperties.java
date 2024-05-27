package edu.fltoshi.insurancecompanyclient.service;

import lombok.Getter;
import edu.fltoshi.insurancecompanyclient.MainApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Getter
public class ClientProperties {
    private final Properties properties = new Properties();

    private String allClient;
    private String findByIdClient;
    private String saveClient;
    private String updateClient;
    private String deleteClient;
    private String findClientByOsago;
    private String findClientByProperty;
    private String findClientByMedical;
    private String findClientByLife;

    private String allInsurance;
    private String saveInsurance;
    private String updateInsurance;
    private String getInsurancePrice;
    private String getInsuranceCost;
    private String getInsuranceBlank;

    private String allContract;
    private String saveContract;
    private String updateContract;
    private String getAllContract;
    private String findContractById;
    private String deleteContract;
    private String getTimelapseContract;

    private String saveUser;
    private String checkUser;

    public ClientProperties() {
        try (InputStream input = MainApplication.class.getClassLoader().getResourceAsStream("config.properties")) {
            System.out.println(input);
            properties.load(input);

            allClient = properties.getProperty("client.getAll");
            findByIdClient = properties.getProperty("client.getById");
            saveClient = properties.getProperty("client.save");
            updateClient = properties.getProperty("client.update");
            deleteClient = properties.getProperty("client.del");
            findClientByOsago = properties.getProperty("client.getByOsago");
            findClientByProperty = properties.getProperty("client.getByProperty");
            findClientByMedical = properties.getProperty("client.getByMedical");
            findClientByLife = properties.getProperty("client.getByLife");

            allInsurance = properties.getProperty("insurance.getAll");
            saveInsurance = properties.getProperty("insurance.update");
            updateInsurance = properties.getProperty("insurance.update");
            getInsurancePrice = properties.getProperty("insurance.getPrice");
            getInsuranceCost = properties.getProperty("insurance.getCost");
            getInsuranceBlank = properties.getProperty("insurance.getBlank");

            allContract = properties.getProperty("contract.getAll");
            saveContract = properties.getProperty("contract.save");
            updateContract = properties.getProperty("contract.update");
            deleteContract = properties.getProperty("contract.del");
            findContractById = properties.getProperty("contract.get");
            getAllContract = properties.getProperty("contract.getAll");
            getTimelapseContract = properties.getProperty("contract.getTimelapse");

            checkUser = properties.getProperty("user.check");
            saveUser = properties.getProperty("user.save");

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}