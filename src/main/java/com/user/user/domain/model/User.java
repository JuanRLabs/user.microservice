package com.user.user.domain.model;

public class User {
    private Long id;
    private String name;
    private String surname;
    private String dni;
    private String email;
    private String phone;
    private String bornDate;
    private String password;
    private Role idRole;

    public User(String name,
                String surname,
                String dni,
                String phone,
                String bornDate,
                String email,
                String password,
                Role idRole) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;

        this.phone = phone;
        this.bornDate = bornDate;
        this.email = email;
        this.password = password;
        this.idRole = idRole;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getBornDate() {
        return bornDate;
    }

    public String getPassword() {
        return password;
    }

    public Role getIdRole() {
        return idRole;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIdRole(Role idRole) {
        this.idRole = idRole;
    }
}
