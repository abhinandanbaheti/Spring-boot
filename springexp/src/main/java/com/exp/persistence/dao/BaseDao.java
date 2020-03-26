package com.exp.persistence.dao;

import java.util.List;

import com.exp.persistence.entities.BaseEntity;

public interface BaseDao<T extends BaseEntity> {
    boolean exists(final String dbId);

    T get(final String dbId);

    T create(final T persistenceObject);

    T update(final T persistenceObject);

    void delete(final String dbId);

    List<T> getAll();
}
