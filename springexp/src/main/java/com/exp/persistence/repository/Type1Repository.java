package com.exp.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import com.exp.persistence.entities.Type1Entity;

@Transactional
public interface Type1Repository extends JpaRepository<Type1Entity, String>, JpaSpecificationExecutor {
//    @Override
//    List<Type1Entity> findAll();
//
//    List<Type1Entity> findByLastName(String lastName);
//
//    Type1Entity findById(long id);
//
//    @Query(value = "select * from type1", nativeQuery = true)
//    List<Type1Entity> findAllEntities();
//
//    @Query(value = "select * from type1 where id=?1", nativeQuery = true)
//    Type1Entity findEntityById(int id);
}
