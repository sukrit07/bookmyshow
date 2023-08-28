package com.sukrit.bookmyshow.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class UserResponseDTO {

    private Long id;
    private String name;
    private String mobileNo;
    private String email;
    private Date dateOfBirth;

}
