package com.exp.persistence.dao;

import com.exp.persistence.entities.Book;

public interface BookDao extends BaseDao<Book> {
    public Book createBook(String bookCategoryId, Book persistenceObject);
}
