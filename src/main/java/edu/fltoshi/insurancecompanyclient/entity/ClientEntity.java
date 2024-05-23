package edu.fltoshi.insurancecompanyclient.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientEntity {
    private Long id;
    private String name;
    private String lastname;
    private String surname;
    private Boolean osago;
    private Boolean property;
    private Boolean medical;
    private Boolean life;
}