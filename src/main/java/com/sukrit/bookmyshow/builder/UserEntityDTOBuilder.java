package com.sukrit.bookmyshow.builder;

import com.sukrit.bookmyshow.dto.UserRequestDTO;
import com.sukrit.bookmyshow.model.Users;
import lombok.experimental.UtilityClass;


@UtilityClass
public class UserEntityDTOBuilder {

    public static Users toEntity(UserRequestDTO userRequestDTO){
        return Users.builder()
                .name(userRequestDTO.getName())
                .email(userRequestDTO.getEmail())
                .mobileNo(userRequestDTO.getMobileNo())
                .dateOfBirth(userRequestDTO.getDateOfBirth())
                .build();
    }

    public static UserRequestDTO toDto(Users user){
        return UserRequestDTO.builder()
                .name(user.getName())
                .email(user.getEmail())
                .mobileNo(user.getMobileNo())
                .dateOfBirth(user.getDateOfBirth())
                .build();
    }
}
