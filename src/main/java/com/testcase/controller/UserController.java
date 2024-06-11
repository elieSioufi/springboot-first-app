package com.testcase.controller;

import com.testcase.model.User;
import com.testcase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    public UserService userService;

    @Autowired
    public UserController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping ("/user")
    public User getUser(@RequestParam Integer id){
        return userService.getUser(id);
    }
}
