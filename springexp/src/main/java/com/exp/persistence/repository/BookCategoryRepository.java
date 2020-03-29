package com.exp.persistence.repository;

import com.exp.persistence.entities.BookCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.transaction.Transactional;

@Transactional
public interface BookCategoryRepository  extends JpaRepository<BookCategory, String>, JpaSpecificationExecutor {
}
