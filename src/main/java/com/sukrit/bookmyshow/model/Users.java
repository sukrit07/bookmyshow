package com.sukrit.bookmyshow.model;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
public class Users extends BaseModel{

    private String name;
    private String mobileNo;
    private String email;
    private Date dateOfBirth;

}
