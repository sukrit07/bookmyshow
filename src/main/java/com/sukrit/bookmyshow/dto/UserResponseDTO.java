package com.sukrit.bookmyshow.dto;

import lombok.*;

import java.util.Date;
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {

    private Long id;
    private String name;
    private String mobileNo;
    private String email;
    private Date dateOfBirth;

}
