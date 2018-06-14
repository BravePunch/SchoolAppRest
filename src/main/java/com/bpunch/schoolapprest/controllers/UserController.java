package com.bpunch.schoolapprest.controllers;

import com.bpunch.schoolapprest.model.dto.UserDto;
import com.bpunch.schoolapprest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public @ResponseBody List<UserDto> getAllUsers() {

        return userService.getAllUsers();
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody UserDto getUserById(@PathVariable("id") Integer id) {

        return userService.getUserById(id);
    }

    @GetMapping("/getBy")
    public @ResponseBody UserDto getUserByEmail(@RequestParam("email") String email) {

        // TODO - Add search parameters (see service)
        return userService.getUserByEmail(email);
    }

    @PostMapping
    public @ResponseBody UserDto createUser(@RequestBody UserDto entity) {

        return userService.createUser(entity);
    }

    @PutMapping(value = "/{id}")
    public @ResponseBody UserDto updateUser(@PathVariable("id") Integer id, @RequestBody UserDto entity) {

        return userService.updateUser(id, entity);
    }

}
