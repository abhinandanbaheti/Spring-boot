package com.exp.controllers;

import com.exp.service.TestService;
import com.exp.service.dtos.TestDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @Value("Hello World")
    private String name;

    @RequestMapping(value = "/")
    public String name() {
        return name;
    }

    @RequestMapping(value = "/tests")
    public ResponseEntity<Object> getResources() {
        return new ResponseEntity<>(testService.getResources(), HttpStatus.OK);
    }

    @RequestMapping(value = "/tests/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateResource(@PathVariable("id") String id, @RequestBody TestDTO testobj) {
        testService.updateResource(id, testobj);
        return new ResponseEntity<>("TestObj is updated successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/tests/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteResource(@PathVariable("id") String id) {
        testService.deleteResource(id);
        return new ResponseEntity<>("TestObj is deleted successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/tests", method = RequestMethod.POST)
    public ResponseEntity<Object> createResource(@RequestBody TestDTO testobj) {
        testService.createResource(testobj);
        return new ResponseEntity<>("TestObj is created successfully", HttpStatus.CREATED);
    }
}
