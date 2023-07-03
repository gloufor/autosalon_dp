package com.example.autosalon_bashkirov;


public class User {

    private String fio;
    private String service;

    public User(){}

    public User(String fio, String service) {
        this.fio = fio;
        this.service = service;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }


    public String getPosition() {
        return service;
    }

    public void setPosition(String position) {
        this.service = position;
    }
}
