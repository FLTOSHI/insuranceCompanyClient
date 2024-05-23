package edu.fltoshi.insurancecompanyclient.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceEntity {
    private Long id;
    private String name;
    private Integer cost;
}
