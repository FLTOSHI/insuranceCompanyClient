package edu.fltoshi.insurancecompanyclient.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContractEntity {
    private Long id;
    private String timelapse;
    private ClientEntity client;
    private InsuranceEntity insurance;

    @Override
    public String toString() {
        return timelapse + client + insurance;
    }
}
