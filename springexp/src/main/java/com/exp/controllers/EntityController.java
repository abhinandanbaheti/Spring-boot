package com.exp.controllers;

import com.exp.orchestrators.EntityOrchestrator;
import com.exp.persistence.entities.Type1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class EntityController {

    private final HttpServletRequest request;
    private final EntityOrchestrator entityOrchestrator;


    @Autowired
    public EntityController(final HttpServletRequest request,
                            final EntityOrchestrator entityOrchestrator) {
        this.request = request;
        this.entityOrchestrator = entityOrchestrator;
    }

    @RequestMapping(value = "/entity", method = RequestMethod.POST)
    public ResponseEntity<Object> createEntity(@RequestBody Type1Entity type1Entity) {
        entityOrchestrator.create(type1Entity);
        return new ResponseEntity<>("TestObj is created successfully", HttpStatus.CREATED);

    }

    @RequestMapping(value = "/entities", method = RequestMethod.GET)
    public ResponseEntity<Object> getEntity() {
        return new ResponseEntity<>(entityOrchestrator.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/entity/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteEntity(@PathVariable("id") String dbId) {
        entityOrchestrator.delete(dbId);
        return new ResponseEntity<>("TestObj is deleted successfully", HttpStatus.CREATED);
    }
}


