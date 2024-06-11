package com.testcase.service;

import com.testcase.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public List<User> userList;

    public UserService(){
        userList = new ArrayList<>();

        User user1 = new User(1, "IC", "Ich", 34);
        User user2 = new User(2, "AL", "Alain", 13);
        User user3 = new User(3, "LE", "Lea", 22);
        User user4 = new User(4, "SA", "Sarah", 49);
        User user5 = new User(5, "EL", "Elie", 23);

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
    }

    public User getUser(Integer id) {

        for (User user: userList) {
            if (id == user.getId())
                return user;
        }
        return null;
    }

}
