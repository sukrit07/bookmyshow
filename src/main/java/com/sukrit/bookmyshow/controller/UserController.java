package com.sukrit.bookmyshow.controller;


import com.sukrit.bookmyshow.dto.UserRequestDTO;
import com.sukrit.bookmyshow.dto.UserResponseDTO;
import com.sukrit.bookmyshow.service.UserService;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping("/user/create")
    public UserResponseDTO createUser(@RequestBody UserRequestDTO userRequestDTO){
        return this.userService.createUser(userRequestDTO);
    }

    @GetMapping("/user/details/{id}")
    public UserResponseDTO getUserDetails(@PathVariable Long id){
        return this.userService.getUserDetails(id);
    }
}
