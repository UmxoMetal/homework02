package com.i.homework02.doctype;

import com.fasterxml.jackson.annotation.JsonView;
import com.i.homework02.user.UserView;

import javax.persistence.*;

@Entity(name = "Doc_type")
public class DocType {

//Служебное поле hibernate
    @Version
    private Integer version=0;

//Код документа
    @Id
    @Basic(optional = false)
    private String code;

//Название документа
    @Basic(optional = false)
    private String name;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}