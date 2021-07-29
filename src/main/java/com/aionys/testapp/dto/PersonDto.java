package com.aionys.testapp.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class PersonDto {

    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private Date dateOfBirth;

//    public String getSurame() {
//        return surname;
//    }

}
