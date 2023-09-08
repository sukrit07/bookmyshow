package com.sukrit.bookmyshow.dto;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {

    private String name;
    private String mobileNo;
    private String email;
    private Date dateOfBirth;

}
