package com.user.user.adapters.driving.dto;

import lombok.Data;

@Data
public class AddUserAssistant {
    private String name;
    private String surname;
    private String dni;
    private String email;
    private String phone;
    private String bornDate;
    private String password;
//    private RoleEntity role;
}
