package com.bpunch.schoolapprest.controllers;

import com.bpunch.schoolapprest.model.dto.UserDto;
import com.bpunch.schoolapprest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public @ResponseBody List<UserDto> getAllUsers() {

        return userService.getAllUsers();
    }

}
