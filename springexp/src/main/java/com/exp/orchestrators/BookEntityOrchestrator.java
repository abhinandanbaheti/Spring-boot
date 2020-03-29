package com.exp.orchestrators;


import com.exp.persistence.dao.BookCategoryDao;
import com.exp.persistence.dao.BookDao;
import com.exp.persistence.daoImpl.BookCategoryDaoImpl;
import com.exp.persistence.entities.Book;
import com.exp.persistence.entities.BookCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookEntityOrchestrator {

    private final BookCategoryDao type1Dao;
    private final BookDao bookDao;


    @Autowired
    public BookEntityOrchestrator(BookCategoryDao type1Dao, BookDao bookDao) {
        this.type1Dao = type1Dao;
        this.bookDao = bookDao;
    }

    public void createCat(BookCategory type1Entity) {
        type1Dao.create(type1Entity);
    }

    public List<BookCategory> getAllCat() {
        return type1Dao.getAll();
    }

    public void deleteCat(String dbId) {
        type1Dao.delete(dbId);
    }

    public void createBook(String dbId, Book type1Entity) {
        bookDao.createBook(dbId, type1Entity);
    }

    public List<Book> getAllBook() {
        return bookDao.getAll();
    }

    public void deleteBook(String dbId) {
        bookDao.delete(dbId);
    }
}
