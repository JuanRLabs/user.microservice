package com.user.user.domain.model;

import java.util.Date;

public class User {
    private Long id;
    private String name;
    private String lastName;
    private String idDocument;
    private String phoneNumber;
    private Date dateBorn;
    private String email;
    private String password;
    private Role role;

    public User(String name,
                String lastName,
                String idDocument,
                String phoneNumber,
                Date dateBorn,
                String email,
                String password,
                Role role) {
        this.name = name;
        this.lastName = lastName;
        this.idDocument = idDocument;
        this.phoneNumber = phoneNumber;
        this.dateBorn = dateBorn;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIdDocument() {
        return idDocument;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getDateBorn() {
        return dateBorn;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }
}
