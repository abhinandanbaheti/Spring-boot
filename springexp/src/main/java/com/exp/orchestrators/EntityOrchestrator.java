package com.exp.orchestrators;

import com.exp.persistence.dao.Type1Dao;
import com.exp.persistence.entities.Type1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EntityOrchestrator {

    private final Type1Dao type1Dao;

    @Autowired
    public EntityOrchestrator(Type1Dao type1Dao) {
        this.type1Dao = type1Dao;
    }

    public void create(Type1Entity type1Entity) {
        type1Dao.create(type1Entity);
    }

    public List<Type1Entity> getAll() {
        return type1Dao.getAll();
    }

    public void delete(String dbId) {
        type1Dao.delete(dbId);
    }
}
