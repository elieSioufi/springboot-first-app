package com.testcase.controller;

import com.testcase.model.User;
import com.testcase.model.Users;
import com.testcase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    public UserService userService;

    /**
     *
     * @param id
     * @return the user's information
     */
    @GetMapping ("/user")
    public User getUser(@RequestParam int id){
        return userService.getUser(id);
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/getUserByAge")
    public User getUserByAge(@RequestParam int age){
        return userService.getUserByAge(age);
    }

    @GetMapping("/Users")
    public List<Users> fetchUsers() {
        return userService.fetchUsers();
    }

}
