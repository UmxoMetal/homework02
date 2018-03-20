package com.i.homework02.organization;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.i.homework02.office.Office;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Entity
public class Organization {
//    @NotNull
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long id;

//Служебное поле hibernate
    @Version
    private Integer version=1;

// Краткое название организации
    private String name;

    //Полное название оранизации
    private String fullName;

    //ИНН организации
    private String inn;

    //КПП организации
    private String kpp;

    //Адрес организации
    private String address;

    //Телефон организации
    private String phone;

    //Активная ли организация
    private Boolean isActive;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "organization", cascade = {CascadeType.ALL},orphanRemoval = true)
    private List<Office> offices;

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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
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

    public List<Office> getOffices() {
        return offices;
    }

    public void setOffices(List<Office> offices) {
        this.offices = offices;
    }
}
