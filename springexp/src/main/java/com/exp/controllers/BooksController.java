package com.exp.controllers;

import com.exp.orchestrators.BookEntityOrchestrator;

import com.exp.persistence.entities.Book;
import com.exp.persistence.entities.BookCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class BooksController {

    private final HttpServletRequest request;
    private final BookEntityOrchestrator entityOrchestrator;

    @Autowired
    public BooksController(final HttpServletRequest request,
                           final BookEntityOrchestrator entityOrchestrator) {
        this.request = request;
        this.entityOrchestrator = entityOrchestrator;
    }

    @RequestMapping(value = "/cat", method = RequestMethod.POST)
    public ResponseEntity<Object> createEntity(@RequestBody BookCategory type1Entity) {
        entityOrchestrator.createCat(type1Entity);
        return new ResponseEntity<>("TestObj is created successfully", HttpStatus.CREATED);

    }

    @RequestMapping(value = "/cats", method = RequestMethod.GET)
    public ResponseEntity<Object> getEntity() {
        return new ResponseEntity<>(entityOrchestrator.getAllCat(), HttpStatus.OK);
    }

    @RequestMapping(value = "/cat/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteEntity(@PathVariable("id") String dbId) {
        entityOrchestrator.deleteCat(dbId);
        return new ResponseEntity<>("TestObj is deleted successfully", HttpStatus.CREATED);
    }


    @RequestMapping(value = "/{id}/book", method = RequestMethod.POST)
    public ResponseEntity<Object> createBook(@PathVariable(value = "id") String id, @RequestBody Book book) {
         entityOrchestrator.createBook(id, book);
        return new ResponseEntity<>("TestObj is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllBooks() {
        return new ResponseEntity<>(entityOrchestrator.getAllBook(), HttpStatus.OK);
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteBook(@PathVariable("id") String dbId) {
        entityOrchestrator.deleteBook(dbId);
        return new ResponseEntity<>("TestObj is deleted successfully", HttpStatus.CREATED);
    }

}
