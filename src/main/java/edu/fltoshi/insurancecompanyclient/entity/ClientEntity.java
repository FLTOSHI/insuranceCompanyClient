package edu.fltoshi.insurancecompanyclient.entity;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientEntity {
    private Long id;
    private String name;
    private String lastname;
    private String surname;
    private Boolean osago;
    private Boolean property;
    private Boolean medical;
    private Boolean life;

    @Override
    public String toString() {
        return lastname + ", " + name + " " + surname + " " + osago + " " + property + " " + medical + " " + life;
    }
}