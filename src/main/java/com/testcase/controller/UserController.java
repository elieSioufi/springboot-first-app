package com.testcase.controller;

import com.testcase.model.User;
import com.testcase.model.Users;
import com.testcase.repo.UsersRepo;
import com.testcase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    public UserService userService;

    @Autowired
    public UsersRepo usersRepo;

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

    @GetMapping("/v1/users")
     public List<Map<String, Object>> getUsersMap(){
        return userService.getUsersMap();
    }

    @GetMapping("/Users")
    public List<Users> fetchUsers() {
        return userService.fetchUsers();
    }




    @GetMapping
    public ResponseEntity<List<Users>> getUsersById(){
        try{
            List<Users> usersList = new ArrayList<>();
            usersRepo.findAll().forEach(usersList :: add);

            if (usersList.isEmpty()) {
                return new ResponseEntity<>(usersList, HttpStatus.NO_CONTENT);
            }
           return new ResponseEntity<>(HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getUsersById/{id}")
    public ResponseEntity<Users> getUsersById(@PathVariable String id){
        Optional<Users> usersData = usersRepo.findById(id);

        if(usersData.isPresent()){
            return new ResponseEntity<>(usersData.get(),HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/addUsers")
    public ResponseEntity<Users> addUsers(@RequestBody Users users){
        Users usersObj = usersRepo.save(users);

        return new ResponseEntity<>(usersObj,HttpStatus.OK);
    }

    @PostMapping("/updateUsersById/{id}")
    public ResponseEntity<Users> updateUsersById(@PathVariable String id, @RequestBody Users newUsersData){
        Optional<Users> oldUsersData = usersRepo.findById(id);

        if(oldUsersData.isPresent()){

            Users updatedUsersData = oldUsersData.get();
            updatedUsersData.setLogin(newUsersData.getLogin());
            updatedUsersData.setNode_id(newUsersData.getNode_id());
            updatedUsersData.setAvatar_url(newUsersData.getAvatar_url());
            updatedUsersData.setGravatar_id(newUsersData.getGravatar_id());
            updatedUsersData.setUrl(newUsersData.getUrl());
            updatedUsersData.setHtml_url(newUsersData.getHtml_url());
            updatedUsersData.setFollowers_url(newUsersData.getFollowers_url());
            updatedUsersData.setFollowing_url(newUsersData.getFollowing_url());
            updatedUsersData.setGists_url(newUsersData.getGists_url());
            updatedUsersData.setStarred_url(newUsersData.getStarred_url());
            updatedUsersData.setSubscriptions_url(newUsersData.getSubscriptions_url());
            updatedUsersData.setOrganizations_url(newUsersData.getOrganizations_url());
            updatedUsersData.setRepos_url(newUsersData.getRepos_url());
            updatedUsersData.setEvents_url(newUsersData.getEvents_url());
            updatedUsersData.setReceived_events_url(newUsersData.getReceived_events_url());
            updatedUsersData.setType(newUsersData.getType());
            updatedUsersData.setSite_admin(newUsersData.getSite_admin());

            Users usersObj = usersRepo.save(updatedUsersData);
            return new ResponseEntity<>(usersObj , HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/deleteUsersById/{id}")
    public ResponseEntity<Object> deleteUsersById(@PathVariable String id) {
        usersRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
