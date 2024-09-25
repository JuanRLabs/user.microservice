package com.user.user.adapters.driving.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AddUserAssistant {
    private String name;
    private String lastName;
    private String idDocument;
    private String phoneNumber;
    private Date dateBorn;
    private String email;
    private String password;
    private Role role;
}
