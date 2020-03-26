package com.exp.persistence.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exp.persistence.dao.Type1Dao;
import com.exp.persistence.entities.Type1Entity;
import com.exp.persistence.repository.Type1Repository;

@Component
public class Type1DaoImpl implements Type1Dao {

    @Autowired
    Type1Repository type1Repository;

    @Override
    public boolean exists(String dbId) {
        return type1Repository.existsById(dbId);
    }

    @Override
    public Type1Entity get(String dbId) {
        return type1Repository.getOne(dbId);
    }

    @Override
    public Type1Entity create(Type1Entity persistenceObject) {
        type1Repository.save(persistenceObject);
        return null;
    }

    @Override
    public Type1Entity update(Type1Entity persistenceObject) {
        type1Repository.save(persistenceObject);
        return null;
    }

    @Override
    public void delete(String dbId) {
        type1Repository.deleteById(dbId);
        ;
    }

    @Override
    public Optional<Type1Entity> getByEntityId(String id) {
        return type1Repository.findById(id);
    }

    @Override
    public Type1Entity getByEntityType(String entityType) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Type1Entity> getAll() {
        return type1Repository.findAll();

    }
}
