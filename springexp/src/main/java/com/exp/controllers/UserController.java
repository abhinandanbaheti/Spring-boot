package com.exp.controllers;

import com.exp.common.AuthZAccess;
import com.exp.common.LogAccess;
import com.exp.service.UserService;
import com.exp.service.dtos.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @Autowired
    UserService testService;

    @Value("Hello World")
    private String name;

    @RequestMapping(value = "/")
    public String name() {
        return name;
    }

    @LogAccess
    @RequestMapping(value = "/users")
    public ResponseEntity<Object> getUsers() {
        return new ResponseEntity<>(testService.getUsers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateUser(@PathVariable("id") String id, @RequestBody User user) {
        testService.updateUser(id, user);
        return new ResponseEntity<>("TestObj is updated successsfully", HttpStatus.OK);
    }

    @AuthZAccess
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUser(@PathVariable("id") String id) {
        testService.deleteUser(id);
        return new ResponseEntity<>("TestObj is deleted successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        testService.createUser(user);
        return new ResponseEntity<>("TestObj is created successfully", HttpStatus.CREATED);
    }

//    @RequestMapping(value = "/aop", method = RequestMethod.GET)
//    @AuthZAccess(accessBy = false)
//    public ResponseEntity<Object> getSomeResult(HttpServletRequest request) {
//        return new ResponseEntity<>("AOP is created successfully", HttpStatus.OK);
//    }
}
