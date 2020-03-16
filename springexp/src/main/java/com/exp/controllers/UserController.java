package com.exp.controllers;

import com.exp.common.AuthZAccess;
import com.exp.common.LogAccess;
import com.exp.exceptions.TestException;
import com.exp.service.UserService;
import com.exp.service.dtos.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import java.util.Arrays;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {

    @Autowired
    UserService testService;

    @Autowired
    RestTemplate restTemplate;

    @Value("${spring.application.name}")
    //@Value("Hello World")
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

    @RequestMapping(value = "/exception/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getException(@PathVariable("id") String id) {
        throw new TestException();
    }

    @RequestMapping(value = "/template/users")
    public String getUsersList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange("http://localhost:9090/users", HttpMethod.GET, entity, String.class).getBody();
    }

//    @GetMapping(value = "/test1")
//    public void getTest1(HttpServletRequest request, HttpServletResponse response) {
//       System.out.println("header: auth param - " + request.getHeader("auth"));
//        response.setStatus(307);
//        response.setHeader(HttpHeaders.LOCATION, "test");
//    }
//    @RequestMapping(value = "/aop", method = RequestMethod.GET)
//    @AuthZAccess(accessBy = false)
//    public ResponseEntity<Object> getSomeResult(HttpServletRequest request) {
//        return new ResponseEntity<>("AOP is created successfully", HttpStatus.OK);
//    }
}
