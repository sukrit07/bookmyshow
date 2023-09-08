package com.sukrit.bookmyshow.model;


import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users extends BaseModel{

    private String name;
    private String mobileNo;
    private String email;
    private Date dateOfBirth;

}
