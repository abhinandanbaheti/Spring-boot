package com.exp.persistence.dao;

import java.util.Optional;

import com.exp.persistence.entities.Type1Entity;

public interface Type1Dao extends BaseDao<Type1Entity> {

    Optional<Type1Entity> getByEntityId(String id);

    Type1Entity getByEntityType(String entityType);
}
