package com.exp.persistence.daoImpl;

import com.exp.persistence.dao.BookCategoryDao;
import com.exp.persistence.entities.BookCategory;
import com.exp.persistence.repository.BookCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookCategoryDaoImpl implements BookCategoryDao {
    @Autowired
    BookCategoryRepository type1Repository;

    @Override
    public boolean exists(String dbId) {
        return type1Repository.existsById(dbId);
    }

    @Override
    public BookCategory get(String dbId) {
        return type1Repository.getOne(dbId);
    }

    @Override
    public BookCategory create(BookCategory persistenceObject) {
        type1Repository.save(persistenceObject);
        return null;
    }

    @Override
    public BookCategory update(BookCategory persistenceObject) {
        type1Repository.save(persistenceObject);
        return null;
    }

    @Override
    public void delete(String dbId) {
        type1Repository.deleteById(dbId);
        ;
    }

    @Override
    public List<BookCategory> getAll() {
        return type1Repository.findAll();

    }

}
