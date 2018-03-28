package com.i.homework02.view;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Version;

public class OfficeIdViewOut {

    //Id офиса
    private Long id;

    // Название офиса
    private String name;

    //Адрес
    private String address;


    //Телефон
    private String phone;

    //Активен ли офис
    private Boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getActive() {
        return isActive;
    }
@JsonProperty(value = "isActive")
    public void setActive(Boolean active) {
        isActive = active;
    }
}
