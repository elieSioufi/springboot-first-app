package com.testcase.service;

import com.testcase.model.User;
import com.testcase.model.Users;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserService {

    User getUser(Integer id);

    List<User> getUsers();

    User getUserByAge(int age);

    List<Users> fetchUsers();

    List<Map<String, Object>> getUsersMap();

    void initializeUserList();



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


}

