package com.testcase.service;

import com.testcase.model.User;
import com.testcase.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    public List<User> userList;

    public UserService() {
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

        for (User user : userList) {
            if (id == user.getId())
                return user;
        }
        return null;
    }

    public  List<User> getUsers() {
        return userList;
    }

    public User getUserByAge(int age){
        for (User user : userList) {
            if(age == user.getAge())
                return user;
        }
        return null;
    }


    public RestTemplate restTemplate;

    public String url ="https://api.github.com/users";

    @Autowired
    public UserService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Users> fetchUsers() {
        ResponseEntity<List<Users>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Users>>() {});
        return response.getBody();
    }

    /**
     * The List<Users> knows which value corresponds to which property through the use of the Users class, which is a POJO
     * Here’s how it works:
     * Class Definition: The Users class defines the properties that correspond to the keys in your original map. Each property in the Users class has a field, along with getter and setter methods.
     * JSON Mapping: When the RestTemplate fetches the JSON data from the API,
     * it uses a process called JSON deserialization to convert the JSON into Java objects.
     * This process maps the JSON keys to the corresponding fields in the Users class.
     * Field Assignment: The JSON values are assigned to the appropriate fields in the Users object based on the matching keys.
     * For example, if the JSON has a key "login", and there is a field login in the Users class, the value for "login" in the JSON will be set to the login field in the Users object.
     * When the RestTemplate receives the JSON response, it uses these getters and setters to populate the Users objects.
     * The ParameterizedTypeReference<List<Users>> in the exchange method call is what tells the RestTemplate that it should expect a List of Users objects,
     * and it should map the JSON data accordingly.
     */


//    public List<Map<String, Object>> fetchUsers() {
//
//        ResponseEntity<List<Users>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Users>>() {});
//        List<Users> usersList = response.getBody();
//
//        List<Map<String, Object>> usersMapList = new ArrayList<>();
//
//        for (Users user : usersList) {
//            Map<String, Object> userMap = new HashMap<>();
//            userMap.put("login", user.getLogin());
//            userMap.put("id", user.getId());
//            userMap.put("node_id", user.getNode_id());
//            userMap.put("avatar_url", user.getAvatar_url());
//            userMap.put("gravatar_id", user.getGravatar_id());
//            userMap.put("url", user.getUrl());
//            userMap.put("html_url" , user.getHtml_url());
//            userMap.put("followers_url" , user.getFollowers_url());
//            userMap.put("following_url" , user.getFollowing_url());
//            userMap.put("gists_url", user.getGists_url());
//            userMap.put("starred_url" , user.getStarred_url());
//            userMap.put("subscription_url" , user.getSubscriptions_url());
//            userMap.put("organizations_url" , user.getOrganizations_url());
//            userMap.put("repos_url" , user.getRepos_url());
//            userMap.put("events_url" , user.getEvents_url());
//            userMap.put("received_events_url" , user.getReceived_events_url());
//            userMap.put("type" , user.getType());
//            userMap.put("site_admin" , user.getSite_admin());
//
//            usersMapList.add(userMap);
//        }
//        return usersMapList;
//    }
}
