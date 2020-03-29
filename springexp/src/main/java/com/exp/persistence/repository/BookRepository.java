package com.exp.persistence.repository;

import com.exp.persistence.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface BookRepository extends JpaRepository<Book, String> {
}
