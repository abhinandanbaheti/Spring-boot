package com.exp.persistence.daoImpl;

import com.exp.persistence.dao.BookDao;
import com.exp.persistence.entities.Book;
import com.exp.persistence.entities.BookCategory;
import com.exp.persistence.repository.BookCategoryRepository;
import com.exp.persistence.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BookDaoImpl implements BookDao {

    @Autowired
    BookRepository type1Repository;

    @Autowired
    BookCategoryRepository bookCategoryRepository;

    @Override
    public boolean exists(String dbId) {
        return type1Repository.existsById(dbId);
    }

    @Override
    public Book get(String dbId) {
        return type1Repository.getOne(dbId);
    }

    public Book createBook(String bookCategoryId, Book persistenceObject) {
        List<Book> books = new ArrayList<>();
        BookCategory bookCategory1 = new BookCategory();


       Optional<BookCategory> id = bookCategoryRepository.findById(bookCategoryId);
       BookCategory bookCategory = id.get();
       persistenceObject.setCategory(bookCategory);

        Book book1 = type1Repository.save(persistenceObject);
        //tie Book to Author
        books.add(book1);
        bookCategory1.setBooks(books);

        type1Repository.save(persistenceObject);
        return null;
    }

    @Override
    public Book update(Book persistenceObject) {
        type1Repository.save(persistenceObject);
        return null;
    }

    @Override
    public void delete(String dbId) {
        type1Repository.deleteById(dbId);
        ;
    }

    @Override
    public List<Book> getAll() {
        return type1Repository.findAll();

    }
    @Override
    public Book create(Book book) {
        return type1Repository.save(book);
    }
}
