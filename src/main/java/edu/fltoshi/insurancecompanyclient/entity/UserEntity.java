package edu.fltoshi.insurancecompanyclient.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    private Long id;
    private String username;
    private String password;
}