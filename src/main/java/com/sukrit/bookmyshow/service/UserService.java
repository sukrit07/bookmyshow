package com.sukrit.bookmyshow.service;

import com.sukrit.bookmyshow.dto.UserRequestDTO;
import com.sukrit.bookmyshow.dto.UserResponseDTO;
import com.sukrit.bookmyshow.model.Users;
import com.sukrit.bookmyshow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO){
        Users user = new Users();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setMobileNo(userRequestDTO.getMobileNo());
        user.setDateOfBirth(userRequestDTO.getDateOfBirth());
        this.userRepository.save(user);
        return mapUserToUserResponseDTO(user);
    }

    public UserResponseDTO getUserDetails(Long userId){
        Users user = this.userRepository.findById(userId).get();
        return mapUserToUserResponseDTO(user);
    }


    private UserResponseDTO mapUserToUserResponseDTO(Users user){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setMobileNo(user.getMobileNo());
        userResponseDTO.setDateOfBirth(user.getDateOfBirth());
        return userResponseDTO;
    }


}
